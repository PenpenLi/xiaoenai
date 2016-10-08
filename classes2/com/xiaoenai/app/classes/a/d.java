package com.xiaoenai.app.classes.a;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

class d
  implements BDLocationListener
{
  d(c paramc) {}
  
  public void onReceiveLocation(BDLocation paramBDLocation)
  {
    c.a(this.a, System.currentTimeMillis());
    if ((paramBDLocation != null) && (b.a(paramBDLocation.getLongitude(), paramBDLocation.getLatitude())))
    {
      c.a(this.a).b();
      if (c.b(this.a) != null)
      {
        c.b(this.a).c();
        c.c(this.a);
      }
    }
    do
    {
      do
      {
        return;
        if ((paramBDLocation == null) || (!b.a(paramBDLocation.getLongitude())) || (!b.a(paramBDLocation.getLatitude()))) {
          break;
        }
        c.a(this.a).b();
      } while (c.b(this.a) == null);
      c.b(this.a).a(paramBDLocation.getLongitude(), paramBDLocation.getLatitude(), paramBDLocation.getRadius());
      c.c(this.a);
      return;
    } while (c.d(this.a) - c.e(this.a) < 5000L);
    c.a(this.a).b();
    c.b(this.a).b();
    c.c(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */