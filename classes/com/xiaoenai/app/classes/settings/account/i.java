package com.xiaoenai.app.classes.settings.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;

class i
  implements TextWatcher
{
  i(ResetPasswordActivity paramResetPasswordActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ResetPasswordActivity.b(this.a).getFormatText().length() > 0) && (ResetPasswordActivity.c(this.a).getFormatText().length() > 0))
    {
      w.b(ResetPasswordActivity.d(this.a));
      return;
    }
    w.a(ResetPasswordActivity.d(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */