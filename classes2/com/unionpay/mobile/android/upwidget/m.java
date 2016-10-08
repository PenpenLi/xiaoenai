package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;

final class m
  implements View.OnClickListener
{
  m(h paramh) {}
  
  public final void onClick(View paramView)
  {
    if (h.b(this.a) != h.c(this.a))
    {
      localObject = h.d(this.a).get(h.b(this.a));
      if ((localObject instanceof c)) {
        ((c)localObject).a(-1);
      }
    }
    h.a(this.a, h.a(this.a));
    h.b(this.a, h.c(this.a));
    Object localObject = h.k(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View.OnClickListener)((Iterator)localObject).next()).onClick(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */