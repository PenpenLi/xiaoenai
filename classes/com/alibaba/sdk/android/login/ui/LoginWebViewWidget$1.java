package com.alibaba.sdk.android.login.ui;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.login.impl.WebResCacheManager;
import com.alibaba.sdk.android.ui.bus.ExecutionResult;
import com.alibaba.sdk.android.ui.bus.UIBus;
import com.alibaba.sdk.android.ui.bus.UIBusRequest;

class LoginWebViewWidget$1
  extends WebViewClient
{
  LoginWebViewWidget$1(LoginWebViewWidget paramLoginWebViewWidget) {}
  
  @TargetApi(11)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (LoginContext.useCache) {
      return WebResCacheManager.INSTANCE.shouldCache(paramString, System.currentTimeMillis());
    }
    return null;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    UIBusRequest localUIBusRequest = new UIBusRequest();
    localUIBusRequest.webView = paramWebView;
    localUIBusRequest.url = paramString;
    localUIBusRequest.scenario = 2;
    localUIBusRequest.scope = "login";
    return UIBus.getDefault().execute(localUIBusRequest).procceed;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\LoginWebViewWidget$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */