package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.entity.mapper.LoggerEntityDataMapper;
import dagger.internal.b;
import javax.inject.a;

public final class f
  implements b<e>
{
  private final a<com.xiaoenai.app.data.e.a.b.f> b;
  private final a<LoggerEntityDataMapper> c;
  
  static
  {
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public f(a<com.xiaoenai.app.data.e.a.b.f> parama, a<LoggerEntityDataMapper> parama1)
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
  
  public static b<e> a(a<com.xiaoenai.app.data.e.a.b.f> parama, a<LoggerEntityDataMapper> parama1)
  {
    return new f(parama, parama1);
  }
  
  public e a()
  {
    return new e((com.xiaoenai.app.data.e.a.b.f)this.b.get(), (LoggerEntityDataMapper)this.c.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */