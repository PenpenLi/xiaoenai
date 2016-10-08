package com.alibaba.sdk.android.util;

import com.alibaba.sdk.android.callback.FailureCallback;

final class CommonUtils$3
  implements Runnable
{
  CommonUtils$3(FailureCallback paramFailureCallback, int paramInt, String paramString) {}
  
  public void run()
  {
    this.val$failureCallback.onFailure(this.val$resultCode, this.val$msg);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\CommonUtils$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */