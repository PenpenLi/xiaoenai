package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.alipay.sdk.data.c;
import com.alipay.sdk.data.e;
import com.alipay.sdk.widget.a;
import org.json.JSONObject;

public final class h
{
  private static final String a = "com.eg.android.AlipayGphone";
  private static final int b = 65;
  private static a c = null;
  private static String d = null;
  
  public static void a(Activity paramActivity, APAuthInfo paramAPAuthInfo)
  {
    Object localObject;
    if (a(paramActivity))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("alipayauth://platformapi/startapp");
      ((StringBuilder)localObject).append("?appId=20000122");
      ((StringBuilder)localObject).append("&approveType=005");
      ((StringBuilder)localObject).append("&scope=kuaijie");
      ((StringBuilder)localObject).append("&productId=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getProductId());
      ((StringBuilder)localObject).append("&thirdpartyId=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getAppId());
      ((StringBuilder)localObject).append("&redirectUri=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getRedirectUri());
      a(paramActivity, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        localObject = new a(paramActivity);
        c = (a)localObject;
        ((a)localObject).b();
        com.alipay.sdk.sys.b.a().a(paramActivity, com.alipay.sdk.data.d.a());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app_id=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getAppId());
      ((StringBuilder)localObject).append("&partner=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getPid());
      ((StringBuilder)localObject).append("&scope=kuaijie");
      ((StringBuilder)localObject).append("&login_goal=auth");
      ((StringBuilder)localObject).append("&redirect_url=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getRedirectUri());
      ((StringBuilder)localObject).append("&view=wap");
      ((StringBuilder)localObject).append("&prod_code=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getProductId());
      localObject = com.alipay.sdk.data.b.a(new c(), ((StringBuilder)localObject).toString(), new JSONObject());
      ((e)localObject).a.b = "com.alipay.mobilecashier";
      ((e)localObject).a.e = "com.alipay.mcpay";
      ((e)localObject).a.d = "4.0.0";
      ((e)localObject).a.c = "/cashier/main";
      new Thread(new i(new com.alipay.sdk.net.d(new c()), paramActivity, (e)localObject, paramAPAuthInfo)).start();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        c = null;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramActivity) {}
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.versionCode;
      if (i >= 65) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static void b(Activity paramActivity, APAuthInfo paramAPAuthInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alipayauth://platformapi/startapp");
    localStringBuilder.append("?appId=20000122");
    localStringBuilder.append("&approveType=005");
    localStringBuilder.append("&scope=kuaijie");
    localStringBuilder.append("&productId=");
    localStringBuilder.append(paramAPAuthInfo.getProductId());
    localStringBuilder.append("&thirdpartyId=");
    localStringBuilder.append(paramAPAuthInfo.getAppId());
    localStringBuilder.append("&redirectUri=");
    localStringBuilder.append(paramAPAuthInfo.getRedirectUri());
    a(paramActivity, localStringBuilder.toString());
  }
  
  private static void c(Activity paramActivity, APAuthInfo paramAPAuthInfo)
  {
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        localObject = new a(paramActivity);
        c = (a)localObject;
        ((a)localObject).b();
        com.alipay.sdk.sys.b.a().a(paramActivity, com.alipay.sdk.data.d.a());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("app_id=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getAppId());
      ((StringBuilder)localObject).append("&partner=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getPid());
      ((StringBuilder)localObject).append("&scope=kuaijie");
      ((StringBuilder)localObject).append("&login_goal=auth");
      ((StringBuilder)localObject).append("&redirect_url=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getRedirectUri());
      ((StringBuilder)localObject).append("&view=wap");
      ((StringBuilder)localObject).append("&prod_code=");
      ((StringBuilder)localObject).append(paramAPAuthInfo.getProductId());
      localObject = com.alipay.sdk.data.b.a(new c(), ((StringBuilder)localObject).toString(), new JSONObject());
      ((e)localObject).a.b = "com.alipay.mobilecashier";
      ((e)localObject).a.e = "com.alipay.mcpay";
      ((e)localObject).a.d = "4.0.0";
      ((e)localObject).a.c = "/cashier/main";
      new Thread(new i(new com.alipay.sdk.net.d(new c()), paramActivity, (e)localObject, paramAPAuthInfo)).start();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        c = null;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\auth\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */