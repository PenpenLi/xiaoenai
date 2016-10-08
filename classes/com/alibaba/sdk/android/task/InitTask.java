package com.alibaba.sdk.android.task;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.AlibabaSDKException;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.bean.impl.BeanLoader;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.device.DeviceInfo;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.plugin.PluginSystemInitializer;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.trace.TraceLoggerManager;
import com.alibaba.sdk.android.trace.TraceLoggerService;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import com.taobao.tae.sdk.log.SdkCoreLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class InitTask
  implements Runnable
{
  private static final String TAG = "kernel";
  private InitResultCallback initResultCallback;
  private CountDownLatch initializationLock = new CountDownLatch(1);
  private boolean safeMode;
  
  public InitTask(InitResultCallback paramInitResultCallback)
  {
    this.initResultCallback = new InitTask.1(this, TraceLoggerManager.INSTANCE.action(3, "init_sdk", "initTask").begin(), paramInitResultCallback);
    this.safeMode = isSafeMode();
  }
  
  private boolean asyncRun()
  {
    if (ConfigManager.DEBUG) {
      SdkCoreLog.startTimeRecord("asyncRun");
    }
    if (this.safeMode) {}
    for (boolean bool = true; !bool; bool = PluginSystemInitializer.INSTANCE.startPlugins(false, this.initResultCallback))
    {
      if (ConfigManager.DEBUG) {
        SdkCoreLog.d("asyncRun", SdkCoreLog.content("kernel", SdkCoreLog.getTimeUsed("asyncRun"), new String[] { "failure" }));
      }
      return false;
    }
    KernelContext.executorService.postUITask(new InitTask.4(this));
    KernelContext.isInitOk = Boolean.valueOf(true);
    if (ConfigManager.DEBUG) {
      SdkCoreLog.d("asyncRun", SdkCoreLog.content("kernel", SdkCoreLog.getTimeUsed("asyncRun"), new String[] { "success" }));
    }
    return true;
  }
  
  private void initializeUTDId()
  {
    DeviceInfo.init(KernelContext.context);
  }
  
  private void invokePluginInitResultCallbacks(boolean paramBoolean, int paramInt, String paramString)
  {
    InitResultCallback[] arrayOfInitResultCallback = (InitResultCallback[])KernelContext.serviceRegistry.getServices(InitResultCallback.class, null);
    if (arrayOfInitResultCallback != null) {
      KernelContext.executorService.postTask(new InitTask.2(this, arrayOfInitResultCallback, paramBoolean, paramInt, paramString));
    }
  }
  
  private boolean isSafeMode()
  {
    if (KernelContext.context == null) {
      return false;
    }
    String str3 = CommonUtils.getCurrentProcessName();
    if (str3 == null) {
      return false;
    }
    String str4 = KernelContext.context.getPackageName();
    if (str3.equals(str4)) {
      return false;
    }
    if ("true".equals(AlibabaSDK.getProperty("kernel", "disableMultiProcessPluginSupport"))) {
      return true;
    }
    String str2 = AlibabaSDK.getProperty("hotpatch", "processName");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "hotpatch";
    }
    return str3.equals(str4 + ":" + str1);
  }
  
  private void sendInitHint(boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramBoolean) {}
    for (String str = "initSuccess";; str = "initFailed")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", str);
      if (paramString != null) {
        localHashMap.put("msg", paramString);
      }
      paramString = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
      if (paramString != null) {
        paramString.sendCustomHit("sdk_init_result", paramLong, str, localHashMap);
      }
      return;
    }
  }
  
  private boolean syncRun()
  {
    try
    {
      Class.forName(AsyncTask.class.getName());
      KernelContext.wrapServiceRegistry();
      ConfigManager.getInstance().init();
      if (ConfigManager.DEBUG) {
        SdkCoreLog.startTimeRecord("securityGuardInit");
      }
      Object localObject1 = BeanLoader.load("security", "com.alibaba.sdk.android.security.SecurityGuardService", "com.alibaba.sdk.android.security.impl.SecurityGuardWrapper", null);
      boolean bool2;
      if ((!((ResultCode)localObject1).isSuccess()) && (((ResultCode)localObject1).code != 16))
      {
        CommonUtils.onFailure(this.initResultCallback, ((ResultCode)localObject1).code, ((ResultCode)localObject1).message);
        bool2 = false;
        return bool2;
      }
      if (AlibabaSDK.getGlobalProperty("com.alibaba.app.appkey") == null)
      {
        localObject1 = CommonUtils.getAndroidManifestMetadata(KernelContext.context, "com.alibaba.app.appkey");
        if (localObject1 != null) {
          AlibabaSDK.setGlobalProperty("com.alibaba.app.appkey", (String)localObject1);
        }
      }
      if (AlibabaSDK.getGlobalProperty("com.alibaba.app.appsecret") == null)
      {
        localObject1 = CommonUtils.getAndroidManifestMetadata(KernelContext.context, "com.alibaba.app.appsecret");
        if (localObject1 != null) {
          AlibabaSDK.setGlobalProperty("com.alibaba.app.appsecret", (String)localObject1);
        }
      }
      if (BeanLoader.load("ut", UserTrackerService.class.getName(), "com.alibaba.sdk.android.ut.impl.AlibabaUserTrackerService", Collections.singletonMap("$isv_scope$", "true")).isSuccess()) {
        localObject1 = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = AlibabaSDK.getGlobalProperty("appVersion");
        if (localObject2 != null) {
          ((UserTrackerService)localObject1).updateUserTrackerProperties(Collections.singletonMap("app_version", localObject2));
        }
        if (ConfigManager.DEBUG) {
          SdkCoreLog.startTimeRecord("traceHelperInit");
        }
        if (ConfigManager.DEBUG) {
          SdkCoreLog.d("traceHelperInit", SdkCoreLog.content("kernel", SdkCoreLog.getTimeUsed("traceHelperInit"), new String[] { "success" }));
        }
        localObject2 = KernelContext.serviceRegistry;
        localObject3 = PluginSystemInitializer.INSTANCE.initialize();
        if (((ResultCode)localObject3).isSuccess()) {
          break;
        }
        CommonUtils.onFailure(this.initResultCallback, ((ResultCode)localObject3).code, ((ResultCode)localObject3).message);
        return false;
        AliSDKLogger.w("kernel", "Fail to initialize the UT user tracker service, will fallback to the default one");
        localObject1 = getClass().getClassLoader();
        localObject2 = new InitTask.3(this);
        localObject1 = (UserTrackerService)UserTrackerService.class.cast(Proxy.newProxyInstance((ClassLoader)localObject1, new Class[] { UserTrackerService.class }, (InvocationHandler)localObject2));
        localObject2 = KernelContext.serviceRegistry;
        localObject3 = Collections.singletonMap("$isv_scope$", "true");
        ((ServiceRegistry)localObject2).registerService(new Class[] { UserTrackerService.class }, localObject1, (Map)localObject3);
      }
      Object localObject3 = Collections.singletonMap("plugin.vendor", "kernel");
      TraceLoggerManager.INSTANCE.setUserTrackerService((UserTrackerService)localObject1);
      if ((DeviceInfo.deviceId == null) && (((UserTrackerService)localObject1).getDefaultUserTrackerId() != null)) {
        TraceLoggerManager.INSTANCE.init(CommonUtils.isDebuggable(), ConfigManager.DEBUG, ((UserTrackerService)localObject1).getDefaultUserTrackerId());
      }
      localObject1 = TraceLoggerManager.INSTANCE;
      ((ServiceRegistry)localObject2).registerService(new Class[] { TraceLoggerService.class }, localObject1, (Map)localObject3);
      localObject1 = KernelContext.executorService;
      ((ServiceRegistry)localObject2).registerService(new Class[] { com.alibaba.sdk.android.executor.ExecutorService.class, java.util.concurrent.ExecutorService.class }, localObject1, (Map)localObject3);
      if (ConfigManager.DEBUG) {
        SdkCoreLog.startTimeRecord("syncRun");
      }
      localObject1 = AlibabaSDK.getProperty("kernel", "sdkVersion");
      ConfigManager.getInstance().setVersion((String)localObject1);
      boolean bool1;
      if (this.safeMode) {
        bool1 = true;
      }
      do
      {
        bool2 = bool1;
        if (!ConfigManager.DEBUG) {
          break;
        }
        SdkCoreLog.d("syncRun", SdkCoreLog.content("kernel", SdkCoreLog.getTimeUsed("syncRun"), new String[] { "success" }));
        return bool1;
        bool2 = PluginSystemInitializer.INSTANCE.startPlugins(true, this.initResultCallback);
        bool1 = bool2;
      } while (bool2);
      return false;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void await()
  {
    try
    {
      this.initializationLock.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AliSDKLogger.e("kernel", localInterruptedException.getMessage(), localInterruptedException);
    }
  }
  
  protected void doFinally()
  {
    KernelContext.initLock.unlock();
  }
  
  protected void doWhenException(Throwable paramThrowable)
  {
    KernelContext.isInitOk = Boolean.valueOf(false);
    int i;
    if (((paramThrowable instanceof AlibabaSDKException)) && (((AlibabaSDKException)paramThrowable).getSDKMessage() != null))
    {
      paramThrowable = ((AlibabaSDKException)paramThrowable).getSDKMessage();
      i = paramThrowable.code;
    }
    for (paramThrowable = paramThrowable.message;; paramThrowable = CommonUtils.toString(paramThrowable))
    {
      CommonUtils.onFailure(this.initResultCallback, i, paramThrowable);
      return;
      i = 10010;
    }
  }
  
  public boolean initialize()
  {
    initializeUTDId();
    if (KernelContext.syncInitialized) {
      return true;
    }
    try
    {
      if (syncRun())
      {
        KernelContext.syncInitialized = true;
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      AliSDKLogger.e("kernel", "fail to sync start", localThrowable);
      doWhenException(localThrowable);
      this.initializationLock.countDown();
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      KernelContext.initLock.lock();
      asyncRun();
      return;
    }
    catch (Throwable localThrowable)
    {
      AliSDKLogger.e("kernel", localThrowable.getMessage(), localThrowable);
      doWhenException(localThrowable);
      return;
    }
    finally
    {
      this.initializationLock.countDown();
      doFinally();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\InitTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */