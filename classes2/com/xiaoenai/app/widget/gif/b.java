package com.xiaoenai.app.widget.gif;

import android.graphics.Bitmap;

class b
  implements Runnable
{
  b(GifDecoderView.a parama, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.a != null) && (!this.a.isRecycled())) {
      this.b.c.setImageBitmap(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\gif\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */