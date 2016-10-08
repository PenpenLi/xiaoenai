package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$12
  implements Runnable
{
  AppMonitor$12(int paramInt) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.setSampling(this.c);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */