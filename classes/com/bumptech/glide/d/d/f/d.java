package com.bumptech.glide.d.d.f;

import com.bumptech.glide.i.g;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static final g a = new g();
  private final Map<g, c<?, ?>> b = new HashMap();
  
  public <Z, R> c<Z, R> a(Class<Z> paramClass, Class<R> paramClass1)
  {
    if (paramClass.equals(paramClass1)) {
      ??? = e.b();
    }
    for (;;)
    {
      return (c<Z, R>)???;
      synchronized (a)
      {
        a.a(paramClass, paramClass1);
        c localc = (c)this.b.get(a);
        ??? = localc;
        if (localc != null) {
          continue;
        }
        throw new IllegalArgumentException("No transcoder registered for " + paramClass + " and " + paramClass1);
      }
    }
  }
  
  public <Z, R> void a(Class<Z> paramClass, Class<R> paramClass1, c<Z, R> paramc)
  {
    this.b.put(new g(paramClass, paramClass1), paramc);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */