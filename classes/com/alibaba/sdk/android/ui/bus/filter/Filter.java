package com.alibaba.sdk.android.ui.bus.filter;

public abstract interface Filter
{
  public abstract boolean doFilter(FilterContext paramFilterContext);
  
  public abstract FilterInfo getFilterInfo();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\filter\Filter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */