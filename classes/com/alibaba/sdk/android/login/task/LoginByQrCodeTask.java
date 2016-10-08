package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.login.utils.LoginUtils;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.task.AbsAsyncTask;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.webview.BridgeCallbackContext;
import java.util.Map;

public class LoginByQrCodeTask
  extends AbsAsyncTask<String, Void, Void>
{
  private static final String TAG = "login";
  private BridgeCallbackContext bridgeCallbackContext;
  
  public LoginByQrCodeTask(BridgeCallbackContext paramBridgeCallbackContext)
  {
    this.bridgeCallbackContext = paramBridgeCallbackContext;
  }
  
  protected Void asyncExecute(String... paramVarArgs)
  {
    paramVarArgs = RpcRequest.create(paramVarArgs[0]);
    ((Map)paramVarArgs.params.get("qrCodeInfo")).put("utdid", LoginContext.appContext.getUserTrackerId());
    paramVarArgs = LoginContext.rpcService.invoke(paramVarArgs);
    Result localResult = LoginUtils.toLoginResultData(paramVarArgs);
    if (localResult.code == 2)
    {
      LoginContext.credentialService.refreshWhenLogin((LoginResultData)localResult.data);
      this.bridgeCallbackContext.getActivity().setResult(ResultCode.SUCCESS.code);
      this.bridgeCallbackContext.getActivity().finish();
    }
    for (;;)
    {
      return null;
      this.bridgeCallbackContext.success(paramVarArgs);
    }
  }
  
  protected void doFinally() {}
  
  protected void doWhenException(Throwable paramThrowable)
  {
    Message localMessage = MessageUtils.createMessage(10010, new Object[] { paramThrowable.getMessage() });
    AliSDKLogger.log("login", localMessage, paramThrowable);
    this.bridgeCallbackContext.onFailure(localMessage.code, localMessage.message);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\LoginByQrCodeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */