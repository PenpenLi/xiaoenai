package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.f.a.a;
import java.lang.reflect.Method;

public class w
{
  private static String c = null;
  private static Context d = null;
  private final String a = "a_start_time";
  private final String b = "a_end_time";
  
  public static String a()
  {
    try
    {
      if (c == null) {
        c = t.a(d).getString("session_id", null);
      }
      return c;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    g localg = g.a(paramContext);
    String str = b(paramContext);
    z.n localn = a(paramContext);
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putString("session_id", str);
    paramSharedPreferences.putLong("session_start_time", System.currentTimeMillis());
    paramSharedPreferences.putLong("session_end_time", 0L);
    paramSharedPreferences.putLong("a_start_time", System.currentTimeMillis());
    paramSharedPreferences.putLong("a_end_time", 0L);
    paramSharedPreferences.putInt("versioncode", Integer.parseInt(av.a(paramContext)));
    paramSharedPreferences.putString("versionname", av.b(paramContext));
    paramSharedPreferences.commit();
    if (localn != null)
    {
      localg.a(localn);
      return str;
    }
    localg.a((z.n)null);
    return str;
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.remove("session_start_time");
    paramSharedPreferences.remove("session_end_time");
    paramSharedPreferences.remove("a_start_time");
    paramSharedPreferences.remove("a_end_time");
    paramSharedPreferences.putString("activities", "");
    paramSharedPreferences.commit();
  }
  
  private boolean b(SharedPreferences paramSharedPreferences)
  {
    long l1 = paramSharedPreferences.getLong("a_start_time", 0L);
    long l2 = paramSharedPreferences.getLong("a_end_time", 0L);
    long l3 = System.currentTimeMillis();
    if ((l1 != 0L) && (l3 - l1 < a.i)) {
      ax.d("onResume called before onPause");
    }
    while (l3 - l2 <= a.i) {
      return false;
    }
    return true;
  }
  
  public static String g(Context paramContext)
  {
    if (c == null) {
      c = t.a(paramContext).getString("session_id", null);
    }
    return c;
  }
  
  public z.n a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = t.a(paramContext);
    Object localObject1 = localSharedPreferences.getString("session_id", null);
    if (localObject1 == null) {
      return null;
    }
    long l3 = localSharedPreferences.getLong("session_start_time", 0L);
    long l4 = localSharedPreferences.getLong("session_end_time", 0L);
    long l1 = 0L;
    long l2;
    if (l4 != 0L)
    {
      l2 = l4 - l3;
      l1 = l2;
      if (Math.abs(l2) > 86400000L) {
        l1 = 0L;
      }
    }
    z.n localn = new z.n();
    localn.b = ((String)localObject1);
    localn.c = l3;
    localn.d = l4;
    localn.e = l1;
    localObject1 = a.a();
    if (localObject1 != null)
    {
      localn.j.a = localObject1[0];
      localn.j.b = localObject1[1];
      localn.j.c = System.currentTimeMillis();
    }
    for (;;)
    {
      try
      {
        Object localObject2 = Class.forName("android.net.TrafficStats");
        localObject1 = ((Class)localObject2).getMethod("getUidRxBytes", new Class[] { Integer.TYPE });
        localObject2 = ((Class)localObject2).getMethod("getUidTxBytes", new Class[] { Integer.TYPE });
        int i = paramContext.getApplicationInfo().uid;
        if (i == -1) {
          return null;
        }
        l3 = ((Long)((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(i) })).longValue();
        l1 = ((Long)((Method)localObject2).invoke(null, new Object[] { Integer.valueOf(i) })).longValue();
        if (l3 > 0L) {
          if (l1 > 0L) {
            continue;
          }
        }
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      y.a(localSharedPreferences, localn);
      a(localSharedPreferences);
      return localn;
      l2 = localSharedPreferences.getLong("uptr", -1L);
      l4 = localSharedPreferences.getLong("dntr", -1L);
      localSharedPreferences.edit().putLong("uptr", l1).putLong("dntr", l3).commit();
      if ((l2 > 0L) && (l4 > 0L))
      {
        l3 -= l4;
        l1 -= l2;
        if ((l3 > 0L) && (l1 > 0L))
        {
          localn.i.a = l3;
          localn.i.b = l1;
        }
      }
    }
  }
  
  public String b(Context paramContext)
  {
    String str = av.c(paramContext);
    paramContext = a.a(paramContext);
    long l = System.currentTimeMillis();
    if (paramContext == null) {
      throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l).append(paramContext).append(str);
    c = aw.a(localStringBuilder.toString());
    return c;
  }
  
  public void c(Context paramContext)
  {
    d = paramContext;
    SharedPreferences localSharedPreferences = t.a(paramContext);
    if (localSharedPreferences == null) {
      return;
    }
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("versioncode", 0);
    int j = Integer.parseInt(av.a(d));
    if ((i != 0) && (j != i))
    {
      if (g(paramContext) == null) {
        a(paramContext, localSharedPreferences);
      }
      e(d);
      g.a(d).c();
      f(d);
      return;
    }
    if (b(localSharedPreferences))
    {
      paramContext = a(paramContext, localSharedPreferences);
      ax.b("Start new session: " + paramContext);
      return;
    }
    paramContext = localSharedPreferences.getString("session_id", null);
    localEditor.putLong("a_start_time", System.currentTimeMillis());
    localEditor.putLong("a_end_time", 0L);
    localEditor.commit();
    ax.b("Extend current session: " + paramContext);
  }
  
  public void d(Context paramContext)
  {
    paramContext = t.a(paramContext);
    if (paramContext == null) {
      return;
    }
    if ((paramContext.getLong("a_start_time", 0L) == 0L) && (a.e))
    {
      ax.d("onPause called before onResume");
      return;
    }
    long l = System.currentTimeMillis();
    paramContext = paramContext.edit();
    paramContext.putLong("a_start_time", 0L);
    paramContext.putLong("a_end_time", l);
    paramContext.putLong("session_end_time", l);
    paramContext.commit();
  }
  
  public boolean e(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject = t.a(paramContext);
    if (localObject == null) {}
    boolean bool1;
    do
    {
      do
      {
        return bool2;
      } while (((SharedPreferences)localObject).getString("session_id", null) == null);
      long l1 = ((SharedPreferences)localObject).getLong("a_start_time", 0L);
      long l2 = ((SharedPreferences)localObject).getLong("a_end_time", 0L);
      bool1 = bool3;
      if (l1 > 0L)
      {
        bool1 = bool3;
        if (l2 == 0L)
        {
          bool1 = true;
          d(paramContext);
        }
      }
      localObject = g.a(paramContext);
      paramContext = a(paramContext);
      bool2 = bool1;
    } while (paramContext == null);
    ((g)localObject).b(paramContext);
    return bool1;
  }
  
  public void f(Context paramContext)
  {
    Object localObject = t.a(paramContext);
    if (localObject == null) {
      return;
    }
    String str = b(paramContext);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("session_id", str);
    ((SharedPreferences.Editor)localObject).putLong("session_start_time", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).putLong("session_end_time", 0L);
    ((SharedPreferences.Editor)localObject).putLong("a_start_time", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).putLong("a_end_time", 0L);
    ((SharedPreferences.Editor)localObject).putInt("versioncode", Integer.parseInt(av.a(paramContext)));
    ((SharedPreferences.Editor)localObject).putString("versionname", av.b(paramContext));
    ((SharedPreferences.Editor)localObject).commit();
    ax.b("Restart session: " + str);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */