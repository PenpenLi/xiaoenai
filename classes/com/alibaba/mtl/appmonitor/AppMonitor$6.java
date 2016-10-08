package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$6
  implements Runnable
{
  public void run()
  {
    try
    {
      AppMonitor.a.init();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.d();
      try
      {
        AppMonitor.a.init();
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */