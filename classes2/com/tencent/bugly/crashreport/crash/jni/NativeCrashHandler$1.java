package com.tencent.bugly.crashreport.crash.jni;

import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.a;
import com.tencent.bugly.proguard.w;

final class NativeCrashHandler$1
  implements Runnable
{
  NativeCrashHandler$1(NativeCrashHandler paramNativeCrashHandler) {}
  
  public final void run()
  {
    if (!a.a(NativeCrashHandler.a(this.a), "native_record_lock", 10000L))
    {
      w.a("Failed to lock file for handling native crash record.", new Object[0]);
      return;
    }
    CrashDetailBean localCrashDetailBean = b.a(NativeCrashHandler.a(this.a), NativeCrashHandler.b(this.a), NativeCrashHandler.c(this.a));
    if (localCrashDetailBean != null)
    {
      if (!NativeCrashHandler.d(this.a).a(localCrashDetailBean)) {
        NativeCrashHandler.d(this.a).a(localCrashDetailBean, 5000L, false);
      }
      b.b(NativeCrashHandler.b(this.a));
      w.a("get crash from native record!", new Object[0]);
    }
    this.a.a();
    a.b(NativeCrashHandler.a(this.a), "native_record_lock");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\NativeCrashHandler$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */