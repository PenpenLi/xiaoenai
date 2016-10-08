package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.CleanableEditText;

class aj
  implements View.OnClickListener
{
  aj(SettingNameOrMailActivity paramSettingNameOrMailActivity) {}
  
  public void onClick(View paramView)
  {
    SettingNameOrMailActivity.e(this.a);
    this.a.mEtvEmailOrNickname.clearFocus();
    ab.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */