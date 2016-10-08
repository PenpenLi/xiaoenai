package com.xiaoenai.app.feature.feedback.a.a.b;

import dagger.internal.d;

public final class c
  implements dagger.internal.b<com.xiaoenai.app.domain.e.b>
{
  private final a b;
  private final javax.inject.a<com.xiaoenai.app.data.e.b.a> c;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public c(a parama, javax.inject.a<com.xiaoenai.app.data.e.b.a> parama1)
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
  
  public static dagger.internal.b<com.xiaoenai.app.domain.e.b> a(a parama, javax.inject.a<com.xiaoenai.app.data.e.b.a> parama1)
  {
    return new c(parama, parama1);
  }
  
  public com.xiaoenai.app.domain.e.b a()
  {
    return (com.xiaoenai.app.domain.e.b)d.a(this.b.a((com.xiaoenai.app.data.e.b.a)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\feedback\a\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */