package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import com.alipay.security.mobile.module.a.c;

public final class i
{
  private static String a = "";
  private static String b = "";
  
  public static String a()
  {
    return a;
  }
  
  public static void a(e parame)
  {
    a = parame.a();
    b = parame.c();
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      long l = Math.abs(System.currentTimeMillis() - h.b(paramContext));
      if (l < 86400000L) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      c.a(paramContext);
    }
    return false;
  }
  
  public static String b()
  {
    return b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */