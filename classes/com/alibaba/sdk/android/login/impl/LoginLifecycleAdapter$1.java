package com.alibaba.sdk.android.login.impl;

import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.ut.UserTrackerService;
import java.util.Collections;

class LoginLifecycleAdapter$1
  implements PropertyChangeListener
{
  LoginLifecycleAdapter$1(LoginLifecycleAdapter paramLoginLifecycleAdapter) {}
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    if (("DEGRADE_NOT_LOGIN".equals(paramString1)) && ("T".equals(paramString3)) && (LoginContext.userTrackerService != null)) {
      LoginContext.userTrackerService.sendCustomHit("degarade", null, Collections.singletonMap("type", "forServerConfig"));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginLifecycleAdapter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */