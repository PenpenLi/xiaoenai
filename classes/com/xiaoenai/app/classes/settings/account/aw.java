package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;

class aw
  implements View.OnClickListener
{
  aw(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    if ((SettingPersonalActivity.c(this.a)) || (SettingPersonalActivity.g(this.a)))
    {
      this.a.g();
      return;
    }
    SettingPersonalActivity.e(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */