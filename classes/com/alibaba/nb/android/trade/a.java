package com.alibaba.nb.android.trade;

import com.alibaba.nb.android.trade.callback.AliTradeInitCallback;

final class a
  implements Runnable
{
  a(AliTradeInitCallback paramAliTradeInitCallback) {}
  
  public final void run()
  {
    AliTradeSDK.a(this.a);
    com.alibaba.nb.android.trade.utils.d.a.b();
    AliTradeSDK.a();
    AliTradeContext.initData();
    AliTradeSDK.b();
    com.alibaba.nb.android.trade.utils.d.a.a(AliTradeSDK.c(), "AliTradeSdk初始化成功");
    AliTradeSDK.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */