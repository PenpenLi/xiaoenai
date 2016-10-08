package com.inmobi.commons.a;

import android.content.Context;
import com.inmobi.commons.core.b.c;

public class b
{
  public static String a()
  {
    char[] arrayOfChar = c().toCharArray();
    String str = "";
    int i = 0;
    if (i < arrayOfChar.length)
    {
      if (arrayOfChar[i] == '.') {}
      for (str = str + "T";; str = str + (char)(arrayOfChar[i] - '0' + 65))
      {
        i += 1;
        break;
      }
    }
    return "pr-SAND-" + str + "-" + f();
  }
  
  public static String a(Context paramContext)
  {
    return c.a(paramContext, "sdk_version_store").b("sdk_version", null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    c.a(paramContext, "sdk_version_store").a("sdk_version", paramString);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    c.a(paramContext, "sdk_version_store").a("db_deletion_failed", paramBoolean);
  }
  
  public static int b()
  {
    return 14;
  }
  
  public static boolean b(Context paramContext)
  {
    return c.a(paramContext, "sdk_version_store").b("db_deletion_failed", false);
  }
  
  public static String c()
  {
    return "5.3.1";
  }
  
  public static String d()
  {
    return "2.0";
  }
  
  public static String e()
  {
    return "android";
  }
  
  public static String f()
  {
    return "20160516";
  }
  
  public static String g()
  {
    return "http://www.inmobi.com/products/sdk/#downloads";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */