package com.alibaba.nb.android.trade.uibridge;

import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.utils.a.a;
import com.alibaba.nb.android.trade.utils.b;

public class AliTradeMyOrdersPage
  extends AliTradeBasePage
{
  public static final String[] ORDER_TYPE = { "all", "waitPay", "waitSend", "waitConfirm", "waitRate" };
  public static final String TAB_CODE = "?tabCode=%s";
  int b;
  boolean c;
  
  public AliTradeMyOrdersPage(int paramInt, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public boolean checkParams()
  {
    boolean bool = true;
    if ((this.b < 0) || (this.b > 4))
    {
      if (AliTradeCallbackContext.tradeProcessCallback != null) {
        b.a(AliTradeCallbackContext.tradeProcessCallback, a.a(14, new Object[] { "openMyOrder, oderStatus" }));
      }
      bool = false;
    }
    return bool;
  }
  
  public String genOpenUrl()
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a))) {
      return this.a;
    }
    String str2 = AliTradeContext.MY_ORDERS_URL;
    int i = str2.indexOf('?');
    String str1 = str2;
    if (i > 0) {
      str1 = str2.substring(0, i);
    }
    str1 = str1 + "?tabCode=%s";
    if ((this.b >= 0) && (this.b < 5)) {
      if (!this.c) {
        this.a = String.format(str1 + "&condition={\"extra\":{\"attributes\":{\"ttid\":\"%s\"}}}", new Object[] { ORDER_TYPE[this.b], AliTradeConfigServiceImpl.getInstance().getAppKey() });
      }
    }
    for (;;)
    {
      return this.a;
      this.a = String.format(str1, new Object[] { ORDER_TYPE[this.b] });
      continue;
      this.a = str1.substring(0, str1.indexOf("?"));
    }
  }
  
  public String getApi()
  {
    return AliTradeUTConstants.E_SHOWORDER;
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\AliTradeMyOrdersPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */