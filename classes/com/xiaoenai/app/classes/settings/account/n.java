package com.xiaoenai.app.classes.settings.account;

import android.text.Editable;
import android.text.TextWatcher;

class n
  implements TextWatcher
{
  n(ResetPasswordByPhoneNumActivity paramResetPasswordByPhoneNumActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0)
    {
      ResetPasswordByPhoneNumActivity.a(this.a);
      return;
    }
    ResetPasswordByPhoneNumActivity.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */