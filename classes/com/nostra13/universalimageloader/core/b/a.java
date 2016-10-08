package com.nostra13.universalimageloader.core.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.a.d;
import com.nostra13.universalimageloader.core.a.e;
import com.nostra13.universalimageloader.core.a.h;
import com.nostra13.universalimageloader.core.d.b.a;
import java.io.IOException;
import java.io.InputStream;

public class a
  implements b
{
  protected final boolean a;
  
  public a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    return ("image/jpeg".equalsIgnoreCase(paramString2)) && (b.a.a(paramString1) == b.a.c);
  }
  
  protected Bitmap a(Bitmap paramBitmap, c paramc, int paramInt, boolean paramBoolean)
  {
    Matrix localMatrix = new Matrix();
    d locald = paramc.d();
    e locale1;
    e locale2;
    h localh;
    if ((locald == d.e) || (locald == d.f))
    {
      locale1 = new e(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt);
      locale2 = paramc.c();
      localh = paramc.e();
      if (locald != d.f) {
        break label257;
      }
    }
    label257:
    for (boolean bool = true;; bool = false)
    {
      float f = com.nostra13.universalimageloader.b.a.b(locale1, locale2, localh, bool);
      if (Float.compare(f, 1.0F) != 0)
      {
        localMatrix.setScale(f, f);
        if (this.a) {
          com.nostra13.universalimageloader.b.c.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] { locale1, locale1.a(f), Float.valueOf(f), paramc.a() });
        }
      }
      if (paramBoolean)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        if (this.a) {
          com.nostra13.universalimageloader.b.c.a("Flip image horizontally [%s]", new Object[] { paramc.a() });
        }
      }
      if (paramInt != 0)
      {
        localMatrix.postRotate(paramInt);
        if (this.a) {
          com.nostra13.universalimageloader.b.c.a("Rotate image on %1$d° [%2$s]", new Object[] { Integer.valueOf(paramInt), paramc.a() });
        }
      }
      paramc = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      if (paramc != paramBitmap) {
        paramBitmap.recycle();
      }
      return paramc;
    }
  }
  
  public Bitmap a(c paramc)
  {
    InputStream localInputStream2 = b(paramc);
    if (localInputStream2 == null)
    {
      com.nostra13.universalimageloader.b.c.d("No stream for image [%s]", new Object[] { paramc.a() });
      return null;
    }
    InputStream localInputStream1 = localInputStream2;
    b localb;
    Bitmap localBitmap;
    try
    {
      localb = a(localInputStream2, paramc);
      localInputStream1 = localInputStream2;
      localInputStream2 = b(localInputStream2, paramc);
      localInputStream1 = localInputStream2;
      localBitmap = BitmapFactory.decodeStream(localInputStream2, null, a(localb.a, paramc));
      com.nostra13.universalimageloader.b.b.a(localInputStream2);
      if (localBitmap == null)
      {
        com.nostra13.universalimageloader.b.c.d("Image can't be decoded [%s]", new Object[] { paramc.a() });
        return localBitmap;
      }
    }
    finally
    {
      com.nostra13.universalimageloader.b.b.a(localInputStream1);
    }
    return a(localBitmap, paramc, localb.b.a, localb.b.b);
  }
  
  protected BitmapFactory.Options a(e parame, c paramc)
  {
    d locald = paramc.d();
    if (locald == d.a) {}
    for (int i = 1;; i = com.nostra13.universalimageloader.b.a.a(parame))
    {
      if ((i > 1) && (this.a)) {
        com.nostra13.universalimageloader.b.c.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] { parame, parame.a(i), Integer.valueOf(i), paramc.a() });
      }
      parame = paramc.i();
      parame.inSampleSize = i;
      return parame;
      if (locald != d.b) {
        break;
      }
    }
    e locale = paramc.c();
    if (locald == d.c) {}
    for (boolean bool = true;; bool = false)
    {
      i = com.nostra13.universalimageloader.b.a.a(parame, locale, paramc.e(), bool);
      break;
    }
  }
  
  protected a a(String paramString)
  {
    int j = 0;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    try
    {
      int k = new ExifInterface(b.a.c.c(paramString)).getAttributeInt("Orientation", 1);
      i = j;
      switch (k)
      {
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i;
        com.nostra13.universalimageloader.b.c.c("Can't read EXIF tags from file [%s]", new Object[] { paramString });
      }
    }
    bool1 = false;
    i = j;
    for (;;)
    {
      return new a(i, bool1);
      bool2 = false;
      i = 90;
      bool1 = bool2;
      continue;
      bool3 = false;
      i = 180;
      bool1 = bool3;
      continue;
      bool4 = false;
      i = 270;
      bool1 = bool4;
    }
  }
  
  protected b a(InputStream paramInputStream, c paramc)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    paramInputStream = paramc.b();
    if ((paramc.h()) && (a(paramInputStream, localOptions.outMimeType))) {}
    for (paramInputStream = a(paramInputStream);; paramInputStream = new a()) {
      return new b(new e(localOptions.outWidth, localOptions.outHeight, paramInputStream.a), paramInputStream);
    }
  }
  
  protected InputStream b(c paramc)
  {
    return paramc.f().a(paramc.b(), paramc.g());
  }
  
  protected InputStream b(InputStream paramInputStream, c paramc)
  {
    if (paramInputStream.markSupported()) {
      try
      {
        paramInputStream.reset();
        return paramInputStream;
      }
      catch (IOException localIOException) {}
    }
    com.nostra13.universalimageloader.b.b.a(paramInputStream);
    return b(paramc);
  }
  
  protected static class a
  {
    public final int a;
    public final boolean b;
    
    protected a()
    {
      this.a = 0;
      this.b = false;
    }
    
    protected a(int paramInt, boolean paramBoolean)
    {
      this.a = paramInt;
      this.b = paramBoolean;
    }
  }
  
  protected static class b
  {
    public final e a;
    public final a.a b;
    
    protected b(e parame, a.a parama)
    {
      this.a = parame;
      this.b = parama;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */