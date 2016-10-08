package com.bumptech.glide.d.d;

import com.bumptech.glide.d.b.k;

public class c<T>
  implements k<T>
{
  protected final T a;
  
  public c(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("Data must not be null");
    }
    this.a = paramT;
  }
  
  public final T b()
  {
    return (T)this.a;
  }
  
  public final int c()
  {
    return 1;
  }
  
  public void d() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */