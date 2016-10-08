package com.baidu.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class aj$1
  implements SensorEventListener
{
  aj$1(aj paramaj) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    }
    double d;
    do
    {
      do
      {
        do
        {
          return;
          paramSensorEvent = (float[])paramSensorEvent.values.clone();
          aj.jdMethod_if(this.a, (float[])paramSensorEvent.clone());
          paramSensorEvent = aj.jdMethod_if(this.a, paramSensorEvent[0], paramSensorEvent[1], paramSensorEvent[2]);
        } while (aj.jdMethod_do(this.a) < 20);
        float f1 = paramSensorEvent[0];
        float f2 = paramSensorEvent[0];
        float f3 = paramSensorEvent[1];
        float f4 = paramSensorEvent[1];
        float f5 = paramSensorEvent[2];
        d = paramSensorEvent[2] * f5 + (f1 * f2 + f3 * f4);
        if (aj.jdMethod_for(this.a) != 0) {
          break;
        }
      } while (d <= 4.0D);
      aj.jdMethod_if(this.a, 1);
      return;
    } while (d >= 0.009999999776482582D);
    aj.jdMethod_if(this.a, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\aj$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */