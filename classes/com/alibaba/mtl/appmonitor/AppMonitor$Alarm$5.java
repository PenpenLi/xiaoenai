package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$Alarm$5
  implements Runnable
{
  AppMonitor$Alarm$5(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.alarm_commitFail1(this.i, this.j, this.m, this.n);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Alarm$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */