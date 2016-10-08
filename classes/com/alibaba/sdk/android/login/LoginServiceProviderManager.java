package com.alibaba.sdk.android.login;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.login.impl.H5LoginServiceProviderImpl;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import java.util.Collections;

public class LoginServiceProviderManager
  implements PropertyChangeListener
{
  private static final String[] DEFAULT_SERVICE_PROVIDER_FULL_NAMES = { "yunos", "taobao", "h5" };
  private static final String[] DEFAULT_SERVICE_PROVIDER_NAMES = { "taobao", "h5" };
  public static final LoginServiceProviderManager INSTANCE = new LoginServiceProviderManager();
  private static final String SERVICE_PROVIDER_ORDER_KEY = "serviceProviderOrder";
  private static final String USE_H5_LOGIN_KEY = "useH5Login";
  private volatile String[] serviceProviderNames = DEFAULT_SERVICE_PROVIDER_NAMES;
  private volatile boolean useH5Login;
  
  public LoginServiceProviderManager()
  {
    initializeProperties("serviceProviderOrder", LoginContext.configurations.getStringValue("serviceProviderOrder"));
    initializeProperties("useH5Login", LoginContext.configurations.getStringValue("useH5Login"));
  }
  
  private void initializeProperties(String paramString1, String paramString2)
  {
    if ("serviceProviderOrder".equals(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        if (LoginConfigs.enableYunOSAutoLogin)
        {
          paramString1 = DEFAULT_SERVICE_PROVIDER_FULL_NAMES;
          this.serviceProviderNames = paramString1;
        }
      }
    }
    while (!"useH5Login".equals(paramString1))
    {
      for (;;)
      {
        return;
        paramString1 = DEFAULT_SERVICE_PROVIDER_NAMES;
      }
      this.serviceProviderNames = paramString2.split("[,]");
      return;
    }
    this.useH5Login = Boolean.valueOf(paramString2).booleanValue();
  }
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    initializeProperties(paramString1, paramString3);
  }
  
  public boolean showLogin(Activity paramActivity, LoginCallback paramLoginCallback)
  {
    if (this.useH5Login) {
      return H5LoginServiceProviderImpl.INSTANCE.showLogin(paramActivity, paramLoginCallback);
    }
    String[] arrayOfString = this.serviceProviderNames;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = (LoginServiceProvider)LoginContext.appContext.getService(LoginServiceProvider.class, Collections.singletonMap("loginServiceProviderName", localObject));
      if (localObject == null) {}
      while (!((LoginServiceProvider)localObject).showLogin(paramActivity, paramLoginCallback))
      {
        i += 1;
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean showLogin(String paramString, Activity paramActivity, LoginCallback paramLoginCallback)
  {
    paramString = (LoginServiceProvider)LoginContext.appContext.getService(LoginServiceProvider.class, Collections.singletonMap("loginServiceProviderName", paramString));
    if (paramString != null) {
      return paramString.showLogin(paramActivity, paramLoginCallback);
    }
    return false;
  }
  
  public boolean showNextLogin(String paramString, Activity paramActivity, LoginCallback paramLoginCallback)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.useH5Login) {
      bool1 = false;
    }
    int j;
    int i;
    String str;
    LoginServiceProvider localLoginServiceProvider;
    do
    {
      return bool1;
      String[] arrayOfString = this.serviceProviderNames;
      int k = arrayOfString.length;
      j = 0;
      i = 0;
      if (j >= k) {
        break label116;
      }
      str = arrayOfString[j];
      if (i == 0) {
        break;
      }
      localLoginServiceProvider = (LoginServiceProvider)LoginContext.appContext.getService(LoginServiceProvider.class, Collections.singletonMap("loginServiceProviderName", str));
      if (localLoginServiceProvider == null) {
        break;
      }
      bool1 = bool2;
    } while (localLoginServiceProvider.showLogin(paramActivity, paramLoginCallback));
    if (str.equals(paramString)) {
      i = 1;
    }
    for (;;)
    {
      j += 1;
      break;
      label116:
      return false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\LoginServiceProviderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */