package com.alibaba.nb.android.trade.web.interception.base.handler;

public abstract interface AliTradeHandler
{
  public abstract boolean doHandle(AliTradeHandlerContext paramAliTradeHandlerContext);
  
  public abstract AliTradeHandlerInfo getHandlerInfo();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\handler\AliTradeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */