package com.xiaoenai.app.ui.xrecyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class f
  extends GridLayoutManager.SpanSizeLookup
{
  f(XRecyclerView.c paramc, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((this.b.a(paramInt)) || (this.b.b(paramInt)) || (this.b.c(paramInt))) {
      return this.a.getSpanCount();
    }
    return 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\xrecyclerview\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */