package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.view.View.OnClickListener;

class d
  implements View.OnClickListener
{
  d(MensesActivity paramMensesActivity) {}
  
  public void onClick(View paramView)
  {
    if (ac.l() == 0)
    {
      MensesActivity.a(this.a, MensesSettingActivity.class);
      return;
    }
    MensesActivity.a(this.a, MensesEditSexActivity.class);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */