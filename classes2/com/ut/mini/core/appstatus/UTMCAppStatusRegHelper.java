package com.ut.mini.core.appstatus;

import android.annotation.TargetApi;
import android.app.Application;

public class UTMCAppStatusRegHelper
{
  @TargetApi(14)
  public static void registeActivityLifecycleCallbacks(Application paramApplication)
  {
    if (paramApplication != null) {
      paramApplication.registerActivityLifecycleCallbacks(UTMCAppStatusMonitor.getInstance());
    }
  }
  
  @TargetApi(14)
  public static void registerAppStatusCallbacks(UTMCAppStatusCallbacks paramUTMCAppStatusCallbacks)
  {
    if (paramUTMCAppStatusCallbacks != null) {
      UTMCAppStatusMonitor.getInstance().registerAppStatusCallbacks(paramUTMCAppStatusCallbacks);
    }
  }
  
  @TargetApi(14)
  public static void unRegisterAppStatusCallbacks(UTMCAppStatusCallbacks paramUTMCAppStatusCallbacks)
  {
    if (paramUTMCAppStatusCallbacks != null) {
      UTMCAppStatusMonitor.getInstance().unregisterAppStatusCallbacks(paramUTMCAppStatusCallbacks);
    }
  }
  
  @TargetApi(14)
  public static void unregisterActivityLifecycleCallbacks(Application paramApplication)
  {
    if (paramApplication != null) {
      paramApplication.unregisterActivityLifecycleCallbacks(UTMCAppStatusMonitor.getInstance());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\core\appstatus\UTMCAppStatusRegHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */