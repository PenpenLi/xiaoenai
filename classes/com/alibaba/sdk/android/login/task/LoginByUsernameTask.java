package com.alibaba.sdk.android.login.task;

import android.app.Activity;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.login.impl.LoginComponent;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.login.ui.LoginWebViewActivity;
import com.alibaba.sdk.android.login.utils.LoginUtils;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.task.AbsAsyncTask;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.JSONUtils;
import com.alibaba.sdk.android.util.ResourceUtils;
import com.alibaba.sdk.android.webview.BridgeCallbackContext;

public class LoginByUsernameTask
  extends AbsAsyncTask<String, Void, Void>
{
  private static final String TAG = "login";
  private BridgeCallbackContext bridgeCallbackContext;
  
  public LoginByUsernameTask(BridgeCallbackContext paramBridgeCallbackContext)
  {
    this.bridgeCallbackContext = paramBridgeCallbackContext;
  }
  
  protected Void asyncExecute(String... paramVarArgs)
  {
    if (!CommonUtils.isNetworkAvailable())
    {
      paramVarArgs = new Result();
      paramVarArgs.code = -1;
      paramVarArgs.message = ResourceUtils.getString("com_taobao_tae_sdk_network_not_available_message");
      paramVarArgs = JSONUtils.toJSONString(paramVarArgs);
      this.bridgeCallbackContext.success(paramVarArgs);
      return null;
    }
    paramVarArgs = LoginComponent.INSTANCE.loginByUserName(paramVarArgs[0]);
    Result localResult = LoginUtils.toLoginResultData(paramVarArgs);
    int i = localResult.code;
    if (i == 1)
    {
      LoginContext.credentialService.refreshWhenLogin((LoginResultData)localResult.data);
      this.bridgeCallbackContext.getActivity().setResult(ResultCode.SUCCESS.code);
      this.bridgeCallbackContext.getActivity().finish();
      return null;
    }
    if (i == 1013)
    {
      ((LoginWebViewActivity)this.bridgeCallbackContext.getActivity()).token = ((LoginResultData)localResult.data).tempLoginToken;
      this.bridgeCallbackContext.success(paramVarArgs);
      return null;
    }
    this.bridgeCallbackContext.success(paramVarArgs);
    return null;
  }
  
  protected void doFinally() {}
  
  protected void doWhenException(Throwable paramThrowable)
  {
    Message localMessage = MessageUtils.createMessage(10010, new Object[] { paramThrowable.getMessage() });
    AliSDKLogger.log("login", localMessage, paramThrowable);
    this.bridgeCallbackContext.onFailure(localMessage.code, localMessage.message);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\LoginByUsernameTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */