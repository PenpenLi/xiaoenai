package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.c.h;
import com.bumptech.glide.d.e;
import java.io.IOException;
import java.io.InputStream;

public class p
  implements e<h, Bitmap>
{
  private final e<InputStream, Bitmap> a;
  private final e<ParcelFileDescriptor, Bitmap> b;
  
  public p(e<InputStream, Bitmap> parame, e<ParcelFileDescriptor, Bitmap> parame1)
  {
    this.a = parame;
    this.b = parame1;
  }
  
  public k<Bitmap> a(h paramh, int paramInt1, int paramInt2)
  {
    Object localObject1 = paramh.a();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = this.a.a(localObject1, paramInt1, paramInt2);
        Object localObject3 = localObject1;
        if (localObject1 == null)
        {
          paramh = paramh.b();
          localObject3 = localObject1;
          if (paramh != null) {
            localObject3 = this.b.a(paramh, paramInt1, paramInt2);
          }
        }
        return (k<Bitmap>)localObject3;
      }
      catch (IOException localIOException)
      {
        if (Log.isLoggable("ImageVideoDecoder", 2)) {
          Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", localIOException);
        }
      }
      Object localObject2 = null;
    }
  }
  
  public String a()
  {
    return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */