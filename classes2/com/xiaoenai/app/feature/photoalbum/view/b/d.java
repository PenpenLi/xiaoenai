package com.xiaoenai.app.feature.photoalbum.view.b;

import com.xiaoenai.app.common.view.a.b;
import com.xiaoenai.app.domain.e.e;

public final class d
  implements dagger.a<c>
{
  private final javax.inject.a<com.xiaoenai.app.common.view.b.c> b;
  private final javax.inject.a<e> c;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public d(javax.inject.a<com.xiaoenai.app.common.view.b.c> parama, javax.inject.a<e> parama1)
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
  
  public static dagger.a<c> a(javax.inject.a<com.xiaoenai.app.common.view.b.c> parama, javax.inject.a<e> parama1)
  {
    return new d(parama, parama1);
  }
  
  public void a(c paramc)
  {
    if (paramc == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    b.a(paramc, this.b);
    paramc.a = ((e)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */