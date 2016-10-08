package com.alibaba.nb.android.trade.web.a;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.nb.a.a.a.a.a;
import com.alibaba.nb.android.trade.ui.a.a;

final class d
  extends WebViewClient
{
  d(c paramc) {}
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    c localc = this.a;
    c.a(paramString);
    c.a(this.a).setTag(a.a.e, Boolean.valueOf(false));
    a.a();
    return a.a(this.a, paramWebView, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */