package b.a.b;

import b.a.j;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class i
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    localSimpleDateFormat.setLenient(false);
    localSimpleDateFormat.setTimeZone(j.d);
    return localSimpleDateFormat;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */