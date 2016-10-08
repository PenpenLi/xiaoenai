package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.g;
import com.bumptech.glide.i.h;

public abstract class d
  implements g<Bitmap>
{
  private com.bumptech.glide.d.b.a.c a;
  
  public d(com.bumptech.glide.d.b.a.c paramc)
  {
    this.a = paramc;
  }
  
  protected abstract Bitmap a(com.bumptech.glide.d.b.a.c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public final k<Bitmap> a(k<Bitmap> paramk, int paramInt1, int paramInt2)
  {
    if (!h.a(paramInt1, paramInt2)) {
      throw new IllegalArgumentException("Cannot apply transformation on width: " + paramInt1 + " or height: " + paramInt2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
    Bitmap localBitmap1 = (Bitmap)paramk.b();
    int i = paramInt1;
    if (paramInt1 == Integer.MIN_VALUE) {
      i = localBitmap1.getWidth();
    }
    paramInt1 = paramInt2;
    if (paramInt2 == Integer.MIN_VALUE) {
      paramInt1 = localBitmap1.getHeight();
    }
    Bitmap localBitmap2 = a(this.a, localBitmap1, i, paramInt1);
    if (localBitmap1.equals(localBitmap2)) {
      return paramk;
    }
    return c.a(localBitmap2, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */