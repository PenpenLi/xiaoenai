package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.log.e.i;

final class AppMonitor$16
  implements Runnable
{
  AppMonitor$16(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet) {}
  
  public void run()
  {
    try
    {
      i.a("AppMonitor", new Object[] { "[register]:", AppMonitor.a });
      AppMonitor.a.register3(this.i, this.j, this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMeasureSet, this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelDimensionSet);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */