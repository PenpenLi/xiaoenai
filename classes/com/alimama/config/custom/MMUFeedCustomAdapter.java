package com.alimama.config.custom;

import android.app.Activity;
import com.alimama.listener.MMUAdInfoStateReporter;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.config.system.bridge.CustomFeedAdapterBridge;
import java.util.HashMap;

public abstract class MMUFeedCustomAdapter
{
  private CustomFeedAdapterBridge adapterBridge;
  
  public MMUFeedCustomAdapter()
  {
    MMLog.i("MMUFeedCustomAdapter init", new Object[0]);
    this.adapterBridge = CustomFeedAdapterBridge.getInstance();
  }
  
  public void addMMUAdInfo(HashMap<String, Object> paramHashMap, MMUAdInfoStateReporter paramMMUAdInfoStateReporter)
  {
    MMLog.d("MMUFeedCustomEventPlatform addMMUAdInfo", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.addMMUAdInfo(paramHashMap, paramMMUAdInfoStateReporter);
    }
  }
  
  public String getAPPID()
  {
    MMLog.d("MMUFeedCustomEventPlatform getAPPID_1", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getId();
    }
    return null;
  }
  
  public Activity getMMUActivity()
  {
    MMLog.d("MMUFeedCustomEventPlatform getMMUActivity", new Object[0]);
    if (this.adapterBridge != null) {
      return this.adapterBridge.getActivity();
    }
    return null;
  }
  
  public void notifyMMUAdRequestAdFail()
  {
    MMLog.d("MMUFeedCustomEventPlatform notifyMMUAdRequestAdFail", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdFail();
    }
  }
  
  public void notifyMMUAdRequestAdSuccess()
  {
    MMLog.d("MMUFeedCustomEventPlatform notifyMMUAdRequestAdSuccess", new Object[0]);
    if (this.adapterBridge != null) {
      this.adapterBridge.notifyMMUAdRequestAdSuccess();
    }
  }
  
  public void setMmuCustomAdapter(Object paramObject)
  {
    this.adapterBridge.setMmuCustomFeedAdapter(paramObject);
  }
  
  public abstract void startRequestAd();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\config\custom\MMUFeedCustomAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */