package com.f.a;

import android.content.Context;
import android.text.TextUtils;
import d.a.av;
import d.a.ax;

public class a
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static long i;
  public static boolean j = false;
  public static int k;
  static double[] l;
  private static String m = null;
  private static String n = null;
  private static String o = null;
  private static int p;
  
  static
  {
    a = null;
    b = null;
    p = 0;
    c = "";
    d = "";
    e = true;
    f = true;
    g = true;
    h = true;
    i = 30000L;
    j = false;
    l = null;
  }
  
  public static String a(Context paramContext)
  {
    if (TextUtils.isEmpty(m))
    {
      m = av.n(paramContext);
      if (TextUtils.isEmpty(m)) {
        m = o.a(paramContext).b();
      }
    }
    return m;
  }
  
  static void a(Context paramContext, int paramInt)
  {
    p = paramInt;
    o.a(paramContext).a(p);
  }
  
  static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      m = paramString;
    }
    do
    {
      return;
      str = av.n(paramContext);
      if (TextUtils.isEmpty(str)) {
        break;
      }
      m = str;
    } while (str.equals(paramString));
    ax.c("Appkey和AndroidManifest.xml中配置的不一致 ");
    return;
    String str = o.a(paramContext).b();
    if (!TextUtils.isEmpty(str)) {
      if (!str.equals(paramString))
      {
        ax.c("Appkey和上次配置的不一致 ");
        o.a(paramContext).a(paramString);
      }
    }
    for (;;)
    {
      m = paramString;
      return;
      o.a(paramContext).a(paramString);
    }
  }
  
  static void a(String paramString)
  {
    n = paramString;
  }
  
  static void a(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public static double[] a()
  {
    return l;
  }
  
  public static String b(Context paramContext)
  {
    if (TextUtils.isEmpty(n)) {
      n = av.q(paramContext);
    }
    return n;
  }
  
  public static String c(Context paramContext)
  {
    if (TextUtils.isEmpty(o)) {
      o = o.a(paramContext).c();
    }
    return o;
  }
  
  public static int d(Context paramContext)
  {
    if (p == 0) {
      p = o.a(paramContext).d();
    }
    return p;
  }
  
  public static String e(Context paramContext)
  {
    return "6.0.1";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */