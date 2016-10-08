package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import in.srain.cube.views.ptr.PtrFrameLayout;

class h
  implements b
{
  h(RefreshCustomUltimateRecyclerview paramRefreshCustomUltimateRecyclerview, StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt) {}
  
  public void a()
  {
    if (RefreshCustomUltimateRecyclerview.a(this.c) != null) {
      RefreshCustomUltimateRecyclerview.a(this.c).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    int[] arrayOfInt = this.a.findFirstVisibleItemPositions(new int[this.b]);
    this.c.a.setEnabled(false);
    if ((arrayOfInt != null) && (arrayOfInt[0] == 0))
    {
      int j = this.a.findViewByPosition(0).getTop();
      if (i < arrayOfInt.length)
      {
        int k = this.a.findViewByPosition(i).getTop();
        if (j < k) {}
        for (;;)
        {
          i += 1;
          break;
          j = k;
        }
      }
      if (j > 5) {
        this.c.a.setEnabled(true);
      }
    }
    if (RefreshCustomUltimateRecyclerview.a(this.c) != null) {
      RefreshCustomUltimateRecyclerview.a(this.c).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(a parama)
  {
    if (RefreshCustomUltimateRecyclerview.a(this.c) != null) {
      RefreshCustomUltimateRecyclerview.a(this.c).a(parama);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */