package com.xiaoenai.app.classes.settings.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class m
  implements DialogInterface.OnDismissListener
{
  m(l paraml) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ResetPasswordActivity.e(this.a.a).equals("findPW"))
    {
      ResetPasswordActivity.f(this.a.a);
      return;
    }
    ResetPasswordActivity.g(this.a.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */