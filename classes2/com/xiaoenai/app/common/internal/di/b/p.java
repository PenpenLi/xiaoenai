package com.xiaoenai.app.common.internal.di.b;

import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.k;
import dagger.internal.b;
import dagger.internal.d;
import javax.inject.a;

public final class p
  implements b<j>
{
  private final c b;
  private final a<k> c;
  
  static
  {
    if (!p.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public p(c paramc, a<k> parama)
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
  
  public static b<j> a(c paramc, a<k> parama)
  {
    return new p(paramc, parama);
  }
  
  public j a()
  {
    return (j)d.a(this.b.a((k)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */