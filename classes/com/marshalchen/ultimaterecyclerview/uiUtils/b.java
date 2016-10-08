package com.marshalchen.ultimaterecyclerview.uiUtils;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.marshalchen.ultimaterecyclerview.s;

class b
  extends GridLayoutManager.SpanSizeLookup
{
  b(BasicGridLayoutManager paramBasicGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if (BasicGridLayoutManager.a(this.a).getItemViewType(paramInt) == 2) {
      return this.a.getSpanCount();
    }
    if (BasicGridLayoutManager.a(this.a).getItemViewType(paramInt) == 1) {
      return this.a.getSpanCount();
    }
    return this.a.a(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\uiUtils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */