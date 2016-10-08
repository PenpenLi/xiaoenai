package com.marshalchen.ultimaterecyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class CustomGridLayoutManager
  extends GridLayoutManager
{
  public boolean a = false;
  private int[] b = new int[2];
  private int c = 0;
  
  public CustomGridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public CustomGridLayoutManager(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.c = paramInt2;
  }
  
  public CustomGridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt1, paramInt2, paramBoolean);
  }
  
  public CustomGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    if (paramInt1 < getItemCount()) {}
    try
    {
      View localView = paramRecycler.getViewForPosition(0);
      if (localView != null)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        localView.measure(ViewGroup.getChildMeasureSpec(paramInt2, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), ViewGroup.getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom(), localLayoutParams.height));
        paramArrayOfInt[0] = (localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin);
        paramInt1 = localView.getMeasuredHeight();
        paramInt2 = localLayoutParams.bottomMargin;
        paramArrayOfInt[1] = (localLayoutParams.topMargin + (paramInt1 + paramInt2));
        paramRecycler.recycleView(localView);
      }
      return;
    }
    catch (Exception paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return (this.a) && (super.canScrollHorizontally());
  }
  
  public boolean canScrollVertically()
  {
    return (this.a) && (super.canScrollVertically());
  }
  
  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = 0;
    paramInt1 = 0;
    int i1 = getItemCount();
    int i2 = getSpanCount();
    int i = 0;
    if (i < i1)
    {
      a(paramRecycler, i, View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(i, 0), this.b);
      if (getOrientation() == 0)
      {
        if (i % i2 != 0) {
          break label231;
        }
        paramInt2 += this.b[0];
      }
    }
    label231:
    for (;;)
    {
      if (i == 0) {
        paramInt1 = this.b[1];
      }
      for (;;)
      {
        i += 1;
        break;
        if (i % i2 == 0) {
          paramInt1 = this.b[1] + paramInt1;
        }
        for (;;)
        {
          if (i == 0)
          {
            paramInt2 = this.b[0];
            break;
            switch (n)
            {
            default: 
              switch (m)
              {
              }
              break;
            }
            for (;;)
            {
              setMeasuredDimension(paramInt2, this.c + paramInt1);
              return;
              paramInt2 = k;
              break;
              paramInt1 = j;
            }
          }
          break;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\CustomGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */