package com.alibaba.sdk.android.task;

import com.alibaba.sdk.android.callback.InitResultCallback;

class InitTask$4
  implements Runnable
{
  InitTask$4(InitTask paramInitTask) {}
  
  public void run()
  {
    if (InitTask.access$200(this.this$0) != null) {
      InitTask.access$200(this.this$0).onSuccess();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\InitTask$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */