package com.xiaoenai.app.utils.h;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class d
  implements MediaPlayer.OnCompletionListener
{
  d(c paramc) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (c.a(this.a) != null)
    {
      paramMediaPlayer = c.b(this.a);
      c.a(this.a).f(paramMediaPlayer);
      if (paramMediaPlayer == c.b(this.a)) {
        c.a(this.a, null);
      }
      this.a.d();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */