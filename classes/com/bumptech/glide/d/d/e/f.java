package com.bumptech.glide.d.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.d.b.a.c;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.d.d.e;
import com.bumptech.glide.d.g;

public class f
  implements g<a>
{
  private final g<Bitmap> a;
  private final g<com.bumptech.glide.d.d.d.b> b;
  
  public f(c paramc, g<Bitmap> paramg)
  {
    this(paramg, new e(paramg, paramc));
  }
  
  f(g<Bitmap> paramg, g<com.bumptech.glide.d.d.d.b> paramg1)
  {
    this.a = paramg;
    this.b = paramg1;
  }
  
  public k<a> a(k<a> paramk, int paramInt1, int paramInt2)
  {
    k localk1 = ((a)paramk.b()).b();
    k localk2 = ((a)paramk.b()).c();
    Object localObject;
    if ((localk1 != null) && (this.a != null))
    {
      localk2 = this.a.a(localk1, paramInt1, paramInt2);
      localObject = paramk;
      if (!localk1.equals(localk2)) {
        localObject = new b(new a(localk2, ((a)paramk.b()).c()));
      }
    }
    do
    {
      do
      {
        do
        {
          return (k<a>)localObject;
          localObject = paramk;
        } while (localk2 == null);
        localObject = paramk;
      } while (this.b == null);
      localk1 = this.b.a(localk2, paramInt1, paramInt2);
      localObject = paramk;
    } while (localk2.equals(localk1));
    return new b(new a(((a)paramk.b()).b(), localk1));
  }
  
  public String a()
  {
    return this.a.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */