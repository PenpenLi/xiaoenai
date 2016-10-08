package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.f;
import com.bumptech.glide.i.d;
import com.bumptech.glide.i.h;
import java.io.OutputStream;

public class b
  implements f<Bitmap>
{
  private Bitmap.CompressFormat a;
  private int b;
  
  public b()
  {
    this(null, 90);
  }
  
  public b(Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    this.a = paramCompressFormat;
    this.b = paramInt;
  }
  
  private Bitmap.CompressFormat a(Bitmap paramBitmap)
  {
    if (this.a != null) {
      return this.a;
    }
    if (paramBitmap.hasAlpha()) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public String a()
  {
    return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
  }
  
  public boolean a(k<Bitmap> paramk, OutputStream paramOutputStream)
  {
    paramk = (Bitmap)paramk.b();
    long l = d.a();
    Bitmap.CompressFormat localCompressFormat = a(paramk);
    paramk.compress(localCompressFormat, this.b, paramOutputStream);
    if (Log.isLoggable("BitmapEncoder", 2)) {
      Log.v("BitmapEncoder", "Compressed with type: " + localCompressFormat + " of size " + h.a(paramk) + " in " + d.a(l));
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */