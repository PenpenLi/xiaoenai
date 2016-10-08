package com.xiaoenai.app.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.utils.d.d;
import com.xiaoenai.app.utils.f.a;
import java.util.Calendar;

public class c
{
  public static void a(Context paramContext)
  {
    b(paramContext);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, MessageService.class);
    ((Intent)localObject).putExtra("from", "AlarmManager");
    paramContext = PendingIntent.getService(paramContext, 124, (Intent)localObject, 134217728);
    localObject = Calendar.getInstance();
    long l = ((Calendar)localObject).getTimeInMillis() + 900000L;
    ((Calendar)localObject).setTimeInMillis(l);
    a.c("time={}", new Object[] { d.a((Calendar)localObject) });
    localAlarmManager.setRepeating(0, l, 900000L, paramContext);
  }
  
  public static void b(Context paramContext)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramContext, MessageService.class);
    localObject = PendingIntent.getService(paramContext, 124, (Intent)localObject, 134217728);
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel((PendingIntent)localObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */