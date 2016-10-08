package com.alibaba.sdk.android.task;

import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.trace.ActionTraceLogger;

class InitTask$1
  implements InitResultCallback
{
  InitTask$1(InitTask paramInitTask, ActionTraceLogger paramActionTraceLogger, InitResultCallback paramInitResultCallback) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    InitTask.access$000(this.this$0, false, this.val$traceLogger.getCaseTime(), paramString);
    this.val$traceLogger.failed();
    if (this.val$initResultCallback != null) {
      this.val$initResultCallback.onFailure(paramInt, paramString);
    }
    InitTask.access$100(this.this$0, false, paramInt, paramString);
  }
  
  public void onSuccess()
  {
    InitTask.access$000(this.this$0, true, this.val$traceLogger.getCaseTime(), null);
    this.val$traceLogger.success();
    if (this.val$initResultCallback != null) {
      this.val$initResultCallback.onSuccess();
    }
    InitTask.access$100(this.this$0, true, ResultCode.SUCCESS.code, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\InitTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */