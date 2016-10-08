package com.sina.weibo.sdk.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.WBAgent;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Utility
{
  private static final String DEFAULT_CHARSET = "UTF-8";
  private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
  
  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split("&");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return localBundle;
      }
      String[] arrayOfString = paramString[i].split("=");
      try
      {
        localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
        i += 1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
  
  public static String generateGUID()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public static String generateUA(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
    paramContext.append("_");
    paramContext.append(Build.VERSION.RELEASE);
    paramContext.append("_");
    paramContext.append("weibosdk");
    paramContext.append("_");
    paramContext.append("0031405000");
    paramContext.append("_android");
    return paramContext.toString();
  }
  
  public static String generateUAAid(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
    paramContext.append("__");
    paramContext.append("weibosdk");
    paramContext.append("__");
    try
    {
      paramContext.append("0031405000".replaceAll("\\s+", "_"));
      paramContext.append("__").append("android").append("__android").append(Build.VERSION.RELEASE);
      return paramContext.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext.append("unknown");
      }
    }
  }
  
  public static String getAid(Context paramContext, String paramString)
  {
    paramContext = AidTask.getInstance(paramContext).getAidSync(paramString);
    if (paramContext != null) {
      return paramContext.getAid();
    }
    return "";
  }
  
  public static String getSign(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        i = 0;
        if (i >= paramContext.signatures.length) {
          return null;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        return null;
      }
      paramString = paramContext.signatures[i].toByteArray();
      if (paramString != null) {
        return MD5.hexdigest(paramString);
      }
      i += 1;
    }
  }
  
  public static boolean isChineseLocale(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale;
      boolean bool;
      if ((!Locale.CHINA.equals(paramContext)) && (!Locale.CHINESE.equals(paramContext)) && (!Locale.SIMPLIFIED_CHINESE.equals(paramContext))) {
        bool = Locale.TAIWAN.equals(paramContext);
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public static Boolean isWeiBoVersionSupportNewPay(Context paramContext)
  {
    boolean bool = false;
    Object localObject1 = new Intent("com.sina.weibo.action.sdkidentity");
    ((Intent)localObject1).addCategory("android.intent.category.DEFAULT");
    localObject1 = paramContext.getPackageManager().queryIntentServices((Intent)localObject1, 0);
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return Boolean.valueOf(false);
    }
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        if (i >= 1920) {
          bool = true;
        }
        return Boolean.valueOf(bool);
      }
      Object localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      if ((((ResolveInfo)localObject2).serviceInfo != null) && (((ResolveInfo)localObject2).serviceInfo.applicationInfo != null) && (!TextUtils.isEmpty(((ResolveInfo)localObject2).serviceInfo.applicationInfo.packageName)))
      {
        localObject2 = ((ResolveInfo)localObject2).serviceInfo.applicationInfo.packageName;
        try
        {
          int j = paramContext.getPackageManager().getPackageInfo((String)localObject2, 0).versionCode;
          i = j;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
        }
      }
    }
  }
  
  public static void openWeiboActivity(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("_weibo_appPackage", paramContext.getPackageName());
      localIntent.setData(Uri.parse(paramString));
      localIntent.setFlags(268435456);
      localIntent.putExtras(paramBundle);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
  
  public static Bundle parseUri(String paramString)
  {
    try
    {
      paramString = decodeUrl(new URI(paramString).getQuery());
      return paramString;
    }
    catch (Exception paramString) {}
    return new Bundle();
  }
  
  public static Bundle parseUrl(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      Bundle localBundle = decodeUrl(paramString.getQuery());
      localBundle.putAll(decodeUrl(paramString.getRef()));
      return localBundle;
    }
    catch (MalformedURLException paramString) {}
    return new Bundle();
  }
  
  public static String safeString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static void shareMessagetoWeibo(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      String str = String.valueOf(System.currentTimeMillis());
      localIntent.putExtra("_weibo_transaction", str);
      HashMap localHashMap = new HashMap();
      localHashMap.put("other_app_action_start_time", str);
      try
      {
        WBAgent.onEvent(paramContext, "message", localHashMap);
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.putExtra("_weibo_appPackage", paramContext.getPackageName());
        localIntent.setData(Uri.parse(paramString));
        localIntent.setFlags(268435456);
        localIntent.putExtras(paramBundle);
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\Utility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */