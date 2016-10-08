package org.cocos2dx.lib;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.SurfaceHolder;

class Cocos2dxVideoView$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  Cocos2dxVideoView$1(Cocos2dxVideoView paramCocos2dxVideoView) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Cocos2dxVideoView.access$002(this.this$0, paramMediaPlayer.getVideoWidth());
    Cocos2dxVideoView.access$102(this.this$0, paramMediaPlayer.getVideoHeight());
    if ((Cocos2dxVideoView.access$000(this.this$0) != 0) && (Cocos2dxVideoView.access$100(this.this$0) != 0)) {
      this.this$0.getHolder().setFixedSize(Cocos2dxVideoView.access$000(this.this$0), Cocos2dxVideoView.access$100(this.this$0));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */