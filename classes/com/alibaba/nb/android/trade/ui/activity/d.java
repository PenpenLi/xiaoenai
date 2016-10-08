package com.alibaba.nb.android.trade.ui.activity;

import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliTradeResult;

final class d
  implements Runnable
{
  d(AliTradeWebViewActivity paramAliTradeWebViewActivity, AliTradeResult paramAliTradeResult) {}
  
  public final void run()
  {
    AliTradeCallbackContext.tradeProcessCallback.onTradeSuccess(this.a);
    this.b.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\ui\activity\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */