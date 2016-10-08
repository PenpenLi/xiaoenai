package com.xiaoenai.app.feature.photoalbum.d.a.a;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.common.view.activity.BaseActivity;
import com.xiaoenai.app.common.view.activity.TitleBarActivity;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper_Factory;
import com.xiaoenai.app.feature.photoalbum.preview.PhotoPreviewActivity;
import com.xiaoenai.app.feature.photoalbum.view.activity.PhotoAlbumActivity;
import com.xiaoenai.app.feature.photoalbum.view.activity.PostPhotoActivity;
import com.xiaoenai.app.feature.photoalbum.view.activity.ad;

public final class a
  implements y
{
  private javax.inject.a<com.xiaoenai.app.data.b.b.a.a> A;
  private javax.inject.a<com.xiaoenai.app.data.b.b.a> B;
  private javax.inject.a<AlbumEntityDataMapper> C;
  private javax.inject.a<com.xiaoenai.app.data.e.a.c.l> D;
  private javax.inject.a<com.xiaoenai.app.data.e.g> E;
  private javax.inject.a<com.xiaoenai.app.domain.e.d> F;
  private javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.c> G;
  private dagger.a<PhotoAlbumActivity> H;
  private javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.a> I;
  private dagger.a<PostPhotoActivity> J;
  private dagger.a<PhotoPreviewActivity> K;
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
  private javax.inject.a<com.xiaoenai.app.data.d.j> u;
  private javax.inject.a<com.xiaoenai.app.data.d.a> v;
  private javax.inject.a<com.xiaoenai.app.data.d.m> w;
  private javax.inject.a<com.xiaoenai.app.data.d.f> x;
  private javax.inject.a<com.xiaoenai.app.data.d.b.a> y;
  private javax.inject.a<com.xiaoenai.app.data.d.d.h> z;
  
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
    this.d = new o(this, parama);
    this.e = com.xiaoenai.app.common.view.activity.a.a(this.b, this.c, this.d);
    this.f = new p(this, parama);
    this.g = new q(this, parama);
    this.h = com.xiaoenai.app.common.view.activity.c.a(this.b, this.c, this.d, this.f, this.g);
    this.i = dagger.internal.a.a(com.xiaoenai.app.common.internal.di.b.b.a(a.b(parama)));
    this.j = new r(this, parama);
    this.k = new s(this, parama);
    this.l = new t(this, parama);
    this.m = new u(this, parama);
    this.n = new c(this, parama);
    this.o = new d(this, parama);
    this.p = new e(this, parama);
    this.q = new f(this, parama);
    this.r = new g(this, parama);
    this.s = new h(this, parama);
    this.t = new i(this, parama);
    this.u = new j(this, parama);
    this.v = new k(this, parama);
    this.w = com.xiaoenai.app.data.d.n.a(this.j, this.g, this.o, this.v);
    this.x = new l(this, parama);
    this.y = dagger.internal.a.a(com.xiaoenai.app.data.d.b.h.a(dagger.internal.c.a(), this.j, this.u, this.w, this.x, this.m));
    this.z = new n(this, parama);
    this.A = dagger.internal.a.a(com.xiaoenai.app.data.b.b.a.b.a(this.t));
    this.B = dagger.internal.a.a(com.xiaoenai.app.feature.photoalbum.d.a.b.b.a(a.c(parama), this.A));
    this.C = dagger.internal.a.a(AlbumEntityDataMapper_Factory.create());
    this.D = dagger.internal.a.a(com.xiaoenai.app.data.e.a.c.m.a(this.j, this.y, this.z, this.B, this.C, this.f));
    this.E = dagger.internal.a.a(com.xiaoenai.app.data.e.n.a(this.D));
    this.F = dagger.internal.a.a(com.xiaoenai.app.feature.photoalbum.d.a.b.c.a(a.c(parama), this.E));
    this.G = com.xiaoenai.app.feature.photoalbum.e.j.a(this.F);
    this.H = com.xiaoenai.app.feature.photoalbum.view.activity.u.a(this.b, this.c, this.d, this.f, this.g, this.G);
    this.I = dagger.internal.a.a(com.xiaoenai.app.feature.photoalbum.e.b.a(this.f));
    this.J = ad.a(this.b, this.c, this.d, this.f, this.g, this.I);
    this.K = com.xiaoenai.app.feature.photoalbum.preview.n.a(this.b, this.c, this.d, this.f, this.g, this.F);
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
  
  public void a(PhotoPreviewActivity paramPhotoPreviewActivity)
  {
    this.K.a(paramPhotoPreviewActivity);
  }
  
  public void a(PhotoAlbumActivity paramPhotoAlbumActivity)
  {
    this.H.a(paramPhotoAlbumActivity);
  }
  
  public void a(PostPhotoActivity paramPostPhotoActivity)
  {
    this.J.a(paramPostPhotoActivity);
  }
  
  public com.xiaoenai.app.domain.e.e b()
  {
    return (com.xiaoenai.app.domain.e.e)this.r.get();
  }
  
  public static final class a
  {
    private com.xiaoenai.app.common.internal.di.b.a a;
    private com.xiaoenai.app.feature.photoalbum.d.a.b.a b;
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
    
    public a a(com.xiaoenai.app.feature.photoalbum.d.a.b.a parama)
    {
      this.b = ((com.xiaoenai.app.feature.photoalbum.d.a.b.a)dagger.internal.d.a(parama));
      return this;
    }
    
    public y a()
    {
      if (this.a == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.b.a.class.getCanonicalName() + " must be set");
      }
      if (this.b == null) {
        this.b = new com.xiaoenai.app.feature.photoalbum.d.a.b.a();
      }
      if (this.c == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.a.b.class.getCanonicalName() + " must be set");
      }
      return new a(this, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\d\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */