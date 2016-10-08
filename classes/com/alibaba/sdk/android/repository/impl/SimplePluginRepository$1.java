package com.alibaba.sdk.android.repository.impl;

import com.alibaba.sdk.android.plugin.PluginInfo;

class SimplePluginRepository$1
  implements Runnable
{
  SimplePluginRepository$1(SimplePluginRepository paramSimplePluginRepository, PluginInfo[] paramArrayOfPluginInfo) {}
  
  public void run()
  {
    SimplePluginRepository.access$000(this.this$0).writePluginInfos(this.val$targetPluginInfos);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\repository\impl\SimplePluginRepository$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */