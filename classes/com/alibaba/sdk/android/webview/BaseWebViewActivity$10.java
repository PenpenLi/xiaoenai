package com.alibaba.sdk.android.webview;

import android.webkit.WebView;
import android.widget.TextView;

class BaseWebViewActivity$10
  extends BridgeWebChromeClient
{
  BaseWebViewActivity$10(BaseWebViewActivity paramBaseWebViewActivity) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (this.this$0.canReceiveTitle) {
      BaseWebViewActivity.access$300(this.this$0).setText(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */