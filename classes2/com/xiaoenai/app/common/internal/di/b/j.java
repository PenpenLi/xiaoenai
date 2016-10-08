package com.xiaoenai.app.common.internal.di.b;

import dagger.internal.d;

public final class j
  implements dagger.internal.b<com.xiaoenai.app.common.application.a.a.b>
{
  private final c b;
  
  static
  {
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public j(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static dagger.internal.b<com.xiaoenai.app.common.application.a.a.b> a(c paramc)
  {
    return new j(paramc);
  }
  
  public com.xiaoenai.app.common.application.a.a.b a()
  {
    return (com.xiaoenai.app.common.application.a.a.b)d.a(this.b.e(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */