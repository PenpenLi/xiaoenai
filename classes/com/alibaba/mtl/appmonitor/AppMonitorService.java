package com.alibaba.mtl.appmonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AppMonitorService
  extends Service
{
  IMonitor a = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.a == null) {
      this.a = new Monitor(getApplication());
    }
    return (IBinder)this.a;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {}
    try
    {
      this.a.triggerUpload();
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public void onLowMemory()
  {
    if (this.a != null) {}
    try
    {
      this.a.triggerUpload();
      super.onLowMemory();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */