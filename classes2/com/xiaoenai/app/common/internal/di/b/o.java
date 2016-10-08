package com.xiaoenai.app.common.internal.di.b;

import android.location.LocationManager;
import dagger.internal.b;
import dagger.internal.d;

public final class o
  implements b<LocationManager>
{
  private final c b;
  
  static
  {
    if (!o.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public o(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<LocationManager> a(c paramc)
  {
    return new o(paramc);
  }
  
  public LocationManager a()
  {
    return (LocationManager)d.a(this.b.c(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */