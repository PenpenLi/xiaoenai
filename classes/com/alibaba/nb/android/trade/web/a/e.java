package com.alibaba.nb.android.trade.web.a;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

final class e
  extends com.alibaba.nb.android.trade.web.a.a.a
{
  e(c paramc, WebViewClient paramWebViewClient, Map paramMap)
  {
    super(paramWebViewClient, paramMap);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (super.shouldOverrideUrlLoading(paramWebView, paramString)) {
      return true;
    }
    com.alibaba.nb.android.trade.ui.a.a.a();
    return com.alibaba.nb.android.trade.ui.a.a.a(this.a, paramWebView, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */