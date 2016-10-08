package com.xiaoenai.app.data.e.a.c;

import android.content.Context;
import com.xiaoenai.app.data.d.d.h;
import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.data.entity.mapper.AlbumEntityDataMapper;
import dagger.internal.b;

public final class m
  implements b<l>
{
  private final javax.inject.a<Context> b;
  private final javax.inject.a<com.xiaoenai.app.data.d.b.a> c;
  private final javax.inject.a<h> d;
  private final javax.inject.a<com.xiaoenai.app.data.b.b.a> e;
  private final javax.inject.a<AlbumEntityDataMapper> f;
  private final javax.inject.a<o> g;
  
  static
  {
    if (!m.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public m(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.data.d.b.a> parama1, javax.inject.a<h> parama2, javax.inject.a<com.xiaoenai.app.data.b.b.a> parama3, javax.inject.a<AlbumEntityDataMapper> parama4, javax.inject.a<o> parama5)
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
  
  public static b<l> a(javax.inject.a<Context> parama, javax.inject.a<com.xiaoenai.app.data.d.b.a> parama1, javax.inject.a<h> parama2, javax.inject.a<com.xiaoenai.app.data.b.b.a> parama3, javax.inject.a<AlbumEntityDataMapper> parama4, javax.inject.a<o> parama5)
  {
    return new m(parama, parama1, parama2, parama3, parama4, parama5);
  }
  
  public l a()
  {
    return new l((Context)this.b.get(), (com.xiaoenai.app.data.d.b.a)this.c.get(), (h)this.d.get(), (com.xiaoenai.app.data.b.b.a)this.e.get(), (AlbumEntityDataMapper)this.f.get(), (o)this.g.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\a\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */