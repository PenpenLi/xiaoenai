package com.xiaoenai.app.classes.extentions.menses;

import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ak;
import java.util.Calendar;

public class ac
{
  private static MensesActivity a = null;
  private static MensesSettingActivity b = null;
  
  public static void a() {}
  
  public static void a(int paramInt)
  {
    UserConfig.setInt("mens_sex", paramInt);
  }
  
  public static void a(long paramLong)
  {
    UserConfig.setLong("menses_last_time", paramLong);
  }
  
  public static void a(MensesSettingActivity paramMensesSettingActivity)
  {
    b = paramMensesSettingActivity;
  }
  
  public static void a(boolean paramBoolean)
  {
    UserConfig.setBoolean("menses_is_stop", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (UserConfig.getLong("menses_recent", 0L) != paramLong1) {
          bool1 = true;
        }
        if (UserConfig.getInt("menses_duration", Integer.valueOf(0)).intValue() != paramInt1) {
          bool1 = true;
        }
        if (UserConfig.getInt("menses_interval", Integer.valueOf(0)).intValue() != paramInt2) {
          bool1 = true;
        }
        if (UserConfig.getLong("noti_ts", 0L) != paramLong2) {
          bool1 = true;
        }
        if (UserConfig.getLong("leave_ts", 0L) != paramLong3) {
          bool1 = true;
        }
        if (!UserConfig.getString("mens_help", "").equals(paramString))
        {
          bool1 = bool2;
          UserConfig.setLong("menses_recent", paramLong1);
          UserConfig.setInt("menses_duration", paramInt1);
          UserConfig.setInt("menses_interval", paramInt2);
          UserConfig.setLong("noti_ts", paramLong2);
          UserConfig.setLong("leave_ts", paramLong3);
          UserConfig.setString("mens_help", paramString);
          return bool1;
        }
      }
      finally {}
    }
  }
  
  public static long b()
  {
    long l = UserConfig.getLong("menses_recent", 0L);
    if (l > 86400L) {
      return l;
    }
    return 0L;
  }
  
  public static void b(long paramLong)
  {
    UserConfig.setLong("mens_localnoti_ts", paramLong);
  }
  
  public static void b(MensesSettingActivity paramMensesSettingActivity)
  {
    b = null;
  }
  
  public static void b(boolean paramBoolean)
  {
    if (a != null) {
      a.a(paramBoolean);
    }
    if (b != null) {
      b.a(paramBoolean);
    }
  }
  
  public static boolean c()
  {
    return UserConfig.getBoolean("menses_is_stop", Boolean.valueOf(false)).booleanValue();
  }
  
  public static int d()
  {
    return UserConfig.getInt("menses_duration", Integer.valueOf(0)).intValue();
  }
  
  public static int e()
  {
    return UserConfig.getInt("menses_interval", Integer.valueOf(0)).intValue();
  }
  
  public static long f()
  {
    return UserConfig.getLong("noti_ts", 0L);
  }
  
  public static long g()
  {
    return UserConfig.getLong("leave_ts", 0L);
  }
  
  public static String h()
  {
    return UserConfig.getString("mens_help", "");
  }
  
  public static long i()
  {
    long l = UserConfig.getLong("noti_ts", 0L);
    if (l > 0L) {
      return l;
    }
    return b();
  }
  
  public static void j()
  {
    UserConfig.setLong("menses_recent", 0L);
    UserConfig.setInt("menses_duration", 0);
    UserConfig.setLong("noti_ts", 0L);
    UserConfig.setLong("leave_ts", 0L);
    UserConfig.setString("mens_help", "");
    UserConfig.setBoolean("menses_is_stop", Boolean.valueOf(false));
    UserConfig.setLong("mens_localnoti_ts", 0L);
    UserConfig.setLong("menses_last_time", System.currentTimeMillis());
    UserConfig.setInt("menses_interval", 0);
  }
  
  public static long k()
  {
    long l1 = i();
    int i = e();
    long l2 = ak.b();
    long l3 = i * 24;
    while (l2 >= l1) {
      l1 += l3 * 3600L;
    }
    return l1;
  }
  
  public static int l()
  {
    return UserConfig.getInt("mens_sex", Integer.valueOf(-1)).intValue();
  }
  
  public static long m()
  {
    return UserConfig.getLong("menses_last_time", i() * 1000L);
  }
  
  public static a n()
  {
    Object localObject2 = a.a;
    Object localObject1;
    if (!p())
    {
      localObject1 = localObject2;
      return (a)localObject1;
    }
    int i = d();
    int j = e();
    long l2 = k();
    long l1 = l2 - j * 86400L;
    long l3 = ak.b();
    while (l3 - l1 > j * 86400L) {
      l1 += j * 86400L;
    }
    if ((l3 >= l1) && (l3 < i * 86400L + l1))
    {
      localObject1 = a.c;
      label103:
      localObject2 = localObject1;
      if (a.c == localObject1)
      {
        if (g() < l1) {
          break label252;
        }
        localObject2 = a.a;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 != a.a) {
        break;
      }
      localObject1 = localObject2;
      if (l3 <= l2 - 259201L) {
        break;
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l3);
      localObject1 = localObject2;
      if (localCalendar.get(11) <= 9) {
        break;
      }
      return a.b;
      if ((l3 >= i * 86400L + l1) && (l3 < (j - 3) * 86400L + l1))
      {
        localObject1 = a.a;
        break label103;
      }
      localObject1 = localObject2;
      if (l3 < (j - 3) * 86400L + l1) {
        break label103;
      }
      localObject1 = localObject2;
      if (l3 >= l2) {
        break label103;
      }
      localObject1 = a.b;
      break label103;
      label252:
      localObject2 = localObject1;
      if (g() < l1)
      {
        localObject2 = localObject1;
        if (f() >= l1)
        {
          localObject2 = localObject1;
          if (f() <= k() - (j - i) * 86400L) {
            localObject2 = a.c;
          }
        }
      }
    }
  }
  
  public static long o()
  {
    return UserConfig.getLong("mens_localnoti_ts", 0L);
  }
  
  public static boolean p()
  {
    return (0L != b()) || (0L != f());
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */