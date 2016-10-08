package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.image.ImagePicker;
import com.xiaoenai.app.utils.as;

class cc
  implements View.OnClickListener
{
  cc(SettingPersonalActivity paramSettingPersonalActivity) {}
  
  public void onClick(View paramView)
  {
    if (!as.c())
    {
      as.a(this.a);
      return;
    }
    paramView = new ImagePicker(this.a);
    paramView.a(new cd(this));
    paramView.a(640, 640);
    paramView.a(this.a.getString(2131101193), new ce(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */