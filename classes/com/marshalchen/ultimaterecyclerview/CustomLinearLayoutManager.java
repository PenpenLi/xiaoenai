package com.marshalchen.ultimaterecyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class CustomLinearLayoutManager
  extends LinearLayoutManager
{
  private int[] a = new int[2];
  
  public CustomLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  private void a(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    View localView = paramRecycler.getViewForPosition(paramInt1);
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
  }
  
  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int i = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    if (i < getItemCount())
    {
      a(paramRecycler, i, View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(i, 0), this.a);
      if (getOrientation() == 0)
      {
        paramInt2 += this.a[0];
        if (i != 0) {
          break label196;
        }
        paramInt1 = this.a[1];
      }
    }
    label196:
    for (;;)
    {
      i += 1;
      break;
      paramInt1 = this.a[1] + paramInt1;
      if (i == 0)
      {
        paramInt2 = this.a[0];
        continue;
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
          setMeasuredDimension(paramInt2, paramInt1);
          return;
          paramInt2 = k;
          break;
          paramInt1 = j;
        }
      }
      else {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\CustomLinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */