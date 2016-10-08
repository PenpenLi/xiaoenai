package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.sina.sso.RemoteSSO;
import com.sina.sso.RemoteSSO.Stub;

class SsoHandler$1
  implements ServiceConnection
{
  SsoHandler$1(SsoHandler paramSsoHandler) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    paramIBinder = RemoteSSO.Stub.asInterface(paramIBinder);
    try
    {
      paramComponentName = paramIBinder.getPackageName();
      paramIBinder = paramIBinder.getActivityName();
      SsoHandler.access$2(this.this$0).getApplicationContext().unbindService(SsoHandler.access$3(this.this$0));
      if (!SsoHandler.access$4(this.this$0, paramComponentName, paramIBinder)) {
        SsoHandler.access$0(this.this$0).anthorize(SsoHandler.access$1(this.this$0));
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    SsoHandler.access$0(this.this$0).anthorize(SsoHandler.access$1(this.this$0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\auth\sso\SsoHandler$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */