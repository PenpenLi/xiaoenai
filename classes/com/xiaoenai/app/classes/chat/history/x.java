package com.xiaoenai.app.classes.chat.history;

import com.xiaoenai.app.model.AppSettings;
import java.util.Calendar;

public class x
{
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return (int)(localCalendar.getTimeInMillis() / 1000L) + AppSettings.getInt("client_server_adjust", Integer.valueOf(0)).intValue();
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    Calendar localCalendar = a(paramInt);
    if (paramBoolean) {
      localCalendar.set(5, localCalendar.get(5) - 1);
    }
    for (;;)
    {
      return (int)(localCalendar.getTimeInMillis() / 1000L);
      localCalendar.set(5, localCalendar.get(5) + 1);
    }
  }
  
  public static Calendar a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(paramInt * 1000L);
    return localCalendar;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */