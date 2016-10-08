package com.ecloud.pulltozoomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;

public class PullToZoomScrollViewEx
  extends PullToZoomBase<ScrollView>
{
  private static final String f = PullToZoomScrollViewEx.class.getSimpleName();
  private static final Interpolator m = new g();
  private boolean g = false;
  private FrameLayout h;
  private LinearLayout i;
  private View j;
  private int k;
  private c l = new c();
  
  public PullToZoomScrollViewEx(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PullToZoomScrollViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((a)this.a).setOnScrollViewChangedListener(new h(this));
  }
  
  private void i()
  {
    if (this.h != null)
    {
      this.h.removeAllViews();
      if (this.c != null) {
        this.h.addView(this.c);
      }
      if (this.b != null) {
        this.h.addView(this.b);
      }
    }
  }
  
  protected void a(int paramInt)
  {
    Log.d(f, "pullHeaderToZoom --> newScrollValue = " + paramInt);
    Log.d(f, "pullHeaderToZoom --> mHeaderHeight = " + this.k);
    if ((this.l != null) && (!this.l.b())) {
      this.l.a();
    }
    ViewGroup.LayoutParams localLayoutParams = this.h.getLayoutParams();
    localLayoutParams.height = (Math.abs(paramInt) + this.k);
    this.h.setLayoutParams(localLayoutParams);
    if (this.g)
    {
      localLayoutParams = this.c.getLayoutParams();
      localLayoutParams.height = (Math.abs(paramInt) + this.k);
      this.c.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(TypedArray paramTypedArray)
  {
    this.i = new LinearLayout(getContext());
    this.i.setOrientation(1);
    this.h = new FrameLayout(getContext());
    if (this.c != null) {
      this.h.addView(this.c);
    }
    if (this.b != null) {
      this.h.addView(this.b);
    }
    int n = paramTypedArray.getResourceId(1, 0);
    if (n > 0) {
      this.j = LayoutInflater.from(getContext()).inflate(n, null, false);
    }
    this.i.addView(this.h);
    if (this.j != null) {
      this.i.addView(this.j);
    }
    this.i.setClipChildren(false);
    this.h.setClipChildren(false);
    ((ScrollView)this.a).addView(this.i);
  }
  
  protected ScrollView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = new a(paramContext, paramAttributeSet);
    paramContext.setId(2131558464);
    return paramContext;
  }
  
  protected void e()
  {
    Log.d(f, "smoothScrollToTop --> ");
    this.l.a(200L);
  }
  
  protected boolean f()
  {
    return ((ScrollView)this.a).getScrollY() == 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d(f, "onLayout --> ");
    if ((this.k == 0) && (this.c != null)) {
      this.k = this.h.getHeight();
    }
  }
  
  public void setHeaderLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    if (this.h != null)
    {
      this.h.setLayoutParams(paramLayoutParams);
      this.k = paramLayoutParams.height;
      this.g = true;
    }
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView != null)
    {
      this.b = paramView;
      i();
    }
  }
  
  public void setHideHeader(boolean paramBoolean)
  {
    if ((paramBoolean != d()) && (this.h != null))
    {
      super.setHideHeader(paramBoolean);
      if (paramBoolean) {
        this.h.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.h.setVisibility(0);
  }
  
  public void setScrollContentView(View paramView)
  {
    if (paramView != null)
    {
      if (this.j != null) {
        this.i.removeView(this.j);
      }
      this.j = paramView;
      this.i.addView(this.j);
    }
  }
  
  public void setZoomView(View paramView)
  {
    if (paramView != null)
    {
      this.c = paramView;
      i();
    }
  }
  
  protected class a
    extends ScrollView
  {
    private PullToZoomScrollViewEx.b b;
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.b != null) {
        this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void setOnScrollViewChangedListener(PullToZoomScrollViewEx.b paramb)
    {
      this.b = paramb;
    }
  }
  
  protected static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  class c
    implements Runnable
  {
    protected long a;
    protected boolean b = true;
    protected float c;
    protected long d;
    
    c() {}
    
    public void a()
    {
      this.b = true;
    }
    
    public void a(long paramLong)
    {
      if (PullToZoomScrollViewEx.this.c != null)
      {
        this.d = SystemClock.currentThreadTimeMillis();
        this.a = paramLong;
        this.c = (PullToZoomScrollViewEx.b(PullToZoomScrollViewEx.this).getBottom() / PullToZoomScrollViewEx.a(PullToZoomScrollViewEx.this));
        this.b = false;
        PullToZoomScrollViewEx.this.post(this);
      }
    }
    
    public boolean b()
    {
      return this.b;
    }
    
    public void run()
    {
      if ((PullToZoomScrollViewEx.this.c != null) && (!this.b) && (this.c > 1.0D))
      {
        float f1 = ((float)SystemClock.currentThreadTimeMillis() - (float)this.d) / (float)this.a;
        float f2 = this.c;
        float f3 = this.c;
        f1 = f2 - PullToZoomScrollViewEx.h().getInterpolation(f1) * (f3 - 1.0F);
        ViewGroup.LayoutParams localLayoutParams = PullToZoomScrollViewEx.b(PullToZoomScrollViewEx.this).getLayoutParams();
        Log.d(PullToZoomScrollViewEx.g(), "ScalingRunnable --> f2 = " + f1);
        if (f1 > 1.0F)
        {
          localLayoutParams.height = ((int)(PullToZoomScrollViewEx.a(PullToZoomScrollViewEx.this) * f1));
          PullToZoomScrollViewEx.b(PullToZoomScrollViewEx.this).setLayoutParams(localLayoutParams);
          if (PullToZoomScrollViewEx.c(PullToZoomScrollViewEx.this))
          {
            localLayoutParams = PullToZoomScrollViewEx.this.c.getLayoutParams();
            localLayoutParams.height = ((int)(f1 * PullToZoomScrollViewEx.a(PullToZoomScrollViewEx.this)));
            PullToZoomScrollViewEx.this.c.setLayoutParams(localLayoutParams);
          }
          PullToZoomScrollViewEx.this.post(this);
        }
      }
      else
      {
        return;
      }
      this.b = true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\PullToZoomScrollViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */