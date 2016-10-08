package com.alibaba.mtl.appmonitor;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.l;
import com.alibaba.mtl.appmonitor.d.m;
import com.alibaba.mtl.log.e.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

class a
  implements Runnable
{
  private static boolean j = false;
  private static boolean l = false;
  private Application b;
  private boolean k;
  
  public a(Application paramApplication)
  {
    this.b = paramApplication;
    this.k = true;
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = b.a(paramContext);
    i.a("BackgroundTrigger", new Object[] { "[checkRuningProcess]:", paramContext });
    return (!TextUtils.isEmpty(paramContext)) && (paramContext.indexOf(":") != -1);
  }
  
  @TargetApi(14)
  public static void init(Application paramApplication)
  {
    a locala;
    if (!j)
    {
      i.a("BackgroundTrigger", new Object[] { "init BackgroundTrigger" });
      l = a(paramApplication.getApplicationContext());
      locala = new a(paramApplication);
      if (!l) {
        break label61;
      }
      r.a().a(4, locala, 60000L);
    }
    for (;;)
    {
      j = true;
      return;
      label61:
      if (Build.VERSION.SDK_INT >= 14)
      {
        locala.getClass();
        paramApplication.registerActivityLifecycleCallbacks(new a(locala, locala));
      }
    }
  }
  
  public void run()
  {
    int m = 0;
    int i = 0;
    i.a("BackgroundTrigger", new Object[] { "[bg check]" });
    boolean bool = b.b(this.b.getApplicationContext());
    f[] arrayOff;
    f localf;
    if (this.k != bool)
    {
      this.k = bool;
      if (!bool) {
        break label118;
      }
      l.a(this.b);
      m.a().k();
      arrayOff = f.a();
      m = arrayOff.length;
      while (i < m)
      {
        localf = arrayOff[i];
        AppMonitorDelegate.setStatisticsInterval(localf, localf.c());
        i += 1;
      }
      com.alibaba.mtl.log.a.m();
    }
    for (;;)
    {
      if (l) {
        r.a().a(4, this, 60000L);
      }
      return;
      label118:
      arrayOff = f.a();
      int n = arrayOff.length;
      i = m;
      while (i < n)
      {
        localf = arrayOff[i];
        AppMonitorDelegate.setStatisticsInterval(localf, localf.d());
        i += 1;
      }
      AppMonitorDelegate.triggerUpload();
      com.alibaba.mtl.log.a.l();
    }
  }
  
  @TargetApi(14)
  class a
    implements Application.ActivityLifecycleCallbacks
  {
    private Runnable jdField_a_of_type_JavaLangRunnable;
    
    a(Runnable paramRunnable)
    {
      this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      r.a().f(4);
      r.a().a(4, this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      r.a().f(4);
      r.a().a(4, this.jdField_a_of_type_JavaLangRunnable, 60000L);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */