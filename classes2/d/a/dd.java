package d.a;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dd
{
  private static long a(long paramLong, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int j = localCalendar.get(11);
    int k = localCalendar.get(12) / 6;
    int m = localCalendar.get(13);
    int i = 0;
    if (paramInt == 1002) {
      i = 360 - (localCalendar.get(12) % 6 * 60 + m);
    }
    for (;;)
    {
      return i * 1000;
      if (paramInt == 1001)
      {
        paramInt = 60 - m % 60;
        i = paramInt;
        if ((k + 1 + j * 10) % 6 == 0) {
          i = paramInt + 60;
        }
      }
    }
  }
  
  public static String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    int j = localCalendar.get(12) / 6;
    paramLong = d(paramLong);
    return String.valueOf(j + 1 + i * 10 - 1 + paramLong * 240L);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return e(paramLong1) == e(paramLong2);
  }
  
  public static long b(long paramLong)
  {
    return a(paramLong, 1001);
  }
  
  public static long c(long paramLong)
  {
    return a(paramLong, 1002);
  }
  
  private static long d(long paramLong)
  {
    long l1 = 0L;
    try
    {
      long l3 = new SimpleDateFormat("yyyy").parse("1970").getTime();
      long l2 = (paramLong - l3) / 86400000L;
      if ((paramLong - l3) % 86400000L > 0L) {
        l1 = 1L;
      }
      return l1 + l2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  private static int e(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(5);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */