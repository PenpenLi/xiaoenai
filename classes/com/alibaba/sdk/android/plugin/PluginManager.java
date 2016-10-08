package com.alibaba.sdk.android.plugin;

public abstract interface PluginManager
{
  public abstract String[] getPluginNames();
  
  public abstract PluginState getPluginState(String paramString);
  
  public abstract void startPlugin(String paramString);
  
  public abstract void stopPlugin(String paramString);
  
  public abstract void syncStartPlugin(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\PluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */