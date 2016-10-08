package com.xiaoenai.app.classes.settings.account;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import java.util.HashMap;

class bj
  implements PlatformActionListener
{
  bj(bi parambi) {}
  
  public void onCancel(Platform paramPlatform, int paramInt) {}
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    SettingPersonalActivity.a(this.a.b, paramPlatform.getDb().get("openid"), paramPlatform.getDb().getToken());
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */