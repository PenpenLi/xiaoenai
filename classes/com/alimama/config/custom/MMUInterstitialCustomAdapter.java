package com.alimama.config.custom;

import android.app.Activity;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.CustomInterstitialAdapterBridge;

public abstract class MMUInterstitialCustomAdapter
{
  private CustomInterstitialAdapterBridge adapterBridge;
  
  public MMUInterstitialCustomAdapter()
  {
    MMLog.i("MMUInterstitialCustomAdapter init", new Object[0]);
    this.adapterBridge = CustomInterstitialAdapterBridge.getInstance();
  }
  
  public String getAPPID()
  {
    MMLog.d("MMUInterstitialCustomEventPlatform getAPPID_1", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getId();
    }
    return null;
  }
  
  public Activity getMMUActivity()
  {
    MMLog.d("MMUInterstitialCustomEventPlatform getMMUActivity", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getActivity();
    }
    return null;
  }
  
  public void notifyMMUAdClicked()
  {
    MMLog.d("MMUInterstitialCustomEventPlatform notifyMMUAdClicked", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdClicked();
    }
  }
  
  public void notifyMMUAdCloseed()
  {
    MMLog.d("MMUInterstitialCustomEventPlatform notifyMMUAdCloseed", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdCloseed();
    }
  }
  
  public void notifyMMUAdRequestAdFail()
  {
    MMLog.d("MMUInterstitialCustomEventPlatform notifyMMUAdRequestAdFail", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdFail();
    }
  }
  
  public void notifyMMUAdRequestAdSuccess()
  {
    MMLog.d("MMUInterstitialCustomEventPlatform notifyMMUAdRequestAdSuccess", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdSuccess();
    }
  }
  
  public void notifyMMUAdShowSuccess()
  {
    MMLog.d("MMUInterstitialCustomEventPlatform notifyMMUAdShowSuccess", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdShowSuccess();
    }
  }
  
  public abstract void onFinishClearCache();
  
  public void setMmuCustomAdapter(Object paramObject)
  {
    this.adapterBridge.setMmuCustomInterstitialAdapter(paramObject);
  }
  
  public abstract void startRequestAd();
  
  public abstract void startShowAd();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\custom\MMUInterstitialCustomAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */