package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.i.h;

public class c
  implements k<Bitmap>
{
  private final Bitmap a;
  private final com.bumptech.glide.d.b.a.c b;
  
  public c(Bitmap paramBitmap, com.bumptech.glide.d.b.a.c paramc)
  {
    if (paramBitmap == null) {
      throw new NullPointerException("Bitmap must not be null");
    }
    if (paramc == null) {
      throw new NullPointerException("BitmapPool must not be null");
    }
    this.a = paramBitmap;
    this.b = paramc;
  }
  
  public static c a(Bitmap paramBitmap, com.bumptech.glide.d.b.a.c paramc)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new c(paramBitmap, paramc);
  }
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public int c()
  {
    return h.a(this.a);
  }
  
  public void d()
  {
    if (!this.b.a(this.a)) {
      this.a.recycle();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */