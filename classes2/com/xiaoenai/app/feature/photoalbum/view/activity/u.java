package com.xiaoenai.app.feature.photoalbum.view.activity;

import com.xiaoenai.app.data.e.o;

public final class u
  implements dagger.a<PhotoAlbumActivity>
{
  private final javax.inject.a<com.xiaoenai.app.common.a> b;
  private final javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private final javax.inject.a<o> e;
  private final javax.inject.a<com.xiaoenai.app.domain.e.a> f;
  private final javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.c> g;
  
  static
  {
    if (!u.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public u(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4, javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.c> parama5)
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
    if ((!a) && (parama5 == null)) {
      throw new AssertionError();
    }
    this.g = parama5;
  }
  
  public static dagger.a<PhotoAlbumActivity> a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4, javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.c> parama5)
  {
    return new u(parama, parama1, parama2, parama3, parama4, parama5);
  }
  
  public void a(PhotoAlbumActivity paramPhotoAlbumActivity)
  {
    if (paramPhotoAlbumActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.xiaoenai.app.common.view.activity.a.a(paramPhotoAlbumActivity, this.b);
    com.xiaoenai.app.common.view.activity.a.b(paramPhotoAlbumActivity, this.c);
    com.xiaoenai.app.common.view.activity.a.c(paramPhotoAlbumActivity, this.d);
    com.xiaoenai.app.common.view.activity.c.a(paramPhotoAlbumActivity, this.e);
    com.xiaoenai.app.common.view.activity.c.b(paramPhotoAlbumActivity, this.f);
    paramPhotoAlbumActivity.e = ((com.xiaoenai.app.feature.photoalbum.e.c)this.g.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */