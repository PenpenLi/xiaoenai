package com.marshalchen.ultimaterecyclerview.uiUtils;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.marshalchen.ultimaterecyclerview.s;

class a
  extends GridLayoutManager.SpanSizeLookup
{
  a(BasicGridLayoutManager paramBasicGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt == 0) {
      i = this.a.getSpanCount();
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (BasicGridLayoutManager.a(this.a).getItemCount() <= 2);
      if (BasicGridLayoutManager.a(this.a).getItemViewType(paramInt) == 2) {
        return this.a.getSpanCount();
      }
      i = j;
    } while (BasicGridLayoutManager.a(this.a).getItemViewType(paramInt) != 1);
    return this.a.getSpanCount();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\uiUtils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */