package com.xiaoenai.app.data.d;

import javax.inject.a;

public final class g
  implements dagger.internal.b<f>
{
  private final a<com.xiaoenai.app.domain.d.a.b> b;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public g(a<com.xiaoenai.app.domain.d.a.b> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static dagger.internal.b<f> a(a<com.xiaoenai.app.domain.d.a.b> parama)
  {
    return new g(parama);
  }
  
  public f a()
  {
    return new f((com.xiaoenai.app.domain.d.a.b)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */