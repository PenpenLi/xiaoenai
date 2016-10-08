package com.alibaba.sdk.android.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.alibaba.sdk.android.impl.KernelContext;

final class DeviceInfo$2
  implements Runnable
{
  public void run()
  {
    try
    {
      SharedPreferences.Editor localEditor = KernelContext.context.getSharedPreferences("onesdk_device", 0).edit();
      localEditor.putString("deviceId", DeviceInfo.deviceId);
      if (Build.VERSION.SDK_INT >= 9)
      {
        localEditor.apply();
        return;
      }
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\device\DeviceInfo$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */