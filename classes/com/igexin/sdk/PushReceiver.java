package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.utils.ad;
import com.xiaoenai.app.utils.f.a;

public class PushReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a.c("PushReceiver : onReceive : {}", new Object[] { paramIntent });
    ad.a(paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\igexin\sdk\PushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */