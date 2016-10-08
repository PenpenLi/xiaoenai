package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xiaoenai.app.utils.ad;
import com.xiaoenai.app.utils.f.a;

public class PushMessageHandler
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    a.c("PushMessageHandler onCreate", new Object[0]);
    ad.a(this);
    super.onCreate();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    a.c("PushMessageHandler onStart", new Object[0]);
    ad.a(this);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    a.c("PushMessageHandler onStartCommand", new Object[0]);
    ad.a(this);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaomi\mipush\sdk\PushMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */