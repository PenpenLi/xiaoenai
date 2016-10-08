package org.cocos2dx.lib;

final class Cocos2dxGLSurfaceView$2
  implements Runnable
{
  Cocos2dxGLSurfaceView$2(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong) {}
  
  public void run()
  {
    Cocos2dxAccelerometer.onSensorChanged(this.val$x, this.val$y, this.val$z, this.val$timestamp);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\org\cocos2dx\lib\Cocos2dxGLSurfaceView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */