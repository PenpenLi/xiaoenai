package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.d.b.a.c;

public class e
  extends d
{
  public e(c paramc)
  {
    super(paramc);
  }
  
  protected Bitmap a(c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap.getConfig() != null) {}
    for (Object localObject = paramBitmap.getConfig();; localObject = Bitmap.Config.ARGB_8888)
    {
      localObject = paramc.a(paramInt1, paramInt2, (Bitmap.Config)localObject);
      paramBitmap = u.a((Bitmap)localObject, paramBitmap, paramInt1, paramInt2);
      if ((localObject != null) && (localObject != paramBitmap) && (!paramc.a((Bitmap)localObject))) {
        ((Bitmap)localObject).recycle();
      }
      return paramBitmap;
    }
  }
  
  public String a()
  {
    return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */