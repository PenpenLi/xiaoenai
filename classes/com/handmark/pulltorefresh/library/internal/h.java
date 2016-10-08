package com.handmark.pulltorefresh.library.internal;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;

class h
  implements AbsListView.OnScrollListener
{
  h(PinnedSectionListView paramPinnedSectionListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      this.a.a.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    paramAbsListView = this.a.getAdapter();
    if ((paramAbsListView == null) || (paramInt2 == 0)) {
      return;
    }
    if (PinnedSectionListView.a(paramAbsListView, paramAbsListView.getItemViewType(paramInt1)))
    {
      if (this.a.getChildAt(0).getTop() == this.a.getPaddingTop())
      {
        this.a.a();
        return;
      }
      this.a.a(paramInt1, paramInt1, paramInt2);
      return;
    }
    paramInt3 = this.a.b(paramInt1);
    if (paramInt3 > -1)
    {
      this.a.a(paramInt3, paramInt1, paramInt2);
      return;
    }
    this.a.a();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\internal\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */