package com.marshalchen.ultimaterecyclerview.uiUtils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.marshalchen.ultimaterecyclerview.s;

public class BasicGridLayoutManager
  extends GridLayoutManager
{
  protected int a = 2;
  protected GridLayoutManager.SpanSizeLookup b = new b(this);
  private final s c;
  private GridLayoutManager.SpanSizeLookup d = new a(this);
  
  public BasicGridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, s params)
  {
    super(paramContext, paramInt1, paramInt2, paramBoolean);
    this.c = params;
    setSpanSizeLookup(a());
  }
  
  public BasicGridLayoutManager(Context paramContext, int paramInt, s params)
  {
    super(paramContext, paramInt);
    this.c = params;
    setSpanSizeLookup(a());
  }
  
  protected int a(int paramInt)
  {
    return 1;
  }
  
  protected GridLayoutManager.SpanSizeLookup a()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\uiUtils\BasicGridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */