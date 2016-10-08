package com.bumptech.glide.d.d.e;

import com.bumptech.glide.d.b.k;

public class b
  implements k<a>
{
  private final a a;
  
  public b(a parama)
  {
    if (parama == null) {
      throw new NullPointerException("Data must not be null");
    }
    this.a = parama;
  }
  
  public a a()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.a.a();
  }
  
  public void d()
  {
    k localk = this.a.b();
    if (localk != null) {
      localk.d();
    }
    localk = this.a.c();
    if (localk != null) {
      localk.d();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */