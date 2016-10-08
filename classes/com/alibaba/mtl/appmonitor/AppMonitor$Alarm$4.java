package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$Alarm$4
  implements Runnable
{
  AppMonitor$Alarm$4(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.alarm_commitSuccess2(this.i, this.j, this.l);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Alarm$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */