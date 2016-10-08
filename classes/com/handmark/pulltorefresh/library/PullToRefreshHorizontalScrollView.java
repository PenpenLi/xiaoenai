package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

public class PullToRefreshHorizontalScrollView
  extends PullToRefreshBase<HorizontalScrollView>
{
  public PullToRefreshHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected HorizontalScrollView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new a(paramContext, paramAttributeSet);; paramContext = new HorizontalScrollView(paramContext, paramAttributeSet))
    {
      paramContext.setId(l.d.scrollview);
      return paramContext;
    }
  }
  
  protected boolean d()
  {
    return ((HorizontalScrollView)this.a).getScrollX() == 0;
  }
  
  protected boolean e()
  {
    View localView = ((HorizontalScrollView)this.a).getChildAt(0);
    if (localView != null) {
      return ((HorizontalScrollView)this.a).getScrollX() >= localView.getWidth() - getWidth();
    }
    return false;
  }
  
  public final PullToRefreshBase.h getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.h.b;
  }
  
  @TargetApi(9)
  final class a
    extends HorizontalScrollView
  {
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int a()
    {
      int i = 0;
      if (getChildCount() > 0) {
        i = Math.max(0, getChildAt(0).getWidth() - (getWidth() - getPaddingLeft() - getPaddingRight()));
      }
      return i;
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      d.a(PullToRefreshHorizontalScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), paramBoolean);
      return bool;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\handmark\pulltorefresh\library\PullToRefreshHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */