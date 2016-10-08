package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class d
{
  private static String a = null;
  private static PackageManager b = null;
  
  public static String a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (b == null))
    {
      a = paramContext.getPackageName();
      b = paramContext.getPackageManager();
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      PackageManager localPackageManager = b;
      if (localPackageManager != null)
      {
        boolean bool = localPackageManager.hasSystemFeature(paramString);
        return bool;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String b()
  {
    try
    {
      if ((b != null) && (a != null))
      {
        Object localObject = b.getPackageInfo(a, 0);
        if (localObject != null)
        {
          localObject = ((PackageInfo)localObject).versionName;
          if (localObject != null)
          {
            int i = ((String)localObject).length();
            if (i != 0) {
              return (String)localObject;
            }
          }
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */