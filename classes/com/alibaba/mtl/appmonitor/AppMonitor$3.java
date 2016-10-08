package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;
import java.util.Map;

final class AppMonitor$3
  implements Runnable
{
  AppMonitor$3(Map paramMap) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.turnOnRealTimeDebug(this.a);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */