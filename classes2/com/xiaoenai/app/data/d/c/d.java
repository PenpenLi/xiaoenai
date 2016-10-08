package com.xiaoenai.app.data.d.c;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.data.d.f;
import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.m;
import dagger.internal.b;
import dagger.internal.c;

public final class d
  implements b<a>
{
  private final dagger.a<a> b;
  private final javax.inject.a<Context> c;
  private final javax.inject.a<j> d;
  private final javax.inject.a<m> e;
  private final javax.inject.a<f> f;
  private final javax.inject.a<Handler> g;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public d(dagger.a<a> parama, javax.inject.a<Context> parama1, javax.inject.a<j> parama2, javax.inject.a<m> parama3, javax.inject.a<f> parama4, javax.inject.a<Handler> parama5)
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
    if ((!a) && (parama4 == null)) {
      throw new AssertionError();
    }
    this.f = parama4;
    if ((!a) && (parama5 == null)) {
      throw new AssertionError();
    }
    this.g = parama5;
  }
  
  public static b<a> a(dagger.a<a> parama, javax.inject.a<Context> parama1, javax.inject.a<j> parama2, javax.inject.a<m> parama3, javax.inject.a<f> parama4, javax.inject.a<Handler> parama5)
  {
    return new d(parama, parama1, parama2, parama3, parama4, parama5);
  }
  
  public a a()
  {
    return (a)c.a(this.b, new a((Context)this.c.get(), (j)this.d.get(), (m)this.e.get(), (f)this.f.get(), (Handler)this.g.get()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */