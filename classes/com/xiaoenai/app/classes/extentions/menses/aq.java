package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.widget.wheel.WheelView;

class aq
  implements View.OnClickListener
{
  aq(MensesSettingActivity paramMensesSettingActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    MensesSettingActivity.c(this.a, false);
    MensesSettingActivity.b(this.a, false);
    paramView = this.a;
    if (MensesSettingActivity.d(this.a).getVisibility() == 8) {
      bool = true;
    }
    MensesSettingActivity.a(paramView, bool);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */