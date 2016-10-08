package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public final class c
{
  private static LocationManager a = null;
  
  public static Location a(String paramString)
  {
    Location localLocation = null;
    try
    {
      LocationManager localLocationManager = a;
      if (localLocationManager != null) {
        localLocation = localLocationManager.getLastKnownLocation(paramString);
      }
      return localLocation;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (a == null)) {
      a = (LocationManager)paramContext.getSystemService("location");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */