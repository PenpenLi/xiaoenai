package com.ut.mini.core.appstatus;

import android.app.Activity;
import android.os.Bundle;

public abstract interface UTMCAppStatusCallbacks
{
  public abstract void onActivityCreated(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onActivityDestroyed(Activity paramActivity);
  
  public abstract void onActivityPaused(Activity paramActivity);
  
  public abstract void onActivityResumed(Activity paramActivity);
  
  public abstract void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onActivityStarted(Activity paramActivity);
  
  public abstract void onActivityStopped(Activity paramActivity);
  
  public abstract void onSwitchBackground();
  
  public abstract void onSwitchForeground();
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\core\appstatus\UTMCAppStatusCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */