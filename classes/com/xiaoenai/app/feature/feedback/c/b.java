package com.xiaoenai.app.feature.feedback.c;

import android.content.Context;
import com.xiaoenai.app.feature.feedback.b.c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class b
{
  private static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramContext = new Date(paramLong);
    String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(paramContext);
    if (paramLong > a()) {}
    while ((paramLong > b()) && (paramLong < a())) {
      return str;
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    return localSimpleDateFormat.format(paramContext) + " " + str;
  }
  
  public static void a(List<c> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (((c)paramList.get(i)).h()) {
        ((c)paramList.get(i)).b(false);
      }
      i -= 1;
    }
    b(paramList);
  }
  
  private static long b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, -24);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private static void b(List<c> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if ((i != 0) && (((c)paramList.get(i)).c() - ((c)paramList.get(i - 1)).c() > 300000L) && (!((c)paramList.get(i - 1)).h())) {
        ((c)paramList.get(i - 1)).b(true);
      }
      i -= 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\feedback\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */