package com.ecloud.pulltozoomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;

public class PullToZoomRecyclerViewEx
  extends PullToZoomBase<RecyclerView>
  implements AbsListView.OnScrollListener
{
  private static final String f = PullToZoomRecyclerViewEx.class.getSimpleName();
  private static final Interpolator j = new c();
  private FrameLayout g;
  private int h;
  private a i;
  
  public PullToZoomRecyclerViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((RecyclerView)this.a).setOnScrollListener(new d(this));
    this.i = new a();
  }
  
  private void i()
  {
    if ((this.g != null) && (this.a != null) && (((RecyclerView)this.a).getAdapter() != null))
    {
      i locali = (i)((RecyclerView)this.a).getAdapter();
      if ((locali != null) && (locali.a(0) != null)) {
        locali.b(locali.a(0));
      }
    }
  }
  
  private void j()
  {
    if ((this.g != null) && (this.a != null) && (((RecyclerView)this.a).getAdapter() != null))
    {
      i locali = (i)((RecyclerView)this.a).getAdapter();
      if (locali != null)
      {
        if (locali.a(0) != null) {
          locali.b(locali.a(0));
        }
        this.g.removeAllViews();
        if (this.c != null) {
          this.g.addView(this.c);
        }
        if (this.b != null) {
          this.g.addView(this.b);
        }
        this.h = this.g.getHeight();
        locali.a(new i.a(0, new e(this, this.g)));
      }
    }
  }
  
  private boolean k()
  {
    if (this.a != null)
    {
      Object localObject2 = ((RecyclerView)this.a).getAdapter();
      Object localObject1 = (GridLayoutManager)((RecyclerView)this.a).getLayoutManager();
      if ((localObject2 == null) || (((RecyclerView.Adapter)localObject2).getItemCount() == 0)) {
        return true;
      }
      localObject2 = new int[2];
      Object tmp50_49 = localObject2;
      tmp50_49[0] = 0;
      Object tmp54_50 = tmp50_49;
      tmp54_50[1] = 0;
      tmp54_50;
      if (localObject1 != null) {
        localObject2[0] = ((GridLayoutManager)localObject1).findFirstVisibleItemPosition();
      }
      if ((localObject2.length > 0) && (localObject2.length > 0) && (localObject2[0] <= 1))
      {
        localObject1 = ((RecyclerView)this.a).getChildAt(0);
        if (localObject1 != null) {
          return ((View)localObject1).getTop() >= ((RecyclerView)this.a).getTop();
        }
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
    paramTypedArray = (i)((RecyclerView)this.a).getAdapter();
    if (paramTypedArray != null) {
      paramTypedArray.a(new i.a(0, new f(this, this.g)));
    }
  }
  
  protected RecyclerView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView(paramContext, paramAttributeSet);
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
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
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
      if (PullToZoomRecyclerViewEx.this.c != null)
      {
        this.d = SystemClock.currentThreadTimeMillis();
        this.a = paramLong;
        this.c = (PullToZoomRecyclerViewEx.b(PullToZoomRecyclerViewEx.this).getBottom() / PullToZoomRecyclerViewEx.a(PullToZoomRecyclerViewEx.this));
        this.b = false;
        PullToZoomRecyclerViewEx.this.post(this);
      }
    }
    
    public boolean b()
    {
      return this.b;
    }
    
    public void run()
    {
      if ((PullToZoomRecyclerViewEx.this.c != null) && (!this.b) && (this.c > 1.0D))
      {
        float f1 = ((float)SystemClock.currentThreadTimeMillis() - (float)this.d) / (float)this.a;
        float f2 = this.c;
        float f3 = this.c;
        f1 = f2 - PullToZoomRecyclerViewEx.h().getInterpolation(f1) * (f3 - 1.0F);
        ViewGroup.LayoutParams localLayoutParams = PullToZoomRecyclerViewEx.b(PullToZoomRecyclerViewEx.this).getLayoutParams();
        Log.d(PullToZoomRecyclerViewEx.g(), "ScalingRunnable --> f2 = " + f1);
        if (f1 > 1.0F)
        {
          localLayoutParams.height = ((int)(f1 * PullToZoomRecyclerViewEx.a(PullToZoomRecyclerViewEx.this)));
          PullToZoomRecyclerViewEx.b(PullToZoomRecyclerViewEx.this).setLayoutParams(localLayoutParams);
          PullToZoomRecyclerViewEx.this.post(this);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\PullToZoomRecyclerViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */