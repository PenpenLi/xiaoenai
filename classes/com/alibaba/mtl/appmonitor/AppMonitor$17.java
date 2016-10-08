package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$17
  implements Runnable
{
  AppMonitor$17(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.updateMeasure(this.i, this.j, this.k, this.a, this.b, this.c);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */