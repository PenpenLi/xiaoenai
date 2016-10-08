package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;

final class AppMonitor$13
  implements Runnable
{
  AppMonitor$13(boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.enableLog(this.f);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */