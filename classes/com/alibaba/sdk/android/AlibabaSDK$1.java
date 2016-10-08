package com.alibaba.sdk.android;

import com.alibaba.sdk.android.callback.ResultCallback;

final class AlibabaSDK$1
  implements Runnable
{
  AlibabaSDK$1(Class paramClass, ResultCallback paramResultCallback) {}
  
  public void run()
  {
    Object localObject = AlibabaSDK.getService(this.val$clazz);
    this.val$callback.onSuccess(localObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\AlibabaSDK$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */