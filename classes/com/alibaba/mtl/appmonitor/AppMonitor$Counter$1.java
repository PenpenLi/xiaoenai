package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$Counter$1
  implements Runnable
{
  AppMonitor$Counter$1(int paramInt) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.counter_setStatisticsInterval(this.b);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Counter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */