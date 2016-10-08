package com.unionpay.mobile.android.widgets;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;

final class i
  implements AdapterView.OnItemClickListener
{
  i(g paramg) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    g.a(this.a, paramInt);
    if (g.a(this.a) != null) {
      g.a(this.a).dismiss();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */