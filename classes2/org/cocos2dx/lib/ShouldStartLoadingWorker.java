package org.cocos2dx.lib;

import java.util.concurrent.CountDownLatch;

class ShouldStartLoadingWorker
  implements Runnable
{
  private CountDownLatch mLatch;
  private boolean[] mResult;
  private final String mUrlString;
  private final int mViewTag;
  
  ShouldStartLoadingWorker(CountDownLatch paramCountDownLatch, boolean[] paramArrayOfBoolean, int paramInt, String paramString)
  {
    this.mLatch = paramCountDownLatch;
    this.mResult = paramArrayOfBoolean;
    this.mViewTag = paramInt;
    this.mUrlString = paramString;
  }
  
  public void run()
  {
    this.mResult[0] = Cocos2dxWebViewHelper._shouldStartLoading(this.mViewTag, this.mUrlString);
    this.mLatch.countDown();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\lib\ShouldStartLoadingWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */