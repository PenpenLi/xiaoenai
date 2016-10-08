package org.cocos2dx.lib;

class Cocos2dxVideoHelper$1
  implements Cocos2dxVideoView.OnVideoEventListener
{
  Cocos2dxVideoHelper$1(Cocos2dxVideoHelper paramCocos2dxVideoHelper) {}
  
  public void onVideoEvent(int paramInt1, int paramInt2)
  {
    Cocos2dxVideoHelper.access$1400(this.this$0).runOnGLThread(new Cocos2dxVideoHelper.VideoEventRunnable(this.this$0, paramInt1, paramInt2));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxVideoHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */