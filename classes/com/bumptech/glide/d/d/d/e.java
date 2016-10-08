package com.bumptech.glide.d.d.d;

import android.graphics.Bitmap;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.g;

public class e
  implements g<b>
{
  private final g<Bitmap> a;
  private final com.bumptech.glide.d.b.a.c b;
  
  public e(g<Bitmap> paramg, com.bumptech.glide.d.b.a.c paramc)
  {
    this.a = paramg;
    this.b = paramc;
  }
  
  public k<b> a(k<b> paramk, int paramInt1, int paramInt2)
  {
    b localb = (b)paramk.b();
    Object localObject = new com.bumptech.glide.d.d.a.c(((b)paramk.b()).b(), this.b);
    k localk = this.a.a((k)localObject, paramInt1, paramInt2);
    if (!localObject.equals(localk)) {
      ((k)localObject).d();
    }
    localObject = (Bitmap)localk.b();
    localb.a(this.a, (Bitmap)localObject);
    return paramk;
  }
  
  public String a()
  {
    return this.a.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */