package com.inmobi.commons.core.utilities.info;

import com.inmobi.commons.a.b;
import com.inmobi.commons.core.utilities.uid.c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private static final String a = d.class.getSimpleName();
  
  public static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mk-version", b.a());
    if (c.a().m()) {}
    for (int i = 1;; i = 0)
    {
      localHashMap.put("u-id-adt", String.valueOf(i));
      localHashMap.put("ts", b());
      localHashMap.put("tz", c());
      localHashMap.putAll(f.a().c());
      return localHashMap;
    }
  }
  
  private static String b()
  {
    return String.valueOf(Calendar.getInstance().getTimeInMillis());
  }
  
  private static String c()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(15);
    return String.valueOf(localCalendar.get(16) + i);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\info\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */