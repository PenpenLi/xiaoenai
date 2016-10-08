package com.xiaoenai.app.classes.common.image.croper;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.os.Handler;
import java.util.ArrayList;

class j
  implements Runnable
{
  float a = 1.0F;
  Matrix b;
  FaceDetector.Face[] c = new FaceDetector.Face[3];
  int d;
  
  j(CropImage paramCropImage) {}
  
  private void a()
  {
    boolean bool2 = false;
    l locall = new l(CropImage.c(this.e));
    int n = CropImage.b(this.e).getWidth();
    int m = CropImage.b(this.e).getHeight();
    Rect localRect = new Rect(0, 0, n, m);
    int i = Math.min(n, m) * 4 / 5;
    int k;
    int j;
    if ((CropImage.g(this.e) != 0) && (CropImage.h(this.e) != 0)) {
      if (CropImage.g(this.e) > CropImage.h(this.e))
      {
        k = CropImage.h(this.e) * i / CropImage.g(this.e);
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      k = (n - j) / 2;
      m = (m - i) / 2;
      RectF localRectF = new RectF(k, m, j + k, i + m);
      Matrix localMatrix = this.b;
      boolean bool3 = CropImage.f(this.e);
      boolean bool1 = bool2;
      if (CropImage.g(this.e) != 0)
      {
        bool1 = bool2;
        if (CropImage.h(this.e) != 0) {
          bool1 = true;
        }
      }
      locall.a(localMatrix, localRect, localRectF, bool3, bool1);
      CropImage.c(this.e).a.clear();
      CropImage.c(this.e).a(locall);
      return;
      j = CropImage.g(this.e) * i / CropImage.h(this.e);
      continue;
      j = i;
      k = i;
      i = j;
      j = k;
    }
  }
  
  private void a(FaceDetector.Face paramFace)
  {
    boolean bool2 = false;
    Object localObject = new PointF();
    int i = (int)(paramFace.eyesDistance() * this.a) * 2;
    paramFace.getMidPoint((PointF)localObject);
    ((PointF)localObject).x *= this.a;
    ((PointF)localObject).y *= this.a;
    int j = (int)((PointF)localObject).x;
    int k = (int)((PointF)localObject).y;
    paramFace = new l(CropImage.c(this.e));
    localObject = new Rect(0, 0, CropImage.b(this.e).getWidth(), CropImage.b(this.e).getHeight());
    RectF localRectF = new RectF(j, k, j, k);
    localRectF.inset(-i, -i);
    if (localRectF.left < 0.0F) {
      localRectF.inset(-localRectF.left, -localRectF.left);
    }
    if (localRectF.top < 0.0F) {
      localRectF.inset(-localRectF.top, -localRectF.top);
    }
    if (localRectF.right > ((Rect)localObject).right) {
      localRectF.inset(localRectF.right - ((Rect)localObject).right, localRectF.right - ((Rect)localObject).right);
    }
    if (localRectF.bottom > ((Rect)localObject).bottom) {
      localRectF.inset(localRectF.bottom - ((Rect)localObject).bottom, localRectF.bottom - ((Rect)localObject).bottom);
    }
    Matrix localMatrix = this.b;
    boolean bool3 = CropImage.f(this.e);
    boolean bool1 = bool2;
    if (CropImage.g(this.e) != 0)
    {
      bool1 = bool2;
      if (CropImage.h(this.e) != 0) {
        bool1 = true;
      }
    }
    paramFace.a(localMatrix, (Rect)localObject, localRectF, bool3, bool1);
    CropImage.c(this.e).a(paramFace);
  }
  
  private Bitmap b()
  {
    if (CropImage.b(this.e) == null) {
      return null;
    }
    if (CropImage.b(this.e).getWidth() > 256) {
      this.a = (256.0F / CropImage.b(this.e).getWidth());
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(this.a, this.a);
    return Bitmap.createBitmap(CropImage.b(this.e), 0, 0, CropImage.b(this.e).getWidth(), CropImage.b(this.e).getHeight(), localMatrix, true);
  }
  
  public void run()
  {
    this.b = CropImage.c(this.e).getImageMatrix();
    Bitmap localBitmap = b();
    this.a = (1.0F / this.a);
    if ((localBitmap != null) && (CropImage.i(this.e))) {
      this.d = new FaceDetector(localBitmap.getWidth(), localBitmap.getHeight(), this.c.length).findFaces(localBitmap, this.c);
    }
    if ((localBitmap != null) && (localBitmap != CropImage.b(this.e))) {
      localBitmap.recycle();
    }
    CropImage.e(this.e).post(new k(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */