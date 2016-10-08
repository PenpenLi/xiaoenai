package com.alibaba.sdk.android.ui;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.event.EventBus;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.PluginLifecycleAdapter;
import com.alibaba.sdk.android.plugin.PluginSyncLifecycleAdapter;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.security.AccessController;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.ui.bus.MatchInfo;
import com.alibaba.sdk.android.ui.bus.UIBus;
import com.alibaba.sdk.android.ui.bus.UIBusInfoRegistry;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfo;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfoBuilder;
import com.alibaba.sdk.android.ui.bus.filter.impl.WebAccessControlFilterAction;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfoBuilder;
import com.alibaba.sdk.android.ui.bus.handler.impl.SessionExceptionHandlerAction;
import com.alibaba.sdk.android.ui.bus.handler.impl.StartActivityHandlerAction;
import com.alibaba.sdk.android.web.CookieService;
import com.alibaba.sdk.android.web.H5WebPageService;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;
import com.alibaba.sdk.android.web.impl.H5WebPageServiceImpl;
import com.alibaba.sdk.android.webview.DefaultTaeWebViewHistoryHelper;
import java.util.Collections;
import java.util.regex.Pattern;

public class UIComponent
  implements PluginLifecycleAdapter, PluginSyncLifecycleAdapter
{
  private void initIgnoreWebviewSslErrorUrlPatterns(PluginContext paramPluginContext)
  {
    try
    {
      paramPluginContext = paramPluginContext.getPluginConfigurations().getStringValue("ignoreWebViewSslErrorUrlPatterns");
      if (paramPluginContext != null)
      {
        paramPluginContext = paramPluginContext.split("[;]");
        if (paramPluginContext.length > 0)
        {
          Pattern[] arrayOfPattern = new Pattern[paramPluginContext.length];
          int i = 0;
          int j = paramPluginContext.length;
          while (i < j)
          {
            arrayOfPattern[i] = Pattern.compile(paramPluginContext[i]);
            i += 1;
          }
          UIContext.SSL_ERROR_IGNORE_URLS = arrayOfPattern;
        }
      }
      return;
    }
    catch (Exception paramPluginContext) {}
  }
  
  public void start(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    UIContext.accessController = (AccessController)paramAppContext.getService(AccessController.class, Collections.singletonMap("plugin.vendor", "security"));
    initIgnoreWebviewSslErrorUrlPatterns(paramPluginContext);
    UIContext.rpcService = (RpcService)paramAppContext.getService(RpcService.class);
    CookieManagerWrapper.INSTANCE.init();
    Object localObject1 = CookieManagerWrapper.INSTANCE;
    paramAppContext.registerService(new Class[] { CookieService.class }, localObject1, null);
    paramPluginContext.getPluginConfigurations().registerPropertyChangeListener(CookieManagerWrapper.INSTANCE);
    localObject1 = new H5WebPageServiceImpl();
    paramAppContext.registerService(new Class[] { H5WebPageService.class }, localObject1, null);
    localObject1 = UIBus.getDefault();
    paramAppContext.registerService(new Class[] { UIBusInfoRegistry.class }, localObject1, null);
    Object localObject2 = paramPluginContext.getPluginConfigurations();
    String str = paramAppContext.getEnvironment().name();
    localObject1 = new String[1];
    localObject1[0] = "login.m.taobao.com/sdk/signfail.htm";
    localObject2 = ((PluginConfigurations)localObject2).getStringValue(str + "_SESSION_EXCEPTION_OVERRIDE_URLS");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).split("[,]");
    }
    localObject1 = HandlerInfoBuilder.newHandlerInfo("sessionExceptionHandler").addMatchInfo("session", "start", MatchInfo.HTTP_HTTPS_SCHEMES, (String[])localObject1).setHandlerAction(SessionExceptionHandlerAction.class.getName()).getHandlerInfo();
    UIBus.getDefault().registerHandlerInfo((HandlerInfo)localObject1);
    localObject1 = HandlerInfoBuilder.newHandlerInfo("startActivityHandler").addMatchInfo("startActivity", "all", new String[] { "tel", "sms", "smsto", "mms", "mmsto" }, null).setHandlerAction(StartActivityHandlerAction.class.getName()).getHandlerInfo();
    UIBus.getDefault().registerHandlerInfo((HandlerInfo)localObject1);
    if (paramPluginContext.getPluginConfigurations().getBooleanValue("enableUrlAccessCheck", false))
    {
      localObject1 = FilterInfoBuilder.newFilterInfo("accessControlFilter").addMatchInfo("accessControlMatch", "all", MatchInfo.HTTP_HTTPS_SCHEMES, null).setFilterScenarios(new int[] { 1 }).addFilterAction("checkAccessControl", WebAccessControlFilterAction.class.getName(), null).setFilterOrder(Boolean.valueOf(true), null, null, null).setProcceed(false).getFilterInfo();
      UIBus.getDefault().registerFilterInfo((FilterInfo)localObject1);
    }
    paramPluginContext = new UIComponent.1(this, paramPluginContext);
    paramAppContext.registerService(new Class[] { InitResultCallback.class }, paramPluginContext, null);
  }
  
  public void stop(AppContext paramAppContext, PluginContext paramPluginContext) {}
  
  public void syncStart(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    UIContext.appContext = paramAppContext;
    UIContext.executorService = (ExecutorService)paramAppContext.getService(ExecutorService.class);
    UIContext.pluginConfigurations = paramPluginContext.getPluginConfigurations();
    UIContext.domains = paramPluginContext.getPluginConfigurations().getStringValue(paramAppContext.getEnvironment().name() + "_COOKIE_DOMAINS", ".taobao.com,.tmall.com,.tmall.hk").split("[,]");
    UIContext.mobileDomains = paramPluginContext.getPluginConfigurations().getStringValue(paramAppContext.getEnvironment().name() + "_MOBILE_COOKIE_DOMAINS", "..m.taobao.com,.m.tmall.com,.m.tmall.hk,.m.etao.com").split("[,]");
    UIContext.securityGuardService = (SecurityGuardService)paramAppContext.getService(SecurityGuardService.class);
    UIContext.securityService = (SecurityService)paramAppContext.getService(SecurityService.class, Collections.singletonMap("plugin.vendor", "security"));
    UIContext.historyHelper = new DefaultTaeWebViewHistoryHelper(paramPluginContext.getPluginConfigurations());
    try
    {
      CookieSyncManager.createInstance(paramAppContext.getAndroidContext());
      CookieManager.getInstance().setAcceptCookie(true);
      paramPluginContext = paramPluginContext.getPluginConfigurations();
      paramAppContext = paramPluginContext.getStringValue("cookieNamesWithApplicationLifecycle", "");
      if (TextUtils.isEmpty(paramAppContext))
      {
        paramAppContext = new String[0];
        UIContext.cookieNamesWithApplicationLifecycle = paramAppContext;
        paramAppContext = paramPluginContext.getStringValue("cookieNamesWithWebViewLifecycle", "");
        if (!TextUtils.isEmpty(paramAppContext)) {
          break label314;
        }
      }
      label314:
      for (paramAppContext = new String[0];; paramAppContext = paramAppContext.split("[,]"))
      {
        UIContext.cookieNamesWithWebViewLifecycle = paramAppContext;
        paramAppContext = EventBus.getDefault();
        paramPluginContext = new UIComponent.2(this);
        paramAppContext.registerEventListener(new String[] { "session.refreshSid", "session.refreshLogin", "session.init" }, paramPluginContext);
        return;
        paramAppContext = paramAppContext.split("[,]");
        break;
      }
    }
    catch (Throwable paramAppContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\UIComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */