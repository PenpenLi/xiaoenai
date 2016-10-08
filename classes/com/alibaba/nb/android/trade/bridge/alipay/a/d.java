package com.alibaba.nb.android.trade.bridge.alipay.a;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import com.alibaba.nb.android.trade.model.AliTradeResultType;
import com.alibaba.nb.android.trade.ui.activity.AliTradeWebViewActivity;

final class d
  implements Runnable
{
  d(a parama, AliTradeResult paramAliTradeResult, WebView paramWebView) {}
  
  public final void run()
  {
    this.a.resultType = AliTradeResultType.TYPEPAY;
    if (AliTradeCallbackContext.tradeProcessCallback != null) {
      AliTradeCallbackContext.tradeProcessCallback.onTradeSuccess(this.a);
    }
    if ((this.b.getContext() instanceof AliTradeWebViewActivity)) {
      ((AliTradeWebViewActivity)this.b.getContext()).finish();
    }
    while (!(this.b.getContext() instanceof Activity)) {
      return;
    }
    ((Activity)this.b.getContext()).finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */