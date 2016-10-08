package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;

final class h
  implements View.OnClickListener
{
  h(e parame) {}
  
  public final void onClick(View paramView)
  {
    e.b(this.a).d();
    ((InputMethodManager)e.k(this.a).getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    e.a(this.a, e.c(this.a).d(), e.c(this.a).c());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pro\views\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */