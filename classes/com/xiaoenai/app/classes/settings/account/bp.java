package com.xiaoenai.app.classes.settings.account;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import com.xiaoenai.app.model.ShareSDKSettings;
import com.xiaoenai.app.utils.f.a;
import java.util.HashMap;

class bp
  implements PlatformActionListener
{
  bp(SettingPersonalActivity paramSettingPersonalActivity, Platform paramPlatform) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    a.a("onCancel", new Object[0]);
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    ShareSDKSettings.loadShareSDK(this.b);
    SettingPersonalActivity.a(this.b, paramPlatform.getDb().getUserId(), paramPlatform.getDb().getToken(), this.a);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (paramPlatform != null) {
      paramPlatform.removeAccount();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */