package com.bumptech.glide.d.d.d;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a.a;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.f;
import com.bumptech.glide.d.g;
import java.io.IOException;
import java.io.OutputStream;

public class j
  implements f<b>
{
  private static final a a = new a();
  private final a.a b;
  private final com.bumptech.glide.d.b.a.c c;
  private final a d;
  
  public j(com.bumptech.glide.d.b.a.c paramc)
  {
    this(paramc, a);
  }
  
  j(com.bumptech.glide.d.b.a.c paramc, a parama)
  {
    this.c = paramc;
    this.b = new a(paramc);
    this.d = parama;
  }
  
  private com.bumptech.glide.b.a a(byte[] paramArrayOfByte)
  {
    Object localObject = this.d.a();
    ((com.bumptech.glide.b.d)localObject).a(paramArrayOfByte);
    localObject = ((com.bumptech.glide.b.d)localObject).b();
    com.bumptech.glide.b.a locala = this.d.a(this.b);
    locala.a((com.bumptech.glide.b.c)localObject, paramArrayOfByte);
    locala.a();
    return locala;
  }
  
  private k<Bitmap> a(Bitmap paramBitmap, g<Bitmap> paramg, b paramb)
  {
    paramBitmap = this.d.a(paramBitmap, this.c);
    paramg = paramg.a(paramBitmap, paramb.getIntrinsicWidth(), paramb.getIntrinsicHeight());
    if (!paramBitmap.equals(paramg)) {
      paramBitmap.d();
    }
    return paramg;
  }
  
  private boolean a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      if (Log.isLoggable("GifEncoder", 3)) {
        Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public String a()
  {
    return "";
  }
  
  public boolean a(k<b> paramk, OutputStream paramOutputStream)
  {
    boolean bool1 = false;
    long l = com.bumptech.glide.i.d.a();
    paramk = (b)paramk.b();
    g localg = paramk.c();
    if ((localg instanceof com.bumptech.glide.d.d.d)) {
      bool1 = a(paramk.d(), paramOutputStream);
    }
    com.bumptech.glide.b.a locala;
    boolean bool2;
    do
    {
      com.bumptech.glide.c.a locala1;
      do
      {
        return bool1;
        locala = a(paramk.d());
        locala1 = this.d.b();
      } while (!locala1.a(paramOutputStream));
      int i = 0;
      while (i < locala.c())
      {
        paramOutputStream = a(locala.f(), localg, paramk);
        try
        {
          bool1 = locala1.a((Bitmap)paramOutputStream.b());
          if (!bool1) {
            return false;
          }
          locala1.a(locala.a(locala.d()));
          locala.a();
          paramOutputStream.d();
          i += 1;
        }
        finally
        {
          paramOutputStream.d();
        }
      }
      bool2 = locala1.a();
      bool1 = bool2;
    } while (!Log.isLoggable("GifEncoder", 2));
    Log.v("GifEncoder", "Encoded gif with " + locala.c() + " frames and " + paramk.d().length + " bytes in " + com.bumptech.glide.i.d.a(l) + " ms");
    return bool2;
  }
  
  static class a
  {
    public com.bumptech.glide.b.a a(a.a parama)
    {
      return new com.bumptech.glide.b.a(parama);
    }
    
    public com.bumptech.glide.b.d a()
    {
      return new com.bumptech.glide.b.d();
    }
    
    public k<Bitmap> a(Bitmap paramBitmap, com.bumptech.glide.d.b.a.c paramc)
    {
      return new com.bumptech.glide.d.d.a.c(paramBitmap, paramc);
    }
    
    public com.bumptech.glide.c.a b()
    {
      return new com.bumptech.glide.c.a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */