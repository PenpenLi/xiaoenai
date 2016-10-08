package com.unionpay.mobile.android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public final class c
{
  public static String a()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      Object localObject2 = ((Class)localObject1).newInstance();
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject2, new Object[] { "gsm.version.baseband", "no message" });
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = (Activity)paramContext;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 4160).versionName;
      return com.unionpay.mobile.android.languages.c.by.a;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static String b()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Runtime.getRuntime().exec("cat /proc/version");
      localObject1 = localObject2;
    }
    catch (IOException localIOException1)
    {
      try
      {
        for (;;)
        {
          BufferedReader localBufferedReader;
          Object localObject2 = localBufferedReader.readLine();
          if (localObject2 == null) {
            break;
          }
          localObject2 = (String)localObject1 + (String)localObject2;
          localObject1 = localObject2;
        }
        localIOException1 = localIOException1;
        localIOException1.printStackTrace();
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        if (localObject1 == "") {
          break label128;
        }
        try
        {
          int i = ((String)localObject1).indexOf("version ");
          localObject1 = ((String)localObject1).substring("version ".length() + i);
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).indexOf(" "));
          return (String)localObject1;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          localIndexOutOfBoundsException.printStackTrace();
        }
      }
    }
    localBufferedReader = new BufferedReader(new InputStreamReader(((Process)localObject1).getInputStream()), 8192);
    localObject1 = "";
    label128:
    return "";
  }
  
  public static final String b(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if ((paramContext != null) && (paramContext.getMacAddress() != null)) {
      return paramContext.getMacAddress().replaceAll(":", "");
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */