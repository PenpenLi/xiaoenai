package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;

class co
  implements View.OnClickListener
{
  co(SettingPhoneInputActivity paramSettingPhoneInputActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!SettingPhoneInputActivity.d(this.a)) && (SettingPhoneInputActivity.e(this.a) != null))
    {
      SettingPhoneInputActivity.f(this.a);
      return;
    }
    this.a.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */