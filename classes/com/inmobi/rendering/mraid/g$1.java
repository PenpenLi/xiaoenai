package com.inmobi.rendering.mraid;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class g$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  g$1(g paramg) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, g.i(), ">>> onVideoSizeChanged");
    if ((g.b(this.a) == null) && (this.a.e.e))
    {
      g.a(this.a, new g.a(this.a.getContext()));
      g.b(this.a).setAnchorView(this.a);
      this.a.setMediaController(g.b(this.a));
      this.a.requestLayout();
      this.a.requestFocus();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\g$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */