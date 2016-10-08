package com.inmobi.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.Map;
import java.util.WeakHashMap;

class ab
  implements Application.ActivityLifecycleCallbacks
{
  private static final String a = ab.class.getSimpleName();
  private static final n.a d = new ab.1();
  private static final ap.a e = new ab.2();
  private final Map<Context, n> b = new WeakHashMap();
  private boolean c;
  
  private n a(@NonNull Activity paramActivity, @NonNull b.f paramf)
  {
    n localn = (n)this.b.get(paramActivity);
    Object localObject = localn;
    if (localn == null)
    {
      paramf = new n(paramf, new m(e, paramActivity), d);
      this.b.put(paramActivity, paramf);
      localObject = paramf;
      if (!this.c)
      {
        paramActivity.getApplication().registerActivityLifecycleCallbacks(this);
        this.c = true;
        localObject = paramf;
      }
    }
    return (n)localObject;
  }
  
  private void a(@NonNull Activity paramActivity)
  {
    n localn = (n)this.b.remove(paramActivity);
    if (localn != null) {
      localn.e();
    }
    if ((this.b.isEmpty()) && (this.c))
    {
      paramActivity.getApplication().unregisterActivityLifecycleCallbacks(this);
      this.c = false;
    }
  }
  
  void a(@NonNull Activity paramActivity, @NonNull b.f paramf, @NonNull View paramView, @NonNull q paramq)
  {
    a(paramActivity, paramf).a(paramView, paramq, paramf);
  }
  
  void a(@NonNull Activity paramActivity, @NonNull q paramq)
  {
    n localn = (n)this.b.get(paramActivity);
    if (localn != null)
    {
      localn.a(paramq);
      if (!localn.d())
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Impression tracker is free, removing it");
        a(paramActivity);
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Activity destroyed, removing impression tracker");
    a(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    paramActivity = (n)this.b.get(paramActivity);
    if (paramActivity != null) {
      paramActivity.a();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = (n)this.b.get(paramActivity);
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */