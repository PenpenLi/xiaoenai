package com.ut.mini.crashhandler;

import java.util.Map;

public abstract interface IUTCrashCaughtListner
{
  public abstract Map<String, String> onCrashCaught(Thread paramThread, Throwable paramThrowable);
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\crashhandler\IUTCrashCaughtListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */