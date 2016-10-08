package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$OffLineCounter$3
  implements Runnable
{
  AppMonitor$OffLineCounter$3(String paramString1, String paramString2, double paramDouble) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.offlinecounter_commit(this.i, this.j, this.d);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$OffLineCounter$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */