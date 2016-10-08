package com.xiaoenai.app.classes.chat;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.xiaoenai.app.common.a.c;
import com.xiaoenai.app.common.service.BaseService;
import com.xiaoenai.app.utils.f.a;

public class ScreenManagerService
  extends BaseService
  implements SensorEventListener
{
  private SensorManager a;
  private Sensor b;
  private c c = null;
  private long d = 0L;
  
  private void a()
  {
    this.a.registerListener(this, this.b, 3);
    this.d = System.currentTimeMillis();
  }
  
  private void b()
  {
    this.a.unregisterListener(this);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onCreate()
  {
    super.onCreate();
    this.a = ((SensorManager)getSystemService("sensor"));
    this.b = this.a.getDefaultSensor(8);
    this.c = new c(this, getClass().getSimpleName());
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    b();
    if ((this.c != null) && (!this.c.a())) {
      this.c.c();
    }
    System.exit(0);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f = paramSensorEvent.values[0];
    a.c("-->  {}  | {} ", new Object[] { Float.valueOf(f), Float.valueOf(this.b.getMaximumRange()) });
    if (System.currentTimeMillis() - this.d < 800L) {
      return;
    }
    if (f >= this.b.getMaximumRange())
    {
      this.c.c();
      return;
    }
    this.c.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ScreenManagerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */