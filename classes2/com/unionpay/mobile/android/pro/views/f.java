package com.unionpay.mobile.android.pro.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;
import java.util.List;

final class f
  implements View.OnClickListener
{
  f(e parame) {}
  
  public final void onClick(View paramView)
  {
    if (e.a(this.a)) {
      return;
    }
    e.b(this.a).d();
    paramView = e.b(this.a).a();
    if (!paramView.a())
    {
      e.a(this.a, paramView.b);
      return;
    }
    if ((e.c(this.a) != null) && (!e.c(this.a).e()))
    {
      e.b(this.a, e.c(this.a).b());
      return;
    }
    if ((e.d(this.a) != null) && (!e.d(this.a).e()))
    {
      e.c(this.a, e.d(this.a).b());
      return;
    }
    e.e(this.a).a(com.unionpay.mobile.android.languages.c.by.U);
    e.a(this.a, (com.unionpay.mobile.android.model.c)e.g(this.a).l.get(e.f(this.a).I), e.b(this.a).a().b, e.b(this.a).c());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\pro\views\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */