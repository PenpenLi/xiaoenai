package com.ut.mini.sdkevents;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTInterfaceCallDelegate;
import com.ut.mini.UTTracker;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.plugin.UTPlugin;
import java.util.List;
import java.util.Map;

public class UTMI1010_2001Event
  extends UTPlugin
  implements UTMCAppStatusCallbacks
{
  private long C = 0L;
  private long D = 0L;
  private long E = 0L;
  
  private void a(long paramLong)
  {
    if ((!c.a().f()) && (paramLong > 0L)) {
      if (0L == this.E) {
        break label119;
      }
    }
    label119:
    for (long l = SystemClock.elapsedRealtime() - this.E;; l = 0L)
    {
      UTOriginalCustomHitBuilder localUTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("UT", 1010, "" + paramLong, "" + l, null, null);
      UTTracker localUTTracker = UTAnalytics.getInstance().getDefaultTracker();
      if (localUTTracker != null)
      {
        localUTTracker.send(localUTOriginalCustomHitBuilder.build());
        return;
      }
      i.a("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
      return;
    }
  }
  
  private static boolean o()
  {
    try
    {
      Object localObject = b.a().getContext();
      if (localObject != null)
      {
        String str = ((Context)localObject).getPackageName();
        if (str != null)
        {
          localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
          if (localObject != null) {
            try
            {
              localObject = ((ActivityManager)localObject).getRunningTasks(1);
              if ((localObject != null) && (((List)localObject).size() > 0))
              {
                localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
                if (localObject != null)
                {
                  boolean bool = str.contains(((ComponentName)localObject).getPackageName());
                  if (bool) {
                    return false;
                  }
                }
              }
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
        }
      }
      return true;
    }
    catch (Exception localException2) {}
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    UTInterfaceCallDelegate.pageDisAppearByAuto(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    UTInterfaceCallDelegate.pageAppearByAuto(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onPluginMsgArrivedFromSDK(int paramInt, Object paramObject)
  {
    if (paramInt == 3)
    {
      paramObject = (Map)paramObject;
      if ((((Map)paramObject).containsKey(LogField.EVENTID.toString())) && ("2001".equals((String)((Map)paramObject).get(LogField.EVENTID.toString()))))
      {
        if (!((Map)paramObject).containsKey(LogField.ARG3.toString())) {
          break label119;
        }
        paramObject = (String)((Map)paramObject).get(LogField.ARG3.toString());
      }
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong((String)paramObject);
        this.C = (l + this.C);
        if (o())
        {
          a(this.C);
          this.C = 0L;
        }
        return;
      }
      catch (Exception paramObject)
      {
        ((Exception)paramObject).printStackTrace();
      }
      label119:
      long l = 0L;
    }
  }
  
  public void onSwitchBackground()
  {
    a(SystemClock.elapsedRealtime() - this.D);
    this.E = SystemClock.elapsedRealtime();
  }
  
  public void onSwitchForeground()
  {
    this.D = SystemClock.elapsedRealtime();
  }
  
  public int[] returnRequiredMsgIds()
  {
    return new int[] { 3 };
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\sdkevents\UTMI1010_2001Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */