package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

final class ax
  implements View.OnClickListener
{
  ax(as paramas) {}
  
  public final void onClick(View paramView)
  {
    as.b(this.a).d();
    ((InputMethodManager)this.a.d.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    this.a.a(as.c(this.a).d(), as.c(this.a).c());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */