package com.alibaba.sdk.android.task;

import android.app.Activity;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.callback.FailureCallback;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.trace.TraceLoggerService;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ReflectionUtils;

public class InitWaitTask
  extends TaskWithDialog<Void, Void, Void>
{
  private Class<?> credentialServiceClazz;
  protected FailureCallback failureCallback;
  private Runnable r;
  private String taskName;
  
  public InitWaitTask(Activity paramActivity, FailureCallback paramFailureCallback, Runnable paramRunnable)
  {
    this(paramActivity, paramFailureCallback, paramRunnable, null);
  }
  
  public InitWaitTask(Activity paramActivity, FailureCallback paramFailureCallback, Runnable paramRunnable, String paramString)
  {
    super(paramActivity);
    this.r = paramRunnable;
    this.failureCallback = paramFailureCallback;
    this.taskName = paramString;
    this.credentialServiceClazz = ReflectionUtils.loadClassQuietly("com.alibaba.sdk.android.session.CredentialService");
  }
  
  protected Void asyncExecute(Void... paramVarArgs)
  {
    Object localObject = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
    TraceLoggerService localTraceLoggerService = (TraceLoggerService)KernelContext.serviceRegistry.getService(TraceLoggerService.class, null);
    if (this.taskName == null) {}
    for (paramVarArgs = "asyncExecute";; paramVarArgs = this.taskName)
    {
      paramVarArgs = localTraceLoggerService.action(1, paramVarArgs).begin();
      if ((this.taskName != null) && (localObject != null)) {
        ((UserTrackerService)localObject).sendCustomHit(this.taskName, this.activity);
      }
      localObject = KernelContext.checkInitStatus();
      if (localObject != null) {
        break;
      }
      paramVarArgs.failed("error", "init failed");
      CommonUtils.onFailure(this.failureCallback, MessageUtils.createMessage(10012, new Object[0]));
      return null;
    }
    if (!((Boolean)localObject).booleanValue())
    {
      AlibabaSDK.asyncInitWithFinish(KernelContext.context, new InitWaitTask.1(this, paramVarArgs));
      return null;
    }
    if (this.credentialServiceClazz != null)
    {
      localObject = KernelContext.serviceRegistry.getService(this.credentialServiceClazz, null);
      if (localObject != null) {
        ReflectionUtils.invoke("com.alibaba.sdk.android.session.CredentialService", "init", null, localObject, null);
      }
    }
    paramVarArgs.success();
    this.r.run();
    return null;
  }
  
  protected void doWhenException(Throwable paramThrowable) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\task\InitWaitTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */