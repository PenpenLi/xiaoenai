package com.alibaba.nb.android.trade;

import com.alibaba.nb.android.trade.callback.AliTradeInitCallback;
import java.util.concurrent.atomic.AtomicInteger;

final class c
  implements Runnable
{
  c(AliTradeInitCallback paramAliTradeInitCallback) {}
  
  public final void run()
  {
    if (AliTradeSDK.d().decrementAndGet() == 0)
    {
      AliTradeContext.isInitOk = Boolean.TRUE;
      this.a.onSuccess();
      AliTradeSDK.e();
      AliTradeSDK.a(true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */