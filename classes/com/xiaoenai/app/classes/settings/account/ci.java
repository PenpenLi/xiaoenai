package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.model.User;

class ci
  implements View.OnClickListener
{
  ci(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    SettingPersonalActivity.a(this.a, 1, User.getInstance().getEmail());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */