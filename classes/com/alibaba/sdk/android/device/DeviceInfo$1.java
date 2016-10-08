package com.alibaba.sdk.android.device;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.sdk.android.impl.KernelContext;

final class DeviceInfo$1
  implements Runnable
{
  public void run()
  {
    try
    {
      DeviceInfo.deviceId = KernelContext.context.getSharedPreferences("onesdk_device", 0).getString("deviceId", null);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\device\DeviceInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */