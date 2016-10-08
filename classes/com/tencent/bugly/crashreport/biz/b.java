package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;
import java.util.List;

public final class b
{
  public static a a;
  private static boolean b;
  private static int c = 10;
  private static long d = 300000L;
  private static long e = 30000L;
  private static long f = 0L;
  private static int g;
  private static long h;
  private static long i;
  private static long j = 0L;
  private static Application.ActivityLifecycleCallbacks k = null;
  private static Class<?> l = null;
  
  public static void a()
  {
    if (a != null) {
      a.a(2, false, 0L);
    }
  }
  
  public static void a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = com.tencent.bugly.crashreport.common.strategy.a.a().c().m;
    }
    f = l1;
  }
  
  public static void a(Context paramContext)
  {
    if ((!b) || (paramContext == null)) {
      return;
    }
    Application localApplication = null;
    if (Build.VERSION.SDK_INT >= 14)
    {
      if ((paramContext.getApplicationContext() instanceof Application)) {
        localApplication = (Application)paramContext.getApplicationContext();
      }
      if (localApplication == null) {}
    }
    try
    {
      if (k != null) {
        localApplication.unregisterActivityLifecycleCallbacks(k);
      }
      b = false;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void a(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    if (b) {
      return;
    }
    e = com.tencent.bugly.crashreport.common.strategy.a.a().c().m;
    c = com.tencent.bugly.crashreport.common.strategy.a.a().c().s;
    a = new a(paramContext);
    b = true;
    if (paramBuglyStrategy != null) {
      l = paramBuglyStrategy.getUserInfoActivity();
    }
    for (long l1 = paramBuglyStrategy.getAppReportDelay();; l1 = 0L)
    {
      if (l1 <= 0L)
      {
        c(paramContext, paramBuglyStrategy);
        return;
      }
      v.a().a(new b.1(paramContext, paramBuglyStrategy), l1);
      return;
    }
  }
  
  public static void a(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean == null) {}
    do
    {
      return;
      if (paramStrategyBean.m > 0L) {
        e = paramStrategyBean.m;
      }
      if (paramStrategyBean.s > 0) {
        c = paramStrategyBean.s;
      }
    } while (paramStrategyBean.t <= 0L);
    d = paramStrategyBean.t;
  }
  
  private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    boolean bool2;
    boolean bool1;
    if (paramBuglyStrategy != null)
    {
      bool2 = paramBuglyStrategy.recordUserInfoOnceADay();
      bool1 = paramBuglyStrategy.isEnableUserInfo();
    }
    for (;;)
    {
      int m;
      Object localObject2;
      if (bool2)
      {
        paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
        localObject1 = paramBuglyStrategy.d;
        localObject1 = a.a((String)localObject1);
        if (localObject1 != null)
        {
          m = 0;
          if (m < ((List)localObject1).size())
          {
            localObject2 = (UserInfoBean)((List)localObject1).get(m);
            if ((((UserInfoBean)localObject2).n.equals(paramBuglyStrategy.i)) && (((UserInfoBean)localObject2).b == 1))
            {
              long l1 = com.tencent.bugly.proguard.a.o();
              if (l1 <= 0L) {
                break label146;
              }
              if (((UserInfoBean)localObject2).e >= l1) {
                if (((UserInfoBean)localObject2).f <= 0L) {
                  a.b();
                }
              }
            }
          }
        }
        label146:
        for (m = 0;; m = 1)
        {
          if (m != 0) {
            break label152;
          }
          return;
          m += 1;
          break;
        }
        label152:
        bool1 = false;
      }
      Object localObject1 = com.tencent.bugly.crashreport.common.info.a.a();
      if (localObject1 != null)
      {
        int n = 0;
        localObject2 = Thread.currentThread().getStackTrace();
        int i1 = localObject2.length;
        paramBuglyStrategy = null;
        m = 0;
        while (m < i1)
        {
          Object localObject3 = localObject2[m];
          if (((StackTraceElement)localObject3).getMethodName().equals("onCreate")) {
            paramBuglyStrategy = ((StackTraceElement)localObject3).getClassName();
          }
          if (((StackTraceElement)localObject3).getClassName().equals("android.app.Activity")) {
            n = 1;
          }
          m += 1;
        }
        if (paramBuglyStrategy == null) {
          break label392;
        }
        if (n == 0) {
          break label386;
        }
        ((com.tencent.bugly.crashreport.common.info.a)localObject1).n = true;
      }
      for (;;)
      {
        ((com.tencent.bugly.crashreport.common.info.a)localObject1).o = paramBuglyStrategy;
        if (bool1)
        {
          paramBuglyStrategy = null;
          if (Build.VERSION.SDK_INT >= 14)
          {
            if ((paramContext.getApplicationContext() instanceof Application)) {
              paramBuglyStrategy = (Application)paramContext.getApplicationContext();
            }
            if (paramBuglyStrategy == null) {}
          }
        }
        try
        {
          if (k == null) {
            k = new b.2();
          }
          paramBuglyStrategy.registerActivityLifecycleCallbacks(k);
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
        i = System.currentTimeMillis();
        a.a(1, true, 0L);
        t.a().a(1001, System.currentTimeMillis());
        w.a("[session] launch app, new start", new Object[0]);
        a.a();
        paramContext = a;
        v.a().a(new a.a(paramContext, null, true), 21600000L);
        return;
        label386:
        paramBuglyStrategy = "background";
        continue;
        label392:
        paramBuglyStrategy = "unknown";
      }
      bool1 = true;
      bool2 = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tencent\bugly\crashreport\biz\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */