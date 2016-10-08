package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public final class e
{
  private static SensorManager a = null;
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (a == null)) {
      a = (SensorManager)paramContext.getSystemService("sensor");
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = a;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(paramInt);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String b(int paramInt)
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(paramInt);
        if (localObject != null)
        {
          localObject = ((Sensor)localObject).getName();
          return (String)localObject;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String c(int paramInt)
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(paramInt);
        if (localObject != null)
        {
          localObject = ((Sensor)localObject).getVendor();
          return (String)localObject;
        }
      }
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */