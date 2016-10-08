package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class g
{
  private static Context a = null;
  private static WifiManager b = null;
  private static ConnectivityManager c = null;
  
  public static String a()
  {
    try
    {
      Object localObject = g();
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getMacAddress();
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (a == null)) {
      a = paramContext;
    }
    if ((paramContext != null) && (b == null)) {
      b = (WifiManager)paramContext.getSystemService("wifi");
    }
    if ((paramContext != null) && (c == null)) {
      c = (ConnectivityManager)paramContext.getSystemService("connectivity");
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject = g();
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getSSID();
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String c()
  {
    try
    {
      Object localObject = g();
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String d()
  {
    try
    {
      WifiInfo localWifiInfo = g();
      if (localWifiInfo != null)
      {
        int i = localWifiInfo.getRssi();
        return String.valueOf(i);
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String e()
  {
    try
    {
      Object localObject1 = c;
      if (localObject1 != null)
      {
        Object localObject2 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable()))
        {
          localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
          if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable()))
          {
            localObject2 = h();
            if (localObject2 != null) {
              return (String)localObject2;
            }
          }
          localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
          if ((localObject1 != null) && (((NetworkInfo)localObject1).isAvailable()))
          {
            InetAddress localInetAddress;
            do
            {
              do
              {
                localObject1 = NetworkInterface.getNetworkInterfaces();
                while (!((Enumeration)localObject2).hasMoreElements())
                {
                  do
                  {
                    do
                    {
                      if (!((Enumeration)localObject1).hasMoreElements()) {
                        break;
                      }
                    } while (localObject1 == null);
                    localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
                  } while (localObject2 == null);
                  localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
                }
              } while (localObject2 == null);
              localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
            } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()));
            localObject1 = localInetAddress.getHostAddress().toString();
            return (String)localObject1;
          }
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean f()
  {
    boolean bool = true;
    try
    {
      if (Build.VERSION.SDK_INT > 14)
      {
        str = System.getProperty("http.proxyHost");
        if ((str == null) || (str.length() <= 0)) {
          break label56;
        }
        return true;
      }
      String str = Proxy.getHost(a);
      if (str != null)
      {
        int i = str.length();
        if (i > 0) {}
      }
      else
      {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      bool = false;
    }
    return bool;
    label56:
    return false;
  }
  
  private static WifiInfo g()
  {
    WifiManager localWifiManager = b;
    if (localWifiManager != null) {
      return localWifiManager.getConnectionInfo();
    }
    return null;
  }
  
  private static String h()
  {
    try
    {
      Object localObject = b;
      if ((localObject != null) && (((WifiManager)localObject).isWifiEnabled()) && (g() != null))
      {
        int i = g().getIpAddress();
        localObject = (i & 0xFF) + "." + (i >> 8 & 0xFF) + "." + (i >> 16 & 0xFF) + "." + (i >> 24 & 0xFF);
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */