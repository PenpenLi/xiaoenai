package com.alibaba.sdk.android.rpc.utils;

import android.os.Process;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.rpc.impl.RpcContext;
import com.alibaba.sdk.android.security.SecurityGuardService;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class TraceUtils
{
  private static String PROCESS_ID;
  private static final AtomicInteger invocationCount = new AtomicInteger();
  
  public static String createTraceId()
  {
    Object localObject1 = null;
    if (RpcContext.appContext != null) {
      localObject1 = RpcContext.appContext.getUserTrackerId();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = RpcContext.securityGuardService.getSecurityToken();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = UUID.randomUUID().toString();
      }
      return (String)localObject1 + "-" + getProcessId() + "-" + System.currentTimeMillis() + "-" + invocationCount.incrementAndGet();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
  }
  
  private static String getProcessId()
  {
    if (PROCESS_ID == null) {}
    try
    {
      PROCESS_ID = String.valueOf(Process.myPid());
      return PROCESS_ID;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        PROCESS_ID = "";
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\utils\TraceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */