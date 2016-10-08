package com.alibaba.sdk.android.task;

import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.util.CommonUtils;

class InitWaitTask$1
  implements InitResultCallback
{
  InitWaitTask$1(InitWaitTask paramInitWaitTask, ActionTraceLogger paramActionTraceLogger) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    this.val$atl.failed("error", paramInt + ":" + paramString);
    CommonUtils.onFailure(this.this$0.failureCallback, paramInt, paramString);
  }
  
  public void onSuccess()
  {
    this.val$atl.success();
    InitWaitTask.access$000(this.this$0).run();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\InitWaitTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */