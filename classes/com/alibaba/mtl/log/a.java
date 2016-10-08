package com.alibaba.mtl.log;

import android.content.Context;
import com.alibaba.mtl.log.c.c;
import com.alibaba.mtl.log.e.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.sign.IRequestAuth;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  public static String G;
  public static IRequestAuth a;
  private static boolean a;
  public static long b;
  public static final AtomicInteger d;
  private static Context mContext;
  public static boolean o;
  public static boolean p;
  private static boolean q;
  public static boolean r;
  public static int s;
  public static int t;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    o = false;
    s = 10000;
    t = 0;
    b = -1L;
    p = false;
    if (t <= s) {}
    for (boolean bool = true;; bool = false)
    {
      q = bool;
      G = String.valueOf(System.currentTimeMillis());
      d = new AtomicInteger(0);
      r = true;
      jdField_a_of_type_ComAlibabaMtlLogSignIRequestAuth = null;
      return;
    }
  }
  
  public static IRequestAuth a()
  {
    return jdField_a_of_type_ComAlibabaMtlLogSignIRequestAuth;
  }
  
  public static void a(IRequestAuth paramIRequestAuth)
  {
    jdField_a_of_type_ComAlibabaMtlLogSignIRequestAuth = paramIRequestAuth;
    if (jdField_a_of_type_ComAlibabaMtlLogSignIRequestAuth != null) {
      b.r(jdField_a_of_type_ComAlibabaMtlLogSignIRequestAuth.getAppkey());
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    if (mContext == null)
    {
      i.a("UTDC", "please call UTDC.init(context) before commit log,and this log will be discarded");
      return;
    }
    if (jdField_a_of_type_ComAlibabaMtlLogSignIRequestAuth == null)
    {
      i.a("UTDC", "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
      return;
    }
    i.a("UTDC", new Object[] { "[commit] page:", paramString1, "eventId:", paramString2, "arg1:", paramString3, "arg2:", paramString4, "arg3:", paramString5, "args:", paramMap });
    com.alibaba.mtl.log.b.a.o(paramString2);
    paramString1 = new com.alibaba.mtl.log.model.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramMap);
    c.a().a(paramString1);
  }
  
  public static String b()
  {
    try
    {
      String str = l.getNetworkState(getContext())[0];
      return str;
    }
    catch (Exception localException) {}
    return "Unknown";
  }
  
  public static String c()
  {
    try
    {
      String[] arrayOfString = l.getNetworkState(getContext());
      if (arrayOfString[0].equals("2G/3G")) {
        return arrayOfString[1];
      }
      return "Unknown";
    }
    catch (Exception localException) {}
    return "Unknown";
  }
  
  public static String d()
  {
    return "";
  }
  
  public static String e()
  {
    return "";
  }
  
  public static Context getContext()
  {
    return mContext;
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        i.a("UTDC", "UTDC init failed ,context:" + paramContext);
        return;
      }
      finally {}
      if (!jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = true;
        mContext = paramContext.getApplicationContext();
        com.alibaba.mtl.log.d.a.a().start();
      }
    }
  }
  
  public static void l()
  {
    i.a("UTDC", new Object[] { "[onBackground]" });
    o = true;
    com.alibaba.mtl.log.b.a.C();
  }
  
  public static void m()
  {
    i.a("UTDC", new Object[] { "[onForeground]" });
    o = false;
    com.alibaba.mtl.log.d.a.a().start();
  }
  
  public static void n()
  {
    com.alibaba.mtl.log.d.a.a().start();
  }
  
  public static void setChannel(String paramString)
  {
    b.q(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */