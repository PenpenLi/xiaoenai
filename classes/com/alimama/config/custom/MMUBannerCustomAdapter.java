package com.alimama.config.custom;

import android.app.Activity;
import android.view.ViewGroup;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.CustomBannerAdapterBridge;

public abstract class MMUBannerCustomAdapter
{
  private CustomBannerAdapterBridge adapterBridge;
  
  public MMUBannerCustomAdapter()
  {
    MMLog.i("MMUBannerCustomAdapter init", new Object[0]);
    this.adapterBridge = CustomBannerAdapterBridge.getInstance();
  }
  
  public void addAdView(ViewGroup paramViewGroup)
  {
    MMLog.d("MMUBannerCustomEventPlatform adView:" + paramViewGroup, new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.addAdView(paramViewGroup);
    }
  }
  
  public String getAPPID()
  {
    MMLog.d("MMUBannerCustomEventPlatform getAPPID_1", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getId();
    }
    return null;
  }
  
  public Activity getMMUActivity()
  {
    MMLog.d("MMUBannerCustomEventPlatform getMMUActivity", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getActivity();
    }
    return null;
  }
  
  public void notifyMMUAdRequestAdFail()
  {
    MMLog.d("MMUBannerCustomEventPlatform notifyMMUAdRequestAdFail", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdFail();
    }
  }
  
  public void notifyMMUAdRequestAdSuccess()
  {
    MMLog.d("MMUBannerCustomEventPlatform notifyMMUAdRequestAdSuccess", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdSuccess();
    }
  }
  
  public abstract void onFinishClearCache();
  
  public void setMmuCustomAdapter(Object paramObject)
  {
    this.adapterBridge.setMmuCustomBannerAdapter(paramObject);
  }
  
  public abstract void startRequestAd();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\custom\MMUBannerCustomAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */