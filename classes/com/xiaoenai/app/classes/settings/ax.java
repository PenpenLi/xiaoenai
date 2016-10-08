package com.xiaoenai.app.classes.settings;

import com.alibaba.sdk.android.login.callback.LogoutCallback;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;

class ax
  implements LogoutCallback
{
  ax(SettingsActivity paramSettingsActivity) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    a.a(true, "logOutTaobao onFailure code = {} msg = {}", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void onSuccess()
  {
    SettingsActivity.f(this.a);
    as.b(2131101234);
    a.c(true, "logOutTaobao onSuccess", new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */