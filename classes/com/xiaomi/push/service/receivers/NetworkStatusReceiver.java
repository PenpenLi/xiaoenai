package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.utils.ad;
import com.xiaoenai.app.utils.f.a;

public class NetworkStatusReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a.c("NetworkStatusReceiver onReceive", new Object[0]);
    ad.a(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaomi\push\service\receivers\NetworkStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */