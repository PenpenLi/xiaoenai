package com.alibaba.sdk.android.bean.impl;

import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.app.AppContextManager;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.taobao.tae.sdk.log.SdkCoreLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BeanLoader
{
  private static final String TAG = "BeanLoader";
  
  public static ResultCode load(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    if (ConfigManager.DEBUG) {
      SdkCoreLog.startTimeRecord(paramString2);
    }
    if (paramString2 != null) {}
    label448:
    label450:
    for (;;)
    {
      try
      {
        localClass = Class.forName(paramString2);
        if (KernelContext.serviceRegistry.getService(localClass, null) == null) {
          break label450;
        }
        return ResultCode.SUCCESS;
      }
      catch (ClassNotFoundException paramString1)
      {
        Object localObject3;
        AliSDKLogger.i("BeanLoader", paramString2 + "/" + paramString3 + " is not available, the error message is " + paramString1.getMessage());
        return ResultCode.create(16, new Object[] { paramString1.getMessage() });
      }
      catch (InvocationTargetException paramString3)
      {
        if (paramString3.getTargetException() == null) {
          continue;
        }
        paramString1 = paramString3.getTargetException().getMessage();
        paramString1 = MessageUtils.createMessage(10010, new Object[] { paramString1 });
        AliSDKLogger.log("BeanLoader", paramString1, paramString3);
        if (!ConfigManager.DEBUG) {
          continue;
        }
        SdkCoreLog.d(paramString2, SdkCoreLog.content("BeanLoader", SdkCoreLog.getTimeUsed(paramString2), new String[] { "failure" }));
        return ResultCode.create(paramString1.code, new Object[] { paramString1.message });
        paramString1 = paramString3.getMessage();
        continue;
      }
      catch (Exception paramString1)
      {
        paramString3 = MessageUtils.createMessage(10010, new Object[] { paramString1.getMessage() });
        AliSDKLogger.log("BeanLoader", paramString3, paramString1);
        if (!ConfigManager.DEBUG) {
          continue;
        }
        SdkCoreLog.d(paramString2, SdkCoreLog.content("BeanLoader", SdkCoreLog.getTimeUsed(paramString2), new String[] { "failure" }));
        return ResultCode.create(paramString3.code, new Object[] { paramString3.message });
      }
      localObject3 = Class.forName(paramString3);
      try
      {
        Object localObject1 = ((Class)localObject3).getField("INSTANCE").get(null);
        AppContext localAppContext = AppContextManager.INSTANCE.createAppContext(paramString1);
        try
        {
          paramString1 = ((Class)localObject3).getMethod("init", new Class[] { AppContext.class });
          localObject3 = paramString1.invoke(localObject1, new Object[] { localAppContext });
          if (paramString1.getReturnType() != Void.TYPE) {
            continue;
          }
          paramString1 = ResultCode.SUCCESS;
          boolean bool = paramString1.isSuccess();
          if (!bool) {
            break label448;
          }
        }
        catch (NoSuchMethodException paramString1)
        {
          Object localObject2;
          continue;
        }
        if (localClass != null) {
          localAppContext.registerService(new Class[] { localClass }, localObject1, paramMap);
        }
        if (ConfigManager.DEBUG) {
          SdkCoreLog.d(paramString2, SdkCoreLog.content("BeanLoader", SdkCoreLog.getTimeUsed(paramString2), new String[] { "success" }));
        }
        return ResultCode.SUCCESS;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject2 = ((Class)localObject3).getConstructor(new Class[0]).newInstance(new Object[0]);
        continue;
        paramString1 = (ResultCode)localObject3;
        continue;
      }
      Class localClass = null;
      continue;
      return paramString1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\bean\impl\BeanLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */