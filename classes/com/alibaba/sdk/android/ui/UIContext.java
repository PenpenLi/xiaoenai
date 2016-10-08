package com.alibaba.sdk.android.ui;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.security.AccessController;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.webview.DefaultTaeWebViewHistoryHelper;
import java.util.regex.Pattern;

public class UIContext
{
  public static Pattern[] SSL_ERROR_IGNORE_URLS;
  public static AccessController accessController;
  public static AppContext appContext;
  public static String[] cookieNamesWithApplicationLifecycle = null;
  public static String[] cookieNamesWithWebViewLifecycle;
  public static String[] domains = { ".taobao.com", ".tmall.com", ".tmall.hk" };
  public static ExecutorService executorService;
  public static DefaultTaeWebViewHistoryHelper historyHelper;
  public static String[] mobileDomains = { ".m.taobao.com", ".m.tmall.com", ".m.tmall.hk", ".m.etao.com" };
  public static String noViewRightUrl = "file:///android_asset/ali_sdk_ui/view_no_right.html";
  public static PluginConfigurations pluginConfigurations;
  public static RpcService rpcService;
  public static SecurityGuardService securityGuardService;
  public static SecurityService securityService;
  
  static
  {
    cookieNamesWithWebViewLifecycle = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\UIContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */