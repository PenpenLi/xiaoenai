package com.alibaba.sdk.android.login.task;

import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.trace.AliSDKLogger;

class AbsLoginByCodeTask$2
  implements Runnable
{
  AbsLoginByCodeTask$2(AbsLoginByCodeTask paramAbsLoginByCodeTask, int paramInt, Result paramResult) {}
  
  public void run()
  {
    Message localMessage = MessageUtils.createMessage(15, new Object[] { "login", "code " + this.val$code + " " + this.val$result.message });
    AliSDKLogger.log("login", localMessage);
    this.this$0.doWhenResultFail(localMessage.code, localMessage.message);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\AbsLoginByCodeTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */