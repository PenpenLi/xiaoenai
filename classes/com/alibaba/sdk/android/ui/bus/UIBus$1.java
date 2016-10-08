package com.alibaba.sdk.android.ui.bus;

import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.bus.handler.Handler;
import com.alibaba.sdk.android.ui.bus.handler.HandlerContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import java.util.concurrent.CountDownLatch;

class UIBus$1
  implements Runnable
{
  UIBus$1(UIBus paramUIBus, UIBus.BooleanHolder paramBooleanHolder, Handler paramHandler, HandlerContext paramHandlerContext, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      this.val$retHolder.returnValue = Boolean.valueOf(this.val$handler.doHandle(this.val$handlerContext));
      return;
    }
    catch (Throwable localThrowable)
    {
      AliSDKLogger.e("ui", "fail to execute the handler " + this.val$handler.getHandlerInfo().name, localThrowable);
      return;
    }
    finally
    {
      this.val$count.countDown();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\UIBus$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */