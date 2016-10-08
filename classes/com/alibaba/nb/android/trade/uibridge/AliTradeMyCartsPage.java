package com.alibaba.nb.android.trade.uibridge;

import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;

public class AliTradeMyCartsPage
  extends AliTradeBasePage
{
  public String genOpenUrl()
  {
    return AliTradeContext.SHOW_CART_URL;
  }
  
  public String getApi()
  {
    return AliTradeUTConstants.E_SHOWCART;
  }
  
  public boolean isBackWhenLoginFail()
  {
    return true;
  }
  
  public boolean needTaoke(AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\AliTradeMyCartsPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */