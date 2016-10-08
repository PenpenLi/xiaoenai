package com.xiaoenai.app.utils.h;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class e
  implements MediaPlayer.OnErrorListener
{
  e(c paramc) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    c.a(this.a).a(c.b(this.a), paramInt1);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */