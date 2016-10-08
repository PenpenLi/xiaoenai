package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.entity.mapper.UserEntityDataMapper;
import javax.inject.a;

public final class r
  implements dagger.internal.b<q>
{
  private final a<com.xiaoenai.app.data.e.a.d.b> b;
  private final a<UserEntityDataMapper> c;
  
  static
  {
    if (!r.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public r(a<com.xiaoenai.app.data.e.a.d.b> parama, a<UserEntityDataMapper> parama1)
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
  
  public static dagger.internal.b<q> a(a<com.xiaoenai.app.data.e.a.d.b> parama, a<UserEntityDataMapper> parama1)
  {
    return new r(parama, parama1);
  }
  
  public q a()
  {
    return new q((com.xiaoenai.app.data.e.a.d.b)this.b.get(), (UserEntityDataMapper)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */