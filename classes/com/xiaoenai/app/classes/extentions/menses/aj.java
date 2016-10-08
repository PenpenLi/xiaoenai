package com.xiaoenai.app.classes.extentions.menses;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class aj
  implements View.OnClickListener
{
  aj(MensesSettingActivity paramMensesSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("from", MensesSettingActivity.class.getName());
    localIntent.setClass(paramView.getContext(), MensesEditSexActivity.class);
    this.a.startActivity(localIntent);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */