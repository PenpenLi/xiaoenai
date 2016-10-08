package com.alibaba.sdk.android.session.impl;

import com.alibaba.sdk.android.model.Result;
import java.util.concurrent.Callable;

class SessionServiceImpl$1
  implements Callable<Result<String>>
{
  SessionServiceImpl$1(SessionServiceImpl paramSessionServiceImpl) {}
  
  public Result<String> call()
  {
    return this.this$0.refreshSId();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\impl\SessionServiceImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */