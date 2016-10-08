package com.alibaba.nb.android.trade.bridge.login.handler;

import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import com.alibaba.nb.android.trade.web.interception.base.handler.a.a;

public class AliTradeLoginHandlerImpl
  extends a
{
  public static String loginMatchUrls = "login.m.taobao.com/login.htm,login.tmall.com,login.taobao.com/member/login.jhtml";
  public static String logoutMatchUrls = "login.m.taobao.com/logout.htm";
  
  public AliTradeLoginHandlerImpl(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    super(paramAliTradeHandlerInfo);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\login\handler\AliTradeLoginHandlerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */