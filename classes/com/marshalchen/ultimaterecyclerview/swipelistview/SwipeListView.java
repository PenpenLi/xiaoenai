package com.marshalchen.ultimaterecyclerview.swipelistview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.marshalchen.ultimaterecyclerview.d.e;
import java.util.List;

public class SwipeListView
  extends RecyclerView
{
  int a = 0;
  int b = 0;
  public b c;
  private int d = 0;
  private float e;
  private float f;
  private int g;
  private LinearLayoutManager h;
  private c i;
  
  public SwipeListView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public SwipeListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SwipeListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    int j = (int)Math.abs(paramFloat1 - this.e);
    int m = (int)Math.abs(paramFloat2 - this.f);
    int n = this.g;
    if (j > n) {}
    for (j = 1;; j = 0)
    {
      if (m > n) {
        k = 1;
      }
      if (j != 0)
      {
        this.d = 1;
        this.e = paramFloat1;
        this.f = paramFloat2;
      }
      if (k != 0)
      {
        this.d = 2;
        this.e = paramFloat1;
        this.f = paramFloat2;
      }
      return;
    }
  }
  
  protected void a()
  {
    if (this.c != null) {
      this.c.b();
    }
  }
  
  protected void a(int paramInt)
  {
    if ((this.c != null) && (paramInt != -1)) {
      this.c.a(paramInt);
    }
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    if ((this.c != null) && (paramInt != -1)) {
      this.c.a(paramInt, paramFloat);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.c != null) && (paramInt1 != -1)) {
      this.c.a(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if ((this.c != null) && (paramInt != -1)) {
      this.c.c(paramInt, paramBoolean);
    }
  }
  
  public void a(AttributeSet paramAttributeSet)
  {
    int i1 = 1;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = false;
    long l = 0L;
    float f2 = 0.0F;
    float f1 = 0.0F;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, d.e.SwipeListView);
      i1 = paramAttributeSet.getInt(d.e.SwipeListView_swipeMode, 1);
      k = paramAttributeSet.getInt(d.e.SwipeListView_swipeActionLeft, 0);
      j = paramAttributeSet.getInt(d.e.SwipeListView_swipeActionRight, 0);
      bool1 = paramAttributeSet.getBoolean(d.e.SwipeListView_onlyOneOpenedWhenSwipe, false);
      f2 = paramAttributeSet.getDimension(d.e.SwipeListView_swipeOffsetLeft, 0.0F);
      f1 = paramAttributeSet.getDimension(d.e.SwipeListView_swipeOffsetRight, 0.0F);
      bool3 = paramAttributeSet.getBoolean(d.e.SwipeListView_swipeOpenOnLongPress, true);
      l = paramAttributeSet.getInteger(d.e.SwipeListView_swipeAnimationTime, 0);
      bool2 = paramAttributeSet.getBoolean(d.e.SwipeListView_swipeCloseAllItemsWhenMoveList, true);
      n = paramAttributeSet.getResourceId(d.e.SwipeListView_swipeDrawableChecked, 0);
      m = paramAttributeSet.getResourceId(d.e.SwipeListView_swipeDrawableUnchecked, 0);
      this.a = paramAttributeSet.getResourceId(d.e.SwipeListView_swipeFrontView, 0);
      this.b = paramAttributeSet.getResourceId(d.e.SwipeListView_swipeBackView, 0);
      paramAttributeSet.recycle();
    }
    if ((this.a == 0) || (this.b == 0))
    {
      this.a = getContext().getResources().getIdentifier("swipelist_frontview", "id", getContext().getPackageName());
      this.b = getContext().getResources().getIdentifier("swipelist_backview", "id", getContext().getPackageName());
      if ((this.a == 0) || (this.b == 0)) {
        throw new RuntimeException(String.format("You forgot the attributes swipeFrontView or swipeBackView. You can add this attributes or use '%s' and '%s' identifiers", new Object[] { "swipelist_frontview", "swipelist_backview" }));
      }
    }
    this.g = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    this.i = new c(this, this.a, this.b);
    if (l > 0L) {
      this.i.a(l);
    }
    this.i.a(f1);
    this.i.b(f2);
    this.i.b(k);
    this.i.c(j);
    this.i.a(i1);
    this.i.a(bool1);
    this.i.b(bool2);
    this.i.c(bool3);
    this.i.d(n);
    this.i.e(m);
    setOnTouchListener(this.i);
    setOnScrollListener(this.i.g());
  }
  
  protected void a(int[] paramArrayOfInt)
  {
    if (this.c != null) {
      this.c.a(paramArrayOfInt);
    }
  }
  
  protected void b()
  {
    if (this.c != null) {
      this.c.c();
    }
  }
  
  protected void b(int paramInt)
  {
    if ((this.c != null) && (paramInt != -1)) {
      this.c.b(paramInt);
    }
  }
  
  protected void b(int paramInt, boolean paramBoolean)
  {
    if ((this.c != null) && (paramInt != -1)) {
      this.c.a(paramInt, paramBoolean);
    }
  }
  
  protected int c(int paramInt)
  {
    int k = -1;
    int j = k;
    if (this.c != null)
    {
      j = k;
      if (paramInt != -1) {
        j = this.c.c(paramInt);
      }
    }
    return j;
  }
  
  protected void c()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  protected void c(int paramInt, boolean paramBoolean)
  {
    if ((this.c != null) && (paramInt != -1)) {
      this.c.b(paramInt, paramBoolean);
    }
  }
  
  public void d()
  {
    this.d = 0;
  }
  
  protected void d(int paramInt, boolean paramBoolean)
  {
    if ((this.c != null) && (paramInt != -1)) {
      this.c.d(paramInt, paramBoolean);
    }
  }
  
  public int getCountSelected()
  {
    return this.i.e();
  }
  
  public List<Integer> getPositionsSelected()
  {
    return this.i.f();
  }
  
  public int getSwipeActionLeft()
  {
    return this.i.b();
  }
  
  public int getSwipeActionRight()
  {
    return this.i.c();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int j = MotionEventCompat.getActionMasked(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((isEnabled()) && (this.i.a())) {
      if (this.d == 1) {
        bool = this.i.onTouch(this, paramMotionEvent);
      }
    }
    do
    {
      return bool;
      switch (j)
      {
      default: 
      case 2: 
      case 0: 
      case 3: 
        for (;;)
        {
          return super.onInterceptTouchEvent(paramMotionEvent);
          a(f1, f2);
          if (this.d == 2) {
            break;
          }
          return false;
          super.onInterceptTouchEvent(paramMotionEvent);
          this.i.onTouch(this, paramMotionEvent);
          this.d = 0;
          this.e = f1;
          this.f = f2;
          return false;
          this.d = 0;
        }
      }
      this.i.onTouch(this, paramMotionEvent);
    } while (this.d == 2);
    return false;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    super.setAdapter(paramAdapter);
    this.i.d();
    paramAdapter.registerAdapterDataObserver(new a(this));
  }
  
  public void setAnimationTime(long paramLong)
  {
    this.i.a(paramLong);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    this.h = ((LinearLayoutManager)paramLayoutManager);
    if (this.i != null) {
      this.i.a(this.h);
    }
  }
  
  public void setOffsetLeft(float paramFloat)
  {
    this.i.b(paramFloat);
  }
  
  public void setOffsetRight(float paramFloat)
  {
    this.i.a(paramFloat);
  }
  
  public void setOnlyOneOpenedWhenSwipe(boolean paramBoolean)
  {
    this.i.a(paramBoolean);
  }
  
  public void setSwipeActionLeft(int paramInt)
  {
    this.i.b(paramInt);
  }
  
  public void setSwipeActionRight(int paramInt)
  {
    this.i.c(paramInt);
  }
  
  public void setSwipeCloseAllItemsWhenMoveList(boolean paramBoolean)
  {
    this.i.b(paramBoolean);
  }
  
  public void setSwipeListViewListener(b paramb)
  {
    this.c = paramb;
  }
  
  public void setSwipeMode(int paramInt)
  {
    this.i.a(paramInt);
  }
  
  public void setSwipeOpenOnLongPress(boolean paramBoolean)
  {
    this.i.c(paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\swipelistview\SwipeListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */