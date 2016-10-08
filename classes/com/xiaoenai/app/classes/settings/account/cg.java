package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.g;

class cg
  implements View.OnClickListener
{
  cg(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    if (!SettingPersonalActivity.a(this.a))
    {
      this.a.a(SettingUserNameActivity.class);
      return;
    }
    paramView = new g(this.a);
    paramView.a(2131101242);
    paramView.a(2131100898, new ch(this));
    paramView.show();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */