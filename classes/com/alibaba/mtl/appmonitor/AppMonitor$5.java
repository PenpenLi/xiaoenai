package com.alibaba.mtl.appmonitor;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alibaba.mtl.log.e.i;

final class AppMonitor$5
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    if (AppMonitor.b.c == AppMonitor.a())
    {
      AppMonitor.a = IMonitor.Stub.asInterface(paramIBinder);
      if ((AppMonitor.d()) && (AppMonitor.a() != null)) {
        AppMonitor.a().postAtFrontOfQueue(new AppMonitor.5.1(this));
      }
    }
    synchronized (AppMonitor.a())
    {
      AppMonitor.a().notifyAll();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    i.a("AppMonitor", new Object[] { "[onServiceDisconnected]" });
    synchronized (AppMonitor.a())
    {
      AppMonitor.a().notifyAll();
      AppMonitor.a(true);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */