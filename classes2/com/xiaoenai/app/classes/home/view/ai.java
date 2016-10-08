package com.xiaoenai.app.classes.home.view;

import android.text.Editable;
import android.text.TextWatcher;

class ai
  implements TextWatcher
{
  ai(LoverSearchView paramLoverSearchView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    LoverSearchView.a(this.a, paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */