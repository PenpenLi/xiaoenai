package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.d.a;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.e;
import java.io.InputStream;

public class t
  implements e<InputStream, Bitmap>
{
  private final f a;
  private com.bumptech.glide.d.b.a.c b;
  private a c;
  private String d;
  
  public t(com.bumptech.glide.d.b.a.c paramc, a parama)
  {
    this(f.a, paramc, parama);
  }
  
  public t(f paramf, com.bumptech.glide.d.b.a.c paramc, a parama)
  {
    this.a = paramf;
    this.b = paramc;
    this.c = parama;
  }
  
  public k<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    return c.a(this.a.a(paramInputStream, this.b, paramInt1, paramInt2, this.c), this.b);
  }
  
  public String a()
  {
    if (this.d == null) {
      this.d = ("StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.a() + this.c.name());
    }
    return this.d;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */