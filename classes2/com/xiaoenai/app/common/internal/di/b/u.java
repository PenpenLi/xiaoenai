package com.xiaoenai.app.common.internal.di.b;

import com.xiaoenai.app.data.e.e;
import dagger.internal.b;
import dagger.internal.d;
import javax.inject.a;

public final class u
  implements b<com.xiaoenai.app.domain.e.c>
{
  private final c b;
  private final a<e> c;
  
  static
  {
    if (!u.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public u(c paramc, a<e> parama)
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
  
  public static b<com.xiaoenai.app.domain.e.c> a(c paramc, a<e> parama)
  {
    return new u(paramc, parama);
  }
  
  public com.xiaoenai.app.domain.e.c a()
  {
    return (com.xiaoenai.app.domain.e.c)d.a(this.b.a((e)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */