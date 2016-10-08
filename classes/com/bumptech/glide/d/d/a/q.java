package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.c.h;
import com.bumptech.glide.d.c.i;
import com.bumptech.glide.d.e;
import com.bumptech.glide.d.f;
import java.io.File;
import java.io.InputStream;

public class q
  implements com.bumptech.glide.f.b<h, Bitmap>
{
  private final p a;
  private final e<File, Bitmap> b;
  private final f<Bitmap> c;
  private final i d;
  
  public q(com.bumptech.glide.f.b<InputStream, Bitmap> paramb, com.bumptech.glide.f.b<ParcelFileDescriptor, Bitmap> paramb1)
  {
    this.c = paramb.d();
    this.d = new i(paramb.c(), paramb1.c());
    this.b = paramb.a();
    this.a = new p(paramb.b(), paramb1.b());
  }
  
  public e<File, Bitmap> a()
  {
    return this.b;
  }
  
  public e<h, Bitmap> b()
  {
    return this.a;
  }
  
  public com.bumptech.glide.d.b<h> c()
  {
    return this.d;
  }
  
  public f<Bitmap> d()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */