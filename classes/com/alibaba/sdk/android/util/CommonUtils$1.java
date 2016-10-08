package com.alibaba.sdk.android.util;

import com.alibaba.sdk.android.callback.FailureCallback;
import com.alibaba.sdk.android.message.Message;

final class CommonUtils$1
  implements Runnable
{
  CommonUtils$1(FailureCallback paramFailureCallback, Message paramMessage) {}
  
  public void run()
  {
    this.val$failureCallback.onFailure(this.val$message.code, this.val$message.message);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\CommonUtils$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */