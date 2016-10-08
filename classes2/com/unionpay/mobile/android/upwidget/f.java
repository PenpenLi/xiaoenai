package com.unionpay.mobile.android.upwidget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Iterator;

final class f
  implements AdapterView.OnItemClickListener
{
  f(e parame) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Iterator localIterator = e.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((AdapterView.OnItemClickListener)localIterator.next()).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */