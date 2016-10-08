package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;

final class d
  implements View.OnClickListener
{
  d(c paramc) {}
  
  public final void onClick(View paramView)
  {
    Iterator localIterator = c.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((View.OnClickListener)localIterator.next()).onClick(paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */