package com.alibaba.mtl.log.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;

public class l
{
  private static a jdField_a_of_type_ComAlibabaMtlLogEL$a = new a(null);
  private static b jdField_a_of_type_ComAlibabaMtlLogEL$b;
  private static String[] b = { "Unknown", "Unknown" };
  
  static
  {
    jdField_a_of_type_ComAlibabaMtlLogEL$b = new b(null);
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return "2G";
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return "3G";
    }
    return "4G";
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(jdField_a_of_type_ComAlibabaMtlLogEL$b, localIntentFilter);
  }
  
  public static void c(Context paramContext)
  {
    if (paramContext == null) {}
    while (jdField_a_of_type_ComAlibabaMtlLogEL$b == null) {
      return;
    }
    paramContext.unregisterReceiver(jdField_a_of_type_ComAlibabaMtlLogEL$b);
  }
  
  public static String[] getNetworkState(Context paramContext)
  {
    return b;
  }
  
  public static String getWifiAddress(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        String str = paramContext.getMacAddress();
        paramContext = str;
        if (TextUtils.isEmpty(str)) {
          paramContext = "00:00:00:00:00:00";
        }
        return paramContext;
      }
      return "00:00:00:00:00:00";
    }
    return "00:00:00:00:00:00";
  }
  
  public static boolean isConnected()
  {
    Object localObject = a.getContext();
    if (localObject != null) {
      try
      {
        localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
        if (localObject != null)
        {
          localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
          if (localObject != null)
          {
            boolean bool = ((NetworkInfo)localObject).isConnected();
            return bool;
          }
          return false;
        }
      }
      catch (Exception localException) {}
    }
    return true;
  }
  
  public static String u()
  {
    Object localObject = a.getContext();
    if (localObject == null) {
      return "Unknown";
    }
    try
    {
      if (((Context)localObject).getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", ((Context)localObject).getPackageName()) != 0) {
        return "Unknown";
      }
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject == null) {
        return "Unknown";
      }
      if (((NetworkInfo)localObject).isConnected())
      {
        if (((NetworkInfo)localObject).getType() == 1) {
          return "wifi";
        }
        if (((NetworkInfo)localObject).getType() == 0)
        {
          localObject = a(((NetworkInfo)localObject).getSubtype());
          return (String)localObject;
        }
      }
    }
    catch (Throwable localThrowable) {}
    return "Unknown";
  }
  
  private static class a
    implements Runnable
  {
    private Context a;
    
    public a a(Context paramContext)
    {
      this.a = paramContext;
      return this;
    }
    
    public void run()
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        try
        {
          if (this.a.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.a.getPackageName()) != 0)
          {
            l.a()[0] = "Unknown";
            return;
          }
          Object localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
          if (localObject == null)
          {
            l.a()[0] = "Unknown";
            return;
          }
          localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
          if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
          {
            if (1 == ((NetworkInfo)localObject).getType())
            {
              l.a()[0] = "Wi-Fi";
              return;
            }
            if (((NetworkInfo)localObject).getType() == 0)
            {
              l.a()[0] = "2G/3G";
              l.a()[1] = ((NetworkInfo)localObject).getSubtypeName();
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  private static class b
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      r.a().b(l.a().a(paramContext));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */