package com.alibaba.sdk.android;

import android.content.Context;
import com.alibaba.sdk.android.callback.InitResultCallback;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class BaseAlibabaSDK$1
  implements Runnable
{
  BaseAlibabaSDK$1(InitResultCallback paramInitResultCallback) {}
  
  public void run()
  {
    try
    {
      Method localMethod = BaseAlibabaSDK.class.getClassLoader().loadClass("com.alibaba.sdk.android.InitSyncExecutor").getDeclaredMethod("init", new Class[] { Context.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { BaseAlibabaSDK.access$000() });
      BaseAlibabaSDK.access$102(true);
      if (this.val$initResultCallback != null) {
        this.val$initResultCallback.onSuccess();
      }
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\BaseAlibabaSDK$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */