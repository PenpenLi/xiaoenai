package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;

final class h
  implements View.OnClickListener
{
  h(g paramg) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.o()) {
      return;
    }
    g.a(this.a).d();
    paramView = g.a(this.a).b();
    if (!paramView.a())
    {
      this.a.a(paramView.b);
      return;
    }
    if ((g.b(this.a) != null) && (!g.b(this.a).e()))
    {
      this.a.a(g.b(this.a).b());
      return;
    }
    this.a.b.a(c.by.U);
    if (!g.c(this.a))
    {
      String str = com.unionpay.mobile.android.utils.g.a(this.a.a.x, "action");
      this.a.e.b(str, paramView.b);
      g.a(this.a, 102);
      return;
    }
    g.d(this.a);
    g.a(this.a, 104);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */