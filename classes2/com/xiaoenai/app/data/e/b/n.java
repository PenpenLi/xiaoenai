package com.xiaoenai.app.data.e.b;

import android.content.Context;
import com.xiaoenai.app.data.entity.mapper.MessageEntityDataMapper;
import com.xiaoenai.app.domain.e.e;
import dagger.internal.b;

public final class n
  implements b<a>
{
  private final javax.inject.a<Context> b;
  private final javax.inject.a<MessageEntityDataMapper> c;
  private final javax.inject.a<e> d;
  private final javax.inject.a<com.xiaoenai.app.data.d.a> e;
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public n(javax.inject.a<Context> parama, javax.inject.a<MessageEntityDataMapper> parama1, javax.inject.a<e> parama2, javax.inject.a<com.xiaoenai.app.data.d.a> parama3)
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
  
  public static b<a> a(javax.inject.a<Context> parama, javax.inject.a<MessageEntityDataMapper> parama1, javax.inject.a<e> parama2, javax.inject.a<com.xiaoenai.app.data.d.a> parama3)
  {
    return new n(parama, parama1, parama2, parama3);
  }
  
  public a a()
  {
    return new a((Context)this.b.get(), (MessageEntityDataMapper)this.c.get(), (e)this.d.get(), (com.xiaoenai.app.data.d.a)this.e.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */