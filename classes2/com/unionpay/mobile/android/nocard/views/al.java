package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;

final class al
  implements View.OnClickListener
{
  al(ak paramak) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.o()) {
      return;
    }
    ak.a(this.a).d();
    paramView = ak.a(this.a).b();
    if (!paramView.a())
    {
      this.a.a(paramView.b);
      return;
    }
    if ((ak.b(this.a) != null) && (!ak.b(this.a).e()))
    {
      this.a.a(ak.b(this.a).b());
      return;
    }
    paramView = paramView.b;
    this.a.b.a(c.by.U);
    this.a.e.i(paramView);
    ak.c(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */