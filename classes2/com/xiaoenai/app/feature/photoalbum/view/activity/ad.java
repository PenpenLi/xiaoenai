package com.xiaoenai.app.feature.photoalbum.view.activity;

import com.xiaoenai.app.common.view.activity.c;
import com.xiaoenai.app.data.e.o;

public final class ad
  implements dagger.a<PostPhotoActivity>
{
  private final javax.inject.a<com.xiaoenai.app.common.a> b;
  private final javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private final javax.inject.a<o> e;
  private final javax.inject.a<com.xiaoenai.app.domain.e.a> f;
  private final javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.a> g;
  
  static
  {
    if (!ad.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public ad(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4, javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.a> parama5)
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
  
  public static dagger.a<PostPhotoActivity> a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<o> parama3, javax.inject.a<com.xiaoenai.app.domain.e.a> parama4, javax.inject.a<com.xiaoenai.app.feature.photoalbum.e.a> parama5)
  {
    return new ad(parama, parama1, parama2, parama3, parama4, parama5);
  }
  
  public void a(PostPhotoActivity paramPostPhotoActivity)
  {
    if (paramPostPhotoActivity == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.xiaoenai.app.common.view.activity.a.a(paramPostPhotoActivity, this.b);
    com.xiaoenai.app.common.view.activity.a.b(paramPostPhotoActivity, this.c);
    com.xiaoenai.app.common.view.activity.a.c(paramPostPhotoActivity, this.d);
    c.a(paramPostPhotoActivity, this.e);
    c.b(paramPostPhotoActivity, this.f);
    paramPostPhotoActivity.e = ((com.xiaoenai.app.feature.photoalbum.e.a)this.g.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\view\activity\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */