package com.xiaoenai.app.common.internal.di.b;

import dagger.internal.b;

public final class l
  implements b<com.xiaoenai.app.common.view.b.a.d>
{
  private final c b;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public l(c paramc)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
  }
  
  public static b<com.xiaoenai.app.common.view.b.a.d> a(c paramc)
  {
    return new l(paramc);
  }
  
  public com.xiaoenai.app.common.view.b.a.d a()
  {
    return (com.xiaoenai.app.common.view.b.a.d)dagger.internal.d.a(this.b.g(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */