package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.d.a;
import com.bumptech.glide.d.c.o;
import com.bumptech.glide.d.e;
import com.bumptech.glide.d.f;
import java.io.File;
import java.io.InputStream;

public class s
  implements com.bumptech.glide.f.b<InputStream, Bitmap>
{
  private final t a;
  private final b b;
  private final o c = new o();
  private final com.bumptech.glide.d.d.c.c<Bitmap> d;
  
  public s(com.bumptech.glide.d.b.a.c paramc, a parama)
  {
    this.a = new t(paramc, parama);
    this.b = new b();
    this.d = new com.bumptech.glide.d.d.c.c(this.a);
  }
  
  public e<File, Bitmap> a()
  {
    return this.d;
  }
  
  public e<InputStream, Bitmap> b()
  {
    return this.a;
  }
  
  public com.bumptech.glide.d.b<InputStream> c()
  {
    return this.c;
  }
  
  public f<Bitmap> d()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */