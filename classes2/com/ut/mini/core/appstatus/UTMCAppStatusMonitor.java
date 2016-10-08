package com.ut.mini.core.appstatus;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.alibaba.mtl.log.e.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@TargetApi(14)
public class UTMCAppStatusMonitor
  implements Application.ActivityLifecycleCallbacks
{
  private static UTMCAppStatusMonitor jdField_a_of_type_ComUtMiniCoreAppstatusUTMCAppStatusMonitor = null;
  private int J = 0;
  private boolean P = false;
  private ScheduledFuture<?> jdField_a_of_type_JavaUtilConcurrentScheduledFuture = null;
  private Object d = new Object();
  private Object e = new Object();
  private List<UTMCAppStatusCallbacks> m = new LinkedList();
  
  private void L()
  {
    synchronized (this.d)
    {
      r.a().f(11);
      return;
    }
  }
  
  public static UTMCAppStatusMonitor getInstance()
  {
    try
    {
      if (jdField_a_of_type_ComUtMiniCoreAppstatusUTMCAppStatusMonitor == null) {
        jdField_a_of_type_ComUtMiniCoreAppstatusUTMCAppStatusMonitor = new UTMCAppStatusMonitor();
      }
      UTMCAppStatusMonitor localUTMCAppStatusMonitor = jdField_a_of_type_ComUtMiniCoreAppstatusUTMCAppStatusMonitor;
      return localUTMCAppStatusMonitor;
    }
    finally {}
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.m.iterator();
      if (localIterator.hasNext()) {
        ((UTMCAppStatusCallbacks)localIterator.next()).onActivityCreated(paramActivity, paramBundle);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.m.iterator();
      if (localIterator.hasNext()) {
        ((UTMCAppStatusCallbacks)localIterator.next()).onActivityDestroyed(paramActivity);
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.m.iterator();
      if (localIterator.hasNext()) {
        ((UTMCAppStatusCallbacks)localIterator.next()).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.m.iterator();
      if (localIterator.hasNext()) {
        ((UTMCAppStatusCallbacks)localIterator.next()).onActivityResumed(paramActivity);
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.m.iterator();
      if (localIterator.hasNext()) {
        ((UTMCAppStatusCallbacks)localIterator.next()).onActivitySaveInstanceState(paramActivity, paramBundle);
      }
    }
  }
  
  public void onActivityStarted(Activity arg1)
  {
    L();
    this.J += 1;
    if (!this.P) {
      synchronized (this.e)
      {
        Iterator localIterator = this.m.iterator();
        if (localIterator.hasNext()) {
          ((UTMCAppStatusCallbacks)localIterator.next()).onSwitchForeground();
        }
      }
    }
    this.P = true;
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.J -= 1;
    if (this.J == 0)
    {
      L();
      r.a().a(11, new a(null), 1000L);
    }
  }
  
  public void registerAppStatusCallbacks(UTMCAppStatusCallbacks paramUTMCAppStatusCallbacks)
  {
    if (paramUTMCAppStatusCallbacks != null) {
      synchronized (this.e)
      {
        this.m.add(paramUTMCAppStatusCallbacks);
        return;
      }
    }
  }
  
  public void unregisterAppStatusCallbacks(UTMCAppStatusCallbacks paramUTMCAppStatusCallbacks)
  {
    if (paramUTMCAppStatusCallbacks != null) {
      synchronized (this.e)
      {
        this.m.remove(paramUTMCAppStatusCallbacks);
        return;
      }
    }
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      UTMCAppStatusMonitor.a(UTMCAppStatusMonitor.this, false);
      synchronized (UTMCAppStatusMonitor.a(UTMCAppStatusMonitor.this))
      {
        Iterator localIterator = UTMCAppStatusMonitor.a(UTMCAppStatusMonitor.this).iterator();
        if (localIterator.hasNext()) {
          ((UTMCAppStatusCallbacks)localIterator.next()).onSwitchBackground();
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\core\appstatus\UTMCAppStatusMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */