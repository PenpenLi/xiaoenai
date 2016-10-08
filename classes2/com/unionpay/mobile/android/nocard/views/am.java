package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

final class am
  implements View.OnClickListener
{
  am(ak paramak) {}
  
  public final void onClick(View paramView)
  {
    ak.a(this.a).d();
    ((InputMethodManager)this.a.d.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    this.a.a(ak.b(this.a).d(), ak.b(this.a).c());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */