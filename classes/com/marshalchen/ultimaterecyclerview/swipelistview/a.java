package com.marshalchen.ultimaterecyclerview.swipelistview;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;

class a
  extends RecyclerView.AdapterDataObserver
{
  a(SwipeListView paramSwipeListView) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.c();
    SwipeListView.a(this.a).d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\swipelistview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */