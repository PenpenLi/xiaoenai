package com.xiaoenai.app.widget.wheel;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class f
{
  private a a;
  private Context b;
  private GestureDetector c = new GestureDetector(paramContext, this.h);
  private Scroller d;
  private int e;
  private float f;
  private boolean g;
  private GestureDetector.SimpleOnGestureListener h = new g(this);
  private final int i = 0;
  private final int j = 1;
  private Handler k = new h(this);
  
  public f(Context paramContext, a parama)
  {
    this.c.setIsLongpressEnabled(false);
    this.d = new Scroller(paramContext);
    this.a = parama;
    this.b = paramContext;
  }
  
  private void a(int paramInt)
  {
    c();
    this.k.sendEmptyMessage(paramInt);
  }
  
  private void c()
  {
    this.k.removeMessages(0);
    this.k.removeMessages(1);
  }
  
  private void d()
  {
    this.a.c();
    a(1);
  }
  
  private void e()
  {
    if (!this.g)
    {
      this.g = true;
      this.a.a();
    }
  }
  
  public void a()
  {
    this.d.forceFinished(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d.forceFinished(true);
    this.e = 0;
    Scroller localScroller = this.d;
    if (paramInt2 != 0) {}
    for (;;)
    {
      localScroller.startScroll(0, 0, 0, paramInt1, paramInt2);
      a(0);
      e();
      return;
      paramInt2 = 400;
    }
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.d.forceFinished(true);
    this.d = new Scroller(this.b, paramInterpolator);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if ((!this.c.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1)) {
        d();
      }
      return true;
      this.f = paramMotionEvent.getY();
      this.d.forceFinished(true);
      c();
      continue;
      int m = (int)(paramMotionEvent.getY() - this.f);
      if (m != 0)
      {
        e();
        this.a.a(m);
        this.f = paramMotionEvent.getY();
      }
    }
  }
  
  void b()
  {
    if (this.g)
    {
      this.a.b();
      this.g = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\wheel\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */