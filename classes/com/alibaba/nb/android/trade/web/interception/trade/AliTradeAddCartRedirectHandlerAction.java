package com.alibaba.nb.android.trade.web.interception.trade;

import android.webkit.WebView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import com.alibaba.nb.android.trade.model.AliTradeResultType;
import com.alibaba.nb.android.trade.ui.activity.AliTradeWebViewActivity;
import com.alibaba.nb.android.trade.utils.e;
import com.alibaba.nb.android.trade.web.a.c;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerAction;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;

public class AliTradeAddCartRedirectHandlerAction
  implements AliTradeHandlerAction
{
  private AliTradeHandlerInfo handlerInfo;
  
  public AliTradeAddCartRedirectHandlerAction(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    this.handlerInfo = paramAliTradeHandlerInfo;
  }
  
  public boolean execute(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    if (paramAliTradeHandlerContext.getScenario() != 2) {}
    Object localObject;
    do
    {
      return false;
      localObject = paramAliTradeHandlerContext.webView;
    } while (localObject == null);
    if ((((WebView)localObject).getContext() instanceof AliTradeWebViewActivity)) {
      if (!paramAliTradeHandlerContext.webViewWrapper.b())
      {
        paramAliTradeHandlerContext = (AliTradeWebViewActivity)((WebView)localObject).getContext();
        localObject = new AliTradeResult();
        ((AliTradeResult)localObject).resultType = AliTradeResultType.TYPECART;
        paramAliTradeHandlerContext.a((AliTradeResult)localObject);
      }
    }
    for (;;)
    {
      return true;
      ((WebView)localObject).goBack();
      continue;
      if (AliTradeCallbackContext.tradeProcessCallback != null) {
        AliTradeContext.executorService.b(new a(this, (WebView)localObject));
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\trade\AliTradeAddCartRedirectHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */