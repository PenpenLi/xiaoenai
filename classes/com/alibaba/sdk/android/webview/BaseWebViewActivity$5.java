package com.alibaba.sdk.android.webview;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class BaseWebViewActivity$5
  implements View.OnClickListener
{
  BaseWebViewActivity$5(BaseWebViewActivity paramBaseWebViewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setAction("android.intent.action.VIEW");
    paramView.setData(Uri.parse(this.this$0.taeWebView.getUrl()));
    this.this$0.startActivity(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */