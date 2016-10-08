package com.alibaba.nb.android.trade.web.interception.base;

import com.alibaba.nb.android.trade.utils.d.a;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandler;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import java.util.concurrent.CountDownLatch;

final class e
  implements Runnable
{
  e(d paramd, d.a parama, AliTradeHandler paramAliTradeHandler, AliTradeHandlerContext paramAliTradeHandlerContext, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      this.a.a = Boolean.valueOf(this.b.doHandle(this.c));
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder("fail to execute the AliTradeHandler ");
      if ((this.b != null) && (this.b.getHandlerInfo() != null)) {}
      for (String str = this.b.getHandlerInfo().name;; str = null)
      {
        a.a("ui", str, localThrowable);
        return;
      }
    }
    finally
    {
      this.d.countDown();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */