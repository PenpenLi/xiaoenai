package com.alibaba.mtl.appmonitor;

import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;

final class AppMonitor$Stat$6
  implements Runnable
{
  AppMonitor$Stat$6(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.stat_commit3(this.i, this.j, this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet, this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMonitor.b(localRemoteException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$Stat$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */