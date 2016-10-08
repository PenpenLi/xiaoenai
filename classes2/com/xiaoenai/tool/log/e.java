package com.xiaoenai.tool.log;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class e
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    d.a((a)paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    d.a(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\tool\log\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */