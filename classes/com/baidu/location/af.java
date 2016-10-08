package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

class af
  implements SensorEventListener, ax, n
{
  private static float g5;
  private static af g9;
  private boolean g3;
  float[] g4;
  SensorManager g6;
  float[] g7 = new float[9];
  float[] g8;
  
  public static af bw()
  {
    if (g9 == null) {
      g9 = new af();
    }
    return g9;
  }
  
  public float bu()
  {
    return g5;
  }
  
  public void bv()
  {
    try
    {
      if (this.g6 != null)
      {
        this.g6.unregisterListener(this);
        this.g6 = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void bx()
  {
    try
    {
      if (this.g6 == null) {
        this.g6 = ((SensorManager)f.getServiceContext().getSystemService("sensor"));
      }
      this.g6.registerListener(this, this.g6.getDefaultSensor(1), 3);
      this.g6.registerListener(this, this.g6.getDefaultSensor(2), 3);
      return;
    }
    finally {}
  }
  
  public boolean by()
  {
    return this.g3;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default: 
      if ((this.g4 != null) && (this.g8 != null))
      {
        paramSensorEvent = new float[9];
        if (SensorManager.getRotationMatrix(paramSensorEvent, null, this.g4, this.g8))
        {
          float[] arrayOfFloat = new float[3];
          SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
          g5 = (float)Math.toDegrees(arrayOfFloat[0]);
          if (g5 < 0.0F) {
            break label131;
          }
        }
      }
      break;
    }
    label131:
    for (double d = g5;; d = g5 + 360.0F)
    {
      g5 = (float)Math.floor(d);
      return;
      this.g4 = paramSensorEvent.values;
      break;
      this.g8 = paramSensorEvent.values;
      break;
    }
  }
  
  public void jdMethod_try(boolean paramBoolean)
  {
    this.g3 = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */