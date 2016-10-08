package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.unionpay.mobile.android.utils.h;

final class aw
  implements View.OnClickListener
{
  aw(UPWidget paramUPWidget) {}
  
  public final void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = UPWidget.b(this.a);
    if (i == 10)
    {
      h.c("kb", " [ FIN ]");
      UPWidget.c(this.a);
      return;
    }
    if (i == 20)
    {
      h.c("kb", " [ DEL ]");
      if (j > 0)
      {
        UPWidget.a(this.a, UPWidget.d(this.a));
        UPWidget.e(this.a);
        paramView = this.a.b.b().toString().substring(0, j - 1);
        this.a.b.c(paramView);
        this.a.b.b(paramView.length());
      }
      UPWidget.b(this.a);
      return;
    }
    if (UPWidget.b(this.a) == 6)
    {
      h.c("kb", " [ FIN ]");
      return;
    }
    UPWidget.a(this.a, UPWidget.d(this.a), Integer.toString(i));
    if (j == 0) {}
    for (paramView = "*";; paramView = this.a.b.b() + "*")
    {
      this.a.b.c(paramView);
      this.a.b.b(paramView.length());
      UPWidget.f(this.a);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */