package com.alibaba.sdk.android.rpc.impl;

import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.plugin.PluginLifecycleAdapter;
import com.alibaba.sdk.android.plugin.PluginSyncLifecycleAdapter;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.security.SecurityGuardService;
import java.util.concurrent.ExecutorService;

public class RpcLifecycleAdapter
  implements PluginLifecycleAdapter, PluginSyncLifecycleAdapter
{
  public void start(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    RpcContext.securityGuardService = (SecurityGuardService)paramAppContext.getService(SecurityGuardService.class);
    RpcContext.executorService = (ExecutorService)paramAppContext.getService(ExecutorService.class);
    PluginConfigurations localPluginConfigurations = paramPluginContext.getPluginConfigurations();
    RpcContext.rpcHTTPGateway = localPluginConfigurations.getStringValue(paramAppContext.getEnvironment().name() + "_RPC_KEY_OF_RPC_HTTP_GATEWAY", "http://gw.channel.aliyun.com/g2");
    RpcContext.defaultAPIVersion = localPluginConfigurations.getStringValue(paramAppContext.getEnvironment().name() + "_DEFAULT_API_VERSION", "1.0.0");
    RpcContext.httpDNSEnabled = localPluginConfigurations.getBooleanValue("httpDNSEnabled", true);
    RpcContext.includeResourceInHttpHeader = localPluginConfigurations.getBooleanValue("includeResourceInHttpHeader", false);
    paramPluginContext.getPluginConfigurations().registerPropertyChangeListener(new RpcLifecycleAdapter.1(this));
    paramPluginContext = new RpcServiceImpl();
    paramAppContext.registerService(new Class[] { RpcService.class }, paramPluginContext, null);
  }
  
  public void stop(AppContext paramAppContext, PluginContext paramPluginContext) {}
  
  public void syncStart(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    RpcContext.appContext = paramAppContext;
    RpcContext.pluginConfigurations = paramPluginContext.getPluginConfigurations();
    RpcContext.rpcVersion = paramPluginContext.getPluginInfo().version;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\impl\RpcLifecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */