package com.xiaoenai.app.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class i
  implements ServiceConnection
{
  i(h paramh) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    paramComponentName = ((j)paramIBinder).a();
    h.a(this.a).a(paramComponentName);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    h.a(this.a).a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\service\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */