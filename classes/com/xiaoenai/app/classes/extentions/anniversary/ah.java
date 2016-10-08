package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Context;
import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.c.c;
import com.xiaoenai.app.utils.f.a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class ah
{
  public static String a = "none";
  public static String b = "loving_time";
  public String c = Xiaoenai.j().getString(2131099941);
  private Integer d = null;
  private String e = "";
  private String f = a;
  private long g = 0L;
  private int h = 0;
  private boolean i = false;
  
  public static ah a(JSONObject paramJSONObject)
  {
    ah localah = new ah();
    try
    {
      localah.d = Integer.valueOf(paramJSONObject.getInt("id"));
      localah.e = paramJSONObject.getString("content");
      localah.g = paramJSONObject.getLong("remind_ts");
      if (paramJSONObject.has("repeat_type")) {
        localah.h = paramJSONObject.getInt("repeat_type");
      }
      if (paramJSONObject.has("calendar_type")) {
        if (paramJSONObject.getInt("calendar_type") != 0) {
          break label87;
        }
      }
      label87:
      for (boolean bool = true;; bool = false)
      {
        localah.i = bool;
        return localah;
      }
      return null;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private Date b(long paramLong)
  {
    return new Date(1000L * paramLong);
  }
  
  private Boolean c(long paramLong)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramLong * 1000L > System.currentTimeMillis()) {
      localBoolean = Boolean.valueOf(false);
    }
    int m;
    int i2;
    do
    {
      return localBoolean;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.clear();
      localCalendar.setTimeInMillis(paramLong * 1000L);
      int j = localCalendar.get(1);
      int k = localCalendar.get(2);
      m = localCalendar.get(5);
      localCalendar = Calendar.getInstance();
      int n = localCalendar.get(1);
      int i1 = localCalendar.get(2);
      i2 = localCalendar.get(5);
      if (n > j) {
        return Boolean.valueOf(true);
      }
      if (i1 > k) {
        return Boolean.valueOf(true);
      }
    } while (i2 <= m);
    return Boolean.valueOf(true);
  }
  
  private long o()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(b() * 1000L);
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    localCalendar1.set(14, 0);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(ak.a());
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    localCalendar2.set(14, 0);
    return Math.abs((localCalendar2.getTime().getTime() - localCalendar1.getTime().getTime()) / 86400000L);
  }
  
  private long p()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(b() * 1000L);
    int j = localCalendar.get(7);
    int k = Calendar.getInstance().get(7);
    if (j >= k) {
      return j - k;
    }
    return j + (7 - k);
  }
  
  private long q()
  {
    if (this.i) {
      return com.xiaoenai.app.utils.c.d.b(b());
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(b() * 1000L);
    int m = localCalendar.get(5);
    localCalendar = Calendar.getInstance();
    int n = localCalendar.get(5);
    int i1 = c.a(localCalendar.get(2) + 1, localCalendar.get(1));
    if (m >= n)
    {
      if (m <= i1) {
        return m - n;
      }
      return i1 - n;
    }
    int k = localCalendar.get(2) + 2;
    int j = k;
    if (k > 12) {
      j = k % 12;
    }
    j = c.a(j, localCalendar.get(1));
    if (m < j) {
      return m + i1 - n;
    }
    return j + i1 - n;
  }
  
  private long r()
  {
    if (this.i)
    {
      long l = com.xiaoenai.app.utils.c.d.a(b());
      if (l != -1L) {}
      return l;
    }
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.clear();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(b() * 1000L);
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    localCalendar1.set(14, 0);
    a.c("anniversary {}", new Object[] { com.xiaoenai.app.utils.d.d.a(localCalendar1) });
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    localCalendar2.set(14, 0);
    if ((localCalendar1.get(2) == 1) && (localCalendar1.get(5) == 29)) {
      if ((!c.d(localCalendar2.get(1))) || (localCalendar2.after(localCalendar1)))
      {
        localCalendar1.set(1, c.g(localCalendar2.get(1)));
        a.c("anniversary next time{}", new Object[] { com.xiaoenai.app.utils.d.d.a(localCalendar1) });
      }
    }
    while (localCalendar2.getTimeInMillis() <= localCalendar1.getTimeInMillis())
    {
      return Math.abs((localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis()) / 86400000L);
      localCalendar1.set(1, localCalendar2.get(1));
    }
    localCalendar1.set(1, Calendar.getInstance().get(1) + 1);
    a.c("anniversary next time{}", new Object[] { com.xiaoenai.app.utils.d.d.a(localCalendar1) });
    return Math.abs((localCalendar1.getTimeInMillis() - localCalendar2.getTimeInMillis()) / 86400000L);
  }
  
  public String a()
  {
    return this.f;
  }
  
  public String a(Context paramContext)
  {
    return String.format(paramContext.getString(2131099935), new Object[] { com.xiaoenai.app.utils.d.d.a(this.g * 1000L) });
  }
  
  public String a(Context paramContext, long paramLong)
  {
    return String.format(paramContext.getString(2131099935), new Object[] { com.xiaoenai.app.utils.d.d.a(1000L * paramLong) });
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(Integer paramInteger)
  {
    this.d = paramInteger;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public long b()
  {
    return this.g;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public boolean d()
  {
    return this.i;
  }
  
  public String e()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date localDate = b(this.g);
    if (localDate != null) {
      return localSimpleDateFormat.format(localDate);
    }
    return "";
  }
  
  public int f()
  {
    if (m().booleanValue()) {
      return 2130838327;
    }
    return 2130838326;
  }
  
  public int g()
  {
    if (m().booleanValue()) {
      return 2130838331;
    }
    return 2130838330;
  }
  
  public String h()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd E");
    Date localDate = b(this.g);
    if (localDate != null) {
      return localSimpleDateFormat.format(localDate);
    }
    return "";
  }
  
  public String i()
  {
    if (this.f.equals(b)) {
      return Xiaoenai.j().getResources().getString(2131099930);
    }
    return this.e;
  }
  
  public String j()
  {
    if (k() == 0L) {
      return this.e;
    }
    if (this.d.intValue() == 0) {
      return this.e;
    }
    if (m().booleanValue()) {
      return String.format(as.a(2131099927), new Object[] { this.e });
    }
    return String.format(as.a(2131099928), new Object[] { this.e });
  }
  
  public long k()
  {
    long l = 0L;
    if (this.g != 0L)
    {
      if (this.f.equals(b)) {
        l = o();
      }
    }
    else {
      return l;
    }
    if (this.g > System.currentTimeMillis() / 1000L) {
      return o();
    }
    if (this.h == 1) {
      return p();
    }
    if (this.h == 2) {
      return q();
    }
    if (this.h == 3) {
      return r();
    }
    return o();
  }
  
  public Integer l()
  {
    return this.d;
  }
  
  public Boolean m()
  {
    if (this.h == 0) {
      return c(this.g);
    }
    return Boolean.valueOf(this.f.equals(b));
  }
  
  public JSONObject n()
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.d);
      localJSONObject.put("content", this.e);
      localJSONObject.put("remind_ts", this.g);
      localJSONObject.put("repeat_type", this.h);
      if (this.i) {}
      for (int j = 0;; j = 1)
      {
        localJSONObject.put("calendar_type", j);
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */