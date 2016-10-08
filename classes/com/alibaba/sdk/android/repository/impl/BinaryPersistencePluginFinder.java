package com.alibaba.sdk.android.repository.impl;

import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.PersistentUtils.ObjectStore;
import java.io.IOException;

public class BinaryPersistencePluginFinder
{
  private static final String TAG = "kernel";
  private PersistentUtils.ObjectStore<PluginInfo[]> store = new PersistentUtils.ObjectStore("alisdk_plugin_list", ".pluginlist");
  
  public PluginInfo[] findPlugins()
  {
    try
    {
      PluginInfo[] arrayOfPluginInfo = (PluginInfo[])this.store.readItem();
      return arrayOfPluginInfo;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      AliSDKLogger.e("kernel", "Fail to read the plugin list from pluginlist file", localClassNotFoundException);
    }
    return null;
  }
  
  public void writePluginInfos(PluginInfo[] paramArrayOfPluginInfo)
  {
    try
    {
      this.store.writeItem(paramArrayOfPluginInfo);
      return;
    }
    catch (IOException paramArrayOfPluginInfo)
    {
      paramArrayOfPluginInfo.printStackTrace();
      AliSDKLogger.e("kernel", "fail to write the plugin info", paramArrayOfPluginInfo);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\repository\impl\BinaryPersistencePluginFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */