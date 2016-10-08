package com.xiaoenai.app.classes.settings.account;

import android.os.Handler;
import android.widget.Button;

class cl
  implements Runnable
{
  cl(SettingPhoneInputActivity paramSettingPhoneInputActivity) {}
  
  public void run()
  {
    if (this.a.mBtnRegetCode != null)
    {
      SettingPhoneInputActivity.a(this.a);
      this.a.mBtnRegetCode.setText(String.valueOf(SettingPhoneInputActivity.b(this.a)) + this.a.getString(2131101070));
      if (SettingPhoneInputActivity.b(this.a) <= 0)
      {
        SettingPhoneInputActivity.a(this.a, true);
        this.a.mBtnRegetCode.setText(this.a.getString(2131101214));
        SettingPhoneInputActivity.a(this.a, 60);
      }
    }
    else
    {
      return;
    }
    SettingPhoneInputActivity.c(this.a).postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */