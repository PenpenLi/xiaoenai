package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class PullToRefreshView
  extends RelativeLayout
{
  private f a;
  private View b;
  private View c;
  private int d;
  private int e;
  private float f;
  private boolean g;
  private boolean h;
  private Runnable i;
  private long j;
  
  public PullToRefreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PullToRefreshView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent)
  {
    return MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 3, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState());
  }
  
  private void a()
  {
    this.i = new g(this);
  }
  
  private void b()
  {
    this.j = System.currentTimeMillis();
    this.g = true;
    if (this.a != null) {
      this.a.d();
    }
  }
  
  private void c()
  {
    this.g = false;
  }
  
  private void d()
  {
    this.e = 0;
    scrollTo(0, 0);
    if (this.a != null) {
      this.a.e();
    }
  }
  
  private boolean e()
  {
    return (!this.h) && (this.a.c());
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent;
    switch (paramMotionEvent.getAction())
    {
    default: 
      localMotionEvent = paramMotionEvent;
    }
    for (;;)
    {
      return super.dispatchTouchEvent(localMotionEvent);
      this.f = paramMotionEvent.getY();
      localMotionEvent = paramMotionEvent;
      continue;
      float f1 = paramMotionEvent.getY();
      if (!this.g)
      {
        localMotionEvent = paramMotionEvent;
        if (!e()) {}
      }
      else
      {
        this.e = ((int)(this.e + (f1 - this.f) / 2.0F));
        if (this.e <= 0) {
          break label161;
        }
        scrollTo(0, -this.e);
        if ((!this.g) && (this.a != null)) {
          this.a.a(this.e * 100 / this.d);
        }
      }
      for (localMotionEvent = a(paramMotionEvent);; localMotionEvent = paramMotionEvent)
      {
        this.f = f1;
        break;
        label161:
        this.e = 0;
        scrollTo(0, 0);
      }
      if (!this.g)
      {
        if (this.e > this.d)
        {
          this.e = this.d;
          scrollTo(0, -this.e);
          if (this.a != null) {
            this.a.a(100);
          }
          b();
          localMotionEvent = a(paramMotionEvent);
        }
        else
        {
          localMotionEvent = paramMotionEvent;
          if (this.e != 0)
          {
            d();
            localMotionEvent = paramMotionEvent;
            if (this.a != null)
            {
              this.a.a(0);
              localMotionEvent = paramMotionEvent;
            }
          }
        }
      }
      else
      {
        this.e = this.d;
        scrollTo(0, -this.e);
        localMotionEvent = paramMotionEvent;
      }
    }
  }
  
  public void setAdapter(f paramf)
  {
    this.a = paramf;
    removeAllViews();
    this.c = ((View)paramf.b());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(10, -1);
    addView(this.c, localLayoutParams);
    this.b = paramf.a();
    this.b.measure(0, 0);
    this.d = this.b.getMeasuredHeight();
    paramf = new RelativeLayout.LayoutParams(-2, this.d);
    paramf.addRule(9, -1);
    paramf.addRule(11, -1);
    paramf.addRule(10, -1);
    paramf.topMargin = (-this.d);
    addView(this.b, paramf);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\PullToRefreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */