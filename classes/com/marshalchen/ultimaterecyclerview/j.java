package com.marshalchen.ultimaterecyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import in.srain.cube.views.ptr.PtrFrameLayout;

class j
  implements b
{
  j(RefreshCustomUltimateRecyclerview paramRefreshCustomUltimateRecyclerview) {}
  
  public void a()
  {
    if (RefreshCustomUltimateRecyclerview.a(this.a) != null) {
      RefreshCustomUltimateRecyclerview.a(this.a).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = ((LinearLayoutManager)this.a.getLayoutManager()).findFirstVisibleItemPosition();
    this.a.a.setEnabled(false);
    if ((i == 0) && (this.a.getLayoutManager().findViewByPosition(i).getTop() > -2)) {
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */