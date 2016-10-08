package com.xiaoenai.app.widget.swipeLayout;

import android.graphics.Rect;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;

class b
  extends ViewDragHelper.Callback
{
  b(SwipeLayout paramSwipeLayout) {}
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == this.a.getSurfaceView()) {
      switch (c.a[SwipeLayout.a(this.a).ordinal()])
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return paramInt1;
              return this.a.getPaddingLeft();
              if (paramInt1 < this.a.getPaddingLeft()) {
                return this.a.getPaddingLeft();
              }
            } while (paramInt1 <= this.a.getPaddingLeft() + SwipeLayout.b(this.a));
            return this.a.getPaddingLeft() + SwipeLayout.b(this.a);
            if (paramInt1 > this.a.getPaddingLeft()) {
              return this.a.getPaddingLeft();
            }
          } while (paramInt1 >= this.a.getPaddingLeft() - SwipeLayout.b(this.a));
          return this.a.getPaddingLeft() - SwipeLayout.b(this.a);
        } while (paramView != this.a.getBottomView());
        switch (c.a[SwipeLayout.a(this.a).ordinal()])
        {
        default: 
          return paramInt1;
        case 1: 
        case 2: 
          return this.a.getPaddingLeft();
        }
      } while ((SwipeLayout.c(this.a) != SwipeLayout.e.b) || (paramInt1 <= this.a.getPaddingLeft()));
      return this.a.getPaddingLeft();
    } while ((SwipeLayout.c(this.a) != SwipeLayout.e.b) || (paramInt1 >= this.a.getMeasuredWidth() - SwipeLayout.b(this.a)));
    return this.a.getMeasuredWidth() - SwipeLayout.b(this.a);
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == this.a.getSurfaceView()) {
      switch (c.a[SwipeLayout.a(this.a).ordinal()])
      {
      }
    }
    label262:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramInt1;
                return this.a.getPaddingTop();
                if (paramInt1 < this.a.getPaddingTop()) {
                  return this.a.getPaddingTop();
                }
              } while (paramInt1 <= this.a.getPaddingTop() + SwipeLayout.b(this.a));
              return this.a.getPaddingTop() + SwipeLayout.b(this.a);
              if (paramInt1 < this.a.getPaddingTop() - SwipeLayout.b(this.a)) {
                return this.a.getPaddingTop() - SwipeLayout.b(this.a);
              }
            } while (paramInt1 <= this.a.getPaddingTop());
            return this.a.getPaddingTop();
            switch (c.a[SwipeLayout.a(this.a).ordinal()])
            {
            default: 
              return paramInt1;
            case 1: 
              if (SwipeLayout.c(this.a) != SwipeLayout.e.b) {
                break label262;
              }
            }
          } while (paramInt1 <= this.a.getPaddingTop());
          return this.a.getPaddingTop();
          return this.a.getPaddingTop();
          if (this.a.getSurfaceView().getTop() + paramInt2 < this.a.getPaddingTop()) {
            return this.a.getPaddingTop();
          }
        } while (this.a.getSurfaceView().getTop() + paramInt2 <= this.a.getPaddingTop() + SwipeLayout.b(this.a));
        return this.a.getPaddingTop() + SwipeLayout.b(this.a);
        if (SwipeLayout.c(this.a) != SwipeLayout.e.b) {
          break;
        }
      } while (paramInt1 >= this.a.getMeasuredHeight() - SwipeLayout.b(this.a));
      return this.a.getMeasuredHeight() - SwipeLayout.b(this.a);
      if (this.a.getSurfaceView().getTop() + paramInt2 >= this.a.getPaddingTop()) {
        return this.a.getPaddingTop();
      }
    } while (this.a.getSurfaceView().getTop() + paramInt2 > this.a.getPaddingTop() - SwipeLayout.b(this.a));
    return this.a.getPaddingTop() - SwipeLayout.b(this.a);
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return SwipeLayout.b(this.a);
  }
  
  public int getViewVerticalDragRange(View paramView)
  {
    return SwipeLayout.b(this.a);
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = this.a.getSurfaceView().getLeft();
    int m = this.a.getSurfaceView().getRight();
    int n = this.a.getSurfaceView().getTop();
    int i1 = this.a.getSurfaceView().getBottom();
    if (paramView == this.a.getSurfaceView()) {
      if (SwipeLayout.c(this.a) == SwipeLayout.e.b)
      {
        if ((SwipeLayout.a(this.a) != SwipeLayout.b.a) && (SwipeLayout.a(this.a) != SwipeLayout.b.b)) {
          break label148;
        }
        this.a.getBottomView().offsetLeftAndRight(paramInt3);
      }
    }
    for (;;)
    {
      this.a.b(k, n, m, i1);
      this.a.a(k, n, paramInt3, paramInt4);
      this.a.invalidate();
      return;
      label148:
      this.a.getBottomView().offsetTopAndBottom(paramInt4);
      continue;
      if (paramView == this.a.getBottomView())
      {
        if (SwipeLayout.c(this.a) != SwipeLayout.e.b) {
          break;
        }
        this.a.getSurfaceView().offsetLeftAndRight(paramInt3);
        this.a.getSurfaceView().offsetTopAndBottom(paramInt4);
      }
    }
    paramView = SwipeLayout.a(this.a, SwipeLayout.a(this.a));
    this.a.getBottomView().layout(paramView.left, paramView.top, paramView.right, paramView.bottom);
    int i = this.a.getSurfaceView().getLeft() + paramInt3;
    int j = this.a.getSurfaceView().getTop() + paramInt4;
    if ((SwipeLayout.a(this.a) == SwipeLayout.b.a) && (i < this.a.getPaddingLeft()))
    {
      paramInt2 = this.a.getPaddingLeft();
      paramInt1 = j;
    }
    for (;;)
    {
      this.a.getSurfaceView().layout(paramInt2, paramInt1, this.a.getMeasuredWidth() + paramInt2, this.a.getMeasuredHeight() + paramInt1);
      break;
      if ((SwipeLayout.a(this.a) == SwipeLayout.b.b) && (i > this.a.getPaddingLeft()))
      {
        paramInt2 = this.a.getPaddingLeft();
        paramInt1 = j;
      }
      else if ((SwipeLayout.a(this.a) == SwipeLayout.b.c) && (j < this.a.getPaddingTop()))
      {
        paramInt1 = this.a.getPaddingTop();
        paramInt2 = i;
      }
      else
      {
        paramInt1 = j;
        paramInt2 = i;
        if (SwipeLayout.a(this.a) == SwipeLayout.b.d)
        {
          paramInt1 = j;
          paramInt2 = i;
          if (j > this.a.getPaddingTop())
          {
            paramInt1 = this.a.getPaddingTop();
            paramInt2 = i;
          }
        }
      }
    }
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    super.onViewReleased(paramView, paramFloat1, paramFloat2);
    Iterator localIterator = SwipeLayout.d(this.a).iterator();
    while (localIterator.hasNext()) {
      ((SwipeLayout.i)localIterator.next()).a(this.a, paramFloat1, paramFloat2);
    }
    if (paramView == this.a.getSurfaceView()) {
      SwipeLayout.a(this.a, paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      if (paramView == this.a.getBottomView()) {
        if (this.a.getShowMode() == SwipeLayout.e.b) {
          SwipeLayout.b(this.a, paramFloat1, paramFloat2);
        } else if (this.a.getShowMode() == SwipeLayout.e.a) {
          SwipeLayout.c(this.a, paramFloat1, paramFloat2);
        }
      }
    }
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    return (paramView == this.a.getSurfaceView()) || (paramView == this.a.getBottomView());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\swipeLayout\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */