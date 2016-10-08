package com.alibaba.sdk.android.webview.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.alibaba.sdk.android.util.ResourceUtils;
import com.alibaba.sdk.android.webview.views.HandWriter;

class FeedbackActivity$1
  implements View.OnClickListener
{
  FeedbackActivity$1(FeedbackActivity paramFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == ResourceUtils.getRId(this.this$0, "com_taobao_tae_sdk_web_view_activity_feedback_refresh_button")) {
      FeedbackActivity.access$000(this.this$0).clear();
    }
    do
    {
      return;
      if (i == ResourceUtils.getRId(this.this$0, "com_taobao_tae_sdk_web_view_activity_feedback_forward_button"))
      {
        this.this$0.saveImageAndGotoNextActivity();
        return;
      }
    } while (i != ResourceUtils.getRId(this.this$0, "com_taobao_tae_sdk_web_view_activity_feedback_titlebar_back_button"));
    this.this$0.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\feedback\FeedbackActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */