package com.tonicartos.superslim;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;

public abstract class h
{
  protected LayoutManager b;
  
  public h(LayoutManager paramLayoutManager)
  {
    this.b = paramLayoutManager;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView;
    for (;;)
    {
      LayoutManager.LayoutParams localLayoutParams;
      if (paramInt2 >= 0)
      {
        localView = this.b.getChildAt(paramInt2);
        localLayoutParams = (LayoutManager.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.d() == paramInt1) {}
      }
      else
      {
        return paramInt3;
      }
      if (!localLayoutParams.a) {
        break;
      }
      paramInt2 -= 1;
    }
    return this.b.getDecoratedBottom(localView);
  }
  
  public abstract int a(int paramInt1, int paramInt2, int paramInt3, g paramg, d paramd);
  
  public int a(int paramInt, SparseArray<Boolean> paramSparseArray)
  {
    int i = 0;
    int k = 0;
    int j = paramInt;
    paramInt = k;
    if (i < paramSparseArray.size())
    {
      if (((Boolean)paramSparseArray.get(j, Boolean.valueOf(false))).booleanValue())
      {
        k = i + 1;
        i = paramInt;
        paramInt = k;
      }
      for (;;)
      {
        k = j + 1;
        j = i;
        i = paramInt;
        paramInt = j;
        j = k;
        break;
        k = paramInt + 1;
        paramInt = i;
        i = k;
      }
    }
    return paramInt;
  }
  
  public abstract int a(int paramInt, View paramView, g paramg, d paramd);
  
  public abstract int a(int paramInt, g paramg, d paramd);
  
  protected int a(d.a parama, int paramInt, LayoutManager.a parama1, d paramd)
  {
    if (parama1 == LayoutManager.a.a) {}
    for (int i = 0;; i = this.b.getChildCount())
    {
      paramd.a(paramInt);
      this.b.addView(parama.a, i);
      return i;
    }
  }
  
  public View a(int paramInt, boolean paramBoolean)
  {
    int j = this.b.getChildCount();
    Object localObject = null;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return (View)localObject;
      }
      View localView = this.b.getChildAt(i);
      LayoutManager.LayoutParams localLayoutParams = (LayoutManager.LayoutParams)localView.getLayoutParams();
      if (paramInt == localLayoutParams.d())
      {
        if ((!localLayoutParams.a) || (!paramBoolean)) {
          return localView;
        }
      }
      else {
        return (View)localObject;
      }
      localObject = localView;
      i += 1;
    }
  }
  
  public LayoutManager.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public LayoutManager.LayoutParams a(LayoutManager.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView;
    for (;;)
    {
      LayoutManager.LayoutParams localLayoutParams;
      if (paramInt2 < this.b.getChildCount())
      {
        localView = this.b.getChildAt(paramInt2);
        localLayoutParams = (LayoutManager.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.d() == paramInt1) {}
      }
      else
      {
        return paramInt3;
      }
      if (!localLayoutParams.a) {
        break;
      }
      paramInt2 += 1;
    }
    return this.b.getDecoratedTop(localView);
  }
  
  public abstract int b(int paramInt1, int paramInt2, int paramInt3, g paramg, d paramd);
  
  public int b(int paramInt, SparseArray<Boolean> paramSparseArray)
  {
    int i = 0;
    int k = 0;
    int j = paramInt;
    paramInt = k;
    if (i < paramSparseArray.size())
    {
      if (((Boolean)paramSparseArray.get(j, Boolean.valueOf(false))).booleanValue())
      {
        k = i + 1;
        i = paramInt;
        paramInt = k;
      }
      for (;;)
      {
        k = j - 1;
        j = i;
        i = paramInt;
        paramInt = j;
        j = k;
        break;
        k = paramInt + 1;
        paramInt = i;
        i = k;
      }
    }
    return paramInt;
  }
  
  public abstract int b(int paramInt, View paramView, g paramg, d paramd);
  
  public h b(g paramg)
  {
    return this;
  }
  
  public View c(int paramInt)
  {
    int i = this.b.getChildCount();
    Object localObject = null;
    i -= 1;
    for (;;)
    {
      if (i < 0) {
        return (View)localObject;
      }
      View localView = this.b.getChildAt(i);
      LayoutManager.LayoutParams localLayoutParams = (LayoutManager.LayoutParams)localView.getLayoutParams();
      if (paramInt == localLayoutParams.d())
      {
        if (!localLayoutParams.a) {
          return localView;
        }
      }
      else {
        return (View)localObject;
      }
      localObject = localView;
      i -= 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tonicartos\superslim\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */