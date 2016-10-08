package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.MeasureSet;

final class AppMonitor$14
  implements Runnable
{
  AppMonitor$14(String paramString1, String paramString2, MeasureSet paramMeasureSet) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.register1(this.i, this.j, this.a);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */