package com.inmobi.ads;

import android.database.DataSetObserver;

class InMobiStrandAdapter$6
  extends DataSetObserver
{
  InMobiStrandAdapter$6(InMobiStrandAdapter paramInMobiStrandAdapter) {}
  
  public void onChanged()
  {
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandAdapter$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */