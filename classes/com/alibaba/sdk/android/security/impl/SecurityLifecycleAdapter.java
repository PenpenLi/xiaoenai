package com.alibaba.sdk.android.security.impl;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.initialization.InitializationHandler;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.PluginLifecycleAdapter;
import com.alibaba.sdk.android.plugin.PluginSyncLifecycleAdapter;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.security.AccessController;
import com.alibaba.sdk.android.security.CertificateService;
import com.alibaba.sdk.android.security.SecurityService;

public class SecurityLifecycleAdapter
  implements PluginLifecycleAdapter, PluginSyncLifecycleAdapter
{
  public void start(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    SecurityContext.appContext = paramAppContext;
    SecurityContext.pluginConfigurations = paramPluginContext.getPluginConfigurations();
    SecurityContext.executorService = (ExecutorService)paramAppContext.getService(ExecutorService.class, null);
    SecurityContext.disableSecurityGuardUT = paramPluginContext.getPluginConfigurations().getBooleanValue("disableSecurityGuardUT", false);
    CertificateManager.INSTANCE.init(paramAppContext.getAndroidContext());
    paramPluginContext = CertificateManager.INSTANCE;
    paramAppContext.registerService(new Class[] { CertificateService.class }, paramPluginContext, null);
    AccessControllerManager.INSTANCE.init();
    paramPluginContext = AccessControllerManager.INSTANCE;
    paramAppContext.registerService(new Class[] { InitializationHandler.class, AccessController.class }, paramPluginContext, null);
  }
  
  public void stop(AppContext paramAppContext, PluginContext paramPluginContext) {}
  
  public void syncStart(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    paramPluginContext = SecurityServiceImpl.INSTANCE;
    paramAppContext.registerService(new Class[] { SecurityService.class }, paramPluginContext, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\SecurityLifecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */