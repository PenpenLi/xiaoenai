package com.alibaba.sdk.android.login.ui;

import android.webkit.WebView;
import com.alibaba.sdk.android.ui.bus.ExecutionResult;
import com.alibaba.sdk.android.ui.bus.UIBus;
import com.alibaba.sdk.android.ui.bus.UIBusRequest;
import com.alibaba.sdk.android.webview.BaseWebViewClient;
import com.alibaba.sdk.android.webview.TaeWebView;

class QrLoginConfirmActivity$1
  extends BaseWebViewClient
{
  QrLoginConfirmActivity$1(QrLoginConfirmActivity paramQrLoginConfirmActivity) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    UIBusRequest localUIBusRequest = new UIBusRequest();
    localUIBusRequest.webView = paramWebView;
    localUIBusRequest.url = paramString;
    localUIBusRequest.scenario = 2;
    localUIBusRequest.scope = "login";
    if (UIBus.getDefault().execute(localUIBusRequest).procceed) {
      return true;
    }
    if ((paramWebView instanceof TaeWebView))
    {
      ((TaeWebView)paramWebView).loadUrl(paramString, false);
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\QrLoginConfirmActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */