package com.bumptech.glide.d.d.e;

import android.graphics.Bitmap;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.c.h;
import com.bumptech.glide.d.d.a.o;
import com.bumptech.glide.d.d.a.o.a;
import com.bumptech.glide.d.d.a.r;
import com.bumptech.glide.d.e;
import java.io.InputStream;

public class c
  implements e<h, a>
{
  private static final b a = new b();
  private static final a b = new a();
  private final e<h, Bitmap> c;
  private final e<InputStream, com.bumptech.glide.d.d.d.b> d;
  private final com.bumptech.glide.d.b.a.c e;
  private final b f;
  private final a g;
  private String h;
  
  public c(e<h, Bitmap> parame, e<InputStream, com.bumptech.glide.d.d.d.b> parame1, com.bumptech.glide.d.b.a.c paramc)
  {
    this(parame, parame1, paramc, a, b);
  }
  
  c(e<h, Bitmap> parame, e<InputStream, com.bumptech.glide.d.d.d.b> parame1, com.bumptech.glide.d.b.a.c paramc, b paramb, a parama)
  {
    this.c = parame;
    this.d = parame1;
    this.e = paramc;
    this.f = paramb;
    this.g = parama;
  }
  
  private a a(h paramh, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramh.a() != null) {
      return b(paramh, paramInt1, paramInt2, paramArrayOfByte);
    }
    return b(paramh, paramInt1, paramInt2);
  }
  
  private a a(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    paramInputStream = this.d.a(paramInputStream, paramInt1, paramInt2);
    if (paramInputStream != null)
    {
      com.bumptech.glide.d.d.d.b localb = (com.bumptech.glide.d.d.d.b)paramInputStream.b();
      if (localb.e() > 1) {
        return new a(null, paramInputStream);
      }
      return new a(new com.bumptech.glide.d.d.a.c(localb.b(), this.e), null);
    }
    return null;
  }
  
  private a b(h paramh, int paramInt1, int paramInt2)
  {
    paramh = this.c.a(paramh, paramInt1, paramInt2);
    if (paramh != null) {
      return new a(paramh, null);
    }
    return null;
  }
  
  private a b(h paramh, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    InputStream localInputStream = this.g.a(paramh.a(), paramArrayOfByte);
    localInputStream.mark(2048);
    Object localObject = this.f.a(localInputStream);
    localInputStream.reset();
    paramArrayOfByte = null;
    if (localObject == o.a.a) {
      paramArrayOfByte = a(localInputStream, paramInt1, paramInt2);
    }
    localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = b(new h(localInputStream, paramh.b()), paramInt1, paramInt2);
    }
    return (a)localObject;
  }
  
  public k<a> a(h paramh, int paramInt1, int paramInt2)
  {
    com.bumptech.glide.i.a locala = com.bumptech.glide.i.a.a();
    byte[] arrayOfByte = locala.b();
    try
    {
      paramh = a(paramh, paramInt1, paramInt2, arrayOfByte);
      locala.a(arrayOfByte);
      if (paramh != null) {
        return new b(paramh);
      }
    }
    finally
    {
      locala.a(arrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    if (this.h == null) {
      this.h = (this.d.a() + this.c.a());
    }
    return this.h;
  }
  
  static class a
  {
    public InputStream a(InputStream paramInputStream, byte[] paramArrayOfByte)
    {
      return new r(paramInputStream, paramArrayOfByte);
    }
  }
  
  static class b
  {
    public o.a a(InputStream paramInputStream)
    {
      return new o(paramInputStream).b();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */