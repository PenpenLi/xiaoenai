package com.tonicartos.superslim;

import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

class a
  implements Runnable
{
  a(LayoutManager paramLayoutManager, RecyclerView paramRecyclerView, int paramInt) {}
  
  public void run()
  {
    b localb = new b(this, this.a.getContext());
    localb.setTargetPosition(this.b);
    this.c.startSmoothScroll(localb);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tonicartos\superslim\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */