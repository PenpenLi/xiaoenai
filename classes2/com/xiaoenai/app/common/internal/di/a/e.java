package com.xiaoenai.app.common.internal.di.a;

import android.location.LocationManager;
import dagger.internal.d;

class e
  implements dagger.internal.b<LocationManager>
{
  private final b c = c.a.a(this.a);
  
  e(c paramc, c.a parama) {}
  
  public LocationManager a()
  {
    return (LocationManager)d.a(this.c.i(), "Cannot return null from a non-@Nullable component method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */