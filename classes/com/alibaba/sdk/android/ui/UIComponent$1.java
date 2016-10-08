package com.alibaba.sdk.android.ui;

import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.ui.bus.UIBus;

class UIComponent$1
  implements InitResultCallback
{
  UIComponent$1(UIComponent paramUIComponent, PluginContext paramPluginContext) {}
  
  public void onFailure(int paramInt, String paramString) {}
  
  public void onSuccess()
  {
    UIBus.getDefault().initialize();
    this.val$pluginContext.getPluginConfigurations().registerGlobalPropertyChangeListener(new UIComponent.1.1(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\UIComponent$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */