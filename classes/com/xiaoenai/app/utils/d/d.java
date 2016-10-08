package com.xiaoenai.app.utils.d;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class d
{
  public static String a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return paramContext.getString(r.a.monday);
    case 3: 
      return paramContext.getString(r.a.tuesday);
    case 4: 
      return paramContext.getString(r.a.wendesday);
    case 5: 
      return paramContext.getString(r.a.thursday);
    case 6: 
      return paramContext.getString(r.a.friday);
    case 7: 
      return paramContext.getString(r.a.saturday);
    }
    return paramContext.getString(r.a.sunday);
  }
  
  public static String a(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(Long.valueOf(paramLong));
  }
  
  public static String a(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static Calendar a()
  {
    return Calendar.getInstance();
  }
  
  public static String b(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    Date localDate = new Date(paramLong);
    if (localDate != null) {
      return localSimpleDateFormat.format(localDate);
    }
    return "";
  }
  
  public static String b(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String c(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM", Locale.getDefault());
    Date localDate = new Date(paramLong);
    if (localDate != null) {
      return localSimpleDateFormat.format(localDate);
    }
    return "";
  }
  
  public static String c(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String d(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd E", Locale.SIMPLIFIED_CHINESE);
    Date localDate = new Date(paramLong);
    if (localDate != null) {
      return localSimpleDateFormat.format(localDate);
    }
    return "";
  }
  
  public static String d(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String e(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String f(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String g(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("hh:mm");
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String h(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM");
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String i(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("dd");
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
  
  public static String j(Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy");
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(paramCalendar.getTime());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */