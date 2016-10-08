package com.bumptech.glide.d.b.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.c;
import com.bumptech.glide.i.e;

public class h
  extends e<c, k<?>>
  implements i
{
  private i.a a;
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(k<?> paramk)
  {
    return paramk.c();
  }
  
  @SuppressLint({"InlinedApi"})
  public void a(int paramInt)
  {
    if (paramInt >= 60) {
      c();
    }
    while (paramInt < 40) {
      return;
    }
    b(a() / 2);
  }
  
  public void a(i.a parama)
  {
    this.a = parama;
  }
  
  protected void a(c paramc, k<?> paramk)
  {
    if (this.a != null) {
      this.a.b(paramk);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */