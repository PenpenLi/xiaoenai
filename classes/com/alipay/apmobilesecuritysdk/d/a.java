package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public static Map<String, String> a(Context paramContext)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("AA1", paramContext.getPackageName());
      localHashMap.put("AA2", b(paramContext));
      localHashMap.put("AA3", "security-sdk-token");
      localHashMap.put("AA4", "3.0.2.20150525");
      return localHashMap;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "0.0.0";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */