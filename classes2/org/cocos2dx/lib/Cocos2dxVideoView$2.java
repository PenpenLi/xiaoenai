package org.cocos2dx.lib;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class Cocos2dxVideoView$2
  implements MediaPlayer.OnPreparedListener
{
  Cocos2dxVideoView$2(Cocos2dxVideoView paramCocos2dxVideoView) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Cocos2dxVideoView.access$202(this.this$0, 2);
    if (Cocos2dxVideoView.access$300(this.this$0) != null) {
      Cocos2dxVideoView.access$300(this.this$0).onPrepared(Cocos2dxVideoView.access$400(this.this$0));
    }
    Cocos2dxVideoView.access$002(this.this$0, paramMediaPlayer.getVideoWidth());
    Cocos2dxVideoView.access$102(this.this$0, paramMediaPlayer.getVideoHeight());
    int i = Cocos2dxVideoView.access$500(this.this$0);
    if (i != 0) {
      this.this$0.seekTo(i);
    }
    if ((Cocos2dxVideoView.access$000(this.this$0) != 0) && (Cocos2dxVideoView.access$100(this.this$0) != 0)) {
      this.this$0.fixSize();
    }
    if (Cocos2dxVideoView.access$600(this.this$0) == 3) {
      this.this$0.start();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */