package com.alimama.mobile.sdk.config;

import com.alimama.mobile.sdk.MMUSDK;
import com.alimama.mobile.sdk.MMUSDK.PLUGIN_LOAD_STATUS;

public class LoopImageController
{
  public static LoopImageController newInstance()
  {
    if (MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED == MMUSDKFactory.getMMUSDK().getStatus()) {
      return new LoopImageController();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\LoopImageController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */