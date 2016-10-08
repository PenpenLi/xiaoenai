package com.bumptech.glide.f;

import com.bumptech.glide.i.g;
import java.util.HashMap;
import java.util.Map;

public class c
{
  private static final g a = new g();
  private final Map<g, b<?, ?>> b = new HashMap();
  
  public <T, Z> b<T, Z> a(Class<T> paramClass, Class<Z> paramClass1)
  {
    synchronized (a)
    {
      a.a(paramClass, paramClass1);
      paramClass1 = (b)this.b.get(a);
      paramClass = paramClass1;
      if (paramClass1 == null) {
        paramClass = d.e();
      }
      return paramClass;
    }
  }
  
  public <T, Z> void a(Class<T> paramClass, Class<Z> paramClass1, b<T, Z> paramb)
  {
    this.b.put(new g(paramClass, paramClass1), paramb);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */