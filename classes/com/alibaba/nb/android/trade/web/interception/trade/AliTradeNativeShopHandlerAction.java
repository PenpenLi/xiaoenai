package com.alibaba.nb.android.trade.web.interception.trade;

import com.alibaba.nb.android.trade.a.c;
import com.alibaba.nb.android.trade.model.inner.AliTradeApplinkOpenType;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerAction;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;

public class AliTradeNativeShopHandlerAction
  implements AliTradeHandlerAction
{
  public static final String TAG = "AliTradeNativeShopHandlerAction";
  
  public AliTradeNativeShopHandlerAction(AliTradeHandlerInfo paramAliTradeHandlerInfo) {}
  
  public static String getActivityBackUrl()
  {
    String str = AliTradeConfigServiceImpl.getInstance().getAppKey() + ".nativeTaobao";
    return "alisdk://" + str + "/handleraction";
  }
  
  public boolean execute(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    String str1 = getActivityBackUrl();
    String str2 = paramAliTradeHandlerContext.getQueryParameter("shop_id");
    String str3 = paramAliTradeHandlerContext.getQueryParameter("pid");
    return c.a(paramAliTradeHandlerContext.activity, AliTradeApplinkOpenType.SHOWSHOP, str2, AliTradeConfigServiceImpl.getInstance().getIsvCode(), str3, str1, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\trade\AliTradeNativeShopHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */