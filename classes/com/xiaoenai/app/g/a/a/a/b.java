package com.xiaoenai.app.g.a.a.a;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.chat.aj;
import com.xiaoenai.app.classes.common.image.imagePreview.ImageViewPager;
import com.xiaoenai.app.classes.common.image.imagePreview.av;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper_Factory;

public final class b
  implements a
{
  private javax.inject.a<com.xiaoenai.app.common.a> b;
  private javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private javax.inject.a<Context> e;
  private javax.inject.a<com.xiaoenai.app.data.d.j> f;
  private javax.inject.a<com.xiaoenai.app.domain.e.a> g;
  private javax.inject.a<com.xiaoenai.app.data.e.c> h;
  private javax.inject.a<com.xiaoenai.app.data.d.a> i;
  private javax.inject.a<com.xiaoenai.app.data.d.m> j;
  private javax.inject.a<com.xiaoenai.app.data.d.f> k;
  private javax.inject.a<Handler> l;
  private javax.inject.a<com.xiaoenai.app.data.d.b.a> m;
  private javax.inject.a<com.xiaoenai.app.data.d.d.h> n;
  private javax.inject.a<com.xiaoenai.app.data.b.a> o;
  private javax.inject.a<com.xiaoenai.app.data.b.b.a.a> p;
  private javax.inject.a<com.xiaoenai.app.data.b.b.a> q;
  private javax.inject.a<AlbumEntityDataMapper> r;
  private javax.inject.a<com.xiaoenai.app.data.e.o> s;
  private javax.inject.a<com.xiaoenai.app.data.e.a.c.l> t;
  private javax.inject.a<com.xiaoenai.app.data.e.g> u;
  private javax.inject.a<com.xiaoenai.app.domain.e.d> v;
  private dagger.a<ChatActivity> w;
  private dagger.a<ImageViewPager> x;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private b(a parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    a(parama);
  }
  
  public static a a()
  {
    return new a(null);
  }
  
  private void a(a parama)
  {
    this.b = new c(this, parama);
    this.c = new h(this, parama);
    this.d = new i(this, parama);
    this.e = new j(this, parama);
    this.f = new k(this, parama);
    this.g = new l(this, parama);
    this.h = new m(this, parama);
    this.i = new n(this, parama);
    this.j = com.xiaoenai.app.data.d.n.a(this.e, this.g, this.h, this.i);
    this.k = new o(this, parama);
    this.l = new d(this, parama);
    this.m = dagger.internal.a.a(com.xiaoenai.app.data.d.b.h.a(dagger.internal.c.a(), this.e, this.f, this.j, this.k, this.l));
    this.n = new e(this, parama);
    this.o = new f(this, parama);
    this.p = dagger.internal.a.a(com.xiaoenai.app.data.b.b.a.b.a(this.o));
    this.q = dagger.internal.a.a(com.xiaoenai.app.feature.photoalbum.d.a.b.b.a(a.b(parama), this.p));
    this.r = dagger.internal.a.a(AlbumEntityDataMapper_Factory.create());
    this.s = new g(this, parama);
    this.t = dagger.internal.a.a(com.xiaoenai.app.data.e.a.c.m.a(this.e, this.m, this.n, this.q, this.r, this.s));
    this.u = dagger.internal.a.a(com.xiaoenai.app.data.e.n.a(this.t));
    this.v = dagger.internal.a.a(com.xiaoenai.app.feature.photoalbum.d.a.b.c.a(a.b(parama), this.u));
    this.w = aj.a(this.b, this.c, this.d, this.v);
    this.x = av.a(this.b, this.c, this.d, this.v);
  }
  
  public void a(ChatActivity paramChatActivity)
  {
    this.w.a(paramChatActivity);
  }
  
  public void a(ImageViewPager paramImageViewPager)
  {
    this.x.a(paramImageViewPager);
  }
  
  public static final class a
  {
    private com.xiaoenai.app.feature.photoalbum.d.a.b.a a;
    private com.xiaoenai.app.common.internal.di.a.b b;
    
    public a a()
    {
      if (this.a == null) {
        this.a = new com.xiaoenai.app.feature.photoalbum.d.a.b.a();
      }
      if (this.b == null) {
        throw new IllegalStateException(com.xiaoenai.app.common.internal.di.a.b.class.getCanonicalName() + " must be set");
      }
      return new b(this, null);
    }
    
    public a a(com.xiaoenai.app.common.internal.di.a.b paramb)
    {
      this.b = ((com.xiaoenai.app.common.internal.di.a.b)dagger.internal.d.a(paramb));
      return this;
    }
    
    @Deprecated
    public a a(com.xiaoenai.app.common.internal.di.b.a parama)
    {
      dagger.internal.d.a(parama);
      return this;
    }
    
    public a a(com.xiaoenai.app.feature.photoalbum.d.a.b.a parama)
    {
      this.a = ((com.xiaoenai.app.feature.photoalbum.d.a.b.a)dagger.internal.d.a(parama));
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\g\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */