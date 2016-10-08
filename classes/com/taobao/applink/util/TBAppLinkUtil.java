package com.taobao.applink.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.taobao.applink.appinfo.TBAppInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class TBAppLinkUtil
{
  public static final String ACTION_CUSTOM = "com.taobao.open.intent.action.GETWAY";
  public static final String ACTION_JUMP = "ali.open.nav";
  public static final String AUTH_ACTION = "com.taobao.applink.ACTION_AUTH_SUCCESS";
  public static final String BASE_TB_VERSION = "5.2.0";
  public static final String BASE_URL = "tbopen://m.taobao.com/tbopen/index.html?";
  public static final String DOWNLOAD_TAOBAO_URL = "http://huodong.m.taobao.com/go/2085.html";
  public static final String GO_AUTH_H5URL = "http://oauth.m.taobao.com/authorize?response_type=code&client_id=%s&redirect_uri=%s&view=wap";
  public static final String GO_DETAIL_H5URL = "http://h5.m.taobao.com/awp/core/detail.htm?id=%s&";
  public static final String GO_SHOP_H5URL = "http://shop.m.taobao.com/shop/shopIndex.htm?shop_id=%s&";
  public static final String METHOD = "method";
  public static final String SDKVERSION = "1.0";
  public static final String TAG = "AppLink";
  public static final String TAOPACKAGENAME = "com.taobao.taobao";
  private static Application sApplication;
  
  public static Application getApplication()
  {
    try
    {
      if (sApplication == null) {
        sApplication = getSystemApp();
      }
      Application localApplication = sApplication;
      return localApplication;
    }
    finally {}
  }
  
  private static Application getSystemApp()
  {
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getDeclaredMethod("currentActivityThread", new Class[0]);
      localObject2 = ((Class)localObject2).getDeclaredField("mInitialApplication");
      ((Field)localObject2).setAccessible(true);
      localObject1 = (Application)((Field)localObject2).get(((Method)localObject1).invoke(null, new Object[0]));
      return (Application)localObject1;
    }
    catch (Exception localException)
    {
      Log.d("AppLink", localException.toString());
    }
    return null;
  }
  
  public static boolean isSupportAppLinkSDK(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("tbopen://m.taobao.com/tbopen/index.html?"));
    localIntent.setAction("com.taobao.open.intent.action.GETWAY");
    try
    {
      if (localPackageManager.getPackageInfo("com.taobao.taobao", 0) == null) {
        return false;
      }
      if (localPackageManager.queryIntentActivities(localIntent, 65536).size() > 0)
      {
        paramContext = TBAppInfo.getTaoVersion(paramContext);
        if (!TBAppLinkStringUtil.isBlank(paramContext))
        {
          boolean bool = TBAppLinkStringUtil.compatVersion(paramContext, "5.2.0");
          return bool;
        }
      }
    }
    catch (Exception paramContext)
    {
      Log.d("AppLink", paramContext.toString());
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\util\TBAppLinkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */