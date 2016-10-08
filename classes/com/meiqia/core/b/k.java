package com.meiqia.core.b;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class k
{
  public static long a(String paramString)
  {
    if (paramString == null) {
      return System.currentTimeMillis();
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return System.currentTimeMillis();
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSSSSS", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(localDate);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */