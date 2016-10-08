package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.CleanableEditText;

class o
  implements View.OnClickListener
{
  o(ResetPasswordByPhoneNumActivity paramResetPasswordByPhoneNumActivity) {}
  
  public void onClick(View paramView)
  {
    ab.b(this.a);
    paramView = ResetPasswordByPhoneNumActivity.c(this.a).getText().toString().replace(" ", "");
    ResetPasswordByPhoneNumActivity.a(this.a, paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */