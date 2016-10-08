package com.xiaoenai.app.classes.street.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.street.model.BuyInfo;

class c
  implements TextWatcher
{
  private CharSequence b;
  
  c(StreetBuyProductView.a parama) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.b.length() > 0)
    {
      StreetBuyProductView.a.a(this.a).setVisibility(0);
      if (StreetBuyProductView.a.b(this.a) != null) {
        StreetBuyProductView.a.b(this.a).setMemo(StreetBuyProductView.a.c(this.a).getText().toString());
      }
      return;
    }
    StreetBuyProductView.a.a(this.a).setVisibility(8);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramCharSequence;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */