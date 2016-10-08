package com.xiaoenai.app.classes.chat;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class c
  implements TextWatcher
{
  c(AddStatusActivity paramAddStatusActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 24 - AddStatusActivity.a(this.a, paramCharSequence.toString());
    if (paramInt1 >= 0)
    {
      AddStatusActivity.a(this.a, false);
      AddStatusActivity.c(this.a).setTextColor(Color.rgb(213, 213, 213));
    }
    for (;;)
    {
      AddStatusActivity.c(this.a).setText(String.valueOf(paramInt1));
      return;
      AddStatusActivity.a(this.a, true);
      AddStatusActivity.c(this.a).setTextColor(-65536);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */