package com.marshalchen.ultimaterecyclerview.uiUtils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class ScrollSmoothLineaerLayoutManager
  extends LinearLayoutManager
{
  private final int a;
  
  public ScrollSmoothLineaerLayoutManager(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    super(paramContext, paramInt1, paramBoolean);
    this.a = paramInt2;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramState = paramRecyclerView.getChildAt(0);
    int j = Math.abs(paramState.getHeight() * (paramRecyclerView.getChildLayoutPosition(paramState) - paramInt));
    int i = j;
    if (j == 0) {
      i = (int)Math.abs(paramState.getY());
    }
    paramRecyclerView = new a(paramRecyclerView.getContext(), i, this.a);
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  private class a
    extends LinearSmoothScroller
  {
    private final float b;
    private final float c;
    
    public a(Context paramContext, int paramInt1, int paramInt2)
    {
      super();
      this.b = paramInt1;
      float f = calculateSpeedPerPixel(paramContext.getResources().getDisplayMetrics());
      if (paramInt1 < 10000) {}
      for (f = (int)(f * Math.abs(paramInt1));; f = paramInt2)
      {
        this.c = f;
        return;
      }
    }
    
    protected int calculateTimeForScrolling(int paramInt)
    {
      return (int)(paramInt / this.b * this.c);
    }
    
    public PointF computeScrollVectorForPosition(int paramInt)
    {
      return ScrollSmoothLineaerLayoutManager.this.computeScrollVectorForPosition(paramInt);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\uiUtils\ScrollSmoothLineaerLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */