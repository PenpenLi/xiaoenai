package com.adhoc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class ds
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    localSimpleDateFormat.setLenient(false);
    localSimpleDateFormat.setTimeZone(dr.a());
    return localSimpleDateFormat;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */