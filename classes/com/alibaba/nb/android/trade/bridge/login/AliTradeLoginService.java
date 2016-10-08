package com.alibaba.nb.android.trade.bridge.login;

import android.app.Activity;
import com.alibaba.nb.android.trade.bridge.login.callback.AliTradeLoginCallback;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.login.callback.LogoutCallback;
import com.alibaba.sdk.android.session.SessionListener;
import com.alibaba.sdk.android.session.model.Session;
import java.util.Map;

public abstract interface AliTradeLoginService
{
  public static final String TAG = "login";
  
  public abstract Session getSession();
  
  public abstract SessionListener getSessionListener();
  
  public abstract boolean isServiceAvliable();
  
  public abstract void logout(Activity paramActivity, LogoutCallback paramLogoutCallback);
  
  public abstract void setSessionListener(SessionListener paramSessionListener);
  
  public abstract void showLogin(Activity paramActivity, AliTradeLoginCallback paramAliTradeLoginCallback);
  
  public abstract void showQrCodeLogin(Activity paramActivity, Map<String, String> paramMap, LoginCallback paramLoginCallback);
  
  public abstract void showQrLoginConfirm(Activity paramActivity, Map<String, String> paramMap, LoginCallback paramLoginCallback);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\login\AliTradeLoginService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */