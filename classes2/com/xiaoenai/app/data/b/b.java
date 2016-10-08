package com.xiaoenai.app.data.b;

import android.content.Context;

public final class b
  implements dagger.internal.b<a>
{
  private final javax.inject.a<Context> b;
  private final javax.inject.a<com.xiaoenai.app.domain.e.a> c;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public b(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.domain.e.a> parama1)
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
  
  public static dagger.internal.b<a> a(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.domain.e.a> parama1)
  {
    return new b(parama, parama1);
  }
  
  public a a()
  {
    return new a((Context)this.b.get(), (com.xiaoenai.app.domain.e.a)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */