package com.xiaoenai.app.classes.common.image.imagePreview;

import com.xiaoenai.app.domain.e.d;

public final class av
  implements dagger.a<ImageViewPager>
{
  private final javax.inject.a<com.xiaoenai.app.common.a> b;
  private final javax.inject.a<com.xiaoenai.app.common.view.b.a> c;
  private final javax.inject.a<com.xiaoenai.app.common.application.a.a> d;
  private final javax.inject.a<d> e;
  
  static
  {
    if (!av.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public av(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<d> parama3)
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
  
  public static dagger.a<ImageViewPager> a(javax.inject.a<com.xiaoenai.app.common.a> parama, javax.inject.a<com.xiaoenai.app.common.view.b.a> parama1, javax.inject.a<com.xiaoenai.app.common.application.a.a> parama2, javax.inject.a<d> parama3)
  {
    return new av(parama, parama1, parama2, parama3);
  }
  
  public void a(ImageViewPager paramImageViewPager)
  {
    if (paramImageViewPager == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.xiaoenai.app.common.view.activity.a.a(paramImageViewPager, this.b);
    com.xiaoenai.app.common.view.activity.a.b(paramImageViewPager, this.c);
    com.xiaoenai.app.common.view.activity.a.c(paramImageViewPager, this.d);
    paramImageViewPager.a = ((d)this.e.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */