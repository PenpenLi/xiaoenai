package com.alibaba.nb.android.trade.uibridge;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.a.c;
import com.alibaba.nb.android.trade.a.d;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeTaokeTraceCallback;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.model.AliTradeShowParams;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.model.inner.AliTradeApplinkOpenType;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.ui.activity.AliTradeNativeTaobaoClientActivity;
import com.alibaba.nb.android.trade.utils.a.a;
import com.alibaba.nb.android.trade.utils.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AliTradeShopPage
  extends AliTradeBasePage
{
  private String b;
  private String c;
  
  public AliTradeShopPage(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.b = paramString;
    }
  }
  
  protected final boolean a(AliTradeTaokeParams paramAliTradeTaokeParams, AliTradeShowParams paramAliTradeShowParams, Map<String, String> paramMap, Activity paramActivity)
  {
    String str = null;
    if (paramAliTradeTaokeParams != null) {}
    for (paramAliTradeTaokeParams = paramAliTradeTaokeParams.pid;; paramAliTradeTaokeParams = null)
    {
      if (paramAliTradeShowParams != null) {
        str = paramAliTradeShowParams.getBackUrl();
      }
      if ((str == null) || (TextUtils.isEmpty(str)))
      {
        paramAliTradeTaokeParams = new Intent(paramActivity, AliTradeNativeTaobaoClientActivity.class);
        paramAliTradeTaokeParams.putExtra("actionParameters", (Serializable)paramMap);
        paramAliTradeTaokeParams.putExtra("actionName", "showNative");
        paramAliTradeTaokeParams.putExtra("type", AliTradeApplinkOpenType.SHOWSHOP);
        paramAliTradeTaokeParams.putExtra("id", this.b);
        paramActivity.startActivity(paramAliTradeTaokeParams);
        return Boolean.TRUE.booleanValue();
      }
      return c.a(paramActivity, AliTradeApplinkOpenType.SHOWSHOP, this.b, AliTradeConfigServiceImpl.getInstance().getIsvCode(), paramAliTradeTaokeParams, str, paramMap);
    }
  }
  
  public boolean checkParams()
  {
    boolean bool = true;
    if ((this.b == null) || (TextUtils.isEmpty(this.b)))
    {
      if (AliTradeCallbackContext.tradeProcessCallback != null) {
        b.a(AliTradeCallbackContext.tradeProcessCallback, a.a(14, new Object[] { "shopId" }));
      }
      bool = false;
    }
    return bool;
  }
  
  public String genOpenUrl()
  {
    if ((this.c != null) && (!TextUtils.isEmpty(this.c))) {
      return this.c;
    }
    String str2 = AliTradeContext.TB_SHOP_URL;
    int i = str2.indexOf('?');
    String str1 = str2;
    if (i > 0) {
      str1 = str2.substring(0, i);
    }
    this.c = String.format(str1 + "?shop_id=%s", new Object[] { this.b });
    return this.c;
  }
  
  public String getApi()
  {
    return AliTradeUTConstants.E_SHOWSHOP;
  }
  
  public boolean needTaoke(AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    return paramAliTradeTaokeParams != null;
  }
  
  public void taokeTraceAndGenUrl(AliTradeTaokeParams paramAliTradeTaokeParams, AliTradeTaokeTraceCallback paramAliTradeTaokeTraceCallback)
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.b))) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      localHashMap.put("shopId", this.b);
    } while (AliTradeCallbackContext.tradeProcessCallback == null);
    d.a.a(localHashMap, genOpenUrl(), true, paramAliTradeTaokeParams, getApi(), paramAliTradeTaokeTraceCallback, AliTradeCallbackContext.tradeProcessCallback);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\AliTradeShopPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */