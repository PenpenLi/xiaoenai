package com.xiaoenai.app.feature.photoalbum.d.a.b;

import com.xiaoenai.app.data.e.g;
import dagger.internal.b;

public final class c
  implements b<com.xiaoenai.app.domain.e.d>
{
  private final a b;
  private final javax.inject.a<g> c;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public c(a parama, javax.inject.a<g> parama1)
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
  
  public static b<com.xiaoenai.app.domain.e.d> a(a parama, javax.inject.a<g> parama1)
  {
    return new c(parama, parama1);
  }
  
  public com.xiaoenai.app.domain.e.d a()
  {
    return (com.xiaoenai.app.domain.e.d)dagger.internal.d.a(this.b.a((g)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\d\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */