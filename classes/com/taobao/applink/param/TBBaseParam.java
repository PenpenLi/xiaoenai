package com.taobao.applink.param;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.applink.TBAppLinkParam;
import com.taobao.applink.TBAppLinkSDK;
import com.taobao.applink.api.TBAPIType;
import com.taobao.applink.appinfo.TBAppInfo;
import com.taobao.applink.auth.TBAppLinkAuthListener;
import com.taobao.applink.secret.TBAppLinkSecret;
import com.taobao.applink.util.TBAppLinkMD5Util;
import com.taobao.applink.util.TBAppLinkStringUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public abstract class TBBaseParam
{
  protected static final String ACTION = "action";
  protected static final String APPKEY = "appkey";
  protected static final String APPNAME = "appName";
  protected static final String APPSERCET = "AppSecret";
  protected static final String BACKURL = "backURL";
  protected static final String E = "e";
  protected static final String EXTRAPARAMS = "params";
  protected static final String H5URL = "h5Url";
  protected static final String ITMEID = "itemId";
  protected static final String MODULE = "module";
  protected static final String PACKAGENAME = "packageName";
  protected static final String PID = "pid";
  protected static final String SDKVERSION = "v";
  protected static final String SHOPID = "shopId";
  protected static final String SIGN = "sign";
  protected static final String SOURCE = "source";
  protected static final String TAG = "tag";
  protected static final String TIME = "time";
  protected static final String TTID = "TTID";
  protected static final String TYPE = "type";
  protected static final String UTDID = "utdid";
  protected HashMap<String, String> mExtraParams = new HashMap();
  public TBAppLinkAuthListener mListener;
  protected HashMap<String, String> mParams = new HashMap();
  public TBAPIType mTBAPIType;
  
  protected TBBaseParam(TBAPIType paramTBAPIType)
  {
    this.mTBAPIType = paramTBAPIType;
    if (TBAppLinkSDK.getInstance().sOpenParam != null)
    {
      if (!TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mBackUrl)) {
        this.mParams.put("backURL", TBAppLinkSDK.getInstance().sOpenParam.mBackUrl);
      }
      if (!TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mAppkey)) {
        this.mParams.put("appkey", TBAppLinkSDK.getInstance().sOpenParam.mAppkey);
      }
      if (!TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mPid)) {
        this.mExtraParams.put("pid", TBAppLinkSDK.getInstance().sOpenParam.mPid);
      }
      if (!TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mTtid)) {
        this.mParams.put("TTID", TBAppLinkSDK.getInstance().sOpenParam.mTtid);
      }
      if (!TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mTag)) {
        this.mParams.put("tag", TBAppLinkSDK.getInstance().sOpenParam.mTag);
      }
      if (!TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mUtdid)) {
        this.mParams.put("utdid", TBAppLinkSDK.getInstance().sOpenParam.mUtdid);
      }
      if (!TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mSource)) {
        this.mParams.put("source", TBAppLinkSDK.getInstance().sOpenParam.mSource);
      }
    }
  }
  
  public TBBaseParam addExtraParams(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        if ((!TBAppLinkStringUtil.isBlank((String)localEntry.getKey())) && (!TBAppLinkStringUtil.isBlank((String)localEntry.getValue()))) {
          this.mExtraParams.put(localEntry.getKey(), localEntry.getValue());
        }
      }
    }
    return this;
  }
  
  public abstract boolean checkParams(JSONObject paramJSONObject);
  
  public abstract String getH5URL();
  
  protected String getH5URL(String paramString)
  {
    if (TBAppLinkStringUtil.isBlank(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1;
    if (this.mExtraParams != null)
    {
      localObject1 = this.mExtraParams.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((!TBAppLinkStringUtil.isBlank((String)((Map.Entry)localObject2).getKey())) && (!TBAppLinkStringUtil.isBlank((String)((Map.Entry)localObject2).getValue()))) {
          try
          {
            String str1 = URLEncoder.encode((String)((Map.Entry)localObject2).getKey(), "UTF-8");
            localObject2 = URLEncoder.encode((String)((Map.Entry)localObject2).getValue(), "UTF-8");
            localStringBuffer.append(str1).append("=").append((String)localObject2).append("&");
          }
          catch (Throwable localThrowable5)
          {
            Log.d("AppLink", localThrowable5.toString());
          }
        }
      }
    }
    if (!TBAppLinkStringUtil.isBlank((String)this.mParams.get("TTID"))) {}
    try
    {
      localObject1 = URLEncoder.encode("TTID", "UTF-8");
      str2 = URLEncoder.encode((String)this.mParams.get("TTID"), "UTF-8");
      localStringBuffer.append((String)localObject1).append("=").append(str2).append("&");
      if (TBAppLinkStringUtil.isBlank((String)this.mParams.get("tag"))) {}
    }
    catch (Throwable localThrowable3)
    {
      try
      {
        localObject1 = URLEncoder.encode("tag", "UTF-8");
        str2 = URLEncoder.encode((String)this.mParams.get("tag"), "UTF-8");
        localStringBuffer.append((String)localObject1).append("=").append(str2).append("&");
        if (TBAppLinkStringUtil.isBlank((String)this.mParams.get("utdid"))) {}
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          localObject1 = URLEncoder.encode("utdid", "UTF-8");
          str2 = URLEncoder.encode((String)this.mParams.get("utdid"), "UTF-8");
          localStringBuffer.append((String)localObject1).append("=").append(str2).append("&");
          if (TBAppLinkStringUtil.isBlank((String)this.mParams.get("source"))) {}
        }
        catch (Throwable localThrowable3)
        {
          try
          {
            for (;;)
            {
              localObject1 = URLEncoder.encode("source", "UTF-8");
              String str2 = URLEncoder.encode((String)this.mParams.get("source"), "UTF-8");
              localStringBuffer.append((String)localObject1).append("=").append(str2).append("&");
              return paramString + localStringBuffer.toString();
              localThrowable1 = localThrowable1;
              Log.d("AppLink", localThrowable1.toString());
              continue;
              localThrowable2 = localThrowable2;
              Log.d("AppLink", localThrowable2.toString());
            }
            localThrowable3 = localThrowable3;
            Log.d("AppLink", localThrowable3.toString());
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              Log.d("AppLink", localThrowable4.toString());
            }
          }
        }
      }
    }
  }
  
  public String getJumpUrl(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("tbopen://m.taobao.com/tbopen/index.html?");
    this.mParams.put("appName", TBAppInfo.getAppName(paramContext));
    this.mParams.put("packageName", TBAppInfo.getPackageName(paramContext));
    this.mParams.put("v", "1.0");
    Iterator localIterator = this.mParams.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ((!TBAppLinkStringUtil.isBlank((String)((Map.Entry)localObject).getKey())) && (!TBAppLinkStringUtil.isBlank((String)((Map.Entry)localObject).getValue()))) {
        try
        {
          String str = URLEncoder.encode((String)((Map.Entry)localObject).getKey(), "UTF-8");
          localObject = URLEncoder.encode((String)((Map.Entry)localObject).getValue(), "UTF-8");
          localStringBuffer.append(str).append("=").append((String)localObject).append("&");
        }
        catch (Throwable localThrowable1)
        {
          Log.d("AppLink", localThrowable1.toString());
        }
      }
    }
    if (TBAppLinkSDK.getInstance().mTBAppLinkSecret != null) {}
    for (;;)
    {
      try
      {
        paramContext = TBAppLinkSDK.getInstance().mTBAppLinkSecret.sign(getSignContent(paramContext));
        if (!TBAppLinkStringUtil.isBlank(paramContext)) {
          this.mExtraParams.put("sign", paramContext);
        }
        paramContext = new JSONObject();
        if (this.mExtraParams == null) {
          break;
        }
        localIterator = this.mExtraParams.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((TBAppLinkStringUtil.isBlank((String)localEntry.getKey())) || (TBAppLinkStringUtil.isBlank((String)localEntry.getValue()))) {
          continue;
        }
        try
        {
          paramContext.put(URLEncoder.encode((String)localEntry.getKey(), "UTF-8"), URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
        }
        catch (Throwable localThrowable2)
        {
          Log.d("AppLink", localThrowable2.toString());
        }
        continue;
      }
      catch (Throwable paramContext)
      {
        Log.d("AppLink", paramContext.toString());
        continue;
      }
      paramContext = TBAppLinkMD5Util.encryptByMD5(getSignContent(paramContext));
      if (!TBAppLinkStringUtil.isBlank(paramContext)) {
        this.mExtraParams.put("sign", paramContext);
      }
    }
    if (!TextUtils.isEmpty(paramContext.toString())) {
      localStringBuffer.append("params").append("=").append(paramContext.toString()).append("&");
    }
    if (localStringBuffer.toString().endsWith("&")) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  public String getSignContent(Context paramContext)
  {
    if (TBAppLinkSDK.getInstance().sOpenParam == null) {}
    StringBuffer localStringBuffer;
    do
    {
      return null;
      String str = String.valueOf(System.currentTimeMillis());
      this.mExtraParams.put("time", str);
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("appkey").append(TBAppLinkSDK.getInstance().sOpenParam.mAppkey).append("packagename").append(TBAppInfo.getPackageName(paramContext)).append("time").append(str);
      if (TBAppLinkSDK.getInstance().mTBAppLinkSecret != null) {
        break;
      }
    } while (TBAppLinkStringUtil.isBlank(TBAppLinkSDK.getInstance().sOpenParam.mAppSecret));
    localStringBuffer.insert(0, TBAppLinkSDK.getInstance().sOpenParam.mAppSecret).append(TBAppLinkSDK.getInstance().sOpenParam.mAppSecret);
    return localStringBuffer.toString();
    return localStringBuffer.toString();
  }
  
  public TBBaseParam setBackUrl(String paramString)
  {
    if (!TBAppLinkStringUtil.isBlank(paramString)) {
      this.mParams.put("backURL", paramString);
    }
    return this;
  }
  
  public TBBaseParam setE(String paramString)
  {
    if (!TBAppLinkStringUtil.isBlank(paramString)) {
      this.mExtraParams.put("e", paramString);
    }
    return this;
  }
  
  public abstract void setParams(JSONObject paramJSONObject);
  
  public TBBaseParam setSign(String paramString)
  {
    if (!TBAppLinkStringUtil.isBlank(paramString)) {
      this.mExtraParams.put("sign", paramString);
    }
    return this;
  }
  
  public TBBaseParam setType(String paramString)
  {
    if (!TBAppLinkStringUtil.isBlank(paramString)) {
      this.mExtraParams.put("type", paramString);
    }
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\param\TBBaseParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */