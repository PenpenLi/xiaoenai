package com.xiaoenai.app.common.application;

import android.location.LocationManager;
import android.os.Handler;
import com.xiaoenai.app.common.application.a.c;

public final class a
  implements dagger.a<BaseApplication>
{
  private final javax.inject.a<Handler> b;
  private final javax.inject.a<LocationManager> c;
  private final javax.inject.a<c> d;
  private final javax.inject.a<com.xiaoenai.app.common.a.a> e;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public a(javax.inject.a<Handler> parama, javax.inject.a<LocationManager> parama1, javax.inject.a<c> parama2, javax.inject.a<com.xiaoenai.app.common.a.a> parama3)
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
  
  public static dagger.a<BaseApplication> a(javax.inject.a<Handler> parama, javax.inject.a<LocationManager> parama1, javax.inject.a<c> parama2, javax.inject.a<com.xiaoenai.app.common.a.a> parama3)
  {
    return new a(parama, parama1, parama2, parama3);
  }
  
  public static void a(BaseApplication paramBaseApplication, javax.inject.a<Handler> parama)
  {
    paramBaseApplication.H = ((Handler)parama.get());
  }
  
  public static void b(BaseApplication paramBaseApplication, javax.inject.a<LocationManager> parama)
  {
    paramBaseApplication.I = ((LocationManager)parama.get());
  }
  
  public static void c(BaseApplication paramBaseApplication, javax.inject.a<c> parama)
  {
    paramBaseApplication.J = ((c)parama.get());
  }
  
  public static void d(BaseApplication paramBaseApplication, javax.inject.a<com.xiaoenai.app.common.a.a> parama)
  {
    paramBaseApplication.K = ((com.xiaoenai.app.common.a.a)parama.get());
  }
  
  public void a(BaseApplication paramBaseApplication)
  {
    if (paramBaseApplication == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramBaseApplication.H = ((Handler)this.b.get());
    paramBaseApplication.I = ((LocationManager)this.c.get());
    paramBaseApplication.J = ((c)this.d.get());
    paramBaseApplication.K = ((com.xiaoenai.app.common.a.a)this.e.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\application\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */