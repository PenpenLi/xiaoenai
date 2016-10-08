package com.alibaba.sdk.android.device;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.Collections;

public class DeviceInfo
{
  public static String deviceId;
  
  @TargetApi(9)
  private static void _initDeviceId(Context paramContext)
  {
    Object localObject = AlibabaSDK.getProperty("kernel", "utClassName");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "com.ut.device.UTDevice";
    }
    String str = AlibabaSDK.getProperty("kernel", "utMethodName");
    localObject = str;
    if (str == null) {
      localObject = "getUtdid";
    }
    localObject = getUtdid(paramContext, (String)localObject);
    if ((localObject == null) && (paramContext.equals("com.ut.device.UTDevice"))) {}
    for (paramContext = getUtdid("com.ta.utdid2.device.UTDevice", "getUtdid");; paramContext = (Context)localObject)
    {
      if (paramContext == null)
      {
        KernelContext.executorService.postTask(new DeviceInfo.1());
        return;
      }
      deviceId = paramContext;
      KernelContext.executorService.postTask(new DeviceInfo.2());
      return;
    }
  }
  
  private static String getUtdid(String paramString1, String paramString2)
  {
    paramString1 = ReflectionUtils.loadClassQuietly(paramString1);
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = paramString1.getMethod(paramString2, new Class[] { Context.class }).invoke(null, new Object[] { KernelContext.context });
      if (paramString1 == null)
      {
        paramString2 = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
        if (paramString2 != null) {
          paramString2.sendCustomHit("sdk_getUtdid", 0L, "error", null);
        }
      }
      paramString1 = paramString1.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
      if (paramString2 != null) {
        paramString2.sendCustomHit("sdk_getUtdid", 0L, "error", Collections.singletonMap("msg", CommonUtils.toString(paramString1)));
      }
    }
    return null;
  }
  
  public static void init(Context paramContext)
  {
    if (TextUtils.isEmpty(deviceId)) {
      _initDeviceId(paramContext);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\device\DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */