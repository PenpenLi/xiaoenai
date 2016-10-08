package com.igexin.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.utils.ad;
import com.xiaoenai.app.utils.f.a;

public class PushService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    a.d("PushService onBind", new Object[0]);
    return null;
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    a.d("PushService onStart", new Object[0]);
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    a.d("PushService onStartCommand", new Object[0]);
    ad.a(this);
    int i = AppSettings.getInt("last_startup_ts", Integer.valueOf(0)).intValue();
    if ((int)(System.currentTimeMillis() / 1000L) - i < ConfigCenter.getMaxStartupInterval()) {
      stopSelf();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\igexin\sdk\PushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */