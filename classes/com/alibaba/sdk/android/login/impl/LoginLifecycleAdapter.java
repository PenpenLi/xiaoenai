package com.alibaba.sdk.android.login.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.event.EventBus;
import com.alibaba.sdk.android.login.LoginService;
import com.alibaba.sdk.android.login.LoginServiceProvider;
import com.alibaba.sdk.android.login.LoginServiceProviderManager;
import com.alibaba.sdk.android.login.filter.ChannelExParamsFilterAction;
import com.alibaba.sdk.android.login.handler.WebViewProxyTaskHandlerAction;
import com.alibaba.sdk.android.login.support.LegacySupport;
import com.alibaba.sdk.android.login.task.DoubleCheckTask;
import com.alibaba.sdk.android.login.task.PageLogoutTask;
import com.alibaba.sdk.android.login.task.RefreshSidTask;
import com.alibaba.sdk.android.login.task.WebViewProxyPageLogoutTask;
import com.alibaba.sdk.android.login.task.WebViewProxyRefreshSidTask;
import com.alibaba.sdk.android.login.ui.handler.LoginHandlerImpl;
import com.alibaba.sdk.android.plugin.PluginContext;
import com.alibaba.sdk.android.plugin.PluginLifecycleAdapter;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.system.RequestCode;
import com.alibaba.sdk.android.ui.bus.MatchInfo;
import com.alibaba.sdk.android.ui.bus.UIBusInfoRegistry;
import com.alibaba.sdk.android.ui.bus.filter.FilterInfoBuilder;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfoBuilder;
import com.alibaba.sdk.android.ui.bus.handler.impl.AsyncTaskHandlerAction;
import com.alibaba.sdk.android.ui.support.ActivityResultHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LoginLifecycleAdapter
  implements PluginLifecycleAdapter
{
  public void start(AppContext paramAppContext, PluginContext paramPluginContext)
  {
    Object localObject1 = paramPluginContext.getPluginConfigurations();
    LoginContext.initialize(paramAppContext, (PluginConfigurations)localObject1);
    ((PluginConfigurations)localObject1).registerGlobalPropertyChangeListener(new LoginLifecycleAdapter.1(this));
    ((PluginConfigurations)localObject1).registerPropertyChangeListener(LoginServiceProviderManager.INSTANCE);
    Object localObject2 = paramAppContext.getEnvironment().name();
    localObject2 = AlibabaSDK.getProperty("trade", (String)localObject2 + "_TRADE_START_OVERRIDE_URLS");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      LoginContext.TRADE_START_OVERRIDE_URLS = ((String)localObject2).split("[,]");
    }
    localObject2 = new LoginActivityResultHandler();
    Object localObject3 = Collections.singletonMap("requestCodeKey", String.valueOf(RequestCode.OPEN_H5_LOGIN));
    paramAppContext.registerService(new Class[] { ActivityResultHandler.class }, localObject2, (Map)localObject3);
    localObject3 = Collections.singletonMap("requestCodeKey", String.valueOf(RequestCode.OPEN_TAOBAO));
    paramAppContext.registerService(new Class[] { ActivityResultHandler.class }, localObject2, (Map)localObject3);
    localObject3 = Collections.singletonMap("requestCodeKey", String.valueOf(RequestCode.OPEN_QR_LOGIN));
    paramAppContext.registerService(new Class[] { ActivityResultHandler.class }, localObject2, (Map)localObject3);
    localObject3 = Collections.singletonMap("requestCodeKey", String.valueOf(RequestCode.OPEN_QR_LOGIN_CONFIRM));
    paramAppContext.registerService(new Class[] { ActivityResultHandler.class }, localObject2, (Map)localObject3);
    localObject2 = H5LoginServiceProviderImpl.INSTANCE;
    localObject3 = Collections.singletonMap("loginServiceProviderName", "h5");
    paramAppContext.registerService(new Class[] { LoginServiceProvider.class }, localObject2, (Map)localObject3);
    localObject2 = TaobaoLoginServiceProviderImpl.INSTANCE;
    localObject3 = Collections.singletonMap("loginServiceProviderName", "taobao");
    paramAppContext.registerService(new Class[] { LoginServiceProvider.class }, localObject2, (Map)localObject3);
    localObject2 = Collections.singletonMap("$isv_scope$", "true");
    localObject3 = new LoginServiceImpl();
    paramAppContext.registerService(new Class[] { LoginService.class }, localObject3, (Map)localObject2);
    if (LegacySupport.sessionListener != null) {
      ((LoginService)localObject3).setSessionListener(LegacySupport.sessionListener);
    }
    paramPluginContext = paramPluginContext.getPluginConfigurations();
    localObject2 = paramAppContext.getEnvironment().name();
    paramAppContext = (UIBusInfoRegistry)paramAppContext.getService(UIBusInfoRegistry.class);
    localObject1 = ((PluginConfigurations)localObject1).getStringValue((String)localObject2 + "_LOGIN_URLS", "login.m.taobao.com/login.htm");
    paramAppContext.registerHandlerInfo(HandlerInfoBuilder.newHandlerInfo("loginHandler").setHandlerType(LoginHandlerImpl.class.getName()).addMatchInfo("login", "start", MatchInfo.HTTP_HTTPS_SCHEMES, ((String)localObject1).split("[,]")).setHandlerAction(AsyncTaskHandlerAction.class.getName()).addHandlerActionParameter("asyncClassName", RefreshSidTask.class.getName()).setHanlderScenarios(new int[] { 2 }).getHandlerInfo());
    paramAppContext.registerHandlerInfo(HandlerInfoBuilder.newHandlerInfo("proxyLoginHandler").setHandlerType(LoginHandlerImpl.class.getName()).addMatchInfo("login", "start", MatchInfo.HTTP_HTTPS_SCHEMES, ((String)localObject1).split("[,]")).setHandlerAction(WebViewProxyTaskHandlerAction.class.getName()).addHandlerActionParameter("asyncClassName", WebViewProxyRefreshSidTask.class.getName()).setHanlderScenarios(new int[] { 4 }).getHandlerInfo());
    paramPluginContext = paramPluginContext.getStringValue((String)localObject2 + "_LOGOUT_URLS", "login.m.taobao.com/logout.htm");
    paramAppContext.registerHandlerInfo(HandlerInfoBuilder.newHandlerInfo("logoutHandler").addMatchInfo("logout", "start", MatchInfo.HTTP_HTTPS_SCHEMES, paramPluginContext.split("[,]")).setHandlerType(LoginHandlerImpl.class.getName()).setHandlerAction(AsyncTaskHandlerAction.class.getName()).addHandlerActionParameter("asyncClassName", PageLogoutTask.class.getName()).setHanlderScenarios(new int[] { 2 }).getHandlerInfo());
    paramAppContext.registerHandlerInfo(HandlerInfoBuilder.newHandlerInfo("proxyLogoutHandler").addMatchInfo("logout", "start", MatchInfo.HTTP_HTTPS_SCHEMES, paramPluginContext.split("[,]")).setHandlerType(LoginHandlerImpl.class.getName()).setHandlerAction(WebViewProxyTaskHandlerAction.class.getName()).addHandlerActionParameter("asyncClassName", WebViewProxyPageLogoutTask.class.getName()).setHanlderScenarios(new int[] { 4 }).getHandlerInfo());
    paramAppContext.registerHandlerInfo(HandlerInfoBuilder.newHandlerInfo("doubleCheckHandler").setHandlerType(LoginHandlerImpl.class.getName()).addMatchInfo("webviewbridge", "start", MatchInfo.HTTP_HTTPS_SCHEMES, new String[] { "www.alipay.com/webviewbridge" }).setHandlerAction(AsyncTaskHandlerAction.class.getName()).addHandlerActionParameter("asyncClassName", DoubleCheckTask.class.getName()).setHandlerScopes(new String[] { "login" }).setHanlderScenarios(new int[] { 2 }).getHandlerInfo());
    paramPluginContext = FilterInfoBuilder.newFilterInfo("tradeChannelExParams");
    paramPluginContext.addMatchInfo("tradeChannelExParamsStartMatches", "start", MatchInfo.HTTP_HTTPS_SCHEMES, LoginContext.TRADE_START_OVERRIDE_URLS);
    paramPluginContext.addMatchInfo("tradeChannelExParamsPatternMatches", "pattern", MatchInfo.HTTP_HTTPS_SCHEMES, LoginContext.TRADE_PATTERN_OVERRIDE_URLS);
    paramPluginContext.setFilterScenarios(new int[] { 1, 2, 4 });
    localObject1 = new HashMap();
    ((Map)localObject1).put("umpChannel", "tradeChannel");
    ((Map)localObject1).put("u_channel", "tradeChannel");
    ((Map)localObject1).put("isv_code", "isv_code");
    paramPluginContext.addFilterAction("addTradeChannelExParams", ChannelExParamsFilterAction.class.getName(), (Map)localObject1);
    paramAppContext.registerFilterInfo(paramPluginContext.getFilterInfo());
    paramAppContext = EventBus.getDefault();
    paramPluginContext = new LoginLifecycleAdapter.2(this);
    paramAppContext.registerEventListener(new String[] { "rpc-degrade", "init-degrade" }, paramPluginContext);
  }
  
  public void stop(AppContext paramAppContext, PluginContext paramPluginContext) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginLifecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */