package com.xiaoenai.app.feature.feedback.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.common.view.activity.BaseActivity;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.data.entity.mapper.MessageEntityDataMapper;
import com.xiaoenai.app.data.entity.mapper.MessageEntityDataMapper_Factory;
import com.xiaoenai.app.feature.feedback.presenter.impl.FeedbackPresenterImpl;
import com.xiaoenai.app.feature.feedback.view.activity.FeedbackActivity;

public final class a
  implements u
{
  private javax.inject.a<com.xiaoenai.app.domain.e.b> A;
  private javax.inject.a<FeedbackPresenterImpl> B;
  private javax.inject.a<com.xiaoenai.app.feature.feedback.presenter.a> C;
  private dagger.a<FeedbackActivity> D;
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
  private javax.inject.a<com.xiaoenai.app.domain.e.c> u;
  private javax.inject.a<com.xiaoenai.app.common.a.a> v;
  private javax.inject.a<com.xiaoenai.app.feature.feedback.b.a.a> w;
  private javax.inject.a<MessageEntityDataMapper> x;
  private javax.inject.a<com.xiaoenai.app.data.d.a> y;
  private javax.inject.a<com.xiaoenai.app.data.e.b.a> z;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private a(a parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    a(parama);
  }
  
  private void a(a parama)
  {
    this.b = new b(this, parama);
    this.c = new m(this, parama);
    this.d = new n(this, parama);
    this.e = com.xiaoenai.app.common.view.activity.a.a(this.b, this.c, this.d);
    this.f = new o(this, parama);
    this.g = new p(this, parama);
    this.h = com.xiaoenai.app.common.view.activity.c.a(this.b, this.c, this.d, this.f, this.g);
    this.i = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.b.a(a.b(parama)));
    this.j = new q(this, parama);
    this.k = new r(this, parama);
    this.l = new s(this, parama);
    this.m = new t(this, parama);
    this.n = new c(this, parama);
    this.o = new d(this, parama);
    this.p = new e(this, parama);
    this.q = new f(this, parama);
    this.r = new g(this, parama);
    this.s = new h(this, parama);
    this.t = new i(this, parama);
    this.u = new j(this, parama);
    this.v = new k(this, parama);
    this.w = dagger.internal.a.a(com.xiaoenai.app.feature.feedback.b.a.b.b());
    this.x = dagger.internal.a.a(MessageEntityDataMapper_Factory.create());
    this.y = new l(this, parama);
    this.z = dagger.internal.a.a(com.xiaoenai.app.data.e.b.n.a(this.j, this.x, this.r, this.y));
    this.A = dagger.internal.a.a(com.xiaoenai.app.feature.feedback.a.a.b.c.a(a.c(parama), this.z));
    this.B = dagger.internal.a.a(com.xiaoenai.app.feature.feedback.presenter.impl.c.a(this.w, this.A, this.r, this.f));
    this.C = dagger.internal.a.a(com.xiaoenai.app.feature.feedback.a.a.b.b.a(a.c(parama), this.B));
    this.D = com.xiaoenai.app.feature.feedback.view.activity.q.a(this.b, this.c, this.d, this.f, this.g, this.u, this.o, this.v, this.C);
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
  
  public void a(FeedbackActivity paramFeedbackActivity)
  {
    this.D.a(paramFeedbackActivity);
  }
  
  public com.xiaoenai.app.domain.e.e b()
  {
    return (com.xiaoenai.app.domain.e.e)this.r.get();
  }
  
  public static final class a
  {
    private com.xiaoenai.app.common.internal.di.b.a a;
    private com.xiaoenai.app.feature.feedback.a.a.b.a b;
    private com.xiaoenai.app.common.internal.di.a.b c;
    
    public a a(com.xiaoenai.app.common.internal.di.a.b paramb)
    {
      this.c = ((com.xiaoenai.app.common.internal.di.a.b)dagger.internal.d.a(paramb));
      return this;
    }
    
    public a a(com.xiaoenai.app.common.internal.di.b.a parama)
    {
      this.a = ((com.xiaoenai.app.common.internal.di.b.a)dagger.internal.d.a(parama));
      return this;
    }
    
    public a a(com.xiaoenai.app.feature.feedback.a.a.b.a parama)
    {
      this.b = ((com.xiaoenai.app.feature.feedback.a.a.b.a)dagger.internal.d.a(parama));
      return this;
    }
    
    public u a()
    {
      if (this.a == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.b.a.class.getCanonicalName() + " must be set");
      }
      if (this.b == null) {
        throw new IllegalStateException(com.xiaoenai.app.feature.feedback.a.a.b.a.class.getCanonicalName() + " must be set");
      }
      if (this.c == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.a.b.class.getCanonicalName() + " must be set");
      }
      return new a(this, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */