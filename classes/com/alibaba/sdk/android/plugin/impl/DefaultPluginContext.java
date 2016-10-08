package com.alibaba.sdk.android.plugin.impl;

import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.plugin.config.impl.DefaultPluginConfigurations;
import com.alibaba.sdk.android.registry.ServiceRegistry;

public class DefaultPluginContext
  implements PluginContext
{
  private DefaultPluginConfigurations pluginConfigurations;
  private PluginInfo pluginInfo;
  
  public DefaultPluginContext(PluginInfo paramPluginInfo)
  {
    this.pluginInfo = paramPluginInfo;
    this.pluginConfigurations = new DefaultPluginConfigurations(paramPluginInfo, (PluginSystemConfigurations)KernelContext.serviceRegistry.getService(PluginSystemConfigurations.class, null));
  }
  
  public void destroy()
  {
    this.pluginConfigurations.destroy();
  }
  
  public PluginConfigurations getPluginConfigurations()
  {
    return this.pluginConfigurations;
  }
  
  public PluginInfo getPluginInfo()
  {
    return this.pluginInfo;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\impl\DefaultPluginContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */