package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;

class n
  extends RecyclerView.OnScrollListener
{
  private int[] b;
  
  n(UltimateRecyclerView paramUltimateRecyclerView) {}
  
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
    Object localObject = paramRecyclerView.getLayoutManager();
    if (this.a.h == null)
    {
      if ((localObject instanceof GridLayoutManager)) {
        this.a.h = UltimateRecyclerView.b.b;
      }
    }
    else {
      switch (UltimateRecyclerView.1.a[this.a.h.ordinal()])
      {
      }
    }
    for (;;)
    {
      if ((UltimateRecyclerView.c(this.a)) && (UltimateRecyclerView.d(this.a) > UltimateRecyclerView.e(this.a)))
      {
        UltimateRecyclerView.a(this.a, false);
        UltimateRecyclerView.f(this.a, UltimateRecyclerView.d(this.a));
      }
      if ((!UltimateRecyclerView.c(this.a)) && (UltimateRecyclerView.d(this.a) - UltimateRecyclerView.f(this.a) <= UltimateRecyclerView.g(this.a)))
      {
        UltimateRecyclerView.i(this.a).a(this.a.e.getAdapter().getItemCount(), UltimateRecyclerView.h(this.a));
        UltimateRecyclerView.a(this.a, true);
        UltimateRecyclerView.f(this.a, UltimateRecyclerView.d(this.a));
      }
      this.a.a(paramRecyclerView);
      return;
      if ((localObject instanceof LinearLayoutManager))
      {
        this.a.h = UltimateRecyclerView.b.a;
        break;
      }
      if ((localObject instanceof StaggeredGridLayoutManager))
      {
        this.a.h = UltimateRecyclerView.b.c;
        break;
      }
      throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
      UltimateRecyclerView.b(this.a, ((RecyclerView.LayoutManager)localObject).getChildCount());
      UltimateRecyclerView.c(this.a, ((RecyclerView.LayoutManager)localObject).getItemCount());
      UltimateRecyclerView.d(this.a, ((LinearLayoutManager)localObject).findLastVisibleItemPosition());
      UltimateRecyclerView.e(this.a, ((LinearLayoutManager)localObject).findFirstVisibleItemPosition());
      continue;
      localObject = (StaggeredGridLayoutManager)localObject;
      if (this.b == null) {
        this.b = new int[((StaggeredGridLayoutManager)localObject).getSpanCount()];
      }
      ((StaggeredGridLayoutManager)localObject).findLastVisibleItemPositions(this.b);
      UltimateRecyclerView.d(this.a, UltimateRecyclerView.a(this.a, this.b));
      ((StaggeredGridLayoutManager)localObject).findFirstVisibleItemPositions(this.b);
      UltimateRecyclerView.e(this.a, UltimateRecyclerView.b(this.a, this.b));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */