package com.alibaba.sdk.android.util;

import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.callback.FailureCallback;

final class CommonUtils$2
  implements Runnable
{
  CommonUtils$2(FailureCallback paramFailureCallback, ResultCode paramResultCode) {}
  
  public void run()
  {
    this.val$failureCallback.onFailure(this.val$resultCode.code, this.val$resultCode.message);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\CommonUtils$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */