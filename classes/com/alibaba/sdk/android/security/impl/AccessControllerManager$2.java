package com.alibaba.sdk.android.security.impl;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.plugin.PluginManager;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.util.Iterator;
import java.util.Set;

class AccessControllerManager$2
  implements Runnable
{
  AccessControllerManager$2(AccessControllerManager paramAccessControllerManager) {}
  
  public void run()
  {
    PluginManager localPluginManager = (PluginManager)SecurityContext.appContext.getService(PluginManager.class, null);
    Iterator localIterator = AccessControllerManager.access$200(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localPluginManager.stopPlugin(str);
      }
      catch (Exception localException)
      {
        AliSDKLogger.e(AccessControllerManager.access$300(), "Fail to stop the plugin " + str + ", the error message is " + localException.getMessage());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\AccessControllerManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */