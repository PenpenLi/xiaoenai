package com.xiaoenai.app.data.e.a.d;

import android.content.Context;
import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.m;
import javax.inject.a;

public final class c
  implements dagger.internal.b<b>
{
  private final a<Context> b;
  private final a<com.xiaoenai.app.data.a.b> c;
  private final a<j> d;
  private final a<m> e;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public c(a<Context> parama, a<com.xiaoenai.app.data.a.b> parama1, a<j> parama2, a<m> parama3)
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
  
  public static dagger.internal.b<b> a(a<Context> parama, a<com.xiaoenai.app.data.a.b> parama1, a<j> parama2, a<m> parama3)
  {
    return new c(parama, parama1, parama2, parama3);
  }
  
  public b a()
  {
    return new b((Context)this.b.get(), (com.xiaoenai.app.data.a.b)this.c.get(), (j)this.d.get(), (m)this.e.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */