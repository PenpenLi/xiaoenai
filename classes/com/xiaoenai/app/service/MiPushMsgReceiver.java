package com.xiaoenai.app.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.utils.ad;
import com.xiaoenai.app.utils.f.a;

public class MiPushMsgReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a.c("MiPushMsgReceiver onReceive: {} {}", new Object[] { paramIntent.getAction(), paramIntent.getExtras() });
    ad.a(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\MiPushMsgReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */