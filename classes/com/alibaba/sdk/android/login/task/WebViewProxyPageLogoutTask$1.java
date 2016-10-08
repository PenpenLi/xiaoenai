package com.alibaba.sdk.android.login.task;

import com.alibaba.sdk.android.web.impl.CookieManagerWrapperWithWebViewProxy;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;

class WebViewProxyPageLogoutTask$1
  implements Runnable
{
  WebViewProxyPageLogoutTask$1(WebViewProxyPageLogoutTask paramWebViewProxyPageLogoutTask) {}
  
  public void run()
  {
    CookieManagerWrapperWithWebViewProxy.INSTANCE.refreshCookie(WebViewProxyPageLogoutTask.access$000(this.this$0), "https://h5.m.taobao.com");
    WebViewProxyPageLogoutTask.access$000(this.this$0).loadUrl("https://h5.m.taobao.com");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\WebViewProxyPageLogoutTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */