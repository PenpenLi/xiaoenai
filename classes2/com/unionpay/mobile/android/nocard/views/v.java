package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;

final class v
  implements View.OnClickListener
{
  v(o paramo) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.o()) {
      return;
    }
    o.b(this.a).d();
    Object localObject = o.b(this.a).b();
    if (!((a.a)localObject).a())
    {
      this.a.a(((a.a)localObject).b);
      return;
    }
    if ((o.c(this.a) != null) && (!o.c(this.a).e()))
    {
      this.a.a(o.c(this.a).b());
      return;
    }
    paramView = "";
    if (o.d(this.a) != null)
    {
      paramView = o.d(this.a).b();
      if (!paramView.a())
      {
        this.a.a(paramView.b);
        return;
      }
      paramView = paramView.b;
    }
    localObject = ((a.a)localObject).b;
    o localo = this.a;
    if (o.b(paramView)) {}
    for (paramView = (String)localObject + "," + paramView;; paramView = (View)localObject)
    {
      this.a.b.a(c.by.U);
      o.b(this.a, paramView);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */