package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;

final class v$1
  implements ThreadFactory
{
  v$1(v paramv) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName("BUGLY_THREAD");
    return paramRunnable;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\proguard\v$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */