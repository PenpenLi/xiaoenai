package com.alibaba.sdk.android.ut.impl;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.PluginLifecycleAdapter;

public class UTLifecycleAdapter
  implements PluginLifecycleAdapter
{
  public void start(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    UTContext.appContext = paramAppContext;
  }
  
  public void stop(AppContext paramAppContext, PluginContext paramPluginContext) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ut\impl\UTLifecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */