package org.cocos2dx.lib;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class Cocos2dxVideoView$3
  implements MediaPlayer.OnCompletionListener
{
  Cocos2dxVideoView$3(Cocos2dxVideoView paramCocos2dxVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Cocos2dxVideoView.access$202(this.this$0, 5);
    Cocos2dxVideoView.access$602(this.this$0, 5);
    Cocos2dxVideoView.access$700(this.this$0, true);
    if (Cocos2dxVideoView.access$800(this.this$0) != null) {
      Cocos2dxVideoView.access$800(this.this$0).onVideoEvent(Cocos2dxVideoView.access$900(this.this$0), 3);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */