package com.unionpay.mobile.android.views.order;

import android.view.View;
import android.view.View.OnClickListener;

final class f
  implements View.OnClickListener
{
  f(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.e != null)
    {
      paramView = this.a.e;
      Object localObject = this.a;
      localObject = b.a(b.c(this.a), "title");
      b localb = this.a;
      paramView.a((String)localObject, b.a(b.c(this.a), "href"));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\views\order\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */