package com.xiaoenai.app.data.d.d;

import com.xiaoenai.app.data.entity.mapper.ImageResultDataMapper;
import dagger.internal.b;

public final class l
  implements b<h>
{
  private final javax.inject.a<a> b;
  private final javax.inject.a<ImageResultDataMapper> c;
  
  static
  {
    if (!l.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public l(javax.inject.a<a> parama, javax.inject.a<ImageResultDataMapper> parama1)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    if ((!a) && (parama1 == null)) {
      throw new AssertionError();
    }
    this.c = parama1;
  }
  
  public static b<h> a(javax.inject.a<a> parama, javax.inject.a<ImageResultDataMapper> parama1)
  {
    return new l(parama, parama1);
  }
  
  public h a()
  {
    return new h((a)this.b.get(), (ImageResultDataMapper)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */