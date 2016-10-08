package com.alibaba.sdk.android.webview;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.alibaba.sdk.android.util.ResourceUtils;

class BaseWebViewActivity$4
  implements View.OnClickListener
{
  BaseWebViewActivity$4(BaseWebViewActivity paramBaseWebViewActivity) {}
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT < 11) {
      ((android.text.ClipboardManager)this.this$0.getSystemService("clipboard")).setText(this.this$0.taeWebView.getUrl());
    }
    for (;;)
    {
      Toast.makeText(this.this$0.getApplicationContext(), ResourceUtils.getString("com_taobao_tae_sdk_web_view_activity_basewebviewactivity_strings_menulist_copy"), 0).show();
      return;
      ((android.content.ClipboardManager)this.this$0.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.this$0.taeWebView.getUrl()));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */