package com.alibaba.sdk.android.plugin;

import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.plugin.config.impl.MemoryBasedConfigurations;
import com.alibaba.sdk.android.plugin.impl.DefaultPluginManager;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.repository.PluginRepository;
import com.alibaba.sdk.android.repository.impl.SimplePluginRepository;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.CommonUtils;
import java.util.Collections;
import java.util.Map;

public class PluginSystemInitializer
{
  public static final PluginSystemInitializer INSTANCE = new PluginSystemInitializer();
  private static final String TAG = PluginSystemInitializer.class.getSimpleName();
  private final Object initializeLock = new Object();
  private volatile boolean initialized = false;
  
  private void initializePluginSystem()
  {
    Map localMap = Collections.singletonMap("tae.sdk.system.service", "true");
    ServiceRegistry localServiceRegistry = KernelContext.serviceRegistry;
    Object localObject = new SimplePluginRepository();
    localServiceRegistry.registerService(new Class[] { PluginRepository.class }, localObject, localMap);
    MemoryBasedConfigurations localMemoryBasedConfigurations = new MemoryBasedConfigurations(KernelContext.context, (PluginRepository)localObject);
    localServiceRegistry.registerService(new Class[] { PluginSystemConfigurations.class }, localMemoryBasedConfigurations, localMap);
    localObject = new DefaultPluginManager((PluginRepository)localObject);
    localServiceRegistry.registerService(new Class[] { PluginManager.class }, localObject, localMap);
  }
  
  private void processPluginLifecycleException(InitResultCallback paramInitResultCallback, PluginLifecycleException paramPluginLifecycleException)
  {
    if (paramPluginLifecycleException.getResultCode() != null)
    {
      CommonUtils.onFailure(paramInitResultCallback, paramPluginLifecycleException.getResultCode());
      return;
    }
    paramPluginLifecycleException = MessageUtils.createMessage(10022, new Object[] { paramPluginLifecycleException.getPluginName(), paramPluginLifecycleException.getMessage() });
    AliSDKLogger.log(TAG, paramPluginLifecycleException);
    CommonUtils.onFailure(paramInitResultCallback, paramPluginLifecycleException.code, paramPluginLifecycleException.message);
  }
  
  public ResultCode initialize()
  {
    if (!this.initialized) {}
    synchronized (this.initializeLock)
    {
      if (!this.initialized)
      {
        initializePluginSystem();
        this.initialized = true;
      }
      return ResultCode.SUCCESS;
    }
  }
  
  public boolean startPlugins(boolean paramBoolean, InitResultCallback paramInitResultCallback)
  {
    PluginSystemConfigurations localPluginSystemConfigurations = (PluginSystemConfigurations)KernelContext.serviceRegistry.getService(PluginSystemConfigurations.class, null);
    if (localPluginSystemConfigurations == null) {
      return false;
    }
    PluginManager localPluginManager = (PluginManager)KernelContext.serviceRegistry.getService(PluginManager.class, null);
    String[] arrayOfString = localPluginSystemConfigurations.getStartedPluginNames();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        localPluginSystemConfigurations = arrayOfString[i];
        if (paramBoolean) {}
        try
        {
          localPluginManager.syncStartPlugin(localPluginSystemConfigurations);
        }
        catch (PluginLifecycleException localPluginLifecycleException)
        {
          AliSDKLogger.e(TAG, "fail to async start plugin " + localPluginSystemConfigurations, localPluginLifecycleException);
          processPluginLifecycleException(paramInitResultCallback, localPluginLifecycleException);
          paramBoolean = false;
          return paramBoolean;
        }
        catch (PluginNotFoundException localPluginNotFoundException)
        {
          for (;;)
          {
            localMessage = MessageUtils.createMessage(13, new Object[] { localPluginNotFoundException.getPluginName() });
            CommonUtils.onFailure(paramInitResultCallback, localMessage.code, localMessage.message);
            AliSDKLogger.log(TAG, localMessage);
            paramBoolean = false;
          }
        }
        localPluginManager.startPlugin(localPluginSystemConfigurations);
      }
      else
      {
        for (;;)
        {
          Message localMessage;
          paramBoolean = true;
        }
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\PluginSystemInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */