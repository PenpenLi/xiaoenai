package com.alibaba.nb.android.trade.web.interception.trade;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import com.alibaba.nb.android.trade.model.AliTradeResultType;

final class a
  implements Runnable
{
  a(AliTradeAddCartRedirectHandlerAction paramAliTradeAddCartRedirectHandlerAction, WebView paramWebView) {}
  
  public final void run()
  {
    AliTradeResult localAliTradeResult = new AliTradeResult();
    localAliTradeResult.resultType = AliTradeResultType.TYPECART;
    AliTradeCallbackContext.tradeProcessCallback.onTradeSuccess(localAliTradeResult);
    if ((this.a != null) && ((this.a.getContext() instanceof Activity))) {
      ((Activity)this.a.getContext()).finish();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\trade\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */