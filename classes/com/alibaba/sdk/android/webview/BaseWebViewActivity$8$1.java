package com.alibaba.sdk.android.webview;

import android.content.Intent;
import com.alibaba.sdk.android.webview.feedback.FeedbackActivity;

class BaseWebViewActivity$8$1
  implements Runnable
{
  BaseWebViewActivity$8$1(BaseWebViewActivity.8 param8, String paramString) {}
  
  public void run()
  {
    if (this.val$imagePath != null)
    {
      Intent localIntent = new Intent(this.this$1.this$0, FeedbackActivity.class);
      localIntent.putExtra("imagePath", this.val$imagePath);
      this.this$1.this$0.startActivity(localIntent);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$8$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */