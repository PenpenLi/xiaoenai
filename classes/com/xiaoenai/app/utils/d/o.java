package com.xiaoenai.app.utils.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class o
{
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
  }
  
  public static boolean c(Context paramContext)
  {
    int i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1).getSubtype();
    return (i == 1) || (i == 2) || (i == 4);
  }
  
  public static boolean d(Context paramContext)
  {
    return ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
  }
  
  public static boolean e(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      Method localMethod = Class.forName(paramContext.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String f(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
    {
      switch (paramContext.getType())
      {
      default: 
        return "unknow";
      case 1: 
        return "wifi";
      }
      switch (paramContext.getSubtype())
      {
      default: 
        return "unknow";
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        return "2g";
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        return "3g";
      }
      return "4g";
    }
    return "unknow";
  }
  
  public static boolean g(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    for (int i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);; i = 0) {
      return i == 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */