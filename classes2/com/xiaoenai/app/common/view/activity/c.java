package com.xiaoenai.app.common.view.activity;

import com.xiaoenai.app.data.e.o;

public final class c
  implements dagger.a<TitleBarActivity>
{
  private final javax.inject.a<com.xiaoenai.app.common.a> b;
  private final javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private final javax.inject.a<o> e;
  private final javax.inject.a<com.xiaoenai.app.domain.e.a> f;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public c(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4)
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
  
  public static dagger.a<TitleBarActivity> a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4)
  {
    return new c(parama, parama1, parama2, parama3, parama4);
  }
  
  public static void a(TitleBarActivity paramTitleBarActivity, javax.inject.a<o> parama)
  {
    paramTitleBarActivity.c = ((o)parama.get());
  }
  
  public static void b(TitleBarActivity paramTitleBarActivity, javax.inject.a<com.xiaoenai.app.domain.e.a> parama)
  {
    paramTitleBarActivity.d = ((com.xiaoenai.app.domain.e.a)parama.get());
  }
  
  public void a(TitleBarActivity paramTitleBarActivity)
  {
    if (paramTitleBarActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    paramTitleBarActivity.p = ((com.xiaoenai.app.common.a)this.b.get());
    paramTitleBarActivity.q = ((com.xiaoenai.app.common.view.b.a)this.c.get());
    paramTitleBarActivity.r = ((com.xiaoenai.app.common.application.a.a)this.d.get());
    paramTitleBarActivity.c = ((o)this.e.get());
    paramTitleBarActivity.d = ((com.xiaoenai.app.domain.e.a)this.f.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\common\view\activity\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */