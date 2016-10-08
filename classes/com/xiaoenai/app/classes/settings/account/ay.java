package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ay
  implements View.OnClickListener
{
  ay(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    if (SettingPersonalActivity.c(this.a))
    {
      SettingPersonalActivity.i(this.a);
      return;
    }
    paramView = new Intent(this.a, ResetPasswordActivity.class);
    paramView.putExtra("from", "setting");
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */