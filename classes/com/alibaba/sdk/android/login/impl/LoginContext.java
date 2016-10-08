package com.alibaba.sdk.android.login.impl;

import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.web.CookieService;
import java.util.Map;

public class LoginContext
{
  public static final String TAG = "login";
  public static String[] TRADE_PATTERN_OVERRIDE_URLS = { "[^.]+.tmall.com[.]*" };
  public static String[] TRADE_START_OVERRIDE_URLS = { "buy.m.tmall.com/order/confirmOrderWap.htm", "h5.m.taobao.com/awp/base/buy.htm", "h5.m.taobao.com/awp/base/order.htm", "detail.m.tmall.com/item.htm", "h5.m.taobao.com/awp/base/bag.htm", "h5.m.taobao.com/cm/snap/index.html", "h5.m.taobao.com/awp/core/detail.htm", "h5.m.taobao.com/awp/base/cart.htm", "shop.m.taobao.com/shop/shopIndex.htm", "h5.m.taobao.com/cart/order.htm", "h5.m.taobao.com/mlapp/olist.htm" };
  public static AppContext appContext;
  public static String authorizeUrl;
  public static long cacheExpireTime = 0L;
  public static PluginConfigurations configurations;
  public static CookieService cookieService;
  public static CredentialService credentialService;
  public static ExecutorService executorService;
  public static final String loginBridgeName = "loginBridge";
  public static String loginChannel;
  public static Map<String, String> params;
  public static String passwordLoginUrl;
  public static PluginConfigurations pluginConfigurations;
  public static String qrCodeLoginUrl;
  public static String qrLoginConfirmUrl;
  public static RpcService rpcService;
  public static SecurityGuardService securityGuardService;
  public static SecurityService securityService;
  public static boolean useCache;
  public static UserTrackerService userTrackerService;
  
  public static void initialize(AppContext paramAppContext, PluginConfigurations paramPluginConfigurations)
  {
    rpcService = (RpcService)paramAppContext.getService(RpcService.class, null);
    userTrackerService = (UserTrackerService)paramAppContext.getService(UserTrackerService.class, null);
    credentialService = (CredentialService)paramAppContext.getService(CredentialService.class, null);
    executorService = (ExecutorService)paramAppContext.getService(ExecutorService.class, null);
    securityService = (SecurityService)paramAppContext.getService(SecurityService.class, null);
    cookieService = (CookieService)paramAppContext.getService(CookieService.class);
    appContext = paramAppContext;
    configurations = paramPluginConfigurations;
    String str = paramAppContext.getEnvironment().name();
    qrCodeLoginUrl = String.format(paramPluginConfigurations.getStringValue(str + "_QR_CODE_LOGIN_URL", "http://login.m.taobao.com/qrcodeShow.htm?appKey=%s&from=bcqrlogin"), new Object[] { paramAppContext.getAppKey() });
    passwordLoginUrl = String.format(paramPluginConfigurations.getStringValue(str + "_PASSWORD_LOGIN_URL", "http://login.m.taobao.com/oauth_native.htm?appKey=%s"), new Object[] { paramAppContext.getAppKey() });
    authorizeUrl = String.format(paramPluginConfigurations.getStringValue(str + "_AUTHORIZE_URL", "http://login.m.taobao.com/oauth_native.htm?appKey=%s"), new Object[] { paramAppContext.getAppKey() });
    qrLoginConfirmUrl = paramPluginConfigurations.getStringValue(str + "_QR_LOGIN_CONFIRM_URL", "https://login.m.taobao.com/qrcodeLogin.htm?shortURL=%s&from=bcqrlogin");
    cacheExpireTime = paramPluginConfigurations.getLongValue("cacheExpireTime", -1L);
    useCache = paramPluginConfigurations.getBooleanValue("useCache", false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */