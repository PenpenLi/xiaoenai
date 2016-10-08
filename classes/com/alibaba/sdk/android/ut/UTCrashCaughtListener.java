package com.alibaba.sdk.android.ut;

import java.util.Map;

public abstract interface UTCrashCaughtListener
{
  public abstract Map<String, String> onCrashCaught(Thread paramThread, Throwable paramThrowable);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ut\UTCrashCaughtListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */