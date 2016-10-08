package com.inmobi.ads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class InMobiStrandAdapter$7
  implements AdapterView.OnItemClickListener
{
  InMobiStrandAdapter$7(InMobiStrandAdapter paramInMobiStrandAdapter, AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!InMobiStrandAdapter.access$500(this.b)) {
      this.a.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    while (InMobiStrandAdapter.access$100(this.b).b(paramInt)) {
      return;
    }
    this.a.onItemClick(paramAdapterView, paramView, InMobiStrandAdapter.access$100(this.b).e(paramInt), paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandAdapter$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */