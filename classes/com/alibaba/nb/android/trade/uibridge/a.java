package com.alibaba.nb.android.trade.uibridge;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.nb.android.trade.callback.AliTradeTaokeTraceCallback;

final class a
  implements AliTradeTaokeTraceCallback
{
  a(AliTradeService paramAliTradeService, AliTradeBasePage paramAliTradeBasePage, Activity paramActivity, WebView paramWebView, WebViewClient paramWebViewClient) {}
  
  public final void genTaokeUrl(String paramString)
  {
    String str = this.a.genOpenUrl();
    if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      AliTradeService.a(this.e, this.b, this.c, this.d, this.a.getAddParamsUrl(paramString, AliTradeService.a(this.e)), this.a);
      return;
      paramString = str;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */