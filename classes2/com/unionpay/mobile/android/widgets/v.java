package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

final class v
  implements TextWatcher
{
  v(t paramt) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (t.a(this.a) == null) {
      return;
    }
    if ((t.b(this.a)) && (t.c(this.a).isFocused()))
    {
      t.a(this.a).setVisibility(0);
      return;
    }
    t.a(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */