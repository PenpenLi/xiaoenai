package com.alimama.config.custom;

import android.app.Activity;
import android.view.ViewGroup;
import com.alimama.listener.MMUAdInfoStateReporter;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.CustomLoopImageAdapterBridge;
import java.util.HashMap;

public abstract class MMULoopImageCustomAdapter
{
  private CustomLoopImageAdapterBridge adapterBridge;
  
  public MMULoopImageCustomAdapter()
  {
    MMLog.i("MMULoopImageCustomAdapter init", new Object[0]);
    this.adapterBridge = CustomLoopImageAdapterBridge.getInstance();
  }
  
  public void addMMUAdInfo(HashMap<String, Object> paramHashMap, MMUAdInfoStateReporter paramMMUAdInfoStateReporter)
  {
    MMLog.d("MMULoopImageCustomEventPlatform addMMUAdInfo", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.addMMUAdInfo(paramHashMap, paramMMUAdInfoStateReporter);
    }
  }
  
  public String getAPPID()
  {
    MMLog.d("MMULoopImageCustomEventPlatform getAPPID_1", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getId();
    }
    return null;
  }
  
  public ViewGroup getContainer()
  {
    MMLog.d("MMULoopImageCustomEventPlatform getContainer", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getContainer();
    }
    return null;
  }
  
  public Activity getMMUActivity()
  {
    MMLog.d("MMULoopImageCustomEventPlatform getMMUActivity", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getActivity();
    }
    return null;
  }
  
  public void notifyMMUAdClicked()
  {
    MMLog.d("MMULoopImageCustomEventPlatform notifyMMUAdClicked", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdClicked();
    }
  }
  
  public void notifyMMUAdRequestAdFail()
  {
    MMLog.d("MMULoopImageCustomEventPlatform notifyMMUAdRequestAdFail", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdFail();
    }
  }
  
  public void notifyMMUAdRequestAdSuccess()
  {
    MMLog.d("MMULoopImageCustomEventPlatform notifyMMUAdRequestAdSuccess", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdSuccess();
    }
  }
  
  public void notifyMMUAdShowAdSuccess()
  {
    MMLog.d("MMULoopImageCustomEventPlatform notifyMMUAdShowAdSuccess", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdShowAdSuccess();
    }
  }
  
  public void setMmuCustomAdapter(Object paramObject)
  {
    this.adapterBridge.setMmuCustomLoopImageAdapter(paramObject);
  }
  
  public abstract void startRequestAd();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\custom\MMULoopImageCustomAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */