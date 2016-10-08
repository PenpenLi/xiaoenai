package com.alibaba.sdk.android.login.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.login.LoginServiceProvider;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.system.RequestCode;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TaobaoLoginServiceProviderImpl
  implements LoginServiceProvider
{
  public static final LoginServiceProvider INSTANCE = new TaobaoLoginServiceProviderImpl();
  private static final String OAUTH_API = "taobao.oauth.code.create";
  
  private String getApkSignNumber(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getPackageManager().getPackageInfo(paramActivity.getPackageName(), 64);
      paramActivity = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramActivity.signatures[0].toByteArray()))).getSerialNumber().toString();
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
  }
  
  private String params2Str(TreeMap<String, String> paramTreeMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramTreeMap = paramTreeMap.entrySet().iterator();
    while (paramTreeMap.hasNext())
    {
      Object localObject = (Map.Entry)paramTreeMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        localStringBuilder.append(str).append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean showLogin(Activity paramActivity, LoginCallback paramLoginCallback)
  {
    boolean bool = false;
    paramLoginCallback = getApkSignNumber(paramActivity);
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("appKey", LoginContext.appContext.getAppKey());
    localTreeMap.put("apkSign", paramLoginCallback);
    localTreeMap.put("apiName", "taobao.oauth.code.create");
    Intent localIntent = new Intent();
    localIntent.setAction("com.taobao.open.intent.action.GETWAY");
    localIntent.setData(Uri.parse("tbopen://m.taobao.com/getway/oauth?" + "&appkey=" + LoginContext.appContext.getAppKey() + "&pluginName=" + "taobao.oauth.code.create" + "&apkSign=" + paramLoginCallback + "&sign=" + LoginContext.securityService.signTopOld(params2Str(localTreeMap))));
    if (paramActivity.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0)
    {
      paramActivity.startActivityForResult(localIntent, RequestCode.OPEN_TAOBAO);
      bool = true;
    }
    return bool;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\TaobaoLoginServiceProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */