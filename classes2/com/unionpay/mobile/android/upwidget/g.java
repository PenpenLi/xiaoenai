package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;

final class g
  implements View.OnClickListener
{
  g(e parame) {}
  
  public final void onClick(View paramView)
  {
    Iterator localIterator = e.b(this.a).iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */