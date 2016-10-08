package com.nostra13.universalimageloader.core.g;

import android.graphics.Bitmap;

public abstract class b
  implements a
{
  private int a = 1;
  
  public b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final Bitmap a(Bitmap paramBitmap)
  {
    return a(paramBitmap, this.a);
  }
  
  public abstract Bitmap a(Bitmap paramBitmap, int paramInt);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */