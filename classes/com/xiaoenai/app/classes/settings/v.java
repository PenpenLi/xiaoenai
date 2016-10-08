package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.feedback.view.activity.FeedbackActivity;

class v
  implements View.OnClickListener
{
  v(SettingFeedbackActivity paramSettingFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.a, FeedbackActivity.class);
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
    this.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */