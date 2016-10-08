package com.xiaoenai.app.classes.settings.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;

class b
  implements TextWatcher
{
  b(ResetByEmailActivity paramResetByEmailActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ResetByEmailActivity.a(this.a).getFormatText().length() > 0) && (ResetByEmailActivity.a(this.a).getFormatText().length() > 0))
    {
      w.b(ResetByEmailActivity.b(this.a));
      return;
    }
    w.a(ResetByEmailActivity.b(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */