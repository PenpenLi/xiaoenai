package com.xiaoenai.app.data.d;

import android.content.Context;
import com.xiaoenai.app.data.e.c;
import dagger.internal.b;

public final class n
  implements b<m>
{
  private final javax.inject.a<Context> b;
  private final javax.inject.a<com.xiaoenai.app.domain.e.a> c;
  private final javax.inject.a<c> d;
  private final javax.inject.a<a> e;
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public n(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.domain.e.a> parama1, javax.inject.a<c> parama2, javax.inject.a<a> parama3)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    if ((!a) && (parama1 == null)) {
      throw new AssertionError();
    }
    this.c = parama1;
    if ((!a) && (parama2 == null)) {
      throw new AssertionError();
    }
    this.d = parama2;
    if ((!a) && (parama3 == null)) {
      throw new AssertionError();
    }
    this.e = parama3;
  }
  
  public static b<m> a(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.domain.e.a> parama1, javax.inject.a<c> parama2, javax.inject.a<a> parama3)
  {
    return new n(parama, parama1, parama2, parama3);
  }
  
  public m a()
  {
    return new m((Context)this.b.get(), (com.xiaoenai.app.domain.e.a)this.c.get(), (c)this.d.get(), (a)this.e.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */