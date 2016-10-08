package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.security.mobile.module.a.a;

public final class h
{
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 10
    //   6: iconst_0
    //   7: invokevirtual 16	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface 22 1 0
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull +26 -> 43
    //   20: aload_0
    //   21: ldc 24
    //   23: invokestatic 29	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   26: aload_1
    //   27: invokestatic 32	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: invokeinterface 38 3 0
    //   35: pop
    //   36: aload_0
    //   37: invokeinterface 42 1 0
    //   42: pop
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: astore_0
    //   54: goto -11 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   0	57	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	16	47	finally
    //   20	43	47	finally
    //   3	16	53	java/lang/Throwable
    //   20	43	53	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = com.alipay.security.mobile.module.c.c.a(paramContext, "vkeyid_settings", "log_switch", "");
      if (a.a(paramContext)) {
        return true;
      }
      paramContext = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), paramContext);
      if (!a.a(paramContext))
      {
        boolean bool = paramContext.equals("1");
        return bool;
      }
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  public static long b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("vkeyid_settings", 0).getString("vkey_valid", "");
      if (a.a(paramContext)) {
        return 0L;
      }
      paramContext = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), paramContext);
      if (!a.a(paramContext))
      {
        long l = Long.parseLong(paramContext);
        return l;
      }
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  /* Error */
  public static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 10
    //   6: iconst_0
    //   7: invokevirtual 16	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface 22 1 0
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull +26 -> 43
    //   20: aload_0
    //   21: ldc 83
    //   23: invokestatic 29	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   26: aload_1
    //   27: invokestatic 32	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: invokeinterface 38 3 0
    //   35: pop
    //   36: aload_0
    //   37: invokeinterface 42 1 0
    //   42: pop
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: astore_0
    //   54: goto -11 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   0	57	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	16	47	finally
    //   20	43	47	finally
    //   3	16	53	java/lang/Throwable
    //   20	43	53	java/lang/Throwable
  }
  
  public static String c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getSharedPreferences("vkeyid_settings", 0).getString("vkey_applist", "");
        if (!a.a(paramContext)) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        String str;
        paramContext = "";
        continue;
      }
      finally {}
      return paramContext;
      str = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), paramContext);
      paramContext = str;
      if (a.a(str)) {
        paramContext = "";
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getSharedPreferences("vkeyid_settings", 0).getString("vkey_applist_version", "");
        if (!a.a(paramContext)) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        String str;
        paramContext = "";
        continue;
      }
      finally {}
      return paramContext;
      str = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), paramContext);
      paramContext = str;
      if (a.a(str)) {
        paramContext = "";
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */