package com.alibaba.sdk.android.task;

import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.trace.AliSDKLogger;

class InitTask$2
  implements Runnable
{
  InitTask$2(InitTask paramInitTask, InitResultCallback[] paramArrayOfInitResultCallback, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    InitResultCallback[] arrayOfInitResultCallback = this.val$resultCallbacks;
    int j = arrayOfInitResultCallback.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        InitResultCallback localInitResultCallback = arrayOfInitResultCallback[i];
        try
        {
          if (this.val$success) {
            localInitResultCallback.onSuccess();
          } else {
            localInitResultCallback.onFailure(this.val$code, this.val$message);
          }
        }
        catch (Exception localException)
        {
          AliSDKLogger.e("kernel", localException.getMessage(), localException);
        }
      }
      return;
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\InitTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */