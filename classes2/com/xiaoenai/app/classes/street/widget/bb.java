package com.xiaoenai.app.classes.street.widget;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.xiaoenai.app.classes.street.a.o;

class bb
  extends GridLayoutManager.SpanSizeLookup
{
  bb(StreetSceneView paramStreetSceneView, RecyclerView.LayoutManager paramLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    int i = 1;
    if ((StreetSceneView.a(this.b).getItemViewType(paramInt) == 1) || (StreetSceneView.a(this.b).getItemViewType(paramInt) == 2)) {
      i = ((GridLayoutManager)this.a).getSpanCount();
    }
    while ((StreetSceneView.a(this.b).getItemViewType(paramInt) != 10) && (StreetSceneView.a(this.b).getItemViewType(paramInt) != 13)) {
      return i;
    }
    return ((GridLayoutManager)this.a).getSpanCount();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */