package com.xiaoenai.app.common.internal.di.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.common.internal.di.b.i;
import com.xiaoenai.app.common.internal.di.b.s;
import com.xiaoenai.app.common.internal.di.b.u;
import com.xiaoenai.app.data.entity.mapper.AppModelEntityDataMapper;
import com.xiaoenai.app.data.entity.mapper.AppModelEntityDataMapper_Factory;
import com.xiaoenai.app.data.entity.mapper.ImageResultDataMapper_Factory;
import com.xiaoenai.app.data.entity.mapper.LoggerEntityDataMapper_Factory;
import com.xiaoenai.app.data.entity.mapper.UserEntityDataMapper;
import com.xiaoenai.app.data.entity.mapper.UserEntityDataMapper_Factory;

public final class t
  implements b
{
  private javax.inject.a<com.xiaoenai.app.data.d.k> A;
  private javax.inject.a<com.xiaoenai.app.data.d.j> B;
  private javax.inject.a<com.xiaoenai.app.data.e.c> C;
  private javax.inject.a<com.xiaoenai.app.data.d.a> D;
  private javax.inject.a<com.xiaoenai.app.data.d.m> E;
  private javax.inject.a<com.xiaoenai.app.data.e.a.d.b> F;
  private javax.inject.a<UserEntityDataMapper> G;
  private javax.inject.a<com.xiaoenai.app.data.e.q> H;
  private javax.inject.a<com.xiaoenai.app.domain.e.e> I;
  private javax.inject.a<com.xiaoenai.app.common.b.a> J;
  private javax.inject.a<com.xiaoenai.app.data.e.o> K;
  private javax.inject.a<com.xiaoenai.app.domain.d.a.b> L;
  private javax.inject.a<com.xiaoenai.app.data.d.f> M;
  private javax.inject.a<com.xiaoenai.app.data.b.a> N;
  private javax.inject.a<com.xiaoenai.app.data.b.a.a.a> O;
  private javax.inject.a<com.xiaoenai.app.data.b.a.a> P;
  private javax.inject.a<com.xiaoenai.app.data.d.c.a> Q;
  private javax.inject.a<com.xiaoenai.app.data.e.a.b.f> R;
  private javax.inject.a<com.xiaoenai.app.data.e.e> S;
  private javax.inject.a<com.xiaoenai.app.domain.e.c> T;
  private javax.inject.a<com.xiaoenai.app.data.d.d.a> U;
  private javax.inject.a<com.xiaoenai.app.data.d.d.h> V;
  private javax.inject.a<Handler> b;
  private javax.inject.a<LocationManager> c;
  private javax.inject.a<com.xiaoenai.app.common.application.a.a.b> d;
  private javax.inject.a<com.xiaoenai.app.common.application.a.c> e;
  private javax.inject.a<com.xiaoenai.app.common.a.a> f;
  private dagger.a<BaseApplication> g;
  private javax.inject.a<Context> h;
  private javax.inject.a<BaseApplication> i;
  private javax.inject.a<com.xiaoenai.app.common.a> j;
  private javax.inject.a<com.xiaoenai.app.common.view.b.a.a> k;
  private javax.inject.a<com.xiaoenai.app.common.view.b.a> l;
  private javax.inject.a<com.xiaoenai.app.common.view.b.a.d> m;
  private javax.inject.a<com.xiaoenai.app.common.view.b.c> n;
  private javax.inject.a<com.xiaoenai.app.common.application.a.a.a> o;
  private javax.inject.a<com.xiaoenai.app.common.application.a.a> p;
  private javax.inject.a<com.xiaoenai.app.data.a.a.a> q;
  private javax.inject.a<com.xiaoenai.app.data.a.a> r;
  private javax.inject.a<com.xiaoenai.app.data.e.a.a.b> s;
  private javax.inject.a<AppModelEntityDataMapper> t;
  private javax.inject.a<com.xiaoenai.app.data.e.a> u;
  private javax.inject.a<com.xiaoenai.app.domain.e.a> v;
  private javax.inject.a<com.xiaoenai.app.data.a.a.c> w;
  private javax.inject.a<com.xiaoenai.app.data.a.b> x;
  private javax.inject.a<com.xiaoenai.app.data.d.a.e> y;
  private javax.inject.a<com.xiaoenai.app.data.d.a.b> z;
  
  static
  {
    if (!t.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private t(a parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    a(parama);
  }
  
  private void a(a parama)
  {
    this.b = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.m.a(a.a(parama)));
    this.c = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.o.a(a.a(parama)));
    this.d = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.j.a(a.a(parama)));
    this.e = dagger.internal.a.a(com.xiaoenai.app.common.application.a.d.a(this.d));
    this.f = dagger.internal.a.a(com.xiaoenai.app.common.a.b.b());
    this.g = com.xiaoenai.app.common.application.a.a(this.b, this.c, this.e, this.f);
    this.h = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.k.a(a.a(parama)));
    this.i = dagger.internal.a.a(i.a(a.a(parama)));
    this.j = dagger.internal.a.a(com.xiaoenai.app.common.b.b());
    this.k = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.d.a(a.a(parama)));
    this.l = dagger.internal.a.a(com.xiaoenai.app.common.view.b.b.a(this.k));
    this.m = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.l.a(a.a(parama)));
    this.n = dagger.internal.a.a(com.xiaoenai.app.common.view.b.d.a(this.m));
    this.o = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.h.a(a.a(parama)));
    this.p = dagger.internal.a.a(com.xiaoenai.app.common.application.a.b.a(this.o));
    this.q = dagger.internal.a.a(com.xiaoenai.app.data.a.a.b.a(this.h));
    this.r = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.f.a(a.a(parama), this.q));
    this.s = dagger.internal.a.a(com.xiaoenai.app.data.e.a.a.c.a(this.h, this.r));
    this.t = dagger.internal.a.a(AppModelEntityDataMapper_Factory.create());
    this.u = dagger.internal.a.a(com.xiaoenai.app.data.e.b.a(this.s, this.t));
    this.v = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.g.a(a.a(parama), this.u));
    this.w = dagger.internal.a.a(com.xiaoenai.app.data.a.a.d.a(this.h, this.r));
    this.x = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.q.a(a.a(parama), this.w));
    this.y = s.a(a.a(parama));
    this.z = dagger.internal.a.a(com.xiaoenai.app.data.d.a.c.a(this.h, this.y));
    this.A = dagger.internal.a.a(com.xiaoenai.app.data.d.l.a(this.z));
    this.B = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.p.a(a.a(parama), this.A));
    this.C = dagger.internal.a.a(com.xiaoenai.app.data.e.d.a(this.h));
    this.D = com.xiaoenai.app.common.internal.di.b.e.a(a.a(parama));
    this.E = com.xiaoenai.app.data.d.n.a(this.h, this.v, this.C, this.D);
    this.F = dagger.internal.a.a(com.xiaoenai.app.data.e.a.d.c.a(this.h, this.x, this.B, this.E));
    this.G = dagger.internal.a.a(UserEntityDataMapper_Factory.create());
    this.H = dagger.internal.a.a(com.xiaoenai.app.data.e.r.a(this.F, this.G));
    this.I = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.r.a(a.a(parama), this.H));
    this.J = dagger.internal.a.a(com.xiaoenai.app.common.b.b.b());
    this.K = dagger.internal.a.a(com.xiaoenai.app.data.e.p.a(this.h, this.s));
    this.L = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.n.a(a.a(parama)));
    this.M = dagger.internal.a.a(com.xiaoenai.app.data.d.g.a(this.L));
    this.N = dagger.internal.a.a(com.xiaoenai.app.data.b.b.a(this.h, this.v));
    this.O = dagger.internal.a.a(com.xiaoenai.app.data.b.a.a.b.a(this.N));
    this.P = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.t.a(a.a(parama), this.O));
    this.Q = com.xiaoenai.app.data.d.c.d.a(dagger.internal.c.a(), this.h, this.B, this.E, this.M, this.b);
    this.R = dagger.internal.a.a(com.xiaoenai.app.data.e.a.b.g.a(this.P, this.Q));
    this.S = dagger.internal.a.a(com.xiaoenai.app.data.e.f.a(this.R, LoggerEntityDataMapper_Factory.create()));
    this.T = dagger.internal.a.a(u.a(a.a(parama), this.S));
    this.U = com.xiaoenai.app.data.d.d.g.a(dagger.internal.c.a(), this.h, this.B, this.E, this.M, this.b);
    this.V = dagger.internal.a.a(com.xiaoenai.app.data.d.d.l.a(this.U, ImageResultDataMapper_Factory.create()));
  }
  
  public static a y()
  {
    return new a(null);
  }
  
  public Context a()
  {
    return (Context)this.h.get();
  }
  
  public void a(BaseApplication paramBaseApplication)
  {
    this.g.a(paramBaseApplication);
  }
  
  public BaseApplication b()
  {
    return (BaseApplication)this.i.get();
  }
  
  public com.xiaoenai.app.common.a c()
  {
    return (com.xiaoenai.app.common.a)this.j.get();
  }
  
  public com.xiaoenai.app.common.application.a.c d()
  {
    return (com.xiaoenai.app.common.application.a.c)this.e.get();
  }
  
  public com.xiaoenai.app.common.view.b.a e()
  {
    return (com.xiaoenai.app.common.view.b.a)this.l.get();
  }
  
  public com.xiaoenai.app.common.view.b.c f()
  {
    return (com.xiaoenai.app.common.view.b.c)this.n.get();
  }
  
  public com.xiaoenai.app.common.application.a.a g()
  {
    return (com.xiaoenai.app.common.application.a.a)this.p.get();
  }
  
  public Handler h()
  {
    return (Handler)this.b.get();
  }
  
  public LocationManager i()
  {
    return (LocationManager)this.c.get();
  }
  
  public com.xiaoenai.app.data.a.a j()
  {
    return (com.xiaoenai.app.data.a.a)this.r.get();
  }
  
  public com.xiaoenai.app.domain.e.a k()
  {
    return (com.xiaoenai.app.domain.e.a)this.v.get();
  }
  
  public com.xiaoenai.app.data.a.b l()
  {
    return (com.xiaoenai.app.data.a.b)this.x.get();
  }
  
  public com.xiaoenai.app.domain.e.e m()
  {
    return (com.xiaoenai.app.domain.e.e)this.I.get();
  }
  
  public com.xiaoenai.app.common.b.a n()
  {
    return (com.xiaoenai.app.common.b.a)this.J.get();
  }
  
  public com.xiaoenai.app.data.e.o o()
  {
    return (com.xiaoenai.app.data.e.o)this.K.get();
  }
  
  public com.xiaoenai.app.data.e.c p()
  {
    return (com.xiaoenai.app.data.e.c)this.C.get();
  }
  
  public com.xiaoenai.app.data.d.j q()
  {
    return (com.xiaoenai.app.data.d.j)this.B.get();
  }
  
  public com.xiaoenai.app.data.d.f r()
  {
    return (com.xiaoenai.app.data.d.f)this.M.get();
  }
  
  public com.xiaoenai.app.data.d.a s()
  {
    return (com.xiaoenai.app.data.d.a)this.D.get();
  }
  
  public com.xiaoenai.app.data.b.a t()
  {
    return (com.xiaoenai.app.data.b.a)this.N.get();
  }
  
  public com.xiaoenai.app.domain.e.c u()
  {
    return (com.xiaoenai.app.domain.e.c)this.T.get();
  }
  
  public com.xiaoenai.app.common.a.a v()
  {
    return (com.xiaoenai.app.common.a.a)this.f.get();
  }
  
  public com.xiaoenai.app.data.d.d.h w()
  {
    return (com.xiaoenai.app.data.d.d.h)this.V.get();
  }
  
  public com.xiaoenai.app.data.d.a.e x()
  {
    return (com.xiaoenai.app.data.d.a.e)this.y.get();
  }
  
  public static final class a
  {
    private com.xiaoenai.app.common.internal.di.b.c a;
    
    public b a()
    {
      if (this.a == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.b.c.class.getCanonicalName() + " must be set");
      }
      return new t(this, null);
    }
    
    public a a(com.xiaoenai.app.common.internal.di.b.c paramc)
    {
      this.a = ((com.xiaoenai.app.common.internal.di.b.c)dagger.internal.d.a(paramc));
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\internal\di\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */