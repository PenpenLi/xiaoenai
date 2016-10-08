package com.xiaoenai.app.utils;

import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.utils.d.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ak
{
  public static long a()
  {
    return System.currentTimeMillis() + AppSettings.getInt("client_server_adjust", Integer.valueOf(0)).intValue() * 1000;
  }
  
  private static String a(int paramInt)
  {
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return "" + paramInt;
  }
  
  public static String a(long paramLong)
  {
    long l = b();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    if (l - paramLong < 60L) {
      return Xiaoenai.j().getResources().getString(2131101527);
    }
    if (l - paramLong < 3600L) {
      return String.format(Xiaoenai.j().getResources().getString(2131101523), new Object[] { Long.valueOf((l - paramLong) / 60L) });
    }
    if (l - paramLong < 86400L) {
      return String.format(Xiaoenai.j().getResources().getString(2131101520), new Object[] { Long.valueOf((l - paramLong) / 3600L) });
    }
    if (l - paramLong < 31536000L) {
      return d.e(localCalendar);
    }
    return d.a(localCalendar);
  }
  
  public static String a(long paramLong1, long paramLong2)
  {
    String str = null;
    paramLong1 = paramLong2 - ((int)b() - paramLong1);
    if (paramLong1 > 0L) {
      str = o(paramLong1);
    }
    return str;
  }
  
  public static long b()
  {
    return System.currentTimeMillis() / 1000L + AppSettings.getInt("client_server_adjust", Integer.valueOf(0)).intValue();
  }
  
  public static String b(long paramLong)
  {
    long l = a();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    paramLong = l / 1000L - paramLong / 1000L;
    if (paramLong < 60L) {
      return Xiaoenai.j().getResources().getString(2131101527);
    }
    if (paramLong < 3600L) {
      return String.format(Xiaoenai.j().getResources().getString(2131101523), new Object[] { Long.valueOf(paramLong / 60L) });
    }
    if (paramLong < 86400L) {
      return String.format(Xiaoenai.j().getResources().getString(2131101520), new Object[] { Long.valueOf(paramLong / 3600L) });
    }
    if (paramLong < 31536000L) {
      return d.e(localCalendar);
    }
    return d.a(localCalendar);
  }
  
  public static int c()
  {
    return Calendar.getInstance(Locale.getDefault()).get(15) / 60 / 60 / 1000;
  }
  
  public static String c(long paramLong)
  {
    long l = a() / 1000L;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(1000L * paramLong);
    paramLong -= l;
    if ((paramLong > 0L) && (paramLong < 86400L)) {
      return d.f(localCalendar);
    }
    return d.b(localCalendar);
  }
  
  public static String d(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(1000L * paramLong);
    return d.d(localCalendar);
  }
  
  public static String e(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    String str = Xiaoenai.j().getResources().getString(2131101525);
    return String.format(str, new Object[] { d.j(localCalendar), d.h(localCalendar), d.i(localCalendar) }) + " " + d.a(localCalendar.get(7), Xiaoenai.j()) + " " + d.f(localCalendar);
  }
  
  public static long f(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    localCalendar1.set(14, 0);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(a());
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    localCalendar2.set(14, 0);
    long l = Math.abs((localCalendar2.getTime().getTime() - localCalendar1.getTime().getTime()) / 86400000L);
    paramLong = l;
    if (l == 0L) {
      paramLong = 1L;
    }
    return paramLong;
  }
  
  public static long g(long paramLong)
  {
    return AppSettings.getInt("client_server_adjust", Integer.valueOf(0)).intValue() + paramLong;
  }
  
  public static String h(long paramLong)
  {
    int i = (int)paramLong;
    int j = i / 60 % 60;
    int k = i / 3600 % 3600;
    StringBuilder localStringBuilder = new StringBuilder();
    if (k > 0)
    {
      localStringBuilder.append(k);
      localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100603));
    }
    if (j > 0)
    {
      localStringBuilder.append(j);
      localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100882));
    }
    localStringBuilder.append(i % 60);
    localStringBuilder.append(Xiaoenai.j().getResources().getString(2131101070));
    return localStringBuilder.toString();
  }
  
  public static String i(long paramLong)
  {
    int i = (int)paramLong;
    int j = i / 60 % 60;
    int k = i / 3600 % 24;
    int m = i / 3600 / 24;
    StringBuilder localStringBuilder = new StringBuilder();
    if (m > 0)
    {
      localStringBuilder.append(m);
      localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100875));
    }
    if (k > 0)
    {
      localStringBuilder.append(k);
      localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100603));
    }
    if (j > 0)
    {
      localStringBuilder.append(j);
      localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100876));
    }
    localStringBuilder.append(i % 60);
    localStringBuilder.append(Xiaoenai.j().getResources().getString(2131101070));
    return localStringBuilder.toString();
  }
  
  public static String j(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(1000L * paramLong));
  }
  
  public static String k(long paramLong)
  {
    return new SimpleDateFormat("MM.dd HH:mm").format(Long.valueOf(1000L * paramLong));
  }
  
  public static int l(long paramLong)
  {
    return (int)((86400000L + paramLong - 1L) / 3600L / 24L / 1000L);
  }
  
  public static String m(long paramLong)
  {
    int k = (int)paramLong;
    int i = k / 60 % 60;
    int j = k / 3600 % 24;
    k = k / 3600 / 24;
    StringBuilder localStringBuilder = new StringBuilder();
    if (k > 0)
    {
      localStringBuilder.append(k);
      localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100420));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (j > 0)
      {
        localStringBuilder.append(j);
        localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100421));
      }
      if (i > 0)
      {
        localStringBuilder.append(i);
        localStringBuilder.append(Xiaoenai.j().getResources().getString(2131100422));
      }
    }
  }
  
  public static String n(long paramLong)
  {
    long l1 = paramLong / 10L;
    long l2 = l1 / 60L;
    long l3 = l1 / 3600L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a((int)l3));
    localStringBuilder.append(":");
    localStringBuilder.append(a((int)(l2 % 60L)));
    localStringBuilder.append(":");
    localStringBuilder.append(a((int)(l1 % 60L)));
    localStringBuilder.append(".");
    localStringBuilder.append(paramLong % 10L);
    return localStringBuilder.toString();
  }
  
  public static String o(long paramLong)
  {
    long l1 = paramLong % 60L;
    long l2 = paramLong / 60L % 60L;
    paramLong /= 3600L;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLong >= 0L)
    {
      localStringBuilder.append(a((int)paramLong));
      localStringBuilder.append(":");
    }
    if (l2 >= 0L)
    {
      localStringBuilder.append(a((int)l2));
      localStringBuilder.append(":");
    }
    if (l1 >= 0L) {
      localStringBuilder.append(a((int)l1));
    }
    return localStringBuilder.toString();
  }
  
  public static boolean p(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int m = localCalendar.get(1);
    int n = localCalendar.get(2);
    return (k == localCalendar.get(5)) && (j == n) && (i == m);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */