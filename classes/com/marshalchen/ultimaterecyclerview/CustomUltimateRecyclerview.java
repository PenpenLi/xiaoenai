package com.marshalchen.ultimaterecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton.FloatingActionButton;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class CustomUltimateRecyclerview
  extends UltimateRecyclerView
{
  public PtrFrameLayout a;
  
  public CustomUltimateRecyclerview(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomUltimateRecyclerview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomUltimateRecyclerview(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(d.d.custom_recycler_view_layout, this);
    this.e = ((RecyclerView)localView.findViewById(d.c.ultimate_list));
    this.w = null;
    if (this.e != null)
    {
      this.e.setClipToPadding(this.n);
      if (this.i == -1.1F) {
        break label213;
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
      label213:
      this.e.setPadding(this.l, this.j, this.m, this.k);
    }
  }
  
  public void b()
  {
    this.a = ((PtrFrameLayout)findViewById(d.c.store_house_ptr_frame));
    this.a.setResistance(1.7F);
    this.a.setRatioOfHeaderHeightToRefresh(1.2F);
    this.a.setDurationToClose(200);
    this.a.setDurationToCloseHeader(1000);
    this.a.setPullToRefresh(false);
    this.a.setKeepHeaderWhenRefresh(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\CustomUltimateRecyclerview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */