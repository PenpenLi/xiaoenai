package com.alibaba.sdk.android.webview;

import android.view.View;
import android.view.View.OnClickListener;

class BaseWebViewActivity$6
  implements View.OnClickListener
{
  BaseWebViewActivity$6(BaseWebViewActivity paramBaseWebViewActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.taeWebView != null) {
      this.this$0.taeWebView.clearCache();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */