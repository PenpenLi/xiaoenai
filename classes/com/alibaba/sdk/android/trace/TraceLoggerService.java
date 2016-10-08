package com.alibaba.sdk.android.trace;

public abstract interface TraceLoggerService
{
  public static final int LEVEL_ALL = 7;
  public static final int LEVEL_DEV = 3;
  public static final int LEVEL_ISV_DEV = 2;
  public static final int LEVEL_ISV_DEV_ONLINE = 6;
  public static final int LEVEL_ONLINE = 4;
  public static final int LEVEL_SDK_DEV = 1;
  public static final int LEVEL_SDK_DEV_ONLINE = 5;
  public static final int LEVEL_TRACK = 8;
  public static final String TAG = "AliSDK";
  
  public abstract ActionTraceLogger action(int paramInt, String paramString);
  
  public abstract ActionTraceLogger action(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\trace\TraceLoggerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */