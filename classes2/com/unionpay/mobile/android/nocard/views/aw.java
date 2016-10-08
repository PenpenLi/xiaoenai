package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.c;
import com.unionpay.mobile.android.views.order.l;

final class aw
  implements View.OnClickListener
{
  aw(as paramas) {}
  
  public final void onClick(View paramView)
  {
    if (c.a(this.a.d, this.a.a) == l.c.intValue())
    {
      this.a.n();
      this.a.n();
      return;
    }
    this.a.n();
    if (this.a.a.E)
    {
      this.a.n();
      this.a.a.E = false;
    }
    this.a.a.aF = l.c.intValue();
    this.a.d(2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\views\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */