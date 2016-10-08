package com.alibaba.sdk.android.session.impl;

import android.os.Looper;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.SessionService;
import com.alibaba.sdk.android.session.model.Session;
import com.alibaba.sdk.android.system.SystemContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SessionServiceImpl
  implements SessionService
{
  public static final SessionService INSTANCE = new SessionServiceImpl();
  private static final String TAG = "system";
  private CredentialManager credentialManager;
  
  public SessionServiceImpl()
  {
    this(null);
  }
  
  public SessionServiceImpl(CredentialManager paramCredentialManager)
  {
    if (paramCredentialManager == null)
    {
      this.credentialManager = CredentialManager.INSTANCE;
      return;
    }
    this.credentialManager = paramCredentialManager;
  }
  
  public Result<String> getSId()
  {
    Object localObject = this.credentialManager.getSid();
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d("get sid: " + (String)localObject);
    }
    if (localObject != null) {
      return Result.result(ResultCode.SUCCESS.code, null, localObject);
    }
    if (Looper.getMainLooper().equals(Looper.myLooper()))
    {
      localObject = ((ExecutorService)SystemContext.appContext.getService(ExecutorService.class)).submit(new SessionServiceImpl.1(this));
      try
      {
        localObject = (Result)((Future)localObject).get(3L, TimeUnit.SECONDS);
        return (Result<String>)localObject;
      }
      catch (Exception localException)
      {
        return Result.result(ResultCode.SUCCESS.code, null, this.credentialManager.getSid());
      }
    }
    return refreshSId();
  }
  
  public Result<Session> getSession()
  {
    return Result.result(ResultCode.SUCCESS.code, null, this.credentialManager.getSession());
  }
  
  public Result<String> refreshSId()
  {
    try
    {
      this.credentialManager.refreshWithInterval();
      if (AliSDKLogger.isDebugEnabled()) {
        AliSDKLogger.d("refresh sid: " + CredentialManager.INSTANCE.getSid());
      }
      String str = this.credentialManager.getSid();
      if (str != null) {
        return Result.result(ResultCode.SUCCESS.code, null, str);
      }
    }
    catch (Throwable localThrowable)
    {
      localMessage = MessageUtils.createMessage(10010, new Object[] { localThrowable.getMessage() });
      AliSDKLogger.log("system", localMessage);
      return Result.result(localMessage.code, localMessage.message);
    }
    Message localMessage = MessageUtils.createMessage(10010, new Object[] { "Null sid is returned" });
    AliSDKLogger.log("system", localMessage);
    return Result.result(localMessage.code, localMessage.message);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\impl\SessionServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */