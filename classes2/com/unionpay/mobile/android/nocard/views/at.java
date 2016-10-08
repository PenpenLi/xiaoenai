package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.upviews.a.a;
import com.unionpay.mobile.android.widgets.m;

final class at
  implements View.OnClickListener
{
  at(as paramas) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.o()) {
      return;
    }
    paramView = "";
    if (as.a(this.a) != null)
    {
      as.a(this.a).d();
      paramView = as.a(this.a).b();
      if (!paramView.a())
      {
        this.a.a(paramView.b);
        return;
      }
      paramView = paramView.b;
    }
    as.b(this.a).d();
    Object localObject = as.b(this.a).b();
    if (!((a.a)localObject).a())
    {
      this.a.a(((a.a)localObject).b);
      return;
    }
    if ((as.c(this.a) != null) && (!as.c(this.a).e()))
    {
      this.a.a(as.c(this.a).b());
      return;
    }
    if ((as.d(this.a) != null) && (!as.d(this.a).e()))
    {
      this.a.a(as.d(this.a).b());
      return;
    }
    localObject = ((a.a)localObject).b;
    as localas = this.a;
    if (as.b(paramView)) {}
    for (paramView = (String)localObject + "," + paramView;; paramView = (View)localObject)
    {
      this.a.b.a(c.by.U);
      if ((this.a.a.z != null) && (this.a.a.z.length() > 0))
      {
        as.a(this.a, as.e(this.a), paramView);
        return;
      }
      as.a(this.a, paramView);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */