package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class o
  extends RecyclerView.AdapterDataObserver
{
  o(UltimateRecyclerView paramUltimateRecyclerView) {}
  
  public void onChanged()
  {
    super.onChanged();
    UltimateRecyclerView.j(this.a);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    super.onItemRangeChanged(paramInt1, paramInt2);
    UltimateRecyclerView.j(this.a);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    super.onItemRangeInserted(paramInt1, paramInt2);
    UltimateRecyclerView.j(this.a);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    super.onItemRangeMoved(paramInt1, paramInt2, paramInt3);
    UltimateRecyclerView.j(this.a);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    super.onItemRangeRemoved(paramInt1, paramInt2);
    UltimateRecyclerView.j(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */