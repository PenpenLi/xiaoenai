package com.xiaoenai.app.classes.common.image.croper;

import android.graphics.Bitmap;
import android.os.Handler;
import java.util.concurrent.CountDownLatch;

class g
  implements Runnable
{
  g(CropImage paramCropImage) {}
  
  public void run()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    if (CropImage.d(this.a) != null) {}
    for (Bitmap localBitmap = CropImage.d(this.a).a(-1, 1048576);; localBitmap = CropImage.b(this.a))
    {
      CropImage.e(this.a).post(new h(this, localBitmap, localCountDownLatch));
      try
      {
        localCountDownLatch.await();
        this.a.d.run();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException(localInterruptedException);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */