package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.internal.a;
import com.handmark.pulltorefresh.library.internal.d;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView>
  extends PullToRefreshBase<T>
  implements AbsListView.OnScrollListener
{
  private boolean b;
  private AbsListView.OnScrollListener c;
  private PullToRefreshBase.c d;
  private View e;
  private d f;
  private d g;
  private boolean h;
  private boolean i = true;
  
  public PullToRefreshAdapterViewBase(Context paramContext)
  {
    super(paramContext);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
    ((AbsListView)this.a).setOnScrollListener(this);
  }
  
  private static FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout.LayoutParams localLayoutParams = null;
    if (paramLayoutParams != null)
    {
      localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
        localLayoutParams.gravity = ((LinearLayout.LayoutParams)paramLayoutParams).gravity;
      }
    }
    else
    {
      return localLayoutParams;
    }
    localLayoutParams.gravity = 17;
    return localLayoutParams;
  }
  
  private boolean getShowIndicatorInternal()
  {
    return (this.h) && (h());
  }
  
  private void o()
  {
    Object localObject = getMode();
    FrameLayout localFrameLayout = getRefreshableViewWrapper();
    if ((((PullToRefreshBase.b)localObject).c()) && (this.f == null))
    {
      this.f = new d(getContext(), PullToRefreshBase.b.b);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = getResources().getDimensionPixelSize(l.b.indicator_right_padding);
      localLayoutParams.gravity = 53;
      localFrameLayout.addView(this.f, localLayoutParams);
    }
    do
    {
      while ((((PullToRefreshBase.b)localObject).d()) && (this.g == null))
      {
        this.g = new d(getContext(), PullToRefreshBase.b.c);
        localObject = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject).rightMargin = getResources().getDimensionPixelSize(l.b.indicator_right_padding);
        ((FrameLayout.LayoutParams)localObject).gravity = 85;
        localFrameLayout.addView(this.g, (ViewGroup.LayoutParams)localObject);
        return;
        if ((!((PullToRefreshBase.b)localObject).c()) && (this.f != null))
        {
          localFrameLayout.removeView(this.f);
          this.f = null;
        }
      }
    } while ((((PullToRefreshBase.b)localObject).d()) || (this.g == null));
    localFrameLayout.removeView(this.g);
    this.g = null;
  }
  
  private boolean p()
  {
    Object localObject = ((AbsListView)this.a).getAdapter();
    if ((localObject == null) || (((Adapter)localObject).isEmpty())) {
      return true;
    }
    int k = ((AbsListView)this.a).getCount();
    int j = ((AbsListView)this.a).getLastVisiblePosition();
    if (j >= k - 1 - 1)
    {
      k = ((AbsListView)this.a).getFirstVisiblePosition();
      localObject = ((AbsListView)this.a).getChildAt(j - k);
      if (localObject != null) {
        return ((View)localObject).getBottom() <= ((AbsListView)this.a).getBottom();
      }
    }
    return false;
  }
  
  private void q()
  {
    if (this.f != null)
    {
      getRefreshableViewWrapper().removeView(this.f);
      this.f = null;
    }
    if (this.g != null)
    {
      getRefreshableViewWrapper().removeView(this.g);
      this.g = null;
    }
  }
  
  private void r()
  {
    if (this.f != null)
    {
      if ((j()) || (!d())) {
        break label77;
      }
      if (!this.f.a()) {
        this.f.c();
      }
    }
    label77:
    do
    {
      for (;;)
      {
        if (this.g != null)
        {
          if ((j()) || (!e())) {
            break;
          }
          if (!this.g.a()) {
            this.g.c();
          }
        }
        return;
        if (this.f.a()) {
          this.f.b();
        }
      }
    } while (!this.g.a());
    this.g.b();
  }
  
  protected void a()
  {
    super.a();
    if (getShowIndicatorInternal()) {
      r();
    }
  }
  
  protected void a(TypedArray paramTypedArray)
  {
    this.h = paramTypedArray.getBoolean(l.g.PullToRefresh_ptrShowIndicator, false);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (getShowIndicatorInternal()) {
      r();
    }
  }
  
  protected void b()
  {
    super.b();
    if (getShowIndicatorInternal()) {}
    switch (f.a[getCurrentMode().ordinal()])
    {
    default: 
      return;
    case 1: 
      this.g.e();
      return;
    }
    this.f.e();
  }
  
  protected void c()
  {
    super.c();
    if (getShowIndicatorInternal()) {}
    switch (f.a[getCurrentMode().ordinal()])
    {
    default: 
      return;
    case 1: 
      this.g.d();
      return;
    }
    this.f.d();
  }
  
  protected boolean d()
  {
    return g();
  }
  
  protected boolean e()
  {
    return p();
  }
  
  protected void f()
  {
    super.f();
    if (getShowIndicatorInternal())
    {
      o();
      return;
    }
    q();
  }
  
  protected boolean g()
  {
    Object localObject = ((AbsListView)this.a).getAdapter();
    if ((localObject == null) || (((Adapter)localObject).isEmpty())) {
      return true;
    }
    if (((AbsListView)this.a).getFirstVisiblePosition() <= 1)
    {
      localObject = ((AbsListView)this.a).getChildAt(0);
      if (localObject != null) {
        return ((View)localObject).getTop() >= ((AbsListView)this.a).getTop();
      }
    }
    return false;
  }
  
  public boolean getShowIndicator()
  {
    return this.h;
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.d != null) {
      if ((paramInt3 <= 0) || (paramInt1 + paramInt2 < paramInt3 - 1)) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      if (getShowIndicatorInternal()) {
        r();
      }
      if (this.c != null) {
        this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.e != null) && (!this.i)) {
      this.e.scrollTo(-paramInt1, -paramInt2);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.d != null) && (this.b)) {
      this.d.a();
    }
    if (this.c != null) {
      this.c.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ((AdapterView)this.a).setAdapter(paramListAdapter);
  }
  
  public final void setEmptyView(View paramView)
  {
    FrameLayout localFrameLayout = getRefreshableViewWrapper();
    if (paramView != null)
    {
      paramView.setClickable(true);
      Object localObject = paramView.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(paramView);
      }
      localObject = a(paramView.getLayoutParams());
      if (localObject != null) {
        localFrameLayout.addView(paramView, (ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      if (!(this.a instanceof a)) {
        break label93;
      }
      ((a)this.a).setEmptyViewInternal(paramView);
    }
    for (;;)
    {
      this.e = paramView;
      return;
      localFrameLayout.addView(paramView);
      break;
      label93:
      ((AbsListView)this.a).setEmptyView(paramView);
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ((AbsListView)this.a).setOnItemClickListener(paramOnItemClickListener);
  }
  
  public final void setOnLastItemVisibleListener(PullToRefreshBase.c paramc)
  {
    this.d = paramc;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.c = paramOnScrollListener;
  }
  
  public final void setScrollEmptyView(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setShowIndicator(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (getShowIndicatorInternal())
    {
      o();
      return;
    }
    q();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\PullToRefreshAdapterViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */