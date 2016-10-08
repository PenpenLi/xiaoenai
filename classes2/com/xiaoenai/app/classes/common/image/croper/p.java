package com.xiaoenai.app.classes.common.image.croper;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class p
{
  private Bitmap a;
  private int b;
  
  public p(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.b = 0;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  public Bitmap b()
  {
    return this.a;
  }
  
  public Matrix c()
  {
    Matrix localMatrix = new Matrix();
    if (this.b != 0)
    {
      int i = this.a.getWidth() / 2;
      int j = this.a.getHeight() / 2;
      localMatrix.preTranslate(-i, -j);
      localMatrix.postRotate(this.b);
      localMatrix.postTranslate(f() / 2, e() / 2);
    }
    return localMatrix;
  }
  
  public boolean d()
  {
    return this.b / 90 % 2 != 0;
  }
  
  public int e()
  {
    if (d()) {
      return this.a.getWidth();
    }
    return this.a.getHeight();
  }
  
  public int f()
  {
    if (d()) {
      return this.a.getHeight();
    }
    return this.a.getWidth();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */