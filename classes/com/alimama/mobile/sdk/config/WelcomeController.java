package com.alimama.mobile.sdk.config;

import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.WelcomePluginBridge;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

public class WelcomeController
{
  public void close()
  {
    try
    {
      WelcomePluginBridge.getInstance().AlimamaSplashAdapter_ManualDismiss.invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMLog.e(localException, "", new Object[0]);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\WelcomeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */