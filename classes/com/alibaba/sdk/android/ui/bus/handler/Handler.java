package com.alibaba.sdk.android.ui.bus.handler;

public abstract interface Handler
{
  public abstract boolean doHandle(HandlerContext paramHandlerContext);
  
  public abstract HandlerInfo getHandlerInfo();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\bus\handler\Handler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */