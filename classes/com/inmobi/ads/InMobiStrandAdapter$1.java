package com.inmobi.ads;

import android.database.DataSetObserver;
import android.widget.Adapter;

class InMobiStrandAdapter$1
  extends DataSetObserver
{
  InMobiStrandAdapter$1(InMobiStrandAdapter paramInMobiStrandAdapter) {}
  
  public void onChanged()
  {
    InMobiStrandAdapter.access$100(this.a).c(InMobiStrandAdapter.access$000(this.a).getCount());
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */