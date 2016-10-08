package com.alibaba.sdk.android.ui.bus;

import com.alibaba.sdk.android.ui.bus.filter.FilterInfo;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;

public abstract interface UIBusInfoRegistry
{
  public abstract void registerFilterInfo(FilterInfo paramFilterInfo);
  
  public abstract void registerHandlerInfo(HandlerInfo paramHandlerInfo);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\UIBusInfoRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */