package com.alibaba.sdk.android.webview.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.LinearLayout;

class SendFeedbackActivity$6
  implements View.OnClickListener
{
  SendFeedbackActivity$6(SendFeedbackActivity paramSendFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    SendFeedbackActivity.access$500(this.this$0).removeView((View)paramView.getParent().getParent());
    SendFeedbackActivity.access$610(this.this$0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\feedback\SendFeedbackActivity$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */