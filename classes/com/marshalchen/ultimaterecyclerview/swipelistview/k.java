package com.marshalchen.ultimaterecyclerview.swipelistview;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class k
  extends RecyclerView.OnScrollListener
{
  private boolean b = false;
  private boolean c = false;
  
  k(c paramc) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = this.a;
    if (paramInt != 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecyclerView.d(bool);
      if ((c.h(this.a)) && (paramInt == 1)) {
        this.a.h();
      }
      if (paramInt == 1)
      {
        c.a(this.a, true);
        this.a.d(false);
      }
      if ((paramInt != 2) && (paramInt != 1))
      {
        c.a(this.a, false);
        c.b(this.a, -1);
        c.b(this.a).d();
        new Handler().postDelayed(new l(this), 500L);
      }
      return;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\swipelistview\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */