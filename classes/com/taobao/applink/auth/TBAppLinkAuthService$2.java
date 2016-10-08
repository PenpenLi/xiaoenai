package com.taobao.applink.auth;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class TBAppLinkAuthService$2
  implements ServiceConnection
{
  TBAppLinkAuthService$2(TBAppLinkAuthService paramTBAppLinkAuthService) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    paramComponentName = new Messenger(paramIBinder);
    paramIBinder = Message.obtain(null, 11801);
    paramIBinder.replyTo = TBAppLinkAuthService.access$200(this.this$0);
    try
    {
      paramComponentName.send(paramIBinder);
      return;
    }
    catch (Throwable paramComponentName)
    {
      Log.d("AppLink", paramComponentName.toString());
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.v("AppLink", "服务已断开");
    TBAppLinkAuthService.access$300(this.this$0);
    if (TBAppLinkAuthService.access$000(this.this$0) != null) {
      TBAppLinkAuthService.access$000(this.this$0).onFailure();
    }
    TBAppLinkAuthService.access$402(this.this$0, null);
    TBAppLinkAuthService.access$202(this.this$0, null);
    TBAppLinkAuthService.access$102(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\auth\TBAppLinkAuthService$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */