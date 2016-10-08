package com.xiaoenai.app.common.internal.di.b;

import dagger.internal.d;

public final class n
  implements dagger.internal.b<com.xiaoenai.app.domain.d.a.b>
{
  private final c b;
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public n(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static dagger.internal.b<com.xiaoenai.app.domain.d.a.b> a(c paramc)
  {
    return new n(paramc);
  }
  
  public com.xiaoenai.app.domain.d.a.b a()
  {
    return (com.xiaoenai.app.domain.d.a.b)d.a(this.b.i(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */