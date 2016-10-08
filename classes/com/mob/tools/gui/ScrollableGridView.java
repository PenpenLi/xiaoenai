package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.GridView;

public class ScrollableGridView
  extends GridView
  implements h
{
  private h.a a;
  private boolean b;
  
  public ScrollableGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ScrollableGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setCacheColorHint(0);
    setSelector(new ColorDrawable());
    this.a = new i(this);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\ScrollableGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */