package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.classes.extentions.anniversary.DatePickerView;

class ap
  implements View.OnClickListener
{
  ap(MensesSettingActivity paramMensesSettingActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    this.a.mStopView.setVisibility(0);
    paramView = this.a.mStopView;
    if (MensesSettingActivity.b(this.a)) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      this.a.mScrollStopView.setVisibility(8);
      MensesSettingActivity.a(this.a, false);
      MensesSettingActivity.b(this.a, false);
      paramView = this.a;
      if (MensesSettingActivity.c(this.a).getVisibility() == 8) {
        bool = true;
      }
      MensesSettingActivity.c(paramView, bool);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */