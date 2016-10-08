package com.taobao.applink.appinfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;

public class TBAppInfo
{
  private static String sAppName;
  private static String sPackageName;
  private static String sTaoVersion;
  
  public static String getAppName(Context paramContext)
  {
    if (TextUtils.isEmpty(sAppName)) {}
    try
    {
      sAppName = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
      return sAppName;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.d("AppLink", paramContext.toString());
      }
    }
  }
  
  public static String getPackageName(Context paramContext)
  {
    if (TextUtils.isEmpty(sPackageName)) {
      sPackageName = paramContext.getPackageName();
    }
    return sPackageName;
  }
  
  public static String getTaoVersion(Context paramContext)
  {
    if ((TextUtils.isEmpty(sTaoVersion)) && (paramContext != null)) {}
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.taobao.taobao", 0);
      if (paramContext != null) {
        sTaoVersion = paramContext.versionName;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.d("AppLink", paramContext.toString());
      }
    }
    return sTaoVersion;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\appinfo\TBAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */