package com.inmobi.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class ao
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  private static final String a = ao.class.getSimpleName();
  private ViewPager b;
  private Point c = new Point();
  private Point d = new Point();
  private boolean e;
  @Nullable
  private a f;
  
  public ao(Context paramContext)
  {
    super(paramContext);
    setClipChildren(false);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.b = new ViewPager(getContext());
    this.b.addOnPageChangeListener(this);
    addView(this.b);
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int j = 0;
    int i = this.b.getCurrentItem();
    int n = this.b.getAdapter().getCount();
    int k = this.b.getWidth();
    int m = getWidth();
    if ((i == 0) || (n - 1 == i))
    {
      m -= k;
      if (i == 0)
      {
        i = j;
        if (paramFloat1 > m)
        {
          i = j;
          if (paramFloat2 > m) {
            i = (int)Math.ceil((paramFloat2 - m) / k);
          }
        }
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
            return i;
            i = j;
          } while (paramFloat1 >= m);
          i = j;
        } while (paramFloat2 >= m);
        return -(int)Math.ceil((m - paramFloat2) / k);
        i = (m - k) / 2;
        if ((paramFloat1 < i) && (paramFloat2 < i)) {
          return -(int)Math.ceil((i - paramFloat2) / k);
        }
        m = (m + k) / 2;
        i = j;
      } while (paramFloat1 <= m);
      i = j;
    } while (paramFloat2 <= m);
    return (int)Math.ceil((paramFloat2 - m) / k);
  }
  
  void a()
  {
    this.f = null;
  }
  
  @TargetApi(14)
  public void a(@NonNull v paramv, @NonNull y paramy, int paramInt1, int paramInt2, @NonNull a parama)
  {
    paramv = (FrameLayout.LayoutParams)aj.a(paramv.a(0), this);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramv.setMarginStart(20);
      paramv.setMarginEnd(20);
    }
    for (;;)
    {
      paramv.gravity = paramInt2;
      this.b.setLayoutParams(paramv);
      this.b.setAdapter(paramy);
      this.b.setOffscreenPageLimit(2);
      this.b.setPageMargin(16);
      this.b.setCurrentItem(paramInt1);
      this.f = parama;
      return;
      paramv.setMargins(20, 0, 20, 0);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      return;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.e) {
      invalidate();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Page Selected:" + paramInt);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    if (this.f != null)
    {
      localLayoutParams.gravity = this.f.a(paramInt);
      this.b.requestLayout();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.x = (paramInt1 / 2);
    this.c.y = (paramInt2 / 2);
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      paramMotionEvent.offsetLocation(this.c.x - this.d.x, this.c.y - this.d.y);
      for (;;)
      {
        return this.b.dispatchTouchEvent(paramMotionEvent);
        int i = a(this.d.x, paramMotionEvent.getX());
        if (i != 0)
        {
          paramMotionEvent.setAction(3);
          this.b.setCurrentItem(i + this.b.getCurrentItem());
        }
        paramMotionEvent.offsetLocation(this.c.x - this.d.x, this.c.y - this.d.y);
      }
      this.d.x = ((int)paramMotionEvent.getX());
      this.d.y = ((int)paramMotionEvent.getY());
    }
  }
  
  static abstract interface a
  {
    public abstract int a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */