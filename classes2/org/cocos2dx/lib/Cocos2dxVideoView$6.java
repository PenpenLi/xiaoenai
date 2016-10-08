package org.cocos2dx.lib;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class Cocos2dxVideoView$6
  implements SurfaceHolder.Callback
{
  Cocos2dxVideoView$6(Cocos2dxVideoView paramCocos2dxVideoView) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (Cocos2dxVideoView.access$600(this.this$0) == 3)
    {
      paramInt1 = 1;
      if ((Cocos2dxVideoView.access$000(this.this$0) != paramInt2) || (Cocos2dxVideoView.access$100(this.this$0) != paramInt3)) {
        break label97;
      }
    }
    label97:
    for (paramInt2 = i;; paramInt2 = 0)
    {
      if ((Cocos2dxVideoView.access$400(this.this$0) != null) && (paramInt1 != 0) && (paramInt2 != 0))
      {
        if (Cocos2dxVideoView.access$500(this.this$0) != 0) {
          this.this$0.seekTo(Cocos2dxVideoView.access$500(this.this$0));
        }
        this.this$0.start();
      }
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Cocos2dxVideoView.access$1302(this.this$0, paramSurfaceHolder);
    Cocos2dxVideoView.access$1400(this.this$0);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Cocos2dxVideoView.access$1302(this.this$0, null);
    Cocos2dxVideoView.access$700(this.this$0, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoView$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */