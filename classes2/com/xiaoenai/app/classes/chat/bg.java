package com.xiaoenai.app.classes.chat;

import android.media.MediaRecorder;
import com.xiaoenai.app.utils.f.b;
import com.xiaoenai.app.utils.h.k;

class bg
  implements Runnable
{
  bg(be parambe) {}
  
  public void run()
  {
    if (be.a(this.a) == null) {}
    MediaRecorder localMediaRecorder;
    do
    {
      return;
      localMediaRecorder = be.a(this.a).c();
    } while ((localMediaRecorder == null) || (be.b(this.a) == null));
    int i = localMediaRecorder.getMaxAmplitude() * 10 / 32767;
    be.b(this.a).sendEmptyMessage(i);
    be.b(this.a).postDelayed(this, 300L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */