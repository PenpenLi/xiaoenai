package com.inmobi.ads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class InMobiStrandAdapter$9
  implements AdapterView.OnItemSelectedListener
{
  InMobiStrandAdapter$9(InMobiStrandAdapter paramInMobiStrandAdapter, AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!InMobiStrandAdapter.access$500(this.b)) {
      this.a.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
    while (this.b.isStrand(paramInt)) {
      return;
    }
    this.a.onItemSelected(paramAdapterView, paramView, InMobiStrandAdapter.access$100(this.b).e(paramInt), paramLong);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    this.a.onNothingSelected(paramAdapterView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandAdapter$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */