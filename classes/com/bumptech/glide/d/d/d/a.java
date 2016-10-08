package com.bumptech.glide.d.d.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.d.b.a.c;

class a
  implements a.a
{
  private final c a;
  
  public a(c paramc)
  {
    this.a = paramc;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return this.a.b(paramInt1, paramInt2, paramConfig);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (!this.a.a(paramBitmap)) {
      paramBitmap.recycle();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */