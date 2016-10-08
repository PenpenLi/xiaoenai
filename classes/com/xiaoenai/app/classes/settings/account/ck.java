package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;

class ck
  implements View.OnClickListener
{
  ck(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    if ((SettingPersonalActivity.c(this.a)) || (SettingPersonalActivity.f(this.a) == null))
    {
      this.a.f();
      return;
    }
    SettingPersonalActivity.e(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */