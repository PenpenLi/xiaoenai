package com.xiaoenai.app.classes.common.image.croper;

import android.os.Handler;

class o
  implements Runnable
{
  o(ImageViewTouchBase paramImageViewTouchBase, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.a, (float)(l - this.b));
    float f2 = this.c;
    float f3 = this.d;
    this.g.a(f2 + f3 * f1, this.e, this.f);
    if (f1 < this.a) {
      this.g.p.post(this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */