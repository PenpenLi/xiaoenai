package com.alibaba.nb.android.trade.uibridge;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliTradeShowParams;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import java.util.Map;

public abstract interface IAliTradeService
{
  public abstract int show(Activity paramActivity, WebView paramWebView, WebViewClient paramWebViewClient, AliTradeBasePage paramAliTradeBasePage, AliTradeShowParams paramAliTradeShowParams, AliTradeTaokeParams paramAliTradeTaokeParams, Map<String, String> paramMap, AliTradeProcessCallback paramAliTradeProcessCallback);
  
  public abstract int show(Activity paramActivity, AliTradeBasePage paramAliTradeBasePage, AliTradeShowParams paramAliTradeShowParams, AliTradeTaokeParams paramAliTradeTaokeParams, Map<String, String> paramMap, AliTradeProcessCallback paramAliTradeProcessCallback);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\IAliTradeService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */