package com.marshalchen.ultimaterecyclerview.swipe;

import android.graphics.Rect;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.View;
import java.util.Iterator;
import java.util.List;

class a
  extends ViewDragHelper.Callback
{
  boolean a = true;
  
  a(SwipeLayout paramSwipeLayout) {}
  
  public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == this.b.getSurfaceView()) {
      switch (SwipeLayout.1.a[SwipeLayout.a(this.b).ordinal()])
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
              return this.b.getPaddingLeft();
              if (paramInt1 < this.b.getPaddingLeft()) {
                return this.b.getPaddingLeft();
              }
            } while (paramInt1 <= this.b.getPaddingLeft() + SwipeLayout.b(this.b));
            return this.b.getPaddingLeft() + SwipeLayout.b(this.b);
            if (paramInt1 > this.b.getPaddingLeft()) {
              return this.b.getPaddingLeft();
            }
          } while (paramInt1 >= this.b.getPaddingLeft() - SwipeLayout.b(this.b));
          return this.b.getPaddingLeft() - SwipeLayout.b(this.b);
        } while (this.b.getCurrentBottomView() != paramView);
        switch (SwipeLayout.1.a[SwipeLayout.a(this.b).ordinal()])
        {
        default: 
          return paramInt1;
        case 1: 
        case 2: 
          return this.b.getPaddingLeft();
        }
      } while ((SwipeLayout.c(this.b) != SwipeLayout.e.b) || (paramInt1 <= this.b.getPaddingLeft()));
      return this.b.getPaddingLeft();
    } while ((SwipeLayout.c(this.b) != SwipeLayout.e.b) || (paramInt1 >= this.b.getMeasuredWidth() - SwipeLayout.b(this.b)));
    return this.b.getMeasuredWidth() - SwipeLayout.b(this.b);
  }
  
  public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == this.b.getSurfaceView()) {
      switch (SwipeLayout.1.a[SwipeLayout.a(this.b).ordinal()])
      {
      }
    }
    label56:
    int i;
    label283:
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
              return this.b.getPaddingTop();
              if (paramInt1 < this.b.getPaddingTop()) {
                return this.b.getPaddingTop();
              }
            } while (paramInt1 <= this.b.getPaddingTop() + SwipeLayout.b(this.b));
            return this.b.getPaddingTop() + SwipeLayout.b(this.b);
            if (paramInt1 < this.b.getPaddingTop() - SwipeLayout.b(this.b)) {
              return this.b.getPaddingTop() - SwipeLayout.b(this.b);
            }
          } while (paramInt1 <= this.b.getPaddingTop());
          return this.b.getPaddingTop();
          paramView = this.b.getSurfaceView();
          if (paramView == null) {}
          for (i = 0;; i = paramView.getTop()) {
            switch (SwipeLayout.1.a[SwipeLayout.a(this.b).ordinal()])
            {
            default: 
              return paramInt1;
            case 1: 
              if (SwipeLayout.c(this.b) != SwipeLayout.e.b) {
                break label283;
              }
              if (paramInt1 <= this.b.getPaddingTop()) {
                break label56;
              }
              return this.b.getPaddingTop();
            }
          }
          return this.b.getPaddingTop();
          if (i + paramInt2 < this.b.getPaddingTop()) {
            return this.b.getPaddingTop();
          }
        } while (i + paramInt2 <= this.b.getPaddingTop() + SwipeLayout.b(this.b));
        return this.b.getPaddingTop() + SwipeLayout.b(this.b);
        if (SwipeLayout.c(this.b) != SwipeLayout.e.b) {
          break;
        }
      } while (paramInt1 >= this.b.getMeasuredHeight() - SwipeLayout.b(this.b));
      return this.b.getMeasuredHeight() - SwipeLayout.b(this.b);
      if (i + paramInt2 >= this.b.getPaddingTop()) {
        return this.b.getPaddingTop();
      }
    } while (i + paramInt2 > this.b.getPaddingTop() - SwipeLayout.b(this.b));
    return this.b.getPaddingTop() - SwipeLayout.b(this.b);
  }
  
  public int getViewHorizontalDragRange(View paramView)
  {
    return SwipeLayout.b(this.b);
  }
  
  public int getViewVerticalDragRange(View paramView)
  {
    return SwipeLayout.b(this.b);
  }
  
  public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView1 = this.b.getSurfaceView();
    if (localView1 == null) {
      return;
    }
    View localView2 = this.b.getCurrentBottomView();
    int k = localView1.getLeft();
    int m = localView1.getRight();
    int n = localView1.getTop();
    int i1 = localView1.getBottom();
    if (paramView == localView1) {
      if ((SwipeLayout.c(this.b) == SwipeLayout.e.b) && (localView2 != null))
      {
        if ((SwipeLayout.a(this.b) != SwipeLayout.b.a) && (SwipeLayout.a(this.b) != SwipeLayout.b.c)) {
          break label147;
        }
        localView2.offsetLeftAndRight(paramInt3);
      }
    }
    for (;;)
    {
      this.b.b(k, n, m, i1);
      this.b.a(k, n, paramInt3, paramInt4);
      this.b.invalidate();
      return;
      label147:
      localView2.offsetTopAndBottom(paramInt4);
      continue;
      if (this.b.getBottomViews().contains(paramView))
      {
        if (SwipeLayout.c(this.b) != SwipeLayout.e.b) {
          break;
        }
        localView1.offsetLeftAndRight(paramInt3);
        localView1.offsetTopAndBottom(paramInt4);
      }
    }
    paramView = SwipeLayout.a(this.b, SwipeLayout.a(this.b));
    if (localView2 != null) {
      localView2.layout(paramView.left, paramView.top, paramView.right, paramView.bottom);
    }
    int i = localView1.getLeft() + paramInt3;
    int j = localView1.getTop() + paramInt4;
    if ((SwipeLayout.a(this.b) == SwipeLayout.b.a) && (i < this.b.getPaddingLeft()))
    {
      paramInt2 = this.b.getPaddingLeft();
      paramInt1 = j;
    }
    for (;;)
    {
      localView1.layout(paramInt2, paramInt1, this.b.getMeasuredWidth() + paramInt2, this.b.getMeasuredHeight() + paramInt1);
      break;
      if ((SwipeLayout.a(this.b) == SwipeLayout.b.c) && (i > this.b.getPaddingLeft()))
      {
        paramInt2 = this.b.getPaddingLeft();
        paramInt1 = j;
      }
      else if ((SwipeLayout.a(this.b) == SwipeLayout.b.b) && (j < this.b.getPaddingTop()))
      {
        paramInt1 = this.b.getPaddingTop();
        paramInt2 = i;
      }
      else
      {
        paramInt1 = j;
        paramInt2 = i;
        if (SwipeLayout.a(this.b) == SwipeLayout.b.d)
        {
          paramInt1 = j;
          paramInt2 = i;
          if (j > this.b.getPaddingTop())
          {
            paramInt1 = this.b.getPaddingTop();
            paramInt2 = i;
          }
        }
      }
    }
  }
  
  public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
  {
    super.onViewReleased(paramView, paramFloat1, paramFloat2);
    this.b.a(paramFloat1, paramFloat2, this.a);
    paramView = SwipeLayout.d(this.b).iterator();
    while (paramView.hasNext()) {
      ((SwipeLayout.i)paramView.next()).a(this.b, paramFloat1, paramFloat2);
    }
    this.b.invalidate();
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramView == this.b.getSurfaceView()) || (this.b.getBottomViews().contains(paramView)))
    {
      bool1 = true;
      if (bool1) {
        if (this.b.getOpenStatus() != SwipeLayout.f.c) {
          break label62;
        }
      }
    }
    for (;;)
    {
      this.a = bool2;
      return bool1;
      bool1 = false;
      break;
      label62:
      bool2 = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\swipe\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */