package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.xiaoenai.app.model.UserConfig;

class cj
  implements View.OnClickListener
{
  cj(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    SettingPersonalActivity.b(this.a).setVisibility(8);
    UserConfig.setBoolean("v_wechat_binded", Boolean.valueOf(true));
    if ((SettingPersonalActivity.c(this.a)) || (SettingPersonalActivity.d(this.a) == null))
    {
      this.a.d();
      return;
    }
    SettingPersonalActivity.e(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */