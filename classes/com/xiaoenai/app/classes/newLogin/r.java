package com.xiaoenai.app.classes.newLogin;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import com.xiaoenai.app.utils.f.a;
import java.util.HashMap;

class r
  implements PlatformActionListener
{
  r(LoginActivity paramLoginActivity) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    a.a("onCancel", new Object[0]);
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    LoginActivity.a(this.a, paramPlatform.getDb().getUserIcon());
    LoginActivity.a(this.a, paramPlatform.getDb().get("openid"), paramPlatform.getDb().getToken());
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    LoginActivity.a(this.a);
    if (paramPlatform != null) {
      paramPlatform.removeAccount();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */