package com.alibaba.nb.android.trade.bridge.alipay.handler.impl;

import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import com.alibaba.nb.android.trade.web.interception.base.handler.a.a;

public class AliTradeAlipayHandlerImpl
  extends a
{
  public static String[] TRADE_APLIPAY_URLS = { "maliprod.alipay.com/w/trade_pay.do", "maliprod.alipay.com/batch_payment.do", "mclient.alipay.com/w/trade_pay.do", "mclient.alipay.com/batch_payment.do" };
  
  public AliTradeAlipayHandlerImpl(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    super(paramAliTradeHandlerInfo);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\handler\impl\AliTradeAlipayHandlerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */