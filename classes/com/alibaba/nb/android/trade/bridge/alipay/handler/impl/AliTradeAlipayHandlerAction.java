package com.alibaba.nb.android.trade.bridge.alipay.handler.impl;

import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.bridge.alipay.handler.a;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerAction;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;

public class AliTradeAlipayHandlerAction
  implements AliTradeHandlerAction
{
  private AliTradeHandlerInfo mHandlerInfo;
  
  public AliTradeAlipayHandlerAction(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    this.mHandlerInfo = paramAliTradeHandlerInfo;
  }
  
  public boolean execute(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    if (!AliTradeConfigServiceImpl.getInstance().getIsNeedAlipay(Boolean.TRUE.booleanValue())) {
      return Boolean.FALSE.booleanValue();
    }
    a locala = (a)AliTradeContext.serviceRegistry.getService(a.class, null);
    if (locala != null) {
      return locala.handle(paramAliTradeHandlerContext.webView, paramAliTradeHandlerContext.getUri());
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\handler\impl\AliTradeAlipayHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */