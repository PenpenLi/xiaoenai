package com.alibaba.sdk.android.web.impl;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.session.SessionService;
import com.alibaba.sdk.android.session.impl.SessionServiceImpl;
import com.alibaba.sdk.android.session.model.Session;
import com.alibaba.sdk.android.session.model.User;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.support.WebViewActivitySupport;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.URLUtils;
import com.alibaba.sdk.android.web.CookieService;
import com.taobao.tae.sdk.log.SdkCoreLog;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CookieManagerWrapper
  implements PropertyChangeListener, CookieService
{
  private static final String CLEAR_MOBILE_COOKIE_NAMES_KEY = "clearMobileCookieNames";
  private static final String CLEAR_ROOT_COOKIE_NAMES_KEY = "clearRootCookieNames";
  private static final String[] EXCLUDED_COOKIE_KEYS = { "cookie2=", "_nk_=", "unb=", "3sg=", "3st=" };
  private static final String HTTP = "http://";
  public static String INSERT_KEY;
  public static final CookieManagerWrapper INSTANCE = new CookieManagerWrapper();
  private static final String MID = "miid=";
  private static final String NICK = "_nk_=";
  private static final String SID = "cookie2=";
  private static final String SIGN = "3sg=";
  private static final String TAG = CookieManagerWrapper.class.getSimpleName();
  private static final String TIMESTAMP = "3st=";
  private static final String UNB = "unb=";
  public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
  private String[] clearMobileCookieNames = { "imewweoriw" };
  private String[] clearRootCookieNames = { "_l_g_" };
  private volatile String domainCookies;
  
  static
  {
    INSERT_KEY = "vst";
  }
  
  private void clearMobileCookie(CookieManager paramCookieManager)
  {
    String[] arrayOfString;
    int k;
    int i;
    String str2;
    Object localObject;
    String str1;
    int m;
    int j;
    String str3;
    if (!"false".equals(AlibabaSDK.getProperty("ui", "clearMobileCookies")))
    {
      arrayOfString = UIContext.mobileDomains;
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        str2 = arrayOfString[i];
        localObject = new StringBuilder().append("http://");
        if (str2.startsWith(".")) {}
        for (str1 = str2.substring(1);; str1 = str2)
        {
          str1 = str1;
          localObject = this.clearMobileCookieNames;
          m = localObject.length;
          j = 0;
          while (j < m)
          {
            str3 = localObject[j];
            paramCookieManager.setCookie(str1, str3 + "=; Domain=" + str2);
            j += 1;
          }
        }
        i += 1;
      }
    }
    if (!"false".equals(AlibabaSDK.getProperty("ui", "clearRootCookies")))
    {
      arrayOfString = UIContext.domains;
      k = arrayOfString.length;
      i = 0;
      while (i < k)
      {
        str2 = arrayOfString[i];
        localObject = new StringBuilder().append("http://");
        if (str2.startsWith(".")) {}
        for (str1 = str2.substring(1);; str1 = str2)
        {
          str1 = str1;
          localObject = this.clearRootCookieNames;
          m = localObject.length;
          j = 0;
          while (j < m)
          {
            str3 = localObject[j];
            paramCookieManager.setCookie(str1, str3 + "=; Domain=" + str2);
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private String getCookieDomain(String paramString)
  {
    paramString = paramString.split("[;]");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (str.trim().startsWith("Domain=")) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  private boolean isCookieInCookieNames(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.indexOf(paramArrayOfString[i]) != -1) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static boolean isInternalSessionCookie(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = EXCLUDED_COOKIE_KEYS;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.indexOf(arrayOfString[i]) != -1) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private String signUrl(String paramString, long paramLong)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString).append((String)SessionServiceImpl.INSTANCE.getSId().data).append(paramLong);
      paramString = UIContext.securityGuardService.sign(localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      AliSDKLogger.e(TAG, "Fail to sign the url, the error message is " + paramString.getMessage());
    }
    return null;
  }
  
  public Long getMid()
  {
    for (;;)
    {
      try
      {
        String str = this.domainCookies;
        if (this.domainCookies == null)
        {
          str = CookieManager.getInstance().getCookie(UIContext.domains[0]);
          if (TextUtils.isEmpty(str)) {
            return null;
          }
          int k = str.indexOf("miid=");
          if (k == -1) {
            break;
          }
          int j = str.indexOf(";", k);
          int i = j;
          if (j == -1) {
            i = str.length();
          }
          long l = Long.parseLong(str.substring(k + "miid=".length(), i));
          return Long.valueOf(l);
        }
      }
      catch (Throwable localThrowable)
      {
        AliSDKLogger.printStackTraceAndMore(localThrowable);
        return null;
      }
    }
    return null;
  }
  
  public void init()
  {
    if (ConfigManager.DEBUG) {
      SdkCoreLog.startTimeRecord("CookieInit");
    }
    CookieSyncManager.createInstance(UIContext.appContext.getAndroidContext());
    String str = UIContext.pluginConfigurations.getStringValue("clearMobileCookieNames");
    if (!TextUtils.isEmpty(str)) {
      this.clearMobileCookieNames = str.split("[,]");
    }
    str = UIContext.pluginConfigurations.getStringValue("clearRootCookieNames");
    if (!TextUtils.isEmpty(str)) {
      this.clearRootCookieNames = str.split("[,]");
    }
    if (ConfigManager.DEBUG) {
      SdkCoreLog.d("CookieInit", SdkCoreLog.content(TAG, SdkCoreLog.getTimeUsed("CookieInit"), new String[] { "success" }));
    }
  }
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    if ("clearMobileCookieNames".equals(paramString1)) {
      if (TextUtils.isEmpty(paramString3))
      {
        paramString1 = new String[0];
        this.clearMobileCookieNames = paramString1;
      }
    }
    while (!"clearRootCookieNames".equals(paramString1)) {
      for (;;)
      {
        return;
        paramString1 = paramString3.split("[,]");
      }
    }
    if (TextUtils.isEmpty(paramString3)) {}
    for (paramString1 = new String[0];; paramString1 = paramString3.split("[,]"))
    {
      this.clearRootCookieNames = paramString1;
      return;
    }
  }
  
  public void refreshCookie(String paramString)
  {
    if (paramString == null) {
      return;
    }
    CookieManager localCookieManager = CookieManager.getInstance();
    clearMobileCookie(localCookieManager);
    Object localObject2 = SessionServiceImpl.INSTANCE;
    Session localSession = (Session)((SessionService)localObject2).getSession().data;
    Object localObject1 = null;
    String str2 = (String)((SessionService)localObject2).getSId().data;
    if (localSession.isLogin().booleanValue()) {}
    for (;;)
    {
      try
      {
        localObject2 = URLEncoder.encode(CommonUtils.native2Ascii(localSession.getUser().nick), "UTF-8");
        localObject1 = localObject2;
        String str1;
        String[] arrayOfString;
        int j;
        int i;
        Object localObject6;
        long l;
        Object localObject5;
        label180:
        String str3;
        label351:
        label396:
        AliSDKLogger.e(TAG, localException2.getMessage(), localException2);
      }
      catch (Exception localException1)
      {
        try
        {
          str1 = String.valueOf(UIContext.securityService.analyzeUserId(localSession.getUserId()));
          localObject2 = localObject1;
          localObject1 = str1;
          arrayOfString = UIContext.domains;
          j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            localSession = arrayOfString[i];
            localObject6 = URLUtils.subUrlHash(paramString);
            l = System.currentTimeMillis();
            localObject5 = new StringBuilder().append("http://");
            if (localSession.startsWith("."))
            {
              str1 = localSession.substring(1);
              localObject5 = str1;
              str3 = "; Domain=" + localSession;
              if (signUrl((String)localObject6, l) != null) {
                localCookieManager.setCookie((String)localObject5, "3sg=" + signUrl((String)localObject6, l) + str3);
              }
              localCookieManager.setCookie((String)localObject5, "3st=" + l + str3);
              localCookieManager.setCookie((String)localObject5, "cookie2=" + str2 + str3);
              localObject6 = new StringBuilder().append("unb=");
              if (localObject1 != null) {
                break label542;
              }
              str1 = "";
              localCookieManager.setCookie((String)localObject5, str1 + str3);
              localObject6 = new StringBuilder().append("_nk_=");
              if (localObject2 != null) {
                break label548;
              }
              str1 = "";
              localCookieManager.setCookie((String)localObject5, str1 + str3);
              if (AliSDKLogger.isDebugEnabled()) {
                AliSDKLogger.d(TAG, "refresh cookie, domain: " + localSession + " current cookie: " + localCookieManager.getCookie(localSession));
              }
              i += 1;
              continue;
              localException1 = localException1;
              AliSDKLogger.e(TAG, localException1.getMessage(), localException1);
              continue;
              localObject3 = localSession.getUserId();
            }
          }
        }
        catch (Exception localException2)
        {
          if (localSession.getUserId() == null) {}
        }
      }
      for (;;)
      {
        Object localObject4 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
        break;
        localObject4 = localSession;
        break label180;
        label542:
        localObject4 = localObject1;
        break label351;
        label548:
        localObject4 = localObject3;
        break label396;
        paramString = WebViewActivitySupport.getInstance().getCookies();
        if (paramString != null) {
          setCookiesWithExcludeCookieNames(paramString, UIContext.cookieNamesWithApplicationLifecycle, false);
        }
        CookieSyncManager.getInstance().sync();
        return;
        localObject3 = null;
      }
      localObject1 = null;
      Object localObject3 = null;
    }
  }
  
  public void removeAllCookies()
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    String[] arrayOfString = UIContext.domains;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str2 = arrayOfString[i];
      String str1 = "http://" + str2.substring(1);
      str2 = "; Domain=" + str2;
      Object localObject = localCookieManager.getCookie(str1);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        i += 1;
      }
      else
      {
        localObject = ((String)localObject).split("[,]");
        int m = localObject.length;
        int j = 0;
        label118:
        CharSequence localCharSequence;
        if (j < m)
        {
          localCharSequence = localObject[j];
          if (!TextUtils.isEmpty(localCharSequence)) {
            break label149;
          }
        }
        for (;;)
        {
          j += 1;
          break label118;
          break;
          label149:
          int n = localCharSequence.indexOf('=');
          if (n != -1) {
            localCookieManager.setCookie(str1, localCharSequence.substring(0, n + 1) + str2);
          }
        }
      }
    }
    CookieSyncManager.getInstance().sync();
  }
  
  public void removeCookies()
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    clearMobileCookie(localCookieManager);
    Object localObject1 = UIContext.domains;
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    String str1;
    while (i < j)
    {
      localObject2 = localObject1[i];
      str1 = "http://" + ((String)localObject2).substring(1);
      localObject2 = "; Domain=" + (String)localObject2;
      localCookieManager.setCookie(str1, "3sg=" + (String)localObject2);
      localCookieManager.setCookie(str1, "3st=" + (String)localObject2);
      localCookieManager.setCookie(str1, "cookie2=" + (String)localObject2);
      localCookieManager.setCookie(str1, "unb=" + (String)localObject2);
      localCookieManager.setCookie(str1, "_nk_=" + (String)localObject2);
      i += 1;
    }
    localObject1 = WebViewActivitySupport.getInstance().getCookies();
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        str1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String[])((Map.Entry)localObject2).getValue();
        if ((str1 != null) && (localObject2 != null))
        {
          j = localObject2.length;
          i = 0;
          label298:
          String str2;
          if (i < j)
          {
            str2 = localObject2[i];
            if ((str2 != null) && (!isInternalSessionCookie(str2)) && (!isCookieInCookieNames(str2, UIContext.cookieNamesWithApplicationLifecycle))) {
              break label346;
            }
          }
          for (;;)
          {
            i += 1;
            break label298;
            break;
            label346:
            int k = str2.indexOf('=');
            if (k != -1)
            {
              String str3 = getCookieDomain(str2);
              if (str3 != null) {
                localCookieManager.setCookie(str1, str2.substring(0, k + 1) + ";" + str3);
              }
            }
          }
        }
      }
    }
    CookieSyncManager.getInstance().sync();
  }
  
  public void setCookiesWithExcludeCookieNames(Map<String, String[]> paramMap, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramMap == null) {}
    label84:
    label130:
    do
    {
      return;
      CookieManager localCookieManager = CookieManager.getInstance();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        localObject = (String[])((Map.Entry)localObject).getValue();
        if ((str1 != null) && (localObject != null))
        {
          int j = localObject.length;
          int i = 0;
          String str2;
          if (i < j)
          {
            str2 = localObject[i];
            if ((str2 != null) && (!isInternalSessionCookie(str2)) && (!isCookieInCookieNames(str2, paramArrayOfString))) {
              break label130;
            }
          }
          for (;;)
          {
            i += 1;
            break label84;
            break;
            localCookieManager.setCookie(str1, str2);
          }
        }
      }
    } while (!paramBoolean);
    CookieSyncManager.getInstance().sync();
  }
  
  public void setCookiesWithIncludeCookieNames(Map<String, String[]> paramMap, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramMap == null) {}
    label84:
    label130:
    do
    {
      return;
      CookieManager localCookieManager = CookieManager.getInstance();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        localObject = (String[])((Map.Entry)localObject).getValue();
        if ((str1 != null) && (localObject != null))
        {
          int j = localObject.length;
          int i = 0;
          String str2;
          if (i < j)
          {
            str2 = localObject[i];
            if ((str2 != null) && (!isInternalSessionCookie(str2)) && (isCookieInCookieNames(str2, paramArrayOfString))) {
              break label130;
            }
          }
          for (;;)
          {
            i += 1;
            break label84;
            break;
            localCookieManager.setCookie(str1, str2);
          }
        }
      }
    } while (!paramBoolean);
    CookieSyncManager.getInstance().sync();
  }
  
  public void setDomainCookies(String paramString)
  {
    this.domainCookies = paramString;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\web\impl\CookieManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */