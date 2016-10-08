package com.xiaoenai.app.classes.chat.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

class g
  implements TextWatcher
{
  g(InputFragment paramInputFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (InputFragment.a(this.a).getText().toString().trim().length() > 0)
    {
      InputFragment.b(this.a).setVisibility(4);
      InputFragment.i(this.a).setVisibility(0);
      if (InputFragment.j(this.a) != null) {
        InputFragment.j(this.a).a(false);
      }
    }
    do
    {
      return;
      InputFragment.b(this.a).setVisibility(0);
      InputFragment.i(this.a).setVisibility(8);
    } while (InputFragment.j(this.a) == null);
    InputFragment.j(this.a).a(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */