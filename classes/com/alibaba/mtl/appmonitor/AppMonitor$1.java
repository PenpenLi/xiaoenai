package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$1
  implements Runnable
{
  public void run()
  {
    try
    {
      AppMonitor.a.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */