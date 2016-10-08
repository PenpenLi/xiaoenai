package com.ut.mini.core.appstatus;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.log.c;
import java.util.HashMap;

public class UTMCAppBackgroundTimeoutDetector
  implements UTMCAppStatusCallbacks
{
  private static UTMCAppBackgroundTimeoutDetector a = null;
  private long B = 0L;
  
  public static UTMCAppBackgroundTimeoutDetector getInstance()
  {
    try
    {
      if (a == null) {
        a = new UTMCAppBackgroundTimeoutDetector();
      }
      UTMCAppBackgroundTimeoutDetector localUTMCAppBackgroundTimeoutDetector = a;
      return localUTMCAppBackgroundTimeoutDetector;
    }
    finally {}
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onSwitchBackground()
  {
    this.B = SystemClock.elapsedRealtime();
  }
  
  public void onSwitchForeground()
  {
    if ((0L != this.B) && (SystemClock.elapsedRealtime() - this.B > 30000L)) {
      c.a().e(new HashMap());
    }
    this.B = 0L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\core\appstatus\UTMCAppBackgroundTimeoutDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */