package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;

final class b$2
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    Object localObject = "unknown";
    if (paramActivity != null) {
      localObject = paramActivity.getClass().getName();
    }
    if ((b.b() != null) && (!b.b().getName().equals(localObject))) {}
    do
    {
      return;
      w.c(">>> %s onPaused <<<", new Object[] { localObject });
      localObject = com.tencent.bugly.crashreport.common.info.a.a();
    } while (localObject == null);
    ((com.tencent.bugly.crashreport.common.info.a)localObject).n = false;
    ((com.tencent.bugly.crashreport.common.info.a)localObject).q = System.currentTimeMillis();
    ((com.tencent.bugly.crashreport.common.info.a)localObject).r = (((com.tencent.bugly.crashreport.common.info.a)localObject).q - ((com.tencent.bugly.crashreport.common.info.a)localObject).p);
    b.c(((com.tencent.bugly.crashreport.common.info.a)localObject).q);
    if (((com.tencent.bugly.crashreport.common.info.a)localObject).r < 0L) {
      ((com.tencent.bugly.crashreport.common.info.a)localObject).r = 0L;
    }
    if (paramActivity != null)
    {
      ((com.tencent.bugly.crashreport.common.info.a)localObject).o = "background";
      return;
    }
    ((com.tencent.bugly.crashreport.common.info.a)localObject).o = "unknown";
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    String str = "unknown";
    if (paramActivity != null) {
      str = paramActivity.getClass().getName();
    }
    if ((b.b() != null) && (!b.b().getName().equals(str))) {}
    label185:
    do
    {
      for (;;)
      {
        return;
        w.c(">>> %s onResumed <<<", new Object[] { str });
        paramActivity = com.tencent.bugly.crashreport.common.info.a.a();
        if (paramActivity != null)
        {
          paramActivity.n = true;
          paramActivity.o = str;
          paramActivity.p = System.currentTimeMillis();
          paramActivity.s = (paramActivity.p - b.c());
          long l2 = paramActivity.p - b.d();
          if (b.e() > 0L) {}
          for (l1 = b.e(); l2 > l1; l1 = b.f())
          {
            paramActivity.c();
            b.g();
            w.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(b.f() / 1000L) });
            if (b.h() % b.i() != 0) {
              break label185;
            }
            b.a.a(4, true, 0L);
            return;
          }
        }
      }
      b.a.a(4, false, 0L);
      l1 = System.currentTimeMillis();
    } while (l1 - b.j() <= b.k());
    b.b(l1);
    w.a("add a timer to upload hot start user info", new Object[0]);
    paramActivity = b.a;
    long l1 = b.k();
    v.a().a(new a.a(paramActivity, null, true), l1);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tencent\bugly\crashreport\biz\b$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */