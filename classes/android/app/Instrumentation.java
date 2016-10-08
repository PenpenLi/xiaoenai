package android.app;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class Instrumentation
{
  public ActivityMonitor addMonitor(IntentFilter paramIntentFilter, ActivityResult paramActivityResult, boolean paramBoolean)
  {
    return null;
  }
  
  public ActivityMonitor addMonitor(String paramString, ActivityResult paramActivityResult, boolean paramBoolean)
  {
    return null;
  }
  
  public void addMonitor(ActivityMonitor paramActivityMonitor) {}
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle) {}
  
  public void callActivityOnDestroy(Activity paramActivity) {}
  
  public void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent) {}
  
  public void callActivityOnPause(Activity paramActivity) {}
  
  public void callActivityOnPostCreate(Activity paramActivity, Bundle paramBundle) {}
  
  public void callActivityOnRestart(Activity paramActivity) {}
  
  public void callActivityOnRestoreInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void callActivityOnResume(Activity paramActivity) {}
  
  public void callActivityOnSaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void callActivityOnStart(Activity paramActivity) {}
  
  public void callActivityOnStop(Activity paramActivity) {}
  
  public void callActivityOnUserLeaving(Activity paramActivity) {}
  
  public void callApplicationOnCreate(Application paramApplication) {}
  
  public boolean checkMonitorHit(ActivityMonitor paramActivityMonitor, int paramInt)
  {
    return false;
  }
  
  public void endPerformanceSnapshot() {}
  
  public ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return null;
  }
  
  @TargetApi(16)
  public ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    return null;
  }
  
  @TargetApi(14)
  public ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    return null;
  }
  
  @TargetApi(16)
  public ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    return null;
  }
  
  public void finish(int paramInt, Bundle paramBundle) {}
  
  public Bundle getAllocCounts()
  {
    return null;
  }
  
  public Bundle getBinderCounts()
  {
    return null;
  }
  
  public ComponentName getComponentName()
  {
    return null;
  }
  
  public Context getContext()
  {
    return null;
  }
  
  public Context getTargetContext()
  {
    return null;
  }
  
  @TargetApi(18)
  public UiAutomation getUiAutomation()
  {
    return null;
  }
  
  public boolean invokeContextMenuAction(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean invokeMenuActionSync(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean isProfiling()
  {
    return false;
  }
  
  public Activity newActivity(Class<?> paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    return null;
  }
  
  public Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    return null;
  }
  
  public Application newApplication(ClassLoader paramClassLoader, String paramString, Context paramContext)
  {
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public boolean onException(Object paramObject, Throwable paramThrowable)
  {
    return false;
  }
  
  public void onStart() {}
  
  public void removeMonitor(ActivityMonitor paramActivityMonitor) {}
  
  public void runOnMainSync(Runnable paramRunnable) {}
  
  public void sendCharacterSync(int paramInt) {}
  
  public void sendKeyDownUpSync(int paramInt) {}
  
  public void sendKeySync(KeyEvent paramKeyEvent) {}
  
  public void sendPointerSync(MotionEvent paramMotionEvent) {}
  
  public void sendStatus(int paramInt, Bundle paramBundle) {}
  
  public void sendStringSync(String paramString) {}
  
  public void sendTrackballEventSync(MotionEvent paramMotionEvent) {}
  
  public void setAutomaticPerformanceSnapshots() {}
  
  public void setInTouchMode(boolean paramBoolean) {}
  
  public void start() {}
  
  public Activity startActivitySync(Intent paramIntent)
  {
    return null;
  }
  
  public void startAllocCounting() {}
  
  public void startPerformanceSnapshot() {}
  
  public void startProfiling() {}
  
  public void stopAllocCounting() {}
  
  public void stopProfiling() {}
  
  public void waitForIdle(Runnable paramRunnable) {}
  
  public void waitForIdleSync() {}
  
  public Activity waitForMonitor(ActivityMonitor paramActivityMonitor)
  {
    return null;
  }
  
  public Activity waitForMonitorWithTimeout(ActivityMonitor paramActivityMonitor, long paramLong)
  {
    return null;
  }
  
  public static class ActivityMonitor {}
  
  public static final class ActivityResult {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\app\Instrumentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */