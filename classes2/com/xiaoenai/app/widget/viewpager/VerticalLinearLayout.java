package com.xiaoenai.app.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.Scroller;

public class VerticalLinearLayout
  extends ViewGroup
{
  private int a;
  private int b;
  private int c;
  private int d;
  private Scroller e;
  private boolean f;
  private VelocityTracker g;
  private int h = 0;
  private boolean i = true;
  private a j;
  
  public VerticalLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramAttributeSet.getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.a = localDisplayMetrics.heightPixels;
    this.e = new Scroller(paramContext);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.g == null) {
      this.g = VelocityTracker.obtain();
    }
    this.g.addMovement(paramMotionEvent);
  }
  
  private boolean a()
  {
    return (this.c - this.b > this.a / 2) || (Math.abs(getVelocity()) > 600);
  }
  
  private boolean b()
  {
    return this.c > this.b;
  }
  
  private boolean c()
  {
    return (-this.c + this.b > this.a / 2) || (Math.abs(getVelocity()) > 600);
  }
  
  private boolean d()
  {
    return this.c < this.b;
  }
  
  private void e()
  {
    if (this.g != null)
    {
      this.g.recycle();
      this.g = null;
    }
  }
  
  private int getVelocity()
  {
    this.g.computeCurrentVelocity(1000);
    return (int)this.g.getYVelocity();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.e.computeScrollOffset())
    {
      scrollTo(0, this.e.getCurrY());
      postInvalidate();
      return;
    }
    int k = getScrollY() / this.a;
    if ((k != this.h) && (this.j != null))
    {
      this.h = k;
      this.j.a(this.h);
    }
    this.f = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      paramInt4 = getChildCount();
      Object localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = (this.a * paramInt4);
      setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramInt2 = 0;
      while (paramInt2 < paramInt4)
      {
        localObject = getChildAt(paramInt2);
        if (((View)localObject).getVisibility() != 8) {
          ((View)localObject).layout(paramInt1, this.a * paramInt2, paramInt3, (paramInt2 + 1) * this.a);
        }
        paramInt2 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int m = getChildCount();
    int k = 0;
    while (k < m)
    {
      measureChild(getChildAt(k), paramInt1, paramInt2);
      k += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.f) || (!this.i)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int k = paramMotionEvent.getAction();
    int n = (int)paramMotionEvent.getY();
    a(paramMotionEvent);
    switch (k)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.b = getScrollY();
        this.d = n;
        continue;
        if (!this.e.isFinished()) {
          this.e.abortAnimation();
        }
        int m = this.d - n;
        int i1 = getScrollY();
        k = m;
        if (m < 0)
        {
          k = m;
          if (i1 + m < 0) {
            k = -i1;
          }
        }
        m = k;
        if (k > 0)
        {
          m = k;
          if (i1 + k > getHeight() - this.a) {
            m = getHeight() - this.a - i1;
          }
        }
        scrollBy(0, m);
        this.d = n;
      }
    }
    this.c = getScrollY();
    k = this.c - this.b;
    if (b())
    {
      if (a()) {
        this.e.startScroll(0, getScrollY(), 0, this.a - k);
      }
    }
    else {
      label236:
      if (d())
      {
        if (!c()) {
          break label304;
        }
        this.e.startScroll(0, getScrollY(), 0, -this.a - k);
      }
    }
    for (;;)
    {
      this.f = true;
      postInvalidate();
      e();
      break;
      this.e.startScroll(0, getScrollY(), 0, -k);
      break label236;
      label304:
      this.e.startScroll(0, getScrollY(), 0, -k);
    }
  }
  
  public void setOnPageChangeListener(a parama)
  {
    this.j = parama;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\viewpager\VerticalLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */