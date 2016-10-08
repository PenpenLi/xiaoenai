package com.ecloud.pulltozoomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PullToZoomListViewEx
  extends PullToZoomBase<ListView>
  implements AbsListView.OnScrollListener
{
  private static final String f = PullToZoomListViewEx.class.getSimpleName();
  private static final Interpolator j = new b();
  private FrameLayout g;
  private int h;
  private a i;
  
  public PullToZoomListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((ListView)this.a).setOnScrollListener(this);
    this.i = new a();
  }
  
  private void i()
  {
    if (this.g != null) {
      ((ListView)this.a).removeHeaderView(this.g);
    }
  }
  
  private void j()
  {
    if (this.g != null)
    {
      ((ListView)this.a).removeHeaderView(this.g);
      this.g.removeAllViews();
      if (this.c != null) {
        this.g.addView(this.c);
      }
      if (this.b != null) {
        this.g.addView(this.b);
      }
      this.h = this.g.getHeight();
      ((ListView)this.a).addHeaderView(this.g);
    }
  }
  
  private boolean k()
  {
    Object localObject = ((ListView)this.a).getAdapter();
    if ((localObject == null) || (((Adapter)localObject).isEmpty())) {
      return true;
    }
    if (((ListView)this.a).getFirstVisiblePosition() <= 1)
    {
      localObject = ((ListView)this.a).getChildAt(0);
      if (localObject != null) {
        return ((View)localObject).getTop() >= ((ListView)this.a).getTop();
      }
    }
    return false;
  }
  
  protected void a(int paramInt)
  {
    Log.d(f, "pullHeaderToZoom --> newScrollValue = " + paramInt);
    Log.d(f, "pullHeaderToZoom --> mHeaderHeight = " + this.h);
    if ((this.i != null) && (!this.i.b())) {
      this.i.a();
    }
    ViewGroup.LayoutParams localLayoutParams = this.g.getLayoutParams();
    localLayoutParams.height = (Math.abs(paramInt) + this.h);
    this.g.setLayoutParams(localLayoutParams);
  }
  
  public void a(TypedArray paramTypedArray)
  {
    this.g = new FrameLayout(getContext());
    if (this.c != null) {
      this.g.addView(this.c);
    }
    if (this.b != null) {
      this.g.addView(this.b);
    }
    ((ListView)this.a).addHeaderView(this.g);
  }
  
  protected ListView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = new ListView(paramContext, paramAttributeSet);
    paramContext.setId(16908298);
    return paramContext;
  }
  
  protected void e()
  {
    Log.d(f, "smoothScrollToTop --> ");
    this.i.a(200L);
  }
  
  protected boolean f()
  {
    return k();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d(f, "onLayout --> ");
    if ((this.h == 0) && (this.g != null)) {
      this.h = this.g.getHeight();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c != null) && (!d()) && (a()))
    {
      float f1 = this.h - this.g.getBottom();
      Log.d(f, "onScroll --> f = " + f1);
      if (c())
      {
        if ((f1 <= 0.0F) || (f1 >= this.h)) {
          break label108;
        }
        paramInt1 = (int)(f1 * 0.65D);
        this.g.scrollTo(0, -paramInt1);
      }
    }
    label108:
    while (this.g.getScrollY() == 0) {
      return;
    }
    this.g.scrollTo(0, 0);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    Log.d(f, "onScrollStateChanged --> ");
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ((ListView)this.a).setAdapter(paramListAdapter);
  }
  
  public void setHeaderLayoutParams(AbsListView.LayoutParams paramLayoutParams)
  {
    if (this.g != null)
    {
      this.g.setLayoutParams(paramLayoutParams);
      this.h = paramLayoutParams.height;
    }
  }
  
  public void setHeaderView(View paramView)
  {
    if (paramView != null)
    {
      this.b = paramView;
      j();
    }
  }
  
  public void setHideHeader(boolean paramBoolean)
  {
    if (paramBoolean != d())
    {
      super.setHideHeader(paramBoolean);
      if (paramBoolean) {
        i();
      }
    }
    else
    {
      return;
    }
    j();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ((ListView)this.a).setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void setZoomView(View paramView)
  {
    if (paramView != null)
    {
      this.c = paramView;
      j();
    }
  }
  
  class a
    implements Runnable
  {
    protected long a;
    protected boolean b = true;
    protected float c;
    protected long d;
    
    a() {}
    
    public void a()
    {
      this.b = true;
    }
    
    public void a(long paramLong)
    {
      if (PullToZoomListViewEx.this.c != null)
      {
        this.d = SystemClock.currentThreadTimeMillis();
        this.a = paramLong;
        this.c = (PullToZoomListViewEx.a(PullToZoomListViewEx.this).getBottom() / PullToZoomListViewEx.b(PullToZoomListViewEx.this));
        this.b = false;
        PullToZoomListViewEx.this.post(this);
      }
    }
    
    public boolean b()
    {
      return this.b;
    }
    
    public void run()
    {
      if ((PullToZoomListViewEx.this.c != null) && (!this.b) && (this.c > 1.0D))
      {
        float f1 = ((float)SystemClock.currentThreadTimeMillis() - (float)this.d) / (float)this.a;
        float f2 = this.c;
        float f3 = this.c;
        f1 = f2 - PullToZoomListViewEx.g().getInterpolation(f1) * (f3 - 1.0F);
        ViewGroup.LayoutParams localLayoutParams = PullToZoomListViewEx.a(PullToZoomListViewEx.this).getLayoutParams();
        Log.d(PullToZoomListViewEx.h(), "ScalingRunnable --> f2 = " + f1);
        if (f1 > 1.0F)
        {
          localLayoutParams.height = ((int)(f1 * PullToZoomListViewEx.b(PullToZoomListViewEx.this)));
          PullToZoomListViewEx.a(PullToZoomListViewEx.this).setLayoutParams(localLayoutParams);
          PullToZoomListViewEx.this.post(this);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\PullToZoomListViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */