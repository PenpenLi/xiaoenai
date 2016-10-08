package com.alibaba.sdk.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.alibaba.sdk.android.network.ConnectType;
import com.alibaba.sdk.android.network.MobileNetworkType;

public class NetworkUtils
{
  public static ConnectType getConnectType(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      switch (paramContext.getType())
      {
      default: 
        return ConnectType.CONNECT_TYPE_OTHER;
      case 0: 
        return ConnectType.CONNECT_TYPE_MOBILE;
      }
      return ConnectType.CONNECT_TYPE_WIFI;
    }
    return ConnectType.CONNECT_TYPE_DISCONNECT;
  }
  
  public static String getLocalMacAddress(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext != null) {}
    for (paramContext = paramContext.getMacAddress();; paramContext = null) {
      return paramContext;
    }
  }
  
  public static MobileNetworkType getMobileNetworkType(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.getType() == 0) && (paramContext.isConnected())) {
      return getNetWorkType(paramContext.getSubtype());
    }
    return MobileNetworkType.MOBILE_NETWORK_TYPE_UNKNOWN;
  }
  
  private static MobileNetworkType getNetWorkType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return MobileNetworkType.MOBILE_NETWORK_TYPE_UNKNOWN;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return MobileNetworkType.MOBILE_NETWORK_TYPE_2G;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return MobileNetworkType.MOBILE_NETWORK_TYPE_3G;
    }
    return MobileNetworkType.MOBILE_NETWORK_TYPE_4G;
  }
  
  public static boolean isNetworkAvaiable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */