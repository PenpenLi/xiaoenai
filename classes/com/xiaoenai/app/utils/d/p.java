package com.xiaoenai.app.utils.d;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;

public class p
{
  public static NotificationCompat.Builder a(Context paramContext)
  {
    return new NotificationCompat.Builder(paramContext).setWhen(System.currentTimeMillis()).setAutoCancel(true).setDefaults(0).setLights(-16711936, 1, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, Intent paramIntent)
  {
    paramIntent = PendingIntent.getActivity(paramContext, paramInt3, paramIntent, 134217728);
    paramString1 = a(paramContext).setContentIntent(paramIntent).setContentTitle(paramString1).setContentText(paramString2).setSmallIcon(paramInt1);
    if (paramInt2 > 0) {
      paramString1.setNumber(paramInt2);
    }
    a(paramContext, paramString1, paramInt3);
  }
  
  public static void a(Context paramContext, NotificationCompat.Builder paramBuilder, int paramInt)
  {
    if (paramBuilder != null)
    {
      paramBuilder = paramBuilder.build();
      ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, paramBuilder);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */