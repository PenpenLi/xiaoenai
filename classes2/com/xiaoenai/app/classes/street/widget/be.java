package com.xiaoenai.app.classes.street.widget;

import android.view.View;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.c;

class be
  implements c
{
  be(StreetSceneView paramStreetSceneView) {}
  
  public void a(PtrFrameLayout paramPtrFrameLayout)
  {
    this.a.mProductRecyclerView.postDelayed(new bf(this), 2000L);
  }
  
  public boolean a(PtrFrameLayout paramPtrFrameLayout, View paramView1, View paramView2)
  {
    return (!paramPtrFrameLayout.c()) && (!this.a.mProductRecyclerView.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */