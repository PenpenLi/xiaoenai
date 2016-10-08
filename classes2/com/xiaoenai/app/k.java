package com.xiaoenai.app;

import android.location.LocationManager;
import android.os.Handler;

public final class k
  implements dagger.a<Xiaoenai>
{
  private final javax.inject.a<Handler> b;
  private final javax.inject.a<LocationManager> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.c> d;
  private final javax.inject.a<com.xiaoenai.app.common.a.a> e;
  private final javax.inject.a<com.xiaoenai.app.domain.e.c> f;
  
  static
  {
    if (!k.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public k(javax.inject.a<Handler> parama, javax.inject.a<LocationManager> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.c> parama2, javax.inject.a<com.xiaoenai.app.common.a.a> parama3, javax.inject.a<com.xiaoenai.app.domain.e.c> parama4)
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
  }
  
  public static dagger.a<Xiaoenai> a(javax.inject.a<Handler> parama, javax.inject.a<LocationManager> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.c> parama2, javax.inject.a<com.xiaoenai.app.common.a.a> parama3, javax.inject.a<com.xiaoenai.app.domain.e.c> parama4)
  {
    return new k(parama, parama1, parama2, parama3, parama4);
  }
  
  public void a(Xiaoenai paramXiaoenai)
  {
    if (paramXiaoenai == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.xiaoenai.app.common.application.a.a(paramXiaoenai, this.b);
    com.xiaoenai.app.common.application.a.b(paramXiaoenai, this.c);
    com.xiaoenai.app.common.application.a.c(paramXiaoenai, this.d);
    com.xiaoenai.app.common.application.a.d(paramXiaoenai, this.e);
    paramXiaoenai.G = ((com.xiaoenai.app.domain.e.c)this.f.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */