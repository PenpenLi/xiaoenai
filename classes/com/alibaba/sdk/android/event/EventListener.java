package com.alibaba.sdk.android.event;

public abstract interface EventListener
{
  public static final int NO_UI_THREAD = 2;
  public static final int UI_THREAD = 1;
  
  public abstract int getThreadModel();
  
  public abstract void onEvent(Event paramEvent);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\event\EventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */