package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$Counter$3
  implements Runnable
{
  AppMonitor$Counter$3(String paramString1, String paramString2, double paramDouble) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.counter_commit1(this.i, this.j, this.d);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Counter$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */