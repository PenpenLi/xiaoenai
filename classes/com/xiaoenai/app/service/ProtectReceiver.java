package com.xiaoenai.app.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.utils.f.a;

public class ProtectReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    paramIntent = paramIntent.getAction();
    if (paramIntent != null)
    {
      a.c("receive action={}", new Object[] { paramIntent });
      if ((paramIntent.equals("android.intent.action.DATE_CHANGED")) || (paramIntent.equals("android.intent.action.TIME_SET"))) {
        localIntent.putExtra("adjustTime", true);
      }
    }
    localIntent.setClass(paramContext, ProtectService.class);
    paramContext.startService(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\ProtectReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */