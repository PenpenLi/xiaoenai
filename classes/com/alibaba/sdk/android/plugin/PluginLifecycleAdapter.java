package com.alibaba.sdk.android.plugin;

import com.alibaba.sdk.android.app.AppContext;

public abstract interface PluginLifecycleAdapter
{
  public abstract void start(AppContext paramAppContext, PluginContext paramPluginContext);
  
  public abstract void stop(AppContext paramAppContext, PluginContext paramPluginContext);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\PluginLifecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */