package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;

class bg
  implements View.OnClickListener
{
  bg(SettingPersonalActivity paramSettingPersonalActivity, e parame) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = new Intent();
    paramView.setClass(this.b, ResetPasswordByPhoneNumActivity.class);
    paramView.putExtra("from", "findPW");
    this.b.startActivity(paramView);
    this.b.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */