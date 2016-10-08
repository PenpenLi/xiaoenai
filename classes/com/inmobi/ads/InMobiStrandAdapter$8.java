package com.inmobi.ads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class InMobiStrandAdapter$8
  implements AdapterView.OnItemLongClickListener
{
  InMobiStrandAdapter$8(InMobiStrandAdapter paramInMobiStrandAdapter, AdapterView.OnItemLongClickListener paramOnItemLongClickListener) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!InMobiStrandAdapter.access$500(this.b)) {
      return this.a.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    return (this.b.isStrand(paramInt)) || (this.a.onItemLongClick(paramAdapterView, paramView, InMobiStrandAdapter.access$100(this.b).e(paramInt), paramLong));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandAdapter$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */