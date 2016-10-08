package com.xiaoenai.app.classes.common.image.croper;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;

class h
  implements Runnable
{
  h(g paramg, Bitmap paramBitmap, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    if ((this.a != CropImage.b(this.c.a)) && (this.a != null))
    {
      CropImage.c(this.c.a).a(this.a, true);
      CropImage.b(this.c.a).recycle();
      CropImage.a(this.c.a, this.a);
    }
    if (CropImage.c(this.c.a).getScale() == 1.0F) {
      CropImage.c(this.c.a).a(true, true);
    }
    this.b.countDown();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */