package com.xiaoenai.app.feature.feedback.view.activity;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;

class j
  extends ViewPropertyAnimatorListenerAdapter
{
  j(FeedbackActivity paramFeedbackActivity) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.a.mRlChatBody.removeView(FeedbackActivity.a(this.a));
    FeedbackActivity.a(this.a, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\view\activity\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */