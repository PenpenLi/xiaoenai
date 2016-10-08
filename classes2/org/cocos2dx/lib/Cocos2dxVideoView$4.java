package org.cocos2dx.lib;

import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;

class Cocos2dxVideoView$4
  implements MediaPlayer.OnErrorListener
{
  Cocos2dxVideoView$4(Cocos2dxVideoView paramCocos2dxVideoView) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.d(Cocos2dxVideoView.access$1000(this.this$0), "Error: " + paramInt1 + "," + paramInt2);
    Cocos2dxVideoView.access$202(this.this$0, -1);
    Cocos2dxVideoView.access$602(this.this$0, -1);
    if ((Cocos2dxVideoView.access$1100(this.this$0) != null) && (Cocos2dxVideoView.access$1100(this.this$0).onError(Cocos2dxVideoView.access$400(this.this$0), paramInt1, paramInt2))) {}
    while (this.this$0.getWindowToken() == null) {
      return true;
    }
    paramMediaPlayer = this.this$0.mCocos2dxActivity.getResources();
    if (paramInt1 == 200) {}
    for (paramInt1 = paramMediaPlayer.getIdentifier("VideoView_error_text_invalid_progressive_playback", "string", "android");; paramInt1 = paramMediaPlayer.getIdentifier("VideoView_error_text_unknown", "string", "android"))
    {
      paramInt2 = paramMediaPlayer.getIdentifier("VideoView_error_title", "string", "android");
      int i = paramMediaPlayer.getIdentifier("VideoView_error_button", "string", "android");
      new AlertDialog.Builder(this.this$0.mCocos2dxActivity).setTitle(paramMediaPlayer.getString(paramInt2)).setMessage(paramInt1).setPositiveButton(paramMediaPlayer.getString(i), new Cocos2dxVideoView.4.1(this)).setCancelable(false).show();
      return true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoView$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */