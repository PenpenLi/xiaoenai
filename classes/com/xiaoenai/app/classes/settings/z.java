package com.xiaoenai.app.classes.settings;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.common.internal.di.a.b;
import com.xiaoenai.app.domain.e.c;
import rx.a;

class z
  implements View.OnClickListener
{
  z(SettingFeedbackActivity paramSettingFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.h())
    {
      paramView = SettingFeedbackActivity.b(this.a).getText().toString();
      if ((!paramView.equals("debug")) && (!paramView.equals("debugdebug"))) {
        break label141;
      }
      if (!paramView.equals("debugdebug")) {
        break label152;
      }
    }
    label141:
    label152:
    for (int i = 2;; i = 1)
    {
      paramView = new aa(this);
      this.a.a(null);
      if (i == 1) {
        SettingFeedbackActivity.c(this.a).u().a(1000).b(paramView);
      }
      for (;;)
      {
        SettingFeedbackActivity.b(this.a).setText("");
        return;
        SettingFeedbackActivity.d(this.a).u().a(2000).b(paramView);
        continue;
        this.a.b(paramView);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */