package com.xiaoenai.app.common.internal.di.b;

import com.xiaoenai.app.common.application.a.a.a;
import dagger.internal.b;
import dagger.internal.d;

public final class h
  implements b<a>
{
  private final c b;
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public h(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<a> a(c paramc)
  {
    return new h(paramc);
  }
  
  public a a()
  {
    return (a)d.a(this.b.h(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */