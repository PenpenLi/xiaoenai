package com.xiaoenai.app.utils.g;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rx.g.c;
import rx.g.e;

public class a
{
  private static volatile a a;
  private final e<Object, Object> b = new c(rx.g.a.e());
  private final Map<Class<?>, Object> c = new ConcurrentHashMap();
  
  public static a a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  public <T> T a(Class<T> paramClass)
  {
    synchronized (this.c)
    {
      paramClass = paramClass.cast(this.c.get(paramClass));
      return paramClass;
    }
  }
  
  public void a(Object paramObject)
  {
    this.b.a(paramObject);
  }
  
  public <T> T b(Class<T> paramClass)
  {
    synchronized (this.c)
    {
      paramClass = paramClass.cast(this.c.remove(paramClass));
      return paramClass;
    }
  }
  
  public void b(Object paramObject)
  {
    synchronized (this.c)
    {
      Class localClass = paramObject.getClass();
      com.xiaoenai.app.utils.f.a.c("key = {}", new Object[] { localClass });
      this.c.put(localClass, paramObject);
      a(paramObject);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */