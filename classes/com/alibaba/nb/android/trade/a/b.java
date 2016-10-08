package com.alibaba.nb.android.trade.a;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.nb.android.trade.web.a.c;
import java.util.Map;

final class b
  implements Runnable
{
  b(a parama, WebView paramWebView, Map paramMap, WebViewClient paramWebViewClient, String paramString) {}
  
  public final void run()
  {
    c localc = new c(this.a, this.b, this.c, true);
    com.alibaba.nb.android.trade.utils.d.a.b(a.a(), "第三方 WebView首次加载的url=" + this.d);
    localc.b(this.d);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */