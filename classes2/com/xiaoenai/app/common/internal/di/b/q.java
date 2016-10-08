package com.xiaoenai.app.common.internal.di.b;

import dagger.internal.d;
import javax.inject.a;

public final class q
  implements dagger.internal.b<com.xiaoenai.app.data.a.b>
{
  private final c b;
  private final a<com.xiaoenai.app.data.a.a.c> c;
  
  static
  {
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public q(c paramc, a<com.xiaoenai.app.data.a.a.c> parama)
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
  
  public static dagger.internal.b<com.xiaoenai.app.data.a.b> a(c paramc, a<com.xiaoenai.app.data.a.a.c> parama)
  {
    return new q(paramc, parama);
  }
  
  public com.xiaoenai.app.data.a.b a()
  {
    return (com.xiaoenai.app.data.a.b)d.a(this.b.a((com.xiaoenai.app.data.a.a.c)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */