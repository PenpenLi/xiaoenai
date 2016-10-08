package com.xiaoenai.app.utils.d;

import android.content.Context;
import android.content.res.Resources;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class v
{
  public static String a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd HH:mm:ss");
  }
  
  public static String a(long paramLong, String paramString)
  {
    return new SimpleDateFormat(paramString, Locale.getDefault()).format(Long.valueOf(1000L * paramLong));
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    return String.format("%.1f%s", new Object[] { Float.valueOf(new BigDecimal((float)paramLong / 3600.0F).setScale(1, 1).floatValue()), paramContext.getResources().getString(r.a.hour) });
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */