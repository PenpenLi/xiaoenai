package com.alibaba.nb.android.trade.bridge.login.handler;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.bridge.login.AliTradeLoginService;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerAction;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;

public class AliTradeLogoutHandlerAction
  implements AliTradeHandlerAction
{
  private AliTradeHandlerInfo handlerInfo;
  
  public AliTradeLogoutHandlerAction(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    this.handlerInfo = paramAliTradeHandlerInfo;
  }
  
  public boolean execute(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    ((AliTradeLoginService)AliTradeContext.serviceRegistry.getService(AliTradeLoginService.class, null)).logout((Activity)paramAliTradeHandlerContext.webView.getContext(), new c(this));
    paramAliTradeHandlerContext.webView.loadUrl(AliTradeContext.HOME_URL);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\login\handler\AliTradeLogoutHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */