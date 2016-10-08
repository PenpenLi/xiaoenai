package org.cocos2dx.lib;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class Cocos2dxVideoView$4$1
  implements DialogInterface.OnClickListener
{
  Cocos2dxVideoView$4$1(Cocos2dxVideoView.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (Cocos2dxVideoView.access$800(this.this$1.this$0) != null) {
      Cocos2dxVideoView.access$800(this.this$1.this$0).onVideoEvent(Cocos2dxVideoView.access$900(this.this$1.this$0), 3);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoView$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */