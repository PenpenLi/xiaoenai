package com.adhoc;

import com.adhoc.adhocsdk.ExperimentFlags;
import com.adhoc.adhocsdk.OnAdHocReceivedData;

class u
  implements Runnable
{
  u(s params, OnAdHocReceivedData paramOnAdHocReceivedData, ExperimentFlags paramExperimentFlags) {}
  
  public void run()
  {
    try
    {
      this.a.onReceivedData(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */