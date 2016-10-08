package com.alibaba.sdk.android.rpc.impl;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.security.SecurityGuardService;
import java.util.concurrent.ExecutorService;

public class RpcContext
{
  public static AppContext appContext;
  public static String defaultAPIVersion = "1.0.0";
  public static ExecutorService executorService;
  public static boolean httpDNSEnabled = true;
  public static boolean includeResourceInHttpHeader = false;
  public static PluginConfigurations pluginConfigurations;
  public static String rpcHTTPGateway = "http://gw.channel.aliyun.com/g2";
  public static String rpcVersion = "rpc-undefined";
  public static SecurityGuardService securityGuardService;
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\impl\RpcContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */