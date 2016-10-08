package com.xiaoenai.app.classes.auth;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformDb;
import com.xiaoenai.app.ui.a.h;

class ag
  implements Runnable
{
  ag(af paramaf, Platform paramPlatform) {}
  
  public void run()
  {
    this.b.a.dismiss();
    SimpleLoginView.a(this.b.b, this.a.getDb().get("openid"), this.a.getDb().getToken());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */