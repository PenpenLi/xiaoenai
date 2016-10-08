package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.log.e.i;

final class AppMonitor$9
  implements Runnable
{
  AppMonitor$9(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      i.a("AppMonitor", new Object[] { "register stat event. module: ", this.i, " monitorPoint: ", this.j });
      AppMonitor.a.register4(this.i, this.j, this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMeasureSet, this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelDimensionSet, this.e);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */