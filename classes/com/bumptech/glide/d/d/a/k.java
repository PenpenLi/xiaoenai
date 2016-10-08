package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.a;
import com.bumptech.glide.d.e;

public class k
  implements e<ParcelFileDescriptor, Bitmap>
{
  private final v a;
  private final com.bumptech.glide.d.b.a.c b;
  private a c;
  
  public k(com.bumptech.glide.d.b.a.c paramc, a parama)
  {
    this(new v(), paramc, parama);
  }
  
  public k(v paramv, com.bumptech.glide.d.b.a.c paramc, a parama)
  {
    this.a = paramv;
    this.b = paramc;
    this.c = parama;
  }
  
  public com.bumptech.glide.d.b.k<Bitmap> a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2)
  {
    return c.a(this.a.a(paramParcelFileDescriptor, this.b, paramInt1, paramInt2, this.c), this.b);
  }
  
  public String a()
  {
    return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */