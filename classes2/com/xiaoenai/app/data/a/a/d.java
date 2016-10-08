package com.xiaoenai.app.data.a.a;

import android.content.Context;
import dagger.internal.b;

public final class d
  implements b<c>
{
  private final javax.inject.a<Context> b;
  private final javax.inject.a<com.xiaoenai.app.data.a.a> c;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public d(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.data.a.a> parama1)
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
  
  public static b<c> a(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.data.a.a> parama1)
  {
    return new d(parama, parama1);
  }
  
  public c a()
  {
    return new c((Context)this.b.get(), (com.xiaoenai.app.data.a.a)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */