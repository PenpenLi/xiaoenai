package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import java.util.Calendar;

class i
{
  public static void a(Context paramContext, PendingIntent paramPendingIntent)
  {
    ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramPendingIntent);
  }
  
  public static void a(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    paramContext.cancel(paramPendingIntent);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    localCalendar.add(14, paramInt);
    paramContext.set(0, localCalendar.getTimeInMillis(), paramPendingIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */