package com.alibaba.sdk.android.repository;

import com.alibaba.sdk.android.plugin.PluginInfo;

public abstract interface PluginRepository
{
  public abstract PluginInfo getPluginInfo(String paramString);
  
  public abstract PluginInfo[] getPluginInfos();
  
  public abstract String[] getPluginNames();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\repository\PluginRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */