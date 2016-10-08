package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;

final class c
  implements AdapterView.OnItemClickListener
{
  c(a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.a(this.a, paramInt);
    if (a.a(this.a) != null) {
      a.a(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */