package com.marshalchen.ultimaterecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.marshalchen.ultimaterecyclerview.swipelistview.SwipeListView;
import com.marshalchen.ultimaterecyclerview.swipelistview.b;
import com.marshalchen.ultimaterecyclerview.ui.VerticalSwipeRefreshLayout;
import com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton.FloatingActionButton;

public class SwipeableUltimateRecyclerview
  extends UltimateRecyclerView
{
  public SwipeableUltimateRecyclerview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((SwipeListView)this.e).a(paramAttributeSet);
  }
  
  public SwipeableUltimateRecyclerview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((SwipeListView)this.e).a(paramAttributeSet);
  }
  
  protected void a()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(d.d.swipeable_ultimate_recycler_view_layout, this);
    this.e = ((SwipeListView)localView.findViewById(d.c.ultimate_list));
    this.w = ((VerticalSwipeRefreshLayout)localView.findViewById(d.c.swipe_refresh_layout));
    c();
    this.w.setEnabled(false);
    if (this.e != null)
    {
      this.e.setClipToPadding(this.n);
      if (this.i == -1.1F) {
        break label234;
      }
      this.e.setPadding(this.i, this.i, this.i, this.i);
    }
    for (;;)
    {
      this.f = ((FloatingActionButton)localView.findViewById(d.c.defaultFloatingActionButton));
      d();
      this.o = ((ViewStub)localView.findViewById(d.c.emptyview));
      this.r = ((ViewStub)localView.findViewById(d.c.floatingActionViewStub));
      this.o.setLayoutResource(this.q);
      this.r.setLayoutResource(this.t);
      if (this.q != 0) {
        this.p = this.o.inflate();
      }
      this.o.setVisibility(8);
      if (this.t != 0)
      {
        this.s = this.r.inflate();
        this.s.setVisibility(0);
      }
      return;
      label234:
      this.e.setPadding(this.l, this.j, this.m, this.k);
    }
  }
  
  public void setSwipeListViewListener(b paramb)
  {
    ((SwipeListView)this.e).c = paramb;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\SwipeableUltimateRecyclerview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */