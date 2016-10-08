package com.xiaoenai.app.common.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.xiaoenai.app.utils.f.a;

public abstract class BaseService
  extends Service
{
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    a.c("onBind", new Object[0]);
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a.c("onConfigurationChanged", new Object[0]);
  }
  
  public void onCreate()
  {
    super.onCreate();
    a.c("onCreate", new Object[0]);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a.c("onDestroy", new Object[0]);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    a.c("onLowMemory", new Object[0]);
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    a.c("onRebind", new Object[0]);
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    a.c("onTrimMemory {}", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    a.c("onUnbind", new Object[0]);
    return super.onUnbind(paramIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\service\BaseService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */