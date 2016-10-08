package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import in.srain.cube.views.ptr.PtrFrameLayout;

class i
  implements b
{
  i(RefreshCustomUltimateRecyclerview paramRefreshCustomUltimateRecyclerview) {}
  
  public void a()
  {
    if (RefreshCustomUltimateRecyclerview.a(this.a) != null) {
      RefreshCustomUltimateRecyclerview.a(this.a).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = ((GridLayoutManager)this.a.getLayoutManager()).findFirstVisibleItemPosition();
    this.a.a.setEnabled(false);
    if ((i == 0) && (this.a.getLayoutManager().findViewByPosition(i).getTop() > 5)) {
      this.a.a.setEnabled(true);
    }
    if (RefreshCustomUltimateRecyclerview.a(this.a) != null) {
      RefreshCustomUltimateRecyclerview.a(this.a).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(a parama)
  {
    if (RefreshCustomUltimateRecyclerview.a(this.a) != null) {
      RefreshCustomUltimateRecyclerview.a(this.a).a(parama);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */