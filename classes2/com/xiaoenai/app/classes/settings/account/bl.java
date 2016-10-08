package com.xiaoenai.app.classes.settings.account;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import java.util.HashMap;

class bl
  implements PlatformActionListener
{
  bl(bk parambk) {}
  
  public void onCancel(Platform paramPlatform, int paramInt) {}
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    SettingPersonalActivity.b(this.a.b, paramPlatform.getDb().getUserId(), paramPlatform.getDb().getToken());
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */