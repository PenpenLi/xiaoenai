package com.xiaoenai.app.common.internal.di.a;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.common.view.activity.BaseActivity;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;

public final class c
  implements a
{
  private javax.inject.a<com.xiaoenai.app.common.a> b;
  private javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private dagger.a<BaseActivity> e;
  private javax.inject.a<com.xiaoenai.app.data.e.o> f;
  private javax.inject.a<com.xiaoenai.app.domain.e.a> g;
  private dagger.a<TitleBarActivity> h;
  private javax.inject.a<Activity> i;
  private javax.inject.a<Context> j;
  private javax.inject.a<BaseApplication> k;
  private javax.inject.a<com.xiaoenai.app.common.view.b.c> l;
  private javax.inject.a<Handler> m;
  private javax.inject.a<LocationManager> n;
  private javax.inject.a<com.xiaoenai.app.data.e.c> o;
  private javax.inject.a<com.xiaoenai.app.data.a.a> p;
  private javax.inject.a<com.xiaoenai.app.data.a.b> q;
  private javax.inject.a<com.xiaoenai.app.domain.e.e> r;
  private javax.inject.a<com.xiaoenai.app.common.b.a> s;
  private javax.inject.a<com.xiaoenai.app.data.b.a> t;
  
  static
  {
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private c(a parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    a(parama);
  }
  
  private void a(a parama)
  {
    this.b = new d(this, parama);
    this.c = new l(this, parama);
    this.d = new m(this, parama);
    this.e = com.xiaoenai.app.common.view.activity.a.a(this.b, this.c, this.d);
    this.f = new n(this, parama);
    this.g = new o(this, parama);
    this.h = com.xiaoenai.app.common.view.activity.c.a(this.b, this.c, this.d, this.f, this.g);
    this.i = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.b.a(a.b(parama)));
    this.j = new p(this, parama);
    this.k = new q(this, parama);
    this.l = new r(this, parama);
    this.m = new s(this, parama);
    this.n = new e(this, parama);
    this.o = new f(this, parama);
    this.p = new g(this, parama);
    this.q = new h(this, parama);
    this.r = new i(this, parama);
    this.s = new j(this, parama);
    this.t = new k(this, parama);
  }
  
  public static a c()
  {
    return new a(null);
  }
  
  public com.xiaoenai.app.common.view.b.c a()
  {
    return (com.xiaoenai.app.common.view.b.c)this.l.get();
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.e.a(paramBaseActivity);
  }
  
  public void a(TitleBarActivity paramTitleBarActivity)
  {
    this.h.a(paramTitleBarActivity);
  }
  
  public com.xiaoenai.app.domain.e.e b()
  {
    return (com.xiaoenai.app.domain.e.e)this.r.get();
  }
  
  public static final class a
  {
    private com.xiaoenai.app.common.internal.di.b.a a;
    private b b;
    
    public a a()
    {
      if (this.a == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.b.a.class.getCanonicalName() + " must be set");
      }
      if (this.b == null) {
        throw new IllegalStateException(b.class.getCanonicalName() + " must be set");
      }
      return new c(this, null);
    }
    
    public a a(b paramb)
    {
      this.b = ((b)dagger.internal.d.a(paramb));
      return this;
    }
    
    public a a(com.xiaoenai.app.common.internal.di.b.a parama)
    {
      this.a = ((com.xiaoenai.app.common.internal.di.b.a)dagger.internal.d.a(parama));
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */