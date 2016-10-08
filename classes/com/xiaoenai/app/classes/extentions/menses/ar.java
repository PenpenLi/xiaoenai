package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.widget.wheel.WheelView;

class ar
  implements View.OnClickListener
{
  ar(MensesSettingActivity paramMensesSettingActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    paramView = this.a.mStopView;
    if (MensesSettingActivity.b(this.a)) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      this.a.mScrollStopView.setVisibility(8);
      MensesSettingActivity.c(this.a, false);
      MensesSettingActivity.a(this.a, false);
      paramView = this.a;
      if (MensesSettingActivity.e(this.a).getVisibility() == 8) {
        bool = true;
      }
      MensesSettingActivity.b(paramView, bool);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */