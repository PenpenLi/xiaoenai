package com.alibaba.nb.android.trade.bridge.alipay.handler.impl;

import android.webkit.WebView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;

public class AliTradePayOverrideHandler
  implements com.alibaba.nb.android.trade.bridge.alipay.handler.a
{
  private static final String TAG = AliTradePayOverrideHandler.class.getSimpleName();
  private String[] urlPrefixes;
  
  public AliTradePayOverrideHandler(String[] paramArrayOfString)
  {
    this.urlPrefixes = paramArrayOfString;
  }
  
  private boolean openAlipayService(WebView paramWebView, String paramString)
  {
    com.alibaba.nb.android.trade.bridge.alipay.a locala = (com.alibaba.nb.android.trade.bridge.alipay.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.bridge.alipay.a.class, null);
    if (locala != null) {
      return locala.a(paramWebView, paramString);
    }
    return false;
  }
  
  public boolean handle(WebView paramWebView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("AliTradePayOverrideHandler.handle()--进入支付流程: url:").append(paramString).append(" webview:");
    if (paramWebView != null) {}
    for (String str = paramWebView.toString();; str = null)
    {
      com.alibaba.nb.android.trade.utils.d.a.a("BaichuanTLOG", str);
      return openAlipayService(paramWebView, paramString);
    }
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\handler\impl\AliTradePayOverrideHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */