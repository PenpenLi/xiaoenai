package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;

class bm
  implements View.OnClickListener
{
  bm(SettingPersonalActivity paramSettingPersonalActivity, e parame) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (SettingPersonalActivity.m(this.b) != null)
    {
      if (SettingPersonalActivity.k(this.b))
      {
        SettingPersonalActivity.r(this.b);
        return;
      }
      SettingPersonalActivity.l(this.b);
      return;
    }
    SettingPersonalActivity.s(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */