package com.alibaba.sdk.android.system;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.security.CertificateService;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.ut.UserTrackerService;

public class SystemContext
{
  public static AppContext appContext;
  public static CertificateService certificateService;
  public static String configPollUrl = "http://sdkinit.taobao.com/sdkConfigVersion.htm";
  public static ExecutorService executorService;
  public static String initUrl = "http://sdkinit.taobao.com/init.htm";
  public static String logoutUrl = "http://sdkinit.taobao.com/logout.htm";
  public static PluginConfigurations pluginConfigurations;
  public static PluginSystemConfigurations pluginSystemConfigurations;
  public static SecurityGuardService securityGuardService;
  public static SecurityService securityService;
  public static long sidRefreshForceInterval = 5000L;
  public static String topGateWayUrl;
  public static UserTrackerService userTrackerService;
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\system\SystemContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */