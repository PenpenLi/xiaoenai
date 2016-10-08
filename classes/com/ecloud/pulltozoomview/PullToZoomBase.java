package com.ecloud.pulltozoomview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.xiaoenai.app.R.styleable;

public abstract class PullToZoomBase<T extends View>
  extends LinearLayout
  implements a<T>
{
  protected T a;
  protected View b;
  protected View c;
  protected int d;
  protected int e;
  private boolean f = true;
  private boolean g = true;
  private boolean h = false;
  private boolean i = false;
  private int j;
  private boolean k = false;
  private float l;
  private float m;
  private float n;
  private float o;
  private a p;
  
  public PullToZoomBase(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PullToZoomBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    setGravity(17);
    this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.d = localDisplayMetrics.heightPixels;
    this.e = localDisplayMetrics.widthPixels;
    this.a = a(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = LayoutInflater.from(getContext());
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.PullToZoomView);
      int i1 = paramAttributeSet.getResourceId(2, 0);
      if (i1 > 0) {
        this.c = paramContext.inflate(i1, null, false);
      }
      i1 = paramAttributeSet.getResourceId(0, 0);
      if (i1 > 0) {
        this.b = paramContext.inflate(i1, null, false);
      }
      this.g = paramAttributeSet.getBoolean(3, true);
      a(paramAttributeSet);
      paramAttributeSet.recycle();
    }
    addView(this.a, -1, -1);
  }
  
  private void g()
  {
    int i1 = Math.round(Math.min(this.n - this.l, 0.0F) / 2.0F);
    a(i1);
    if (this.p != null) {
      this.p.a(i1);
    }
  }
  
  protected abstract T a(Context paramContext, AttributeSet paramAttributeSet);
  
  protected abstract void a(int paramInt);
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  protected abstract void e();
  
  protected abstract boolean f();
  
  public View getHeaderView()
  {
    return this.b;
  }
  
  public T getPullRootView()
  {
    return this.a;
  }
  
  public View getZoomView()
  {
    return this.c;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!a()) || (d())) {
      bool = false;
    }
    int i1;
    do
    {
      return bool;
      i1 = paramMotionEvent.getAction();
      if ((i1 == 3) || (i1 == 1))
      {
        this.k = false;
        return false;
      }
    } while ((i1 != 0) && (this.k));
    switch (i1)
    {
    }
    for (;;)
    {
      return this.k;
      if (f())
      {
        float f1 = paramMotionEvent.getY();
        float f2 = paramMotionEvent.getX();
        float f3 = f1 - this.l;
        float f4 = this.m;
        float f5 = Math.abs(f3);
        if ((f5 > this.j) && (f5 > Math.abs(f2 - f4)) && (f3 >= 1.0F) && (f()))
        {
          this.l = f1;
          this.m = f2;
          this.k = true;
          continue;
          if (f())
          {
            f1 = paramMotionEvent.getY();
            this.n = f1;
            this.l = f1;
            f1 = paramMotionEvent.getX();
            this.o = f1;
            this.m = f1;
            this.k = false;
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if ((!a()) || (d())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          }
        } while (!f());
        float f1 = paramMotionEvent.getY();
        this.n = f1;
        this.l = f1;
        f1 = paramMotionEvent.getX();
        this.o = f1;
        this.m = f1;
        return true;
      } while (!this.k);
      this.l = paramMotionEvent.getY();
      this.m = paramMotionEvent.getX();
      g();
      this.h = true;
      return true;
    } while (!this.k);
    this.k = false;
    if (b())
    {
      e();
      if (this.p != null) {
        this.p.a();
      }
      this.h = false;
      return true;
    }
    return true;
  }
  
  public abstract void setHeaderView(View paramView);
  
  public void setHideHeader(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setOnPullZoomListener(a parama)
  {
    this.p = parama;
  }
  
  public void setParallax(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setZoomEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public abstract void setZoomView(View paramView);
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\PullToZoomBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */