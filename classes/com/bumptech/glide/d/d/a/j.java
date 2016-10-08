package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.e;
import com.bumptech.glide.d.f;
import java.io.File;

public class j
  implements com.bumptech.glide.f.b<ParcelFileDescriptor, Bitmap>
{
  private final e<File, Bitmap> a;
  private final k b;
  private final b c;
  private final com.bumptech.glide.d.b<ParcelFileDescriptor> d;
  
  public j(com.bumptech.glide.d.b.a.c paramc, com.bumptech.glide.d.a parama)
  {
    this.a = new com.bumptech.glide.d.d.c.c(new t(paramc, parama));
    this.b = new k(paramc, parama);
    this.c = new b();
    this.d = com.bumptech.glide.d.d.a.b();
  }
  
  public e<File, Bitmap> a()
  {
    return this.a;
  }
  
  public e<ParcelFileDescriptor, Bitmap> b()
  {
    return this.b;
  }
  
  public com.bumptech.glide.d.b<ParcelFileDescriptor> c()
  {
    return this.d;
  }
  
  public f<Bitmap> d()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */