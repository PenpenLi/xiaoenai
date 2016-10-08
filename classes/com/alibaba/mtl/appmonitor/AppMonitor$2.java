package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$2
  implements Runnable
{
  AppMonitor$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.setStatisticsInterval2(this.a, this.b);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */