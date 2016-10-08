package com.xiaoenai.app.classes.home.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.settings.account.SettingPersonalActivity;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.widget.remindButton.RemindButton;

class aa
  implements View.OnClickListener
{
  aa(z paramz) {}
  
  public void onClick(View paramView)
  {
    this.a.a(SettingPersonalActivity.class);
    UserConfig.setBoolean("v_wechat_entered_personal", Boolean.valueOf(true));
    z.a(this.a).b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */