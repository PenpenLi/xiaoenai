package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.view.View.OnClickListener;

final class h
  implements View.OnClickListener
{
  h(CViewMethods paramCViewMethods, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    com.unionpay.mobile.android.utils.h.c("uppay", " touched " + this.a);
    if (CViewMethods.a(this.b) != null) {
      CViewMethods.a(this.b).b(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\views\order\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */