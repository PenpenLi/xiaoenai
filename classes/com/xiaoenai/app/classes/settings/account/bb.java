package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;

class bb
  implements View.OnClickListener
{
  bb(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    if ((SettingPersonalActivity.c(this.a)) || (SettingPersonalActivity.m(this.a) == null))
    {
      this.a.g();
      return;
    }
    SettingPersonalActivity.e(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */