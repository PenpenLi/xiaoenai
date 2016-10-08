package com.alibaba.sdk.android.task;

import com.alibaba.sdk.android.device.DeviceInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class InitTask$3
  implements InvocationHandler
{
  InitTask$3(InitTask paramInitTask) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getName().equals("getDefaultUserTrackerId")) {
      return DeviceInfo.deviceId;
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\InitTask$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */