package com.xiaoenai.app.classes.settings.account;

import android.text.Editable;
import android.text.TextWatcher;

class cz
  implements TextWatcher
{
  cz(cw paramcw, SettingPhoneInputActivity paramSettingPhoneInputActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.a.onCodeTextChange(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */