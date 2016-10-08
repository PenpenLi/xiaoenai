package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ListView;

public class ScrollableListView
  extends ListView
  implements h
{
  private h.a a;
  private boolean b;
  
  public ScrollableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ScrollableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setCacheColorHint(0);
    setSelector(new ColorDrawable());
    setDividerHeight(0);
    this.a = new j(this);
  }
  
  protected int computeVerticalScrollOffset()
  {
    int i = super.computeVerticalScrollOffset();
    if (this.a != null) {
      this.a.a(this, 0, i, 0, 0);
    }
    return i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\ScrollableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */