package com.ecloud.pulltozoomview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.widget.FrameLayout;

class d
  extends RecyclerView.OnScrollListener
{
  d(PullToZoomRecyclerViewEx paramPullToZoomRecyclerViewEx) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if ((this.a.c != null) && (!this.a.d()) && (this.a.a()))
    {
      float f = PullToZoomRecyclerViewEx.a(this.a) - PullToZoomRecyclerViewEx.b(this.a).getBottom();
      Log.d(PullToZoomRecyclerViewEx.g(), "onScroll --> f = " + f);
      if (this.a.c())
      {
        if ((f <= 0.0F) || (f >= PullToZoomRecyclerViewEx.a(this.a))) {
          break label139;
        }
        paramInt1 = (int)(f * 0.65D);
        PullToZoomRecyclerViewEx.b(this.a).scrollTo(0, -paramInt1);
      }
    }
    label139:
    while (PullToZoomRecyclerViewEx.b(this.a).getScrollY() == 0) {
      return;
    }
    PullToZoomRecyclerViewEx.b(this.a).scrollTo(0, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */