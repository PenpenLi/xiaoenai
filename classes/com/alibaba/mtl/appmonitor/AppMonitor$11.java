package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$11
  implements Runnable
{
  AppMonitor$11(int paramInt) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.setStatisticsInterval1(this.b);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */