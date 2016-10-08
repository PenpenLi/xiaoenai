package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;

final class AppMonitor$Stat$5
  implements Runnable
{
  AppMonitor$Stat$5(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, double paramDouble) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.stat_commit2(this.i, this.j, this.a, this.d);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Stat$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */