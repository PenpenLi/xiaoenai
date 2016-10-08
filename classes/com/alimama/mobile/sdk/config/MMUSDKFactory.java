package com.alimama.mobile.sdk.config;

import android.app.Activity;
import com.alimama.mobile.sdk.MMUSDK;
import com.alimama.mobile.sdk.config.system.HookManager;
import com.alimama.mobile.sdk.config.system.MMUSDKImpl;

public final class MMUSDKFactory
{
  private static MMUSDK mSdk;
  
  public static MMUSDK getMMUSDK()
  {
    if (mSdk == null) {
      mSdk = new MMUSDKImpl();
    }
    return mSdk;
  }
  
  public static void registerAcvitity(Class<? extends Activity> paramClass)
  {
    HookManager.registerAcvitity(paramClass);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\MMUSDKFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */