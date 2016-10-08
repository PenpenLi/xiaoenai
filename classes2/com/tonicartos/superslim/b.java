package com.tonicartos.superslim;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

class b
  extends LinearSmoothScroller
{
  b(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    int i = 0;
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if (!localLayoutManager.canScrollVertically()) {
      return 0;
    }
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int j = localLayoutManager.getDecoratedTop(paramView);
    int k = localLayoutParams.topMargin;
    int m = localLayoutManager.getDecoratedBottom(paramView);
    int n = localLayoutParams.bottomMargin;
    if (this.a.c.getPosition(paramView) == 0) {
      i = localLayoutManager.getPaddingTop();
    }
    i = calculateDtToFit(j - k, m + n, i, localLayoutManager.getHeight() - localLayoutManager.getPaddingBottom(), paramInt);
    paramInt = i;
    if (i == 0) {
      paramInt = 1;
    }
    return paramInt;
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    return new PointF(0.0F, LayoutManager.a(this.a.c, paramInt));
  }
  
  protected int getVerticalSnapPreference()
  {
    return -1;
  }
  
  protected void onChildAttachedToWindow(View paramView)
  {
    super.onChildAttachedToWindow(paramView);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.a.c.requestLayout();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tonicartos\superslim\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */