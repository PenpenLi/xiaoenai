package com.alibaba.nb.android.trade.ui.a;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.web.a.c;
import com.alibaba.nb.android.trade.web.interception.base.b;
import com.alibaba.nb.android.trade.web.interception.base.d;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;
import com.alibaba.sdk.android.webview.utils.WebViewUtils;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final String a = a.class.getSimpleName();
  
  public static a a()
  {
    return a.a();
  }
  
  public static boolean a(c paramc, WebView paramWebView, String paramString)
  {
    com.alibaba.nb.android.trade.utils.d.a.a(a, "加参数前的url:" + paramString);
    if (com.alibaba.nb.android.trade.utils.d.a.a()) {
      com.alibaba.nb.android.trade.utils.d.a.b(a, paramString);
    }
    if (paramWebView == null) {
      return false;
    }
    com.alibaba.nb.android.trade.web.interception.base.a.a locala = new com.alibaba.nb.android.trade.web.interception.base.a.a();
    locala.g = ((Activity)paramWebView.getContext());
    locala.a = paramWebView;
    locala.d = paramString;
    locala.b = paramc;
    if (!paramc.d()) {
      locala.f = "noForceH5";
    }
    locala.e = 2;
    locala.i = new HashMap();
    if (paramc.c() != null) {
      locala.i.put("ui_contextParams", paramc.c());
    }
    paramc = d.a().b(locala);
    if (paramc.a)
    {
      if (paramWebView.getUrl().matches(AliTradeContext.sclickPattern)) {
        ((Activity)paramWebView.getContext()).finish();
      }
      return true;
    }
    paramc = paramc.b;
    if (!WebViewUtils.isLoginDowngraded()) {
      CookieManagerWrapper.INSTANCE.refreshCookie(paramc);
    }
    if (paramString.equals(paramc))
    {
      com.alibaba.nb.android.trade.utils.d.a.a(a, "加参数后与原来的url一致，加载的url为:" + paramc);
      return false;
    }
    com.alibaba.nb.android.trade.utils.d.a.a(a, "加参数后与原来的url不同，加载的url为:" + paramc);
    paramWebView.loadUrl(paramc);
    return true;
  }
  
  private static final class a
  {
    private static final a a = new a((byte)0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\ui\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */