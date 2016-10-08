package com.alibaba.sdk.android;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.executor.impl.ExecutorServiceImpl;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BaseAlibabaSDK
{
  private static Context SDKContext;
  protected static Environment env;
  public static ExecutorService executorService = new ExecutorServiceImpl();
  private static boolean isInitSuccessed = false;
  
  public static void asyncInit(Context paramContext)
  {
    asyncInit(paramContext, null);
  }
  
  public static void asyncInit(Context paramContext, InitResultCallback paramInitResultCallback)
  {
    internalAsyncInit(paramContext, paramInitResultCallback);
  }
  
  public static String getGlobalProperty(String paramString)
  {
    return (String)ConfigManager.userProperties.get("$global$." + paramString);
  }
  
  public static String getProperty(String paramString1, String paramString2)
  {
    return (String)ConfigManager.userProperties.get(paramString1 + "." + paramString2);
  }
  
  public static <T> T getService(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("getInstance", new Class[0]);
      paramClass.setAccessible(true);
      paramClass = paramClass.invoke(null, new Object[0]);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Version getVersion()
  {
    return ConfigManager.TAE_SDK_VERSION;
  }
  
  private static void internalAsyncInit(Context paramContext, InitResultCallback paramInitResultCallback)
  {
    SDKContext = paramContext.getApplicationContext();
    if (env == null) {
      env = Environment.ONLINE;
    }
    executorService.postHandlerTask(new BaseAlibabaSDK.1(paramInitResultCallback));
  }
  
  public static boolean isInitSucceed()
  {
    return isInitSuccessed;
  }
  
  public static void setEnvironment(Environment paramEnvironment)
  {
    env = paramEnvironment;
  }
  
  public static void setGlobalProperty(String paramString1, String paramString2)
  {
    ConfigManager.userProperties.put("$global$." + paramString1, paramString2);
  }
  
  public static void setProperty(String paramString1, String paramString2, String paramString3)
  {
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\BaseAlibabaSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */