package com.xiaoenai.app.common.internal.di.b;

import android.os.Handler;
import dagger.internal.b;
import dagger.internal.d;

public final class m
  implements b<Handler>
{
  private final c b;
  
  static
  {
    if (!m.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public m(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<Handler> a(c paramc)
  {
    return new m(paramc);
  }
  
  public Handler a()
  {
    return (Handler)d.a(this.b.d(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */