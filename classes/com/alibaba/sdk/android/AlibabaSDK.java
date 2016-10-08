package com.alibaba.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.callback.ResultCallback;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.task.InitTask;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import java.util.Collections;
import java.util.Map;

public class AlibabaSDK
  extends BaseAlibabaSDK
{
  private static final String ISV_OLD_SERVICE_PACKAGE_PREFIX = "com.taobao.tae.sdk.api.";
  private static final Map<String, String> USER_SERVICE_FILTER = Collections.singletonMap("$isv_scope$", "true");
  
  public static void asyncInit(Context paramContext)
  {
    asyncInit(paramContext, null);
  }
  
  public static void asyncInit(Context paramContext, InitResultCallback paramInitResultCallback)
  {
    internalAsyncInit(paramContext, paramInitResultCallback);
  }
  
  public static void asyncInitWithFinish(Context paramContext, InitResultCallback paramInitResultCallback)
  {
    internalAsyncInit(paramContext, paramInitResultCallback).await();
  }
  
  public static String getGlobalProperty(String paramString)
  {
    PluginSystemConfigurations localPluginSystemConfigurations = (PluginSystemConfigurations)KernelContext.serviceRegistry.getService(PluginSystemConfigurations.class, null);
    if (localPluginSystemConfigurations != null) {
      return localPluginSystemConfigurations.getGlobalProperty(paramString);
    }
    return (String)ConfigManager.userProperties.get("$global$." + paramString);
  }
  
  public static String getProperty(String paramString1, String paramString2)
  {
    PluginSystemConfigurations localPluginSystemConfigurations = (PluginSystemConfigurations)KernelContext.serviceRegistry.getService(PluginSystemConfigurations.class, null);
    if (localPluginSystemConfigurations == null) {
      return (String)ConfigManager.userProperties.get(paramString1 + "." + paramString2);
    }
    return localPluginSystemConfigurations.getPluginProperty(paramString1, paramString2);
  }
  
  public static <T> T getService(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    if (paramClass.getName().startsWith("com.taobao.tae.sdk.api.")) {
      return (T)KernelContext.serviceRegistry.getService(paramClass, null);
    }
    return (T)KernelContext.serviceRegistry.getService(paramClass, USER_SERVICE_FILTER);
  }
  
  public static <T> void getService(Activity paramActivity, Class<T> paramClass, ResultCallback<T> paramResultCallback)
  {
    CommonUtils.startInitWaitTask(paramActivity, paramResultCallback, new AlibabaSDK.1(paramClass, paramResultCallback), "api_getService");
  }
  
  public static Version getVersion()
  {
    return ConfigManager.TAE_SDK_VERSION;
  }
  
  private static InitTask internalAsyncInit(Context paramContext, InitResultCallback paramInitResultCallback)
  {
    KernelContext.context = paramContext.getApplicationContext();
    paramContext = new InitTask(paramInitResultCallback);
    if (paramContext.initialize()) {
      KernelContext.executorService.postHandlerTask(paramContext);
    }
    return paramContext;
  }
  
  public static boolean isInitSucceed()
  {
    if (KernelContext.isInitOk == null) {
      return false;
    }
    return KernelContext.isInitOk.booleanValue();
  }
  
  public static void setAppVersion(String paramString)
  {
    if (paramString == null) {
      return;
    }
    UserTrackerService localUserTrackerService = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
    if (localUserTrackerService != null) {
      localUserTrackerService.updateUserTrackerProperties(Collections.singletonMap("app_version", paramString));
    }
    setGlobalProperty("appVersion", paramString);
  }
  
  public static void setGlobalProperty(String paramString1, String paramString2)
  {
    PluginSystemConfigurations localPluginSystemConfigurations = (PluginSystemConfigurations)KernelContext.serviceRegistry.getService(PluginSystemConfigurations.class, null);
    if (localPluginSystemConfigurations != null)
    {
      localPluginSystemConfigurations.setGlobalProperty(paramString1, paramString2);
      return;
    }
    ConfigManager.userProperties.put("$global$." + paramString1, paramString2);
  }
  
  public static void setProperty(String paramString1, String paramString2, String paramString3)
  {
    PluginSystemConfigurations localPluginSystemConfigurations = (PluginSystemConfigurations)KernelContext.serviceRegistry.getService(PluginSystemConfigurations.class, null);
    if (localPluginSystemConfigurations != null)
    {
      localPluginSystemConfigurations.setPluginProperty(paramString1, paramString2, paramString3);
      return;
    }
    ConfigManager.userProperties.put(paramString1 + "." + paramString2, paramString3);
  }
  
  public static void setSecGuardImagePostfix(String paramString)
  {
    ConfigManager.POSTFIX_OF_SECURITY_JPG_USER_SET = paramString;
  }
  
  public static void turnOnDebug()
  {
    Log.w("AlibabaSDK", "************************************\nDebug is enabled, make sure to turn it off in the production environment\n************************************");
    ConfigManager.DEBUG = true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\AlibabaSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */