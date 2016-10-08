package com.xiaoenai.app.classes.auth;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformDb;

class h
  implements Runnable
{
  h(g paramg, Platform paramPlatform) {}
  
  public void run()
  {
    this.b.a.dismiss();
    SimpleLoginView.b(this.b.b, this.a.getDb().getUserId(), this.a.getDb().getToken());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */