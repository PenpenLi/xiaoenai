package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$Counter$4
  implements Runnable
{
  AppMonitor$Counter$4(String paramString1, String paramString2, String paramString3, double paramDouble) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.counter_commit2(this.i, this.j, this.l, this.d);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Counter$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */