package com.xiaoenai.app.data.a.a;

import android.content.Context;

public final class b
  implements dagger.internal.b<a>
{
  private final javax.inject.a<Context> b;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public b(javax.inject.a<Context> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
  }
  
  public static dagger.internal.b<a> a(javax.inject.a<Context> parama)
  {
    return new b(parama);
  }
  
  public a a()
  {
    return new a((Context)this.b.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */