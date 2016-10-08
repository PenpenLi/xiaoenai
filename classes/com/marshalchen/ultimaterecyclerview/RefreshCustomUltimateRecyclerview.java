package com.marshalchen.ultimaterecyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class RefreshCustomUltimateRecyclerview
  extends CustomUltimateRecyclerview
{
  public boolean b;
  float c;
  float d;
  private b x;
  
  public RefreshCustomUltimateRecyclerview(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RefreshCustomUltimateRecyclerview(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RefreshCustomUltimateRecyclerview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  private void h()
  {
    RecyclerLoadingLayout localRecyclerLoadingLayout = new RecyclerLoadingLayout(getContext());
    b();
    this.a.setHeaderView(localRecyclerLoadingLayout);
    this.a.a(localRecyclerLoadingLayout);
  }
  
  private void i()
  {
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)getLayoutManager();
    setScrollViewCallbacks(new h(this, localStaggeredGridLayoutManager, localStaggeredGridLayoutManager.getSpanCount()));
  }
  
  private void j()
  {
    setScrollViewCallbacks(new i(this));
  }
  
  private void k()
  {
    setScrollViewCallbacks(new j(this));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.c = f1;
      this.d = f2;
      continue;
      float f3 = this.c;
      float f4 = this.d;
      if (Math.abs(f3 - f1) + 10.0F > Math.abs(f4 - f2)) {
        this.b = true;
      } else {
        this.b = false;
      }
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    if ((paramLayoutManager instanceof LinearLayoutManager)) {
      k();
    }
    do
    {
      return;
      if ((paramLayoutManager instanceof GridLayoutManager))
      {
        j();
        return;
      }
    } while (!(paramLayoutManager instanceof StaggeredGridLayoutManager));
    i();
  }
  
  public void setOnScrollChangeListener(b paramb)
  {
    this.x = paramb;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\RefreshCustomUltimateRecyclerview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */