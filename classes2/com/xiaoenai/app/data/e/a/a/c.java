package com.xiaoenai.app.data.e.a.a;

import android.content.Context;

public final class c
  implements dagger.internal.b<b>
{
  private final javax.inject.a<Context> b;
  private final javax.inject.a<com.xiaoenai.app.data.a.a> c;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public c(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.data.a.a> parama1)
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
  
  public static dagger.internal.b<b> a(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.data.a.a> parama1)
  {
    return new c(parama, parama1);
  }
  
  public b a()
  {
    return new b((Context)this.b.get(), (com.xiaoenai.app.data.a.a)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */