package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$Alarm$3
  implements Runnable
{
  AppMonitor$Alarm$3(String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.alarm_commitSuccess1(this.i, this.j);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Alarm$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */