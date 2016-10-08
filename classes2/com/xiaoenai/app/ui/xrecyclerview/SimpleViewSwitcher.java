package com.xiaoenai.app.ui.xrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class SimpleViewSwitcher
  extends ViewGroup
{
  public SimpleViewSwitcher(Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleViewSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleViewSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8) {
        localView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
      }
      i += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int m = getChildCount();
    int j = 0;
    int k = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      measureChild(localView, paramInt1, paramInt2);
      localView.getMeasuredWidth();
      j = localView.getMeasuredWidth();
      k = localView.getMeasuredHeight();
      i += 1;
    }
    setMeasuredDimension(j, k);
  }
  
  public void setView(View paramView)
  {
    if (getChildCount() != 0) {
      removeViewAt(0);
    }
    addView(paramView, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\xrecyclerview\SimpleViewSwitcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */