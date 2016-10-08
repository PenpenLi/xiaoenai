package com.alimama.mobile.sdk.lab;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.Instrumentation.ActivityResult;
import android.app.UiAutomation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.alimama.mobile.sdk.config.system.HookManager;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.FrameworkBridge;
import com.alimama.mobile.sdk.config.system.bridge.GodModeHacks;
import com.alimama.mobile.sdk.hack.Hack.HackedField;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.lang.reflect.InvocationTargetException;

public class InstrumentationHook
  extends Instrumentation
{
  private Context context;
  private Instrumentation mBase;
  
  public InstrumentationHook(Instrumentation paramInstrumentation, Context paramContext)
  {
    this.context = paramContext;
    this.mBase = paramInstrumentation;
  }
  
  private Instrumentation.ActivityResult execStartActivityInternal(Context paramContext, Intent paramIntent, ExecStartActivityCallback paramExecStartActivityCallback)
  {
    return paramExecStartActivityCallback.execStartActivity();
  }
  
  private void hookInjectResource(String paramString, Activity paramActivity)
  {
    if (HookManager.containsRegActivity(paramString)) {
      try
      {
        Resources localResources = (Resources)FrameworkBridge.FrameworkLoader_getPluginResources.invoke(null, new Object[0]);
        if (GodModeHacks.ContextThemeWrapper_mResources != null) {
          GodModeHacks.ContextThemeWrapper_mResources.on(paramActivity).set(localResources);
        }
        HookManager.addHookActivity(paramActivity);
        MMLog.i("Inject successfully.[Activity=%s]", new Object[] { paramString });
        return;
      }
      catch (InvocationTargetException paramString)
      {
        MMLog.e(paramString, "Inject ContextThemeWapper error.", new Object[0]);
        return;
      }
    }
    MMLog.i("The Actvity[%s] is no in HookMangager", new Object[] { paramString });
  }
  
  public Instrumentation.ActivityMonitor addMonitor(IntentFilter paramIntentFilter, Instrumentation.ActivityResult paramActivityResult, boolean paramBoolean)
  {
    return this.mBase.addMonitor(paramIntentFilter, paramActivityResult, paramBoolean);
  }
  
  public Instrumentation.ActivityMonitor addMonitor(String paramString, Instrumentation.ActivityResult paramActivityResult, boolean paramBoolean)
  {
    return this.mBase.addMonitor(paramString, paramActivityResult, paramBoolean);
  }
  
  public void addMonitor(Instrumentation.ActivityMonitor paramActivityMonitor)
  {
    this.mBase.addMonitor(paramActivityMonitor);
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
  {
    this.mBase.callActivityOnCreate(paramActivity, paramBundle);
  }
  
  public void callActivityOnDestroy(Activity paramActivity)
  {
    this.mBase.callActivityOnDestroy(paramActivity);
  }
  
  public void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent)
  {
    this.mBase.callActivityOnNewIntent(paramActivity, paramIntent);
  }
  
  public void callActivityOnPause(Activity paramActivity)
  {
    this.mBase.callActivityOnPause(paramActivity);
  }
  
  public void callActivityOnPostCreate(Activity paramActivity, Bundle paramBundle)
  {
    this.mBase.callActivityOnPostCreate(paramActivity, paramBundle);
  }
  
  public void callActivityOnRestart(Activity paramActivity)
  {
    this.mBase.callActivityOnRestart(paramActivity);
  }
  
  public void callActivityOnRestoreInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.mBase.callActivityOnRestoreInstanceState(paramActivity, paramBundle);
  }
  
  public void callActivityOnResume(Activity paramActivity)
  {
    this.mBase.callActivityOnResume(paramActivity);
  }
  
  public void callActivityOnSaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    this.mBase.callActivityOnSaveInstanceState(paramActivity, paramBundle);
  }
  
  public void callActivityOnStart(Activity paramActivity)
  {
    this.mBase.callActivityOnStart(paramActivity);
  }
  
  public void callActivityOnStop(Activity paramActivity)
  {
    this.mBase.callActivityOnStop(paramActivity);
  }
  
  public void callActivityOnUserLeaving(Activity paramActivity)
  {
    this.mBase.callActivityOnUserLeaving(paramActivity);
  }
  
  public void callApplicationOnCreate(Application paramApplication)
  {
    this.mBase.callApplicationOnCreate(paramApplication);
  }
  
  public boolean checkMonitorHit(Instrumentation.ActivityMonitor paramActivityMonitor, int paramInt)
  {
    return this.mBase.checkMonitorHit(paramActivityMonitor, paramInt);
  }
  
  public void endPerformanceSnapshot()
  {
    this.mBase.endPerformanceSnapshot();
  }
  
  public Instrumentation.ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt)
  {
    return execStartActivityInternal(this.context, paramIntent, new InstrumentationHook.1(this, paramContext, paramIBinder1, paramIBinder2, paramActivity, paramIntent, paramInt));
  }
  
  @TargetApi(16)
  public Instrumentation.ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    return execStartActivityInternal(this.context, paramIntent, new InstrumentationHook.2(this, paramContext, paramIBinder1, paramIBinder2, paramActivity, paramIntent, paramInt, paramBundle));
  }
  
  @TargetApi(14)
  public Instrumentation.ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    return execStartActivityInternal(this.context, paramIntent, new InstrumentationHook.3(this, paramContext, paramIBinder1, paramIBinder2, paramFragment, paramIntent, paramInt));
  }
  
  @TargetApi(16)
  public Instrumentation.ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    return execStartActivityInternal(this.context, paramIntent, new InstrumentationHook.4(this, paramContext, paramIBinder1, paramIBinder2, paramFragment, paramIntent, paramInt, paramBundle));
  }
  
  public void finish(int paramInt, Bundle paramBundle)
  {
    this.mBase.finish(paramInt, paramBundle);
  }
  
  public Bundle getAllocCounts()
  {
    return this.mBase.getAllocCounts();
  }
  
  public Bundle getBinderCounts()
  {
    return this.mBase.getBinderCounts();
  }
  
  public ComponentName getComponentName()
  {
    return this.mBase.getComponentName();
  }
  
  public Context getContext()
  {
    return this.mBase.getContext();
  }
  
  public Context getTargetContext()
  {
    return this.mBase.getTargetContext();
  }
  
  @TargetApi(18)
  public UiAutomation getUiAutomation()
  {
    return this.mBase.getUiAutomation();
  }
  
  public boolean invokeContextMenuAction(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return this.mBase.invokeContextMenuAction(paramActivity, paramInt1, paramInt2);
  }
  
  public boolean invokeMenuActionSync(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return this.mBase.invokeMenuActionSync(paramActivity, paramInt1, paramInt2);
  }
  
  public boolean isProfiling()
  {
    return this.mBase.isProfiling();
  }
  
  public Activity newActivity(Class<?> paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    paramContext = this.mBase.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
    hookInjectResource(paramClass.getCanonicalName(), paramContext);
    return paramContext;
  }
  
  public Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    paramClassLoader = this.mBase.newActivity(paramClassLoader, paramString, paramIntent);
    hookInjectResource(paramString, paramClassLoader);
    return paramClassLoader;
  }
  
  public Application newApplication(ClassLoader paramClassLoader, String paramString, Context paramContext)
  {
    return this.mBase.newApplication(paramClassLoader, paramString, paramContext);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mBase.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.mBase.onDestroy();
  }
  
  public boolean onException(Object paramObject, Throwable paramThrowable)
  {
    return this.mBase.onException(paramObject, paramThrowable);
  }
  
  public void onStart()
  {
    this.mBase.onStart();
  }
  
  public void removeMonitor(Instrumentation.ActivityMonitor paramActivityMonitor)
  {
    this.mBase.removeMonitor(paramActivityMonitor);
  }
  
  public void runOnMainSync(Runnable paramRunnable)
  {
    this.mBase.runOnMainSync(paramRunnable);
  }
  
  public void sendCharacterSync(int paramInt)
  {
    this.mBase.sendCharacterSync(paramInt);
  }
  
  public void sendKeyDownUpSync(int paramInt)
  {
    this.mBase.sendKeyDownUpSync(paramInt);
  }
  
  public void sendKeySync(KeyEvent paramKeyEvent)
  {
    this.mBase.sendKeySync(paramKeyEvent);
  }
  
  public void sendPointerSync(MotionEvent paramMotionEvent)
  {
    this.mBase.sendPointerSync(paramMotionEvent);
  }
  
  public void sendStatus(int paramInt, Bundle paramBundle)
  {
    this.mBase.sendStatus(paramInt, paramBundle);
  }
  
  public void sendStringSync(String paramString)
  {
    this.mBase.sendStringSync(paramString);
  }
  
  public void sendTrackballEventSync(MotionEvent paramMotionEvent)
  {
    this.mBase.sendTrackballEventSync(paramMotionEvent);
  }
  
  public void setAutomaticPerformanceSnapshots()
  {
    this.mBase.setAutomaticPerformanceSnapshots();
  }
  
  public void setInTouchMode(boolean paramBoolean)
  {
    this.mBase.setInTouchMode(paramBoolean);
  }
  
  public void start()
  {
    this.mBase.start();
  }
  
  public Activity startActivitySync(Intent paramIntent)
  {
    return this.mBase.startActivitySync(paramIntent);
  }
  
  public void startAllocCounting()
  {
    this.mBase.startAllocCounting();
  }
  
  public void startPerformanceSnapshot()
  {
    this.mBase.startPerformanceSnapshot();
  }
  
  public void startProfiling()
  {
    this.mBase.startProfiling();
  }
  
  public void stopAllocCounting()
  {
    this.mBase.stopAllocCounting();
  }
  
  public void stopProfiling()
  {
    this.mBase.stopProfiling();
  }
  
  public void waitForIdle(Runnable paramRunnable)
  {
    this.mBase.waitForIdle(paramRunnable);
  }
  
  public void waitForIdleSync()
  {
    this.mBase.waitForIdleSync();
  }
  
  public Activity waitForMonitor(Instrumentation.ActivityMonitor paramActivityMonitor)
  {
    return this.mBase.waitForMonitor(paramActivityMonitor);
  }
  
  public Activity waitForMonitorWithTimeout(Instrumentation.ActivityMonitor paramActivityMonitor, long paramLong)
  {
    return this.mBase.waitForMonitorWithTimeout(paramActivityMonitor, paramLong);
  }
  
  private static abstract interface ExecStartActivityCallback
  {
    public abstract Instrumentation.ActivityResult execStartActivity();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\lab\InstrumentationHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */