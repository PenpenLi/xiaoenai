package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$Stat$4
  implements Runnable
{
  AppMonitor$Stat$4(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.stat_end(this.i, this.j, this.q);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Stat$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */