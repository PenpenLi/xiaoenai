package com.nostra13.universalimageloader.core.e;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.a.e;
import com.nostra13.universalimageloader.core.a.h;

public class c
  implements a
{
  protected final String a;
  protected final e b;
  protected final h c;
  
  public c(String paramString, e parame, h paramh)
  {
    if (parame == null) {
      throw new IllegalArgumentException("imageSize must not be null");
    }
    if (paramh == null) {
      throw new IllegalArgumentException("scaleType must not be null");
    }
    this.a = paramString;
    this.b = parame;
    this.c = paramh;
  }
  
  public int a()
  {
    return this.b.a();
  }
  
  public boolean a(Bitmap paramBitmap)
  {
    return true;
  }
  
  public boolean a(Drawable paramDrawable)
  {
    return true;
  }
  
  public int b()
  {
    return this.b.b();
  }
  
  public h c()
  {
    return this.c;
  }
  
  public View d()
  {
    return null;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public int f()
  {
    if (TextUtils.isEmpty(this.a)) {
      return super.hashCode();
    }
    return this.a.hashCode();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */