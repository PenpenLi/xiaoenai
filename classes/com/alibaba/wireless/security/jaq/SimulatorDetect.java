package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;

public class SimulatorDetect
{
  private Context a;
  
  public SimulatorDetect(Context paramContext)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
  }
  
  public boolean isSimulator()
  {
    try
    {
      ISimulatorDetectComponent localISimulatorDetectComponent = SecurityGuardManager.getInstance(this.a).getSimulatorDetectComp();
      if (localISimulatorDetectComponent != null) {
        return localISimulatorDetectComponent.isSimulator();
      }
      throw new SecException(1598);
    }
    catch (SecException localSecException)
    {
      throw new JAQException(localSecException.getErrorCode());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\jaq\SimulatorDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */