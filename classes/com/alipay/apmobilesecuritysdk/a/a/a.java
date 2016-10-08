package com.alipay.apmobilesecuritysdk.a.a;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

public final class a
{
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 9	com/alipay/apmobilesecuritysdk/a/a/a:b	()Ljava/lang/String;
    //   8: astore_0
    //   9: aload_0
    //   10: invokestatic 14	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +10 -> 25
    //   18: aload_1
    //   19: astore_0
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: ldc 16
    //   28: invokevirtual 22	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: aload_2
    //   35: ifnull -15 -> 20
    //   38: aload_1
    //   39: astore_0
    //   40: aload_2
    //   41: arraylength
    //   42: iconst_2
    //   43: if_icmplt -23 -> 20
    //   46: aload_2
    //   47: iconst_0
    //   48: aaload
    //   49: astore_0
    //   50: goto -30 -> 20
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	42	0	localObject1	Object
    //   53	5	0	localObject2	Object
    //   1	38	1	localObject3	Object
    //   31	16	2	arrayOfString	String[]
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	14	53	finally
    //   25	32	53	finally
    //   40	46	53	finally
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str2 = a();
      String str1 = str2;
      if (com.alipay.security.mobile.module.a.a.a(str2)) {
        str1 = b(paramContext);
      }
      return str1;
    }
    finally {}
  }
  
  /* Error */
  public static void a(com.alipay.apmobilesecuritysdk.a.e parame)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 34	com/alipay/apmobilesecuritysdk/a/e:a	()Ljava/lang/String;
    //   7: invokestatic 14	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: invokevirtual 34	com/alipay/apmobilesecuritysdk/a/e:a	()Ljava/lang/String;
    //   23: invokestatic 26	com/alipay/apmobilesecuritysdk/a/a/a:a	()Ljava/lang/String;
    //   26: invokevirtual 38	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifne -14 -> 15
    //   32: new 40	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   39: aload_0
    //   40: invokevirtual 34	com/alipay/apmobilesecuritysdk/a/e:a	()Ljava/lang/String;
    //   43: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 16
    //   48: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: invokevirtual 51	com/alipay/apmobilesecuritysdk/a/e:d	()Ljava/lang/String;
    //   55: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull -48 -> 15
    //   66: invokestatic 57	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   69: aload_0
    //   70: invokestatic 60	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_0
    //   74: new 62	org/json/JSONObject
    //   77: dup
    //   78: invokespecial 63	org/json/JSONObject:<init>	()V
    //   81: astore_1
    //   82: aload_1
    //   83: ldc 65
    //   85: aload_0
    //   86: invokevirtual 69	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: ldc 71
    //   92: aload_1
    //   93: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
    //   96: invokestatic 77	com/alipay/security/mobile/module/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: goto -84 -> 15
    //   102: astore_0
    //   103: goto -88 -> 15
    //   106: astore_0
    //   107: ldc 2
    //   109: monitorexit
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	parame	com.alipay.apmobilesecuritysdk.a.e
    //   81	12	1	localJSONObject	JSONObject
    //   10	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   66	99	102	java/lang/Exception
    //   3	11	106	finally
    //   19	62	106	finally
    //   66	99	106	finally
  }
  
  private static String b()
  {
    String str = com.alipay.security.mobile.module.c.a.a("deviceid_v2");
    try
    {
      str = new JSONObject(str).getString("device");
      str = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String b(Context paramContext)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        paramContext = com.alipay.security.mobile.module.c.c.a(paramContext, "profiles", "deviceid", "");
        if (!com.alipay.security.mobile.module.a.a.a(paramContext)) {
          continue;
        }
        paramContext = null;
        boolean bool = com.alipay.security.mobile.module.a.a.a(paramContext);
        if (!bool) {
          continue;
        }
        paramContext = (Context)localObject;
      }
      catch (Throwable paramContext)
      {
        paramContext = "";
        continue;
      }
      finally {}
      return paramContext;
      paramContext = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), paramContext);
      continue;
      new b();
      paramContext = b.a(paramContext);
      if (paramContext == null) {
        continue;
      }
      paramContext = (String)paramContext.get("deviceId");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */