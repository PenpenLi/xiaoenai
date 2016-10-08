package com.alibaba.nb.android.trade;

import android.content.Context;
import com.alibaba.nb.android.trade.bridge.login.AliTradeLoginService;
import com.alibaba.nb.android.trade.callback.AliTradeInitCallback;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.uibridge.IAliTradeService;
import com.alibaba.nb.android.trade.utils.e;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AliTradeSDK
{
  private static String a = AliTradeSDK.class.getName();
  private static final Map<String, String> b = Collections.singletonMap("$isv_scope$", "true");
  private static AtomicInteger c;
  
  public static void asyncInit(Context paramContext, String paramString, AliTradeInitCallback paramAliTradeInitCallback)
  {
    AliTradeContext.context = paramContext.getApplicationContext();
    AliTradeContext.appKey = paramString;
    AliTradeConfigServiceImpl.getInstance().initConfigure(paramString);
    c = new AtomicInteger(2);
    AliTradeContext.executorService.a(new a(paramAliTradeInitCallback));
  }
  
  public static void destory()
  {
    com.alibaba.nb.android.trade.callback.AliTradeCallbackContext.tradeProcessCallback = null;
  }
  
  public static String getLogFilePath()
  {
    com.alibaba.nb.android.trade.service.log.a.a();
    return com.alibaba.nb.android.trade.service.log.a.c().getAbsolutePath();
  }
  
  public static <T> T getService(Class<T> paramClass)
  {
    if ((paramClass.equals(AliTradeLoginService.class)) || (paramClass.equals(IAliTradeService.class))) {
      return (T)AliTradeContext.serviceRegistry.getService(paramClass, b);
    }
    return null;
  }
  
  public static void setChannel(String paramString1, String paramString2)
  {
    AliTradeConfigServiceImpl.getInstance().setChannel(paramString1, paramString2);
  }
  
  public static void setEnvironment(AliTradeContext.Environment paramEnvironment)
  {
    AliTradeContext.environment = paramEnvironment;
    AliTradeContext.updateUrl();
  }
  
  public static boolean setForceH5(boolean paramBoolean)
  {
    return AliTradeConfigServiceImpl.getInstance().setIsForceH5(paramBoolean);
  }
  
  public static boolean setISVCode(String paramString)
  {
    return AliTradeConfigServiceImpl.getInstance().setIsvCode(paramString);
  }
  
  public static boolean setISVVersion(String paramString)
  {
    return AliTradeConfigServiceImpl.getInstance().setIsvVersion(paramString);
  }
  
  public static boolean setSyncForTaoke(boolean paramBoolean)
  {
    return AliTradeConfigServiceImpl.getInstance().setIsSyncForTaoke(paramBoolean);
  }
  
  public static void setTaokeParams(AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    AliTradeConfigServiceImpl.getInstance().setTaokeParams(paramAliTradeTaokeParams);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\AliTradeSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */