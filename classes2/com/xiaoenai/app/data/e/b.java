package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.entity.mapper.AppModelEntityDataMapper;

public final class b
  implements dagger.internal.b<a>
{
  private final javax.inject.a<com.xiaoenai.app.data.e.a.a.b> b;
  private final javax.inject.a<AppModelEntityDataMapper> c;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public b(javax.inject.a<com.xiaoenai.app.data.e.a.a.b> parama, javax.inject.a<AppModelEntityDataMapper> parama1)
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
  
  public static dagger.internal.b<a> a(javax.inject.a<com.xiaoenai.app.data.e.a.a.b> parama, javax.inject.a<AppModelEntityDataMapper> parama1)
  {
    return new b(parama, parama1);
  }
  
  public a a()
  {
    return new a((com.xiaoenai.app.data.e.a.a.b)this.b.get(), (AppModelEntityDataMapper)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */