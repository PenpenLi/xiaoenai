package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

public class MobViewPager
  extends ViewGroup
{
  private int a;
  private int b;
  private View c;
  private View d;
  private View e;
  private Scroller f;
  private int g;
  private int h;
  private k i;
  private VelocityTracker j;
  private int k = 0;
  private float l;
  private float m;
  
  public MobViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MobViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (this.i != null)
    {
      int n;
      int i1;
      View localView;
      if (this.a > paramInt)
      {
        n = 0;
        if (n < this.a - paramInt)
        {
          i1 = paramInt + n + 1;
          localView = this.c;
          this.c = this.d;
          this.d = this.e;
          if (getChildCount() >= 3) {
            removeViewAt(0);
          }
          if (i1 < this.b - 1)
          {
            this.e = this.i.a(i1 + 1, localView, this);
            addView(this.e);
          }
          for (;;)
          {
            n += 1;
            break;
            this.e = localView;
          }
        }
      }
      else
      {
        n = 0;
        if (n < paramInt - this.a)
        {
          i1 = paramInt - n - 1;
          localView = this.e;
          this.e = this.d;
          this.d = this.c;
          if (getChildCount() >= 3) {
            removeViewAt(2);
          }
          if (i1 > 0)
          {
            this.c = this.i.a(i1 - 1, localView, this);
            addView(this.c, 0);
          }
          for (;;)
          {
            n += 1;
            break;
            this.c = localView;
          }
        }
      }
      this.i.a(this.a, paramInt);
    }
  }
  
  private void a(Context paramContext)
  {
    this.f = new Scroller(getContext(), new e(this));
    paramContext = ViewConfiguration.get(paramContext);
    this.g = paramContext.getScaledTouchSlop();
    this.h = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int n = (int)Math.abs(f1 - this.l);
    if (((int)Math.abs(f2 - this.m) < n) && (n > this.g))
    {
      this.k = 1;
      this.l = f1;
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (this.i == null) {}
    int n;
    int i1;
    do
    {
      do
      {
        do
        {
          return;
          float f1 = paramMotionEvent.getX();
          n = (int)(this.l - f1);
          this.l = f1;
          if (n >= 0) {
            break;
          }
        } while (getScrollX() <= 0);
        scrollBy(Math.max(-getScrollX(), n), 0);
        return;
      } while ((n <= 0) || (getChildCount() == 0));
      i1 = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
    } while (i1 <= 0);
    scrollBy(Math.min(i1, n), 0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.d != null) && (getFocusedChild() == this.d)) {
      this.d.clearFocus();
    }
    int n = getWidth() * paramInt - getScrollX();
    this.f.abortAnimation();
    Scroller localScroller = this.f;
    int i1 = getScrollX();
    if (paramBoolean) {}
    for (paramInt = 0;; paramInt = Math.abs(n) / 2)
    {
      localScroller.startScroll(i1, 0, n, 0, paramInt);
      invalidate();
      return;
    }
  }
  
  public void computeScroll()
  {
    if ((this.i == null) || (this.b <= 0)) {}
    int i2;
    do
    {
      return;
      if (this.f.computeScrollOffset())
      {
        scrollTo(this.f.getCurrX(), this.f.getCurrY());
        postInvalidate();
        return;
      }
      i2 = this.a;
      int i3 = this.f.getCurrX();
      int i4 = getWidth();
      int i1 = i3 / i4;
      int n = i1;
      if (i3 % i4 > i4 / 2) {
        n = i1 + 1;
      }
      this.a = Math.max(0, Math.min(n, this.b - 1));
    } while (i2 == this.a);
    a(i2);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.i == null) || (this.b <= 0)) {}
    long l1;
    do
    {
      return;
      l1 = getDrawingTime();
      if (this.a > 0) {
        drawChild(paramCanvas, this.c, l1);
      }
      drawChild(paramCanvas, this.d, l1);
    } while (this.a >= this.b - 1);
    drawChild(paramCanvas, this.e, l1);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (this.i == null) {
      return super.dispatchUnhandledMove(paramView, paramInt);
    }
    if (paramInt == 17)
    {
      if (this.a > 0)
      {
        a(this.a - 1, false);
        return true;
      }
    }
    else if ((paramInt == 66) && (this.a < this.b - 1))
    {
      a(this.a + 1, false);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = paramMotionEvent.getAction();
    if ((n == 2) && (this.k != 0)) {}
    for (;;)
    {
      return true;
      if (this.j == null) {
        this.j = VelocityTracker.obtain();
      }
      this.j.addMovement(paramMotionEvent);
      switch (n)
      {
      }
      while (this.k == 0)
      {
        return false;
        a(paramMotionEvent);
        continue;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.l = f1;
        this.m = f2;
        if (this.f.isFinished()) {}
        for (n = 0;; n = 1)
        {
          this.k = n;
          break;
        }
        if (this.j != null)
        {
          this.j.recycle();
          this.j = null;
        }
        this.k = 0;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.i == null) || (this.b <= 0)) {}
    do
    {
      return;
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = paramInt4 - paramInt2;
      paramInt3 = this.a * paramInt1;
      if (this.a > 0) {
        this.c.layout(paramInt3 - paramInt1, 0, paramInt3, paramInt2);
      }
      this.d.layout(paramInt3, 0, paramInt3 + paramInt1, paramInt2);
    } while (this.a >= this.b - 1);
    this.e.layout(paramInt3 + paramInt1, 0, paramInt1 + (paramInt3 + paramInt1), paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.i == null) || (this.b <= 0)) {}
    for (;;)
    {
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = getMeasuredHeight();
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      int n = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        getChildAt(paramInt1).measure(paramInt2, n);
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.i == null) {
      return false;
    }
    if (this.j == null) {
      this.j = VelocityTracker.obtain();
    }
    this.j.addMovement(paramMotionEvent);
    int n = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (n)
    {
    }
    for (;;)
    {
      return true;
      if (this.k != 0)
      {
        if (!this.f.isFinished()) {
          this.f.abortAnimation();
        }
        this.l = f1;
        continue;
        if (this.k == 1)
        {
          b(paramMotionEvent);
        }
        else if ((onInterceptTouchEvent(paramMotionEvent)) && (this.k == 1))
        {
          b(paramMotionEvent);
          continue;
          if (this.k == 1)
          {
            paramMotionEvent = this.j;
            paramMotionEvent.computeCurrentVelocity(1000, this.h);
            n = (int)paramMotionEvent.getXVelocity();
            if ((n <= 500) || (this.a <= 0)) {
              break label229;
            }
            a(this.a - 1, false);
          }
          for (;;)
          {
            if (this.j != null)
            {
              this.j.recycle();
              this.j = null;
            }
            this.k = 0;
            break;
            label229:
            if ((n < 65036) && (this.a < this.b - 1))
            {
              a(this.a + 1, false);
            }
            else
            {
              n = getWidth();
              a((getScrollX() + n / 2) / n, false);
            }
          }
          this.k = 0;
        }
      }
    }
  }
  
  public void setAdapter(k paramk)
  {
    if (this.i != null) {
      this.i.a(null);
    }
    this.i = paramk;
    if (this.i != null) {
      this.i.a(this);
    }
    if (paramk == null)
    {
      this.a = 0;
      removeAllViews();
    }
    do
    {
      return;
      this.b = paramk.a();
      if (this.b <= 0)
      {
        this.a = 0;
        removeAllViews();
        return;
      }
      if (this.b <= this.a)
      {
        a(this.b - 1, true);
        return;
      }
      removeAllViews();
      if (this.a > 0)
      {
        this.c = paramk.a(this.a - 1, this.c, this);
        addView(this.c);
      }
      this.d = paramk.a(this.a, this.d, this);
      addView(this.d);
    } while (this.a >= this.b - 1);
    this.e = paramk.a(this.a + 1, this.e, this);
    addView(this.e);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\MobViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */