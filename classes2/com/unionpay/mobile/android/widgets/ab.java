package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;

final class ab
  implements TextWatcher
{
  ab(z paramz) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.a.a(paramEditable);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (z.a(this.a) != null) {
      z.a(this.a).a(this.a.b, paramCharSequence.toString());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */