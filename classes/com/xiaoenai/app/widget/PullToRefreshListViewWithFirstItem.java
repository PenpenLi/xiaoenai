package com.xiaoenai.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.a;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class PullToRefreshListViewWithFirstItem
  extends PullToRefreshListView
{
  public PullToRefreshListViewWithFirstItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshListViewWithFirstItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshListViewWithFirstItem(Context paramContext, PullToRefreshBase.b paramb)
  {
    super(paramContext, paramb);
  }
  
  public PullToRefreshListViewWithFirstItem(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected boolean d()
  {
    Object localObject = ((ListView)getRefreshableView()).getAdapter();
    if ((localObject == null) || ((((Adapter)localObject).isEmpty()) && (((ListView)getRefreshableView()).getHeaderViewsCount() <= 1))) {
      return true;
    }
    if (((ListView)getRefreshableView()).getFirstVisiblePosition() <= 1)
    {
      localObject = ((ListView)getRefreshableView()).getChildAt(0);
      if (localObject != null) {
        return ((View)localObject).getTop() >= ((ListView)getRefreshableView()).getTop();
      }
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\PullToRefreshListViewWithFirstItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */