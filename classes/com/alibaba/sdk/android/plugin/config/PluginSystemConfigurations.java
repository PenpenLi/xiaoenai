package com.alibaba.sdk.android.plugin.config;

public abstract interface PluginSystemConfigurations
{
  public abstract void addStartRequiredPlugin(String paramString);
  
  public abstract String getGlobalProperty(String paramString);
  
  public abstract String getPluginProperty(String paramString1, String paramString2);
  
  public abstract String[] getStartedPluginNames();
  
  public abstract void removeStartRequiredPlugin(String paramString);
  
  public abstract void setDynamicProperties(String paramString);
  
  public abstract void setGlobalProperty(String paramString1, String paramString2);
  
  public abstract void setPluginProperty(String paramString1, String paramString2, String paramString3);
  
  public abstract void unsetGlobalProperty(String paramString);
  
  public abstract void unsetPluginProperty(String paramString1, String paramString2);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\config\PluginSystemConfigurations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */