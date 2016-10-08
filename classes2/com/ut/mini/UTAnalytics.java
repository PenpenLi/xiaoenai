package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;
import com.ut.mini.crashhandler.UTMiniCrashHandler;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;

public class UTAnalytics
{
  private static UTAnalytics jdField_a_of_type_ComUtMiniUTAnalytics = null;
  private UTTracker jdField_a_of_type_ComUtMiniUTTracker;
  private Map<String, UTTracker> t = new HashMap();
  
  private UTAnalytics()
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      localUTMI1010_2001Event = new UTMI1010_2001Event();
      UTPluginMgr.getInstance().registerPlugin(localUTMI1010_2001Event, false);
      UTMIVariables.getInstance().setUTMI1010_2001EventInstance(localUTMI1010_2001Event);
      return;
    }
    UTMI1010_2001Event localUTMI1010_2001Event = new UTMI1010_2001Event();
    UTMCAppStatusRegHelper.registerAppStatusCallbacks(localUTMI1010_2001Event);
    UTMIVariables.getInstance().setUTMI1010_2001EventInstance(localUTMI1010_2001Event);
  }
  
  public static UTAnalytics getInstance()
  {
    try
    {
      if (jdField_a_of_type_ComUtMiniUTAnalytics == null) {
        jdField_a_of_type_ComUtMiniUTAnalytics = new UTAnalytics();
      }
      UTAnalytics localUTAnalytics = jdField_a_of_type_ComUtMiniUTAnalytics;
      return localUTAnalytics;
    }
    finally {}
  }
  
  public UTTracker getDefaultTracker()
  {
    try
    {
      if (this.jdField_a_of_type_ComUtMiniUTTracker == null) {
        this.jdField_a_of_type_ComUtMiniUTTracker = new UTTracker();
      }
      if (this.jdField_a_of_type_ComUtMiniUTTracker == null) {
        i.a("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
      }
      UTTracker localUTTracker = this.jdField_a_of_type_ComUtMiniUTTracker;
      return localUTTracker;
    }
    finally {}
  }
  
  public UTTracker getTracker(String paramString)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if (this.t.containsKey(paramString))
          {
            paramString = (UTTracker)this.t.get(paramString);
            return paramString;
          }
          UTTracker localUTTracker = new UTTracker();
          localUTTracker.s(paramString);
          this.t.put(paramString, localUTTracker);
          paramString = localUTTracker;
          continue;
        }
        i.a("getTracker", "TrackId is null.");
      }
      finally {}
      paramString = null;
    }
  }
  
  public void setAppApplicationInstance(Application paramApplication)
  {
    b.a().setAppApplicationInstance(paramApplication);
    AppMonitor.init(paramApplication);
  }
  
  public void setAppVersion(String paramString)
  {
    b.a().setAppVersion(paramString);
  }
  
  public void setChannel(String paramString)
  {
    AppMonitor.setChannel(paramString);
  }
  
  public void setContext(Context paramContext)
  {
    b.a().setContext(paramContext);
    if (paramContext != null)
    {
      if (!UTMiniCrashHandler.getInstance().isTurnOff()) {
        UTMiniCrashHandler.getInstance().turnOn(paramContext);
      }
      UTTeamWork.getInstance().initialized();
    }
  }
  
  public void setCrashCaughtListener(IUTCrashCaughtListner paramIUTCrashCaughtListner)
  {
    UTMiniCrashHandler.getInstance().setCrashCaughtListener(paramIUTCrashCaughtListner);
  }
  
  public void setRequestAuthentication(IUTRequestAuthentication paramIUTRequestAuthentication)
  {
    if (paramIUTRequestAuthentication == null) {
      i.a("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
    }
    if ((paramIUTRequestAuthentication instanceof UTBaseRequestAuthentication))
    {
      AppMonitor.setRequestAuthInfo(false, paramIUTRequestAuthentication.getAppkey(), ((UTBaseRequestAuthentication)paramIUTRequestAuthentication).getAppSecret(), null);
      return;
    }
    AppMonitor.setRequestAuthInfo(true, paramIUTRequestAuthentication.getAppkey(), null, ((UTSecuritySDKRequestAuthentication)paramIUTRequestAuthentication).getAuthCode());
  }
  
  public void turnOffAutoPageTrack()
  {
    UTPageHitHelper.getInstance().turnOffAutoPageTrack();
  }
  
  public void turnOffCrashHandler()
  {
    UTMiniCrashHandler.getInstance().turnOff();
  }
  
  public void turnOnDebug()
  {
    b.a().turnOnDebug();
  }
  
  public void updateSessionProperties(Map<String, String> paramMap)
  {
    Map localMap = c.a().a();
    HashMap localHashMap = new HashMap();
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    localHashMap.putAll(paramMap);
    c.a().e(localHashMap);
  }
  
  public void updateUserAccount(String paramString1, String paramString2)
  {
    b.a().updateUserAccount(paramString1, paramString2);
  }
  
  public void userRegister(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      UTTracker localUTTracker = getDefaultTracker();
      if (localUTTracker != null)
      {
        localUTTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, paramString, null, null, null).build());
        return;
      }
      i.a("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
      return;
    }
    i.a("userRegister", "Fatal Error,usernick can not be null or empty!");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\UTAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */