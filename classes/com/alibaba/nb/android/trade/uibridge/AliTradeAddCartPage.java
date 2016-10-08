package com.alibaba.nb.android.trade.uibridge;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.a.d;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeTaokeTraceCallback;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.utils.a.a;
import com.alibaba.nb.android.trade.utils.b;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.security.SecurityService;
import java.util.HashMap;
import java.util.Map;

public class AliTradeAddCartPage
  extends AliTradeBasePage
{
  private String b;
  
  public AliTradeAddCartPage(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.matches("^\\d+$")) {
        break label26;
      }
      this.b = paramString;
    }
    label26:
    SecurityService localSecurityService;
    do
    {
      return;
      localSecurityService = (SecurityService)KernelContext.serviceRegistry.getService(SecurityService.class, null);
    } while (localSecurityService == null);
    this.b = String.valueOf(localSecurityService.analyzeItemId(paramString));
  }
  
  public boolean checkParams()
  {
    boolean bool = true;
    if ((this.b == null) || (TextUtils.isEmpty(this.b)))
    {
      if (AliTradeCallbackContext.tradeProcessCallback != null) {
        b.a(AliTradeCallbackContext.tradeProcessCallback, a.a(14, new Object[] { "openItemId, itemId" }));
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
    String str2 = AliTradeContext.TB_ITEM_DETAIL_URL;
    int i = str2.indexOf('?');
    String str1 = str2;
    if (i > 0) {
      str1 = str2.substring(0, i);
    }
    this.a = Uri.parse(String.format(str1 + "?id=%s", new Object[] { String.valueOf(this.b) })).buildUpon().appendQueryParameter("action_tae", "cart").appendQueryParameter("from_tae", "true").fragment("sku").build().toString();
    return this.a;
  }
  
  public String getApi()
  {
    return AliTradeUTConstants.E_ADDITEM2CART;
  }
  
  public boolean needTaoke(AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    return paramAliTradeTaokeParams != null;
  }
  
  public int requireOpenType()
  {
    return 1;
  }
  
  public void taokeTraceAndGenUrl(AliTradeTaokeParams paramAliTradeTaokeParams, AliTradeTaokeTraceCallback paramAliTradeTaokeTraceCallback)
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.b))) {}
    HashMap localHashMap;
    do
    {
      return;
      localHashMap = new HashMap();
      localHashMap.put("itemId", this.b);
    } while (AliTradeCallbackContext.tradeProcessCallback == null);
    d.a.a(localHashMap, genOpenUrl(), false, paramAliTradeTaokeParams, getApi(), paramAliTradeTaokeTraceCallback, AliTradeCallbackContext.tradeProcessCallback);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\AliTradeAddCartPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */