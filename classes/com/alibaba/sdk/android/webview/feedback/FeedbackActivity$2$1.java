package com.alibaba.sdk.android.webview.feedback;

import android.content.Intent;

class FeedbackActivity$2$1
  implements Runnable
{
  FeedbackActivity$2$1(FeedbackActivity.2 param2, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$1.this$0, SendFeedbackActivity.class);
    localIntent.putExtra("imagePath", this.val$drawedImagePath);
    this.this$1.this$0.startActivityForResult(localIntent, 200);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\feedback\FeedbackActivity$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */