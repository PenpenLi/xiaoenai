package com.alibaba.sdk.android.login.impl;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.sdk.android.login.LoginServiceProvider;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.login.ui.LoginWebViewActivity;
import com.alibaba.sdk.android.system.RequestCode;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.ResourceUtils;

public class H5LoginServiceProviderImpl
  implements LoginServiceProvider
{
  public static final LoginServiceProvider INSTANCE = new H5LoginServiceProviderImpl();
  
  public boolean showLogin(Activity paramActivity, LoginCallback paramLoginCallback)
  {
    paramLoginCallback = new Intent(paramActivity, LoginWebViewActivity.class);
    paramLoginCallback.putExtra("url", LoginContext.authorizeUrl);
    paramLoginCallback.putExtra("title", ResourceUtils.getString("com_taobao_tae_sdk_authorize_title"));
    paramActivity.startActivityForResult(paramLoginCallback, RequestCode.OPEN_H5_LOGIN);
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d("login", "open H5 login");
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\H5LoginServiceProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */