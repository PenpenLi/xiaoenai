package com.xiaoenai.app.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class AutoScrollViewPager
  extends ViewPager
{
  private long a = 1500L;
  private int b = 1;
  private boolean c = true;
  private boolean d = true;
  private int e = 0;
  private boolean f = true;
  private double g = 1.0D;
  private double h = 1.0D;
  private Handler i;
  private boolean j = false;
  private boolean k = false;
  private float l = 0.0F;
  private float m = 0.0F;
  private a n = null;
  
  public AutoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void a(long paramLong)
  {
    this.i.removeMessages(0);
    this.i.sendEmptyMessageDelayed(0, paramLong);
  }
  
  private void d()
  {
    this.i = new b(this);
    e();
  }
  
  private void e()
  {
    try
    {
      Field localField1 = ViewPager.class.getDeclaredField("mScroller");
      localField1.setAccessible(true);
      Field localField2 = ViewPager.class.getDeclaredField("sInterpolator");
      localField2.setAccessible(true);
      this.n = new a(getContext(), (Interpolator)localField2.get(null));
      localField1.set(this, this.n);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.j = true;
    a((this.a + this.n.getDuration() / this.g * this.h));
  }
  
  public void b()
  {
    this.j = false;
    this.i.removeMessages(0);
  }
  
  public void c()
  {
    PagerAdapter localPagerAdapter = getAdapter();
    int i1 = getCurrentItem();
    int i2;
    if (localPagerAdapter != null)
    {
      i2 = localPagerAdapter.getCount();
      if (i2 > 1) {
        break label25;
      }
    }
    label25:
    label66:
    do
    {
      return;
      if (this.b == 0) {
        i1 -= 1;
      }
      for (;;)
      {
        if (i1 >= 0) {
          break label66;
        }
        if (!this.c) {
          break;
        }
        setCurrentItem(i2 - 1, this.f);
        return;
        i1 += 1;
      }
      if (i1 != i2) {
        break;
      }
    } while (!this.c);
    setCurrentItem(0, this.f);
    return;
    setCurrentItem(i1, true);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i2;
    PagerAdapter localPagerAdapter;
    if (this.d)
    {
      if ((i1 == 0) && (this.j))
      {
        this.k = true;
        b();
      }
    }
    else
    {
      if ((this.e != 2) && (this.e != 1)) {
        break label211;
      }
      this.l = paramMotionEvent.getX();
      if (paramMotionEvent.getAction() == 0) {
        this.m = this.l;
      }
      i2 = getCurrentItem();
      localPagerAdapter = getAdapter();
      if (localPagerAdapter != null) {
        break label171;
      }
      i1 = 0;
      label88:
      if (((i2 != 0) || (this.m > this.l)) && ((i2 != i1 - 1) || (this.m < this.l))) {
        break label211;
      }
      if (this.e != 2) {
        break label179;
      }
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getAction() != 1) || (!this.k)) {
        break;
      }
      a();
      break;
      label171:
      i1 = localPagerAdapter.getCount();
      break label88;
      label179:
      if (i1 > 1) {
        setCurrentItem(i1 - i2 - 1, this.f);
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    label211:
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int getDirection()
  {
    if (this.b == 0) {
      return 0;
    }
    return 1;
  }
  
  public long getInterval()
  {
    return this.a;
  }
  
  public int getSlideBorderMode()
  {
    return this.e;
  }
  
  public void setAutoScrollDurationFactor(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public void setBorderAnimation(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setCycle(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setDirection(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setInterval(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setSlideBorderMode(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setStopScrollWhenTouch(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setSwipeScrollDurationFactor(double paramDouble)
  {
    this.h = paramDouble;
  }
  
  private class a
    extends Scroller
  {
    private double b = 1.0D;
    
    public a(Context paramContext, Interpolator paramInterpolator)
    {
      super(paramInterpolator);
    }
    
    public void a(double paramDouble)
    {
      this.b = paramDouble;
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, (int)(paramInt5 * this.b));
    }
  }
  
  private static class b
    extends Handler
  {
    private final WeakReference<AutoScrollViewPager> a;
    
    public b(AutoScrollViewPager paramAutoScrollViewPager)
    {
      this.a = new WeakReference(paramAutoScrollViewPager);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        paramMessage = (AutoScrollViewPager)this.a.get();
      } while (paramMessage == null);
      AutoScrollViewPager.b(paramMessage).a(AutoScrollViewPager.a(paramMessage));
      paramMessage.c();
      AutoScrollViewPager.b(paramMessage).a(AutoScrollViewPager.c(paramMessage));
      AutoScrollViewPager.a(paramMessage, AutoScrollViewPager.d(paramMessage) + AutoScrollViewPager.b(paramMessage).getDuration());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\AutoScrollViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */