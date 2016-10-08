package com.xiaoenai.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

public class ScrollLayout
  extends ViewGroup
{
  private Scroller a;
  private int b;
  private int c;
  private float d;
  private float e;
  private int f = 0;
  private float g;
  private b h;
  private c i;
  private a j;
  private boolean k = true;
  private int l;
  private int m;
  private int n = 0;
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new Scroller(paramContext);
    this.b = 0;
    this.c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.l = a(paramContext);
    this.m = this.l;
    setChildrenDrawingCacheEnabled(true);
    setChildrenDrawnWithCacheEnabled(true);
  }
  
  public static int a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public void a()
  {
    int i1 = getWidth();
    a((getScrollX() + i1 / 2) / i1);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool1 = false;
    int i1 = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    int i2;
    if (getScrollX() != getWidth() * i1)
    {
      i2 = getWidth() * i1 - getScrollX();
      if (Math.abs(i2) <= this.l) {
        break label120;
      }
    }
    label120:
    for (paramInt = this.l;; paramInt = Math.abs(i2))
    {
      this.a.startScroll(getScrollX(), 0, i2, 0, Math.max(paramInt, 300));
      this.b = i1;
      boolean bool2 = true;
      invalidate();
      bool1 = bool2;
      if (this.h != null)
      {
        this.h.a(i1);
        bool1 = bool2;
      }
      return bool1;
    }
  }
  
  public void computeScroll()
  {
    if (this.a.computeScrollOffset())
    {
      scrollTo(this.a.getCurrX(), this.a.getCurrY());
      postInvalidate();
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    this.h = null;
  }
  
  public int getCurScreen()
  {
    return this.b;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i1)
    {
    }
    while (this.f != 0)
    {
      return true;
      if (((int)Math.abs(f1 - this.d) > this.c) && (Math.abs(f2 - this.g) < Math.abs(f1 - this.d)))
      {
        this.f = 1;
        continue;
        this.e = f1;
        this.d = f1;
        this.g = f2;
        if (this.a.isFinished()) {}
        for (i1 = 0;; i1 = 1)
        {
          this.f = i1;
          break;
        }
        this.f = 0;
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = getChildCount();
    if (1073741824 == View.MeasureSpec.getMode(paramInt1))
    {
      int i1 = 0;
      while (i1 < i3)
      {
        getChildAt(i1).measure(paramInt1, paramInt2);
        i1 += 1;
      }
      scrollTo(this.b * i2, 0);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.k) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label218:
    do
    {
      float f1;
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
                return bool1;
                i1 = paramMotionEvent.getAction();
                f1 = paramMotionEvent.getX();
                switch (i1)
                {
                default: 
                  return true;
                case 0: 
                  if (!this.a.isFinished()) {
                    this.a.abortAnimation();
                  }
                  if (this.i != null) {
                    this.i.a(true);
                  }
                  this.d = f1;
                  return true;
                case 2: 
                  i1 = (int)(this.d - f1);
                  this.n = Math.abs((int)(f1 - this.e));
                  this.d = f1;
                  if (i1 >= 0) {
                    break label218;
                  }
                  if (getScrollX() > 0) {
                    scrollBy(Math.max(-getScrollX(), i1), 0);
                  }
                  bool1 = bool2;
                }
              } while (this.j == null);
              bool1 = bool2;
            } while (this.b <= 0);
            i1 = (int)(this.n % this.m * 1.0D / this.m * 255.0D);
            this.j.a(this.b, false, i1);
            return true;
            bool1 = bool2;
          } while (i1 <= 0);
          if (getChildCount() > 0)
          {
            int i2 = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
            if (i2 > 0) {
              scrollBy(Math.min(i2, i1), 0);
            }
          }
          bool1 = bool2;
        } while (this.j == null);
        bool1 = bool2;
      } while (this.b >= getChildCount() - 1);
      int i1 = (int)(this.n % this.m * 1.0D / this.m * 255.0D);
      this.j.a(this.b, true, i1);
      return true;
      if ((f1 - this.e > this.c * 4) && (this.b > 0)) {
        a(this.b - 1);
      }
      for (;;)
      {
        if (this.i != null) {
          this.i.a(false);
        }
        this.f = 0;
        return true;
        if ((this.e - f1 > this.c * 4) && (this.b < getChildCount() - 1)) {
          a(this.b + 1);
        } else if (getChildCount() > 0) {
          a();
        }
      }
      this.f = 0;
      bool1 = bool2;
    } while (this.i == null);
    this.i.a(false);
    return true;
  }
  
  public void setOnScrollListener(a parama)
  {
    this.j = parama;
  }
  
  public void setOnScrollPageChangeListener(b paramb)
  {
    this.h = paramb;
  }
  
  public void setOnScrollPageTouchListener(c paramc)
  {
    this.i = paramc;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, boolean paramBoolean, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\ScrollLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */