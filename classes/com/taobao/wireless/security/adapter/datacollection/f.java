package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.telephony.TelephonyManager;

public final class f
{
  private static TelephonyManager a = null;
  
  public static String a()
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        if (localObject != null)
        {
          int i = ((String)localObject).length();
          if (i != 0) {
            return (String)localObject;
          }
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (a == null)) {
      a = (TelephonyManager)paramContext.getSystemService("phone");
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSubscriberId();
        if (localObject != null)
        {
          int i = ((String)localObject).length();
          if (i != 0) {
            return (String)localObject;
          }
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String c()
  {
    try
    {
      String str = a.getSimOperatorName();
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String d()
  {
    try
    {
      String str = a.getSimSerialNumber();
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String e()
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getNetworkOperatorName();
        if (localObject != null)
        {
          int i = ((String)localObject).length();
          if (i != 0) {
            return (String)localObject;
          }
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String f()
  {
    TelephonyManager localTelephonyManager = a;
    if (localTelephonyManager != null) {
      try
      {
        int i = localTelephonyManager.getNetworkType();
        switch (i)
        {
        default: 
          return "unknown";
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
      catch (Exception localException) {}
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */