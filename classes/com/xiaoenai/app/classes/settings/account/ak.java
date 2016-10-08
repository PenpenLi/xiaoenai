package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.widget.TitleBarView;

class ak
  implements View.OnClickListener
{
  ak(SettingNameOrMailActivity paramSettingNameOrMailActivity) {}
  
  public void onClick(View paramView)
  {
    SettingNameOrMailActivity.a(this.a, true);
    SettingNameOrMailActivity.f(this.a);
    SettingNameOrMailActivity.g(this.a).setRightButtonVisible(8);
    SettingNameOrMailActivity.h(this.a).setTitle(2131101103);
    SettingNameOrMailActivity.i(this.a).a(0, 2131099973);
    SettingNameOrMailActivity.k(this.a).setLeftButtonClickListener(new al(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */