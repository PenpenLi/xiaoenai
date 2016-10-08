package com.xiaoenai.app.classes.extentions.anniversary;

import android.text.Editable;
import android.text.TextWatcher;

class z
  implements TextWatcher
{
  z(AnniversaryAddActivity paramAnniversaryAddActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramCharSequence.toString().equals(AnniversaryAddActivity.i(this.a).i())) {
      AnniversaryAddActivity.a(this.a, true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */