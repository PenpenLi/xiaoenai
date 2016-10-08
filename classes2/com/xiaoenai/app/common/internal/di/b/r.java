package com.xiaoenai.app.common.internal.di.b;

import com.xiaoenai.app.data.e.q;
import com.xiaoenai.app.domain.e.e;
import dagger.internal.b;
import dagger.internal.d;
import javax.inject.a;

public final class r
  implements b<e>
{
  private final c b;
  private final a<q> c;
  
  static
  {
    if (!r.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public r(c paramc, a<q> parama)
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
  
  public static b<e> a(c paramc, a<q> parama)
  {
    return new r(paramc, parama);
  }
  
  public e a()
  {
    return (e)d.a(this.b.a((q)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */