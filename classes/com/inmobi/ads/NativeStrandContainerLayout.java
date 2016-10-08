package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class NativeStrandContainerLayout
  extends ViewGroup
{
  private static final String a = NativeStrandContainerLayout.class.getSimpleName();
  
  public NativeStrandContainerLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof a;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new a(-2, -2);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new a(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        a locala = (a)localView.getLayoutParams();
        localView.layout(locala.a, locala.b, locala.a + localView.getMeasuredWidth(), locala.b + localView.getMeasuredHeight());
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildren(paramInt1, paramInt2);
    int n = getChildCount();
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    if (k < n)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8) {
        break label171;
      }
      a locala = (a)localView.getLayoutParams();
      int i2 = locala.a;
      int i3 = localView.getMeasuredWidth();
      m = locala.b;
      int i1 = localView.getMeasuredHeight();
      i = Math.max(i, i2 + i3);
      m = Math.max(j, m + i1);
      j = i;
      i = m;
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      j = Math.max(j, getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(i, getSuggestedMinimumWidth()), paramInt1), resolveSize(j, paramInt2));
      return;
      label171:
      m = i;
      i = j;
      j = m;
    }
  }
  
  public static class a
    extends ViewGroup.LayoutParams
  {
    public int a;
    public int b;
    
    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\NativeStrandContainerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */