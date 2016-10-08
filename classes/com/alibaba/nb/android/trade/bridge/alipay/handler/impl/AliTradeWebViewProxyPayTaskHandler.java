package com.alibaba.nb.android.trade.bridge.alipay.handler.impl;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.utils.e;
import java.util.ArrayList;
import java.util.List;

public class AliTradeWebViewProxyPayTaskHandler
  implements com.alibaba.nb.android.trade.bridge.alipay.handler.b
{
  private static final String TAG = "WebViewProxyPayTaskHandler";
  private String[] urlPrefixes;
  
  public AliTradeWebViewProxyPayTaskHandler(String[] paramArrayOfString)
  {
    this.urlPrefixes = paramArrayOfString;
  }
  
  private String buildTbOrderInfo(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new StringBuilder("trade_no=\"").append(paramString1).append("\"&extern_token=\"").append(paramString2).append("\"&partner=\"PARTNER_TAOBAO_ORDER\"");
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.append("&payPhaseId=\"").append(paramString3).append("\"");
    }
    return paramString1.toString();
  }
  
  private String getContent(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2) + paramString2.length();
    if (paramString3 != null) {}
    try
    {
      return paramString1.substring(i, paramString1.indexOf(paramString3));
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    paramString2 = paramString1.substring(i);
    return paramString2;
    return paramString1;
  }
  
  public boolean handle(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public boolean handle(com.alibaba.nb.android.trade.ui.a.b paramb, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    Object localObject1 = localUri.getQueryParameter("alipay_trade_no");
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = localUri.getQueryParameter("trade_nos");
    }
    Object localObject2 = localUri.getQueryParameter("payPhaseId");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localUri.getQueryParameter("pay_phase_id");
    }
    paramString = buildTbOrderInfo(paramString, localUri.getQueryParameter("s_id"), (String)localObject1);
    localObject2 = localUri.getQueryParameter("pay_order_id");
    localObject1 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split(",");
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject1).add(Long.valueOf(Long.parseLong(localObject2[i])));
        i += 1;
      }
    }
    paramb = (Activity)((View)paramb).getContext();
    AliTradeContext.executorService.a(new a(this, paramb, paramString));
    return true;
  }
  
  public boolean isURLSupported(String paramString)
  {
    if (paramString == null) {}
    label97:
    for (;;)
    {
      return false;
      String str;
      int j;
      int i;
      if ((paramString.startsWith("http://")) && (paramString.length() > 7))
      {
        str = paramString.substring(7);
        paramString = this.urlPrefixes;
        j = paramString.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          break label97;
        }
        if (str.startsWith(paramString[i]))
        {
          return true;
          str = paramString;
          if (!paramString.startsWith("https://")) {
            break;
          }
          str = paramString;
          if (paramString.length() <= 8) {
            break;
          }
          str = paramString.substring(8);
          break;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\handler\impl\AliTradeWebViewProxyPayTaskHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */