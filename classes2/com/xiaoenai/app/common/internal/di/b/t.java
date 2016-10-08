package com.xiaoenai.app.common.internal.di.b;

import dagger.internal.b;
import dagger.internal.d;

public final class t
  implements b<com.xiaoenai.app.data.b.a.a>
{
  private final c b;
  private final javax.inject.a<com.xiaoenai.app.data.b.a.a.a> c;
  
  static
  {
    if (!t.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public t(c paramc, javax.inject.a<com.xiaoenai.app.data.b.a.a.a> parama)
  {
    if ((!a) && (paramc == null)) {
      throw new AssertionError();
    }
    this.b = paramc;
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.c = parama;
  }
  
  public static b<com.xiaoenai.app.data.b.a.a> a(c paramc, javax.inject.a<com.xiaoenai.app.data.b.a.a.a> parama)
  {
    return new t(paramc, parama);
  }
  
  public com.xiaoenai.app.data.b.a.a a()
  {
    return (com.xiaoenai.app.data.b.a.a)d.a(this.b.a((com.xiaoenai.app.data.b.a.a.a)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */