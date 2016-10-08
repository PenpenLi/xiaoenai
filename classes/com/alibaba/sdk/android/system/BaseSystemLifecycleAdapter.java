package com.alibaba.sdk.android.system;

import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.initialization.InitializationHandler;
import com.alibaba.sdk.android.initialization.InitializationServiceClient;
import com.alibaba.sdk.android.initialization.impl.DefaultInitializationServiceClientImpl;
import com.alibaba.sdk.android.initialization.impl.DynamicConfigInitHandler;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.PluginLifecycleAdapter;
import com.alibaba.sdk.android.plugin.PluginSyncLifecycleAdapter;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.security.CertificateService;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.SessionService;
import com.alibaba.sdk.android.session.impl.CredentialManager;
import com.alibaba.sdk.android.session.impl.SessionServiceImpl;
import com.alibaba.sdk.android.time.TimeService;
import com.alibaba.sdk.android.time.impl.TimeServiceImpl;
import com.alibaba.sdk.android.ut.UserTrackerService;
import java.util.Collections;
import java.util.Map;

public class BaseSystemLifecycleAdapter
  implements PluginLifecycleAdapter, PluginSyncLifecycleAdapter
{
  public void start(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    Object localObject1 = Collections.singletonMap("plugin.vendor", "security");
    SystemContext.pluginSystemConfigurations = (PluginSystemConfigurations)paramAppContext.getService(PluginSystemConfigurations.class);
    SystemContext.certificateService = (CertificateService)paramAppContext.getService(CertificateService.class, (Map)localObject1);
    SystemContext.userTrackerService = (UserTrackerService)paramAppContext.getService(UserTrackerService.class, null);
    SystemContext.executorService = (ExecutorService)paramAppContext.getService(ExecutorService.class, null);
    SystemContext.securityService = (SecurityService)paramAppContext.getService(SecurityService.class, (Map)localObject1);
    localObject1 = paramPluginContext.getPluginConfigurations();
    Object localObject2 = paramAppContext.getEnvironment().name();
    SystemContext.topGateWayUrl = ((PluginConfigurations)localObject1).getStringValue((String)localObject2 + "_TOP_GATEWAY_URL", "http://gw.api.taobao.com/router/rest");
    SystemContext.logoutUrl = ((PluginConfigurations)localObject1).getStringValue((String)localObject2 + "_INIT_LOGOUT_URL", "http://sdkinit.taobao.com/logout.htm");
    SystemContext.configPollUrl = ((PluginConfigurations)localObject1).getStringValue((String)localObject2 + "_CONFIG_POLL_URL", "http://sdkinit.taobao.com/sdkConfigVersion.htm");
    SystemContext.initUrl = ((PluginConfigurations)localObject1).getStringValue((String)localObject2 + "_INIT_URL", "http://sdkinit.taobao.com/init.htm");
    localObject1 = new DefaultInitializationServiceClientImpl(paramAppContext);
    paramAppContext.registerService(new Class[] { InitializationServiceClient.class }, localObject1, null);
    localObject2 = CredentialManager.INSTANCE.getSessionInitHandler(false);
    paramAppContext.registerService(new Class[] { InitializationHandler.class }, localObject2, null);
    paramPluginContext = new DynamicConfigInitHandler(paramPluginContext.getPluginConfigurations());
    paramAppContext.registerService(new Class[] { InitializationHandler.class }, paramPluginContext, null);
    ((DefaultInitializationServiceClientImpl)localObject1).request();
    paramPluginContext = SessionServiceImpl.INSTANCE;
    paramAppContext.registerService(new Class[] { SessionService.class }, paramPluginContext, null);
    paramPluginContext = CredentialManager.INSTANCE;
    localObject1 = Collections.singletonMap("scop", "system");
    paramAppContext.registerService(new Class[] { CredentialService.class }, paramPluginContext, (Map)localObject1);
    paramPluginContext = TimeServiceImpl.INSTANCE;
    paramAppContext.registerService(new Class[] { TimeService.class }, paramPluginContext, null);
  }
  
  public void stop(AppContext paramAppContext, PluginContext paramPluginContext) {}
  
  public void syncStart(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    SystemContext.appContext = paramAppContext;
    SystemContext.pluginConfigurations = paramPluginContext.getPluginConfigurations();
    SystemContext.securityGuardService = (SecurityGuardService)paramAppContext.getService(SecurityGuardService.class, Collections.singletonMap("plugin.vendor", "security"));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\system\BaseSystemLifecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */