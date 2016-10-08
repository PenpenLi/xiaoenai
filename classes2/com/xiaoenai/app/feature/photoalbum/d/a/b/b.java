package com.xiaoenai.app.feature.photoalbum.d.a.b;

import dagger.internal.d;

public final class b
  implements dagger.internal.b<com.xiaoenai.app.data.b.b.a>
{
  private final a b;
  private final javax.inject.a<com.xiaoenai.app.data.b.b.a.a> c;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public b(a parama, javax.inject.a<com.xiaoenai.app.data.b.b.a.a> parama1)
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
  
  public static dagger.internal.b<com.xiaoenai.app.data.b.b.a> a(a parama, javax.inject.a<com.xiaoenai.app.data.b.b.a.a> parama1)
  {
    return new b(parama, parama1);
  }
  
  public com.xiaoenai.app.data.b.b.a a()
  {
    return (com.xiaoenai.app.data.b.b.a)d.a(this.b.a((com.xiaoenai.app.data.b.b.a.a)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\d\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */