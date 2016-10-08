package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.model.User;

class bt
  implements View.OnClickListener
{
  bt(SettingPersonalActivity paramSettingPersonalActivity, e parame) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = User.getInstance().getEmail();
    if ((paramView == null) || (paramView.equals("")))
    {
      SettingPersonalActivity.a(this.b, this.b.getString(2131101221), 1);
      return;
    }
    Intent localIntent = new Intent("resetPwdAction");
    localIntent.putExtra("email", paramView);
    localIntent.setClass(this.b, ResetByEmailActivity.class);
    this.b.startActivity(localIntent);
    this.b.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */