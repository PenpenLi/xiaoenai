package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.internal.a;
import com.handmark.pulltorefresh.library.internal.f;

public class PullToRefreshListView
  extends PullToRefreshAdapterViewBase<ListView>
{
  private f b;
  private f c;
  private FrameLayout d;
  private boolean e;
  
  public PullToRefreshListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }
  
  public PullToRefreshListView(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected ListView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return new b(paramContext, paramAttributeSet);
    }
    return new a(paramContext, paramAttributeSet);
  }
  
  protected c a(boolean paramBoolean1, boolean paramBoolean2)
  {
    c localc = super.a(paramBoolean1, paramBoolean2);
    if (this.e)
    {
      PullToRefreshBase.b localb = getMode();
      if ((paramBoolean1) && (localb.c())) {
        localc.a(this.b);
      }
      if ((paramBoolean2) && (localb.d())) {
        localc.a(this.c);
      }
    }
    return localc;
  }
  
  protected void a()
  {
    int j = 0;
    int i = 1;
    if (!this.e)
    {
      super.a();
      return;
    }
    f localf2;
    f localf1;
    int k;
    switch (j.a[getCurrentMode().ordinal()])
    {
    default: 
      localf2 = getHeaderLayout();
      localf1 = this.b;
      k = -getHeaderSize();
      if (Math.abs(((ListView)this.a).getFirstVisiblePosition() - 0) > 1) {
        break;
      }
    }
    for (;;)
    {
      if (localf1.getVisibility() == 0)
      {
        localf2.j();
        localf1.setVisibility(8);
        if ((i != 0) && (getState() != PullToRefreshBase.j.e))
        {
          ((ListView)this.a).setSelection(j);
          setHeaderScroll(k);
        }
      }
      super.a();
      return;
      localf2 = getFooterLayout();
      localf1 = this.c;
      j = ((ListView)this.a).getCount() - 1;
      k = getFooterSize();
      if (Math.abs(((ListView)this.a).getLastVisiblePosition() - j) <= 1) {}
      for (i = 1;; i = 0) {
        break;
      }
      i = 0;
    }
  }
  
  protected void a(TypedArray paramTypedArray)
  {
    super.a(paramTypedArray);
    this.e = paramTypedArray.getBoolean(l.g.PullToRefresh_ptrListViewExtrasEnabled, true);
    if (this.e)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      this.b = a(getContext(), PullToRefreshBase.b.b, paramTypedArray);
      this.b.setVisibility(8);
      localFrameLayout.addView(this.b, localLayoutParams);
      ((ListView)this.a).addHeaderView(localFrameLayout, null, false);
      this.d = new FrameLayout(getContext());
      this.c = a(getContext(), PullToRefreshBase.b.c, paramTypedArray);
      this.c.setVisibility(8);
      this.d.addView(this.c, localLayoutParams);
      if (!paramTypedArray.hasValue(l.g.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
        setScrollingWhileRefreshingEnabled(true);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = ((ListView)this.a).getAdapter();
    if ((!this.e) || (!getShowViewWhileRefreshing()) || (localObject == null))
    {
      super.a(paramBoolean);
      return;
    }
    super.a(false);
    f localf1;
    f localf2;
    int i;
    int j;
    switch (j.a[getCurrentMode().ordinal()])
    {
    default: 
      localObject = getHeaderLayout();
      localf1 = this.b;
      localf2 = this.c;
      i = getScrollY() + getHeaderSize();
      j = 0;
    }
    for (;;)
    {
      ((f)localObject).i();
      ((f)localObject).e();
      localf2.setVisibility(8);
      localf1.setVisibility(0);
      localf1.g();
      if (!paramBoolean) {
        break;
      }
      m();
      setHeaderScroll(i);
      ((ListView)this.a).setSelection(j);
      a(0);
      return;
      localObject = getFooterLayout();
      localf1 = this.c;
      localf2 = this.b;
      j = ((ListView)this.a).getCount() - 1;
      i = getScrollY() - getFooterSize();
    }
  }
  
  protected ListView b(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = a(paramContext, paramAttributeSet);
    paramContext.setId(16908298);
    return paramContext;
  }
  
  public final PullToRefreshBase.h getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.h.a;
  }
  
  protected class a
    extends ListView
    implements a
  {
    private boolean b = false;
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        return;
      }
      catch (IndexOutOfBoundsException paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      try
      {
        boolean bool = super.dispatchTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (IndexOutOfBoundsException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      if ((PullToRefreshListView.a(PullToRefreshListView.this) != null) && (!this.b))
      {
        addFooterView(PullToRefreshListView.a(PullToRefreshListView.this), null, false);
        this.b = true;
      }
      super.setAdapter(paramListAdapter);
    }
    
    public void setEmptyView(View paramView)
    {
      PullToRefreshListView.this.setEmptyView(paramView);
    }
    
    public void setEmptyViewInternal(View paramView)
    {
      super.setEmptyView(paramView);
    }
  }
  
  @TargetApi(9)
  final class b
    extends PullToRefreshListView.a
  {
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramContext, paramAttributeSet);
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      d.a(PullToRefreshListView.this, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
      return bool;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\PullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */