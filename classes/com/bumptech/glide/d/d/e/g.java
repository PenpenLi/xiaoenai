package com.bumptech.glide.d.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.d.c.h;
import com.bumptech.glide.d.f;
import java.io.File;
import java.io.InputStream;

public class g
  implements com.bumptech.glide.f.b<h, a>
{
  private final com.bumptech.glide.d.e<File, a> a;
  private final com.bumptech.glide.d.e<h, a> b;
  private final f<a> c;
  private final com.bumptech.glide.d.b<h> d;
  
  public g(com.bumptech.glide.f.b<h, Bitmap> paramb, com.bumptech.glide.f.b<InputStream, com.bumptech.glide.d.d.d.b> paramb1, com.bumptech.glide.d.b.a.c paramc)
  {
    paramc = new c(paramb.b(), paramb1.b(), paramc);
    this.a = new com.bumptech.glide.d.d.c.c(new e(paramc));
    this.b = paramc;
    this.c = new d(paramb.d(), paramb1.d());
    this.d = paramb.c();
  }
  
  public com.bumptech.glide.d.e<File, a> a()
  {
    return this.a;
  }
  
  public com.bumptech.glide.d.e<h, a> b()
  {
    return this.b;
  }
  
  public com.bumptech.glide.d.b<h> c()
  {
    return this.d;
  }
  
  public f<a> d()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */