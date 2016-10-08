package com.xiaoenai.app.common.internal.di.b;

import com.xiaoenai.app.common.view.b.a.a;
import dagger.internal.b;

public final class d
  implements b<a>
{
  private final c b;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public d(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<a> a(c paramc)
  {
    return new d(paramc);
  }
  
  public a a()
  {
    return (a)dagger.internal.d.a(this.b.f(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */