package com.alibaba.sdk.android.webview;

import android.view.View;
import android.view.View.OnClickListener;

class BaseWebViewActivity$2
  implements View.OnClickListener
{
  BaseWebViewActivity$2(BaseWebViewActivity paramBaseWebViewActivity, View paramView) {}
  
  public void onClick(View paramView)
  {
    BaseWebViewActivity.access$000(this.this$0);
    if (this.val$closeButton != null) {
      this.val$closeButton.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */