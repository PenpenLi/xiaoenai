package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class l
  extends RecyclerView.OnScrollListener
{
  l(UltimateRecyclerView paramUltimateRecyclerView) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (UltimateRecyclerView.a(this.a) != null)
    {
      UltimateRecyclerView.a(this.a, UltimateRecyclerView.b(this.a) + paramInt2);
      if (UltimateRecyclerView.g()) {
        UltimateRecyclerView.a(this.a, UltimateRecyclerView.b(this.a));
      }
    }
    this.a.a(paramRecyclerView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */