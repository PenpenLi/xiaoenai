package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.model.User;

class cf
  implements View.OnClickListener
{
  cf(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    SettingPersonalActivity.a(this.a, 0, User.getInstance().getNickName());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */