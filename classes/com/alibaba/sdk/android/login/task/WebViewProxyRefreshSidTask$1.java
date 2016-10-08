package com.alibaba.sdk.android.login.task;

import com.alibaba.sdk.android.ui.support.WebViewActivitySupport;

class WebViewProxyRefreshSidTask$1
  implements Runnable
{
  WebViewProxyRefreshSidTask$1(WebViewProxyRefreshSidTask paramWebViewProxyRefreshSidTask) {}
  
  public void run()
  {
    WebViewActivitySupport.getInstance().safeReload(WebViewProxyRefreshSidTask.access$000(this.this$0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\WebViewProxyRefreshSidTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */