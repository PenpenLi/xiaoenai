package com.ut.mini.plugin;

import com.alibaba.mtl.log.e.i;

class UTPluginMgr$3
  implements UTPluginContextValueDispatchDelegate
{
  UTPluginMgr$3(UTPluginMgr paramUTPluginMgr) {}
  
  public void onPluginContextValueChange(UTPluginContext paramUTPluginContext)
  {
    paramUTPluginContext.setDebugLogFlag(i.n());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\plugin\UTPluginMgr$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */