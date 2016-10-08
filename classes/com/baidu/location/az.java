package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.location.b.a.a;

class az
  implements SensorEventListener, ax, n
{
  public static String iH = null;
  public static String iM = null;
  private static az iQ = null;
  int iI = -1;
  SensorManager iJ = null;
  int iK = -1;
  String iL = null;
  String iN = null;
  private Sensor iO;
  String iP = null;
  
  private az()
  {
    try
    {
      this.iL = ((TelephonyManager)f.getServiceContext().getSystemService("phone")).getDeviceId();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.iP = a.jdMethod_if(f.getServiceContext());
          try
          {
            iH = f.getServiceContext().getPackageName();
            return;
          }
          catch (Exception localException3)
          {
            iH = null;
          }
          localException1 = localException1;
          this.iL = "NULL";
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          this.iP = null;
        }
      }
    }
  }
  
  public static az cn()
  {
    if (iQ == null) {
      iQ = new az();
    }
    return iQ;
  }
  
  public String jdMethod_char(boolean paramBoolean)
  {
    return jdMethod_if(paramBoolean, null);
  }
  
  public String cj()
  {
    if (iH != null) {
      return ck() + "|" + iH;
    }
    return ck();
  }
  
  public String ck()
  {
    if (this.iP != null) {
      return "v4.2|" + this.iP + "|" + Build.MODEL;
    }
    return "v4.2" + this.iL + "|" + Build.MODEL;
  }
  
  public String cl()
  {
    return "&sdk=4.2" + co();
  }
  
  /* Error */
  public void cm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 128	com/baidu/location/ab:gv	Z
    //   5: ifeq +36 -> 41
    //   8: aload_0
    //   9: invokestatic 57	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   12: ldc -126
    //   14: invokevirtual 65	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 132	android/hardware/SensorManager
    //   20: putfield 47	com/baidu/location/az:iJ	Landroid/hardware/SensorManager;
    //   23: aload_0
    //   24: getfield 47	com/baidu/location/az:iJ	Landroid/hardware/SensorManager;
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 47	com/baidu/location/az:iJ	Landroid/hardware/SensorManager;
    //   32: iconst_5
    //   33: invokevirtual 136	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   36: iconst_3
    //   37: invokevirtual 140	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: astore_1
    //   50: goto -9 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	az
    //   44	4	1	localObject	Object
    //   49	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	41	44	finally
    //   2	41	49	java/lang/Exception
  }
  
  public String co()
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    if (this.iP != null)
    {
      localStringBuffer.append("&cu=");
      localStringBuffer.append(this.iP);
    }
    try
    {
      for (;;)
      {
        localStringBuffer.append("&mb=");
        localStringBuffer.append(Build.MODEL);
        localStringBuffer.append("&pack=");
        try
        {
          localStringBuffer.append(iH);
          localStringBuffer.append("&sdk=");
          localStringBuffer.append(4.2F);
          return localStringBuffer.toString();
          localStringBuffer.append("&im=");
          localStringBuffer.append(this.iL);
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public void cp()
  {
    try
    {
      if (this.iJ != null) {
        this.iJ.unregisterListener(this);
      }
      this.iJ = null;
      return;
    }
    finally {}
  }
  
  public String jdMethod_if(boolean paramBoolean, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(4.2F);
    if ((paramBoolean) && (c.aw.equals("all"))) {
      localStringBuffer.append("&addr=all");
    }
    if (paramBoolean)
    {
      if (paramString == null) {
        localStringBuffer.append("&coor=gcj02");
      }
    }
    else
    {
      if (this.iP != null) {
        break label265;
      }
      localStringBuffer.append("&im=");
      localStringBuffer.append(this.iL);
    }
    for (;;)
    {
      localStringBuffer.append("&fw=");
      localStringBuffer.append(f.getFrameVersion());
      localStringBuffer.append("&lt=1");
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      if (this.iK != -1)
      {
        localStringBuffer.append("&al=");
        localStringBuffer.append(this.iK);
      }
      localStringBuffer.append("&resid=");
      localStringBuffer.append("12");
      localStringBuffer.append("&os=A");
      localStringBuffer.append(Build.VERSION.SDK);
      if (paramBoolean)
      {
        localStringBuffer.append("&sv=");
        String str = Build.VERSION.RELEASE;
        paramString = str;
        if (str != null)
        {
          paramString = str;
          if (str.length() > 6) {
            paramString = str.substring(0, 6);
          }
        }
        localStringBuffer.append(paramString);
      }
      return localStringBuffer.toString();
      localStringBuffer.append("&coor=");
      localStringBuffer.append(paramString);
      break;
      label265:
      localStringBuffer.append("&cu=");
      localStringBuffer.append(this.iP);
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = paramSensorEvent.sensor.getType();
    if (i == 5) {
      this.iK = ((int)paramSensorEvent.values[0]);
    }
    while (i != 8) {
      return;
    }
    this.iI = ((int)paramSensorEvent.values[0]);
  }
  
  public String s(String paramString)
  {
    return jdMethod_if(true, paramString);
  }
  
  public void jdMethod_try(String paramString1, String paramString2)
  {
    iM = paramString1;
    iH = paramString2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */