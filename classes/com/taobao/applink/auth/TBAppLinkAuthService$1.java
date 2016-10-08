package com.taobao.applink.auth;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.taobao.applink.auth.userinfo.TBAppLinkUserInfo;
import com.taobao.applink.util.TBAppLinkUtil;

class TBAppLinkAuthService$1
  implements Handler.Callback
{
  TBAppLinkAuthService$1(TBAppLinkAuthService paramTBAppLinkAuthService) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      if (TBAppLinkUtil.getApplication() != null)
      {
        TBAppLinkUtil.getApplication().unbindService(TBAppLinkAuthService.access$100());
        return false;
      }
      break;
    case 11802: 
      label28:
      TBAppLinkUserInfo localTBAppLinkUserInfo = new TBAppLinkUserInfo();
      paramMessage = paramMessage.getData();
      if (paramMessage != null)
      {
        localTBAppLinkUserInfo.result = "true".equals(paramMessage.getString("result"));
        if (localTBAppLinkUserInfo.result)
        {
          localTBAppLinkUserInfo.mixedNick = paramMessage.getString("mixedNick");
          localTBAppLinkUserInfo.icon = paramMessage.getString("icon");
          if (TBAppLinkAuthService.access$000(this.this$0) != null) {
            TBAppLinkAuthService.access$000(this.this$0).onSuccess(localTBAppLinkUserInfo);
          }
          label127:
          Log.d("AppLink", localTBAppLinkUserInfo.toString());
        }
      }
      break;
    }
    for (;;)
    {
      TBAppLinkAuthService.access$002(this.this$0, null);
      break label28;
      break;
      if (TBAppLinkAuthService.access$000(this.this$0) == null) {
        break label127;
      }
      TBAppLinkAuthService.access$000(this.this$0).onFailure();
      break label127;
      if (TBAppLinkAuthService.access$000(this.this$0) != null) {
        TBAppLinkAuthService.access$000(this.this$0).onFailure();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\auth\TBAppLinkAuthService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */