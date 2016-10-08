package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.marshalchen.ultimaterecyclerview.ui.VerticalSwipeRefreshLayout;

class p
  extends RecyclerView.AdapterDataObserver
{
  p(UltimateRecyclerView paramUltimateRecyclerView) {}
  
  private void a()
  {
    UltimateRecyclerView.a(this.a, false);
    if (this.a.w != null) {
      this.a.w.setRefreshing(false);
    }
  }
  
  public void onChanged()
  {
    super.onChanged();
    a();
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    super.onItemRangeChanged(paramInt1, paramInt2);
    a();
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    super.onItemRangeInserted(paramInt1, paramInt2);
    a();
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    super.onItemRangeRemoved(paramInt1, paramInt2);
    a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */