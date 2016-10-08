package com.xiaoenai.app.classes.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.feedback.view.activity.FeedbackActivity;
import com.xiaoenai.app.h.a.a;

class bd
  implements View.OnClickListener
{
  bd(SettingsActivity paramSettingsActivity) {}
  
  public void onClick(View paramView)
  {
    if (a.a().a(this.a, "mzd_enable_meiqia", false))
    {
      this.a.a(FeedbackActivity.class);
      return;
    }
    this.a.a(SettingFeedbackActivity.class);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */