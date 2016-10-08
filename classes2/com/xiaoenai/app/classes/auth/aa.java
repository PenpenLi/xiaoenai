package com.xiaoenai.app.classes.auth;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.xiaoenai.app.widget.TitleBarView;

class aa
  implements TextWatcher
{
  aa(SimpleLoginView paramSimpleLoginView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((SimpleLoginView.a(this.a).getText().toString().trim().length() > 0) && (SimpleLoginView.b(this.a).getText().toString().trim().length() > 0))
    {
      SimpleLoginView.e(this.a).setRightButtonEnable(true);
      SimpleLoginView.f(this.a).setEnabled(true);
      return;
    }
    SimpleLoginView.e(this.a).setRightButtonEnable(false);
    SimpleLoginView.f(this.a).setEnabled(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */