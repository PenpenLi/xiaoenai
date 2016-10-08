package com.alibaba.sdk.android.login.impl;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.alibaba.sdk.android.login.LoginService;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.login.callback.LogoutCallback;
import com.alibaba.sdk.android.login.task.LogoutTask;
import com.alibaba.sdk.android.login.ui.QrLoginActivity;
import com.alibaba.sdk.android.login.ui.QrLoginConfirmActivity;
import com.alibaba.sdk.android.login.utils.StringUtil;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.SessionListener;
import com.alibaba.sdk.android.session.model.Session;
import com.alibaba.sdk.android.system.RequestCode;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.ResourceUtils;
import java.util.Map;

public class LoginServiceImpl
  implements LoginService
{
  public Session getSession()
  {
    return LoginContext.credentialService.getSession();
  }
  
  public SessionListener getSessionListener()
  {
    return LoginContext.credentialService.getSessionListener();
  }
  
  public void logout(Activity paramActivity, LogoutCallback paramLogoutCallback)
  {
    new LogoutTask(paramActivity, paramLogoutCallback).execute(new Void[0]);
  }
  
  public void setSessionListener(SessionListener paramSessionListener)
  {
    LoginContext.credentialService.setSessionListener(paramSessionListener);
  }
  
  public void showLogin(Activity paramActivity, LoginCallback paramLoginCallback)
  {
    CommonUtils.startInitWaitTask(paramActivity, paramLoginCallback, new LoginServiceImpl.1(this, paramLoginCallback, paramActivity), "api_showLogin");
  }
  
  public void showQrCodeLogin(Activity paramActivity, Map<String, String> paramMap, LoginCallback paramLoginCallback)
  {
    if ((paramMap != null) && (!StringUtil.isBlank((String)paramMap.get("userDefActivity")))) {}
    for (;;)
    {
      try
      {
        Object localObject = Class.forName((String)paramMap.get("userDefActivity"));
        localObject = new Intent(paramActivity, (Class)localObject);
        if ((paramMap != null) && (!StringUtil.isBlank((String)paramMap.get("userDefLayoutId")))) {
          ((Intent)localObject).putExtra("userDefLayoutId", (String)paramMap.get("userDefLayoutId"));
        }
        LoginContext.params = paramMap;
        ((Intent)localObject).putExtra("passwordLoginUrl", LoginContext.passwordLoginUrl);
        CallbackContext.loginCallback = paramLoginCallback;
        CallbackContext.setActivity(paramActivity);
        paramActivity.startActivityForResult((Intent)localObject, RequestCode.OPEN_QR_LOGIN);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        AliSDKLogger.log("login", MessageUtils.createMessage(16, new Object[] { localClassNotFoundException.getMessage() }), localClassNotFoundException);
      }
      Class localClass = QrLoginActivity.class;
    }
  }
  
  public void showQrLoginConfirm(Activity paramActivity, Map<String, String> paramMap, LoginCallback paramLoginCallback)
  {
    if ((paramMap == null) || (StringUtil.isBlank((String)paramMap.get("shortUrl")))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(LoginContext.qrLoginConfirmUrl);
    if (!StringUtil.isBlank((String)paramMap.get("domain"))) {
      localStringBuilder.append("_").append((String)paramMap.get("domain"));
    }
    Intent localIntent = new Intent(paramActivity, QrLoginConfirmActivity.class);
    localIntent.putExtra("url", String.format(localStringBuilder.toString(), new Object[] { paramMap.get("shortUrl") }));
    localIntent.putExtra("title", ResourceUtils.getString("com_taobao_tae_sdk_authorize_title"));
    CallbackContext.loginCallback = paramLoginCallback;
    CallbackContext.setActivity(paramActivity);
    paramActivity.startActivityForResult(localIntent, RequestCode.OPEN_QR_LOGIN_CONFIRM);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */