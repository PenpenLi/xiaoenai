package com.bumptech.glide.i;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class e<T, Y>
{
  private final LinkedHashMap<T, Y> a = new LinkedHashMap(100, 0.75F, true);
  private int b;
  private final int c;
  private int d = 0;
  
  public e(int paramInt)
  {
    this.c = paramInt;
    this.b = paramInt;
  }
  
  private void d()
  {
    b(this.b);
  }
  
  public int a()
  {
    return this.d;
  }
  
  protected int a(Y paramY)
  {
    return 1;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Multiplier must be >= 0");
    }
    this.b = Math.round(this.c * paramFloat);
    d();
  }
  
  protected void a(T paramT, Y paramY) {}
  
  public int b()
  {
    return this.b;
  }
  
  public Y b(T paramT)
  {
    return (Y)this.a.get(paramT);
  }
  
  public Y b(T paramT, Y paramY)
  {
    if (a(paramY) >= this.b)
    {
      a(paramT, paramY);
      return null;
    }
    paramT = this.a.put(paramT, paramY);
    if (paramY != null) {
      this.d += a(paramY);
    }
    if (paramT != null) {
      this.d -= a(paramT);
    }
    d();
    return paramT;
  }
  
  protected void b(int paramInt)
  {
    while (this.d > paramInt)
    {
      Object localObject2 = (Map.Entry)this.a.entrySet().iterator().next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      this.d -= a(localObject1);
      localObject2 = ((Map.Entry)localObject2).getKey();
      this.a.remove(localObject2);
      a(localObject2, localObject1);
    }
  }
  
  public Y c(T paramT)
  {
    paramT = this.a.remove(paramT);
    if (paramT != null) {
      this.d -= a(paramT);
    }
    return paramT;
  }
  
  public void c()
  {
    b(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */