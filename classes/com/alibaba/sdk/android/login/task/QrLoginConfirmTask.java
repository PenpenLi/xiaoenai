package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.task.AbsAsyncTask;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.webview.BridgeCallbackContext;
import java.util.Map;

public class QrLoginConfirmTask
  extends AbsAsyncTask<String, Void, Void>
{
  private static final String TAG = "login";
  private BridgeCallbackContext bridgeCallbackContext;
  
  public QrLoginConfirmTask(BridgeCallbackContext paramBridgeCallbackContext)
  {
    this.bridgeCallbackContext = paramBridgeCallbackContext;
  }
  
  protected Void asyncExecute(String... paramVarArgs)
  {
    paramVarArgs = (Map)RpcRequest.create(paramVarArgs[0]).params.get("qrConfirmInfo");
    if (paramVarArgs == null)
    {
      this.bridgeCallbackContext.getActivity().finish();
      return null;
    }
    int i = ((Integer)paramVarArgs.get("action")).intValue();
    if (i == 0) {
      this.bridgeCallbackContext.getActivity().setResult(ResultCode.SUCCESS.code);
    }
    for (;;)
    {
      this.bridgeCallbackContext.getActivity().finish();
      return null;
      if (-1 == i) {
        this.bridgeCallbackContext.getActivity().setResult(ResultCode.USER_CANCEL.code);
      }
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\QrLoginConfirmTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */