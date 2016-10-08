package com.alibaba.sdk.android.login.bridge;

import com.alibaba.sdk.android.login.task.LoginByQrCodeTask;
import com.alibaba.sdk.android.login.task.LoginByUsernameTask;
import com.alibaba.sdk.android.login.task.QrLoginConfirmTask;
import com.alibaba.sdk.android.webview.BridgeCallbackContext;
import com.alibaba.sdk.android.webview.BridgeMethod;

public class LoginBridge
{
  @BridgeMethod
  public void loginByQrCode(BridgeCallbackContext paramBridgeCallbackContext, String paramString)
  {
    new LoginByQrCodeTask(paramBridgeCallbackContext).execute(new String[] { paramString });
  }
  
  @BridgeMethod
  public void loginByUsername(BridgeCallbackContext paramBridgeCallbackContext, String paramString)
  {
    new LoginByUsernameTask(paramBridgeCallbackContext).execute(new String[] { paramString });
  }
  
  @BridgeMethod
  public void qrLoginConfirm(BridgeCallbackContext paramBridgeCallbackContext, String paramString)
  {
    new QrLoginConfirmTask(paramBridgeCallbackContext).execute(new String[] { paramString });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\bridge\LoginBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */