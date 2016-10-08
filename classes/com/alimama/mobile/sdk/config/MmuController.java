package com.alimama.mobile.sdk.config;

public abstract interface MmuController<T>
{
  public abstract void close();
  
  public abstract T getInstanceView();
  
  public abstract void setInstanceView(T paramT);
  
  public static abstract interface ClickCallBackListener
  {
    public abstract void onClick();
  }
  
  public static abstract interface InitAsyncComplete
  {
    public abstract void onComplete(boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\MmuController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */