package com.inmobi.ads;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

class InMobiStrandAdapter$10
  implements AbsListView.OnScrollListener
{
  InMobiStrandAdapter$10(InMobiStrandAdapter paramInMobiStrandAdapter, ListView paramListView, int paramInt) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.setOnScrollListener(null);
      new Handler().post(new InMobiStrandAdapter.10.1(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiStrandAdapter$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */