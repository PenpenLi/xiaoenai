package com.xiaoenai.app.data.e.a.b;

import dagger.internal.b;

public final class g
  implements b<f>
{
  private final javax.inject.a<com.xiaoenai.app.data.b.a.a> b;
  private final javax.inject.a<com.xiaoenai.app.data.d.c.a> c;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public g(javax.inject.a<com.xiaoenai.app.data.b.a.a> parama, javax.inject.a<com.xiaoenai.app.data.d.c.a> parama1)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    if ((!a) && (parama1 == null)) {
      throw new AssertionError();
    }
    this.c = parama1;
  }
  
  public static b<f> a(javax.inject.a<com.xiaoenai.app.data.b.a.a> parama, javax.inject.a<com.xiaoenai.app.data.d.c.a> parama1)
  {
    return new g(parama, parama1);
  }
  
  public f a()
  {
    return new f((com.xiaoenai.app.data.b.a.a)this.b.get(), (com.xiaoenai.app.data.d.c.a)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */