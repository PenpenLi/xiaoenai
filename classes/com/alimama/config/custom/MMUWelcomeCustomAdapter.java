package com.alimama.config.custom;

import android.app.Activity;
import android.view.ViewGroup;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.CustomWelcomeAdapterBridge;

public abstract class MMUWelcomeCustomAdapter
{
  private CustomWelcomeAdapterBridge adapterBridge;
  
  public MMUWelcomeCustomAdapter()
  {
    MMLog.i("MMUWelcomeCustomAdapter init", new Object[0]);
    this.adapterBridge = CustomWelcomeAdapterBridge.getInstance();
  }
  
  public String getAPPID()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform getAPPID_1", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getId();
    }
    return null;
  }
  
  public ViewGroup getAdView()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform getAdView", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getAdView();
    }
    return null;
  }
  
  public Activity getMMUActivity()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform getMMUActivity", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getActivity();
    }
    return null;
  }
  
  public ViewGroup getViewContainer()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform getViewContainer", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getViewContainer();
    }
    return null;
  }
  
  public void notifyMMUAdClicked()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform notifyMMUAdClicked", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdClicked();
    }
  }
  
  public void notifyMMUAdCloseed()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform notifyMMUAdCloseed", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdCloseed();
    }
  }
  
  public void notifyMMUAdRequestAdFail()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform notifyMMUAdRequestAdFail", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdFail();
    }
  }
  
  public void notifyMMUAdShowSuccess()
  {
    MMLog.d("MMUWelcomeCustomEventPlatform notifyMMUAdShowSuccess", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdShowSuccess();
    }
  }
  
  public abstract void onFinishClearCache();
  
  public void setMmuCustomAdapter(Object paramObject)
  {
    this.adapterBridge.setMmuCustomWelcomeAdapter(paramObject);
  }
  
  public abstract void startRequestAd();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\custom\MMUWelcomeCustomAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */