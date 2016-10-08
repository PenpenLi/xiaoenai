package com.xiaoenai.app.utils.h;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class f
  implements MediaPlayer.OnPreparedListener
{
  f(c paramc, int paramInt) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    c.c(this.b).setMode(this.a);
    c.d(this.b).start();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */