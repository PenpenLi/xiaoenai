package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import org.json.JSONObject;

public final class d
{
  /* Error */
  public static e a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 12	com/alipay/apmobilesecuritysdk/a/d:b	()Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   13: istore_2
    //   14: iload_2
    //   15: ifeq +8 -> 23
    //   18: ldc 2
    //   20: monitorexit
    //   21: aload_0
    //   22: areturn
    //   23: new 19	org/json/JSONObject
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 23	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: new 25	com/alipay/apmobilesecuritysdk/a/e
    //   35: dup
    //   36: aload_1
    //   37: ldc 27
    //   39: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: aload_1
    //   43: ldc 33
    //   45: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: aload_1
    //   49: ldc 35
    //   51: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: aload_1
    //   55: ldc 37
    //   57: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokespecial 40	com/alipay/apmobilesecuritysdk/a/e:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: goto -48 -> 18
    //   69: astore_1
    //   70: aload_1
    //   71: invokestatic 45	com/alipay/security/mobile/module/a/c:a	(Ljava/lang/Throwable;)V
    //   74: goto -56 -> 18
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	65	0	localObject1	Object
    //   77	5	0	localObject2	Object
    //   8	57	1	localObject3	Object
    //   69	2	1	localException	Exception
    //   13	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   23	64	69	java/lang/Exception
    //   5	14	77	finally
    //   23	64	77	finally
    //   70	74	77	finally
  }
  
  /* Error */
  public static e a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 51	com/alipay/apmobilesecuritysdk/a/d:c	(Landroid/content/Context;)Ljava/lang/String;
    //   9: astore_2
    //   10: aload_2
    //   11: astore_0
    //   12: aload_2
    //   13: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   16: ifeq +7 -> 23
    //   19: invokestatic 12	com/alipay/apmobilesecuritysdk/a/d:b	()Ljava/lang/String;
    //   22: astore_0
    //   23: aload_0
    //   24: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   27: istore_3
    //   28: iload_3
    //   29: ifeq +10 -> 39
    //   32: aload_1
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: new 19	org/json/JSONObject
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 23	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   47: astore_0
    //   48: new 25	com/alipay/apmobilesecuritysdk/a/e
    //   51: dup
    //   52: aload_0
    //   53: ldc 27
    //   55: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: aload_0
    //   59: ldc 33
    //   61: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   64: aload_0
    //   65: ldc 35
    //   67: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: aload_0
    //   71: ldc 37
    //   73: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokespecial 40	com/alipay/apmobilesecuritysdk/a/e:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   79: astore_0
    //   80: goto -46 -> 34
    //   83: astore_0
    //   84: aload_0
    //   85: invokestatic 45	com/alipay/security/mobile/module/a/c:a	(Ljava/lang/Throwable;)V
    //   88: aload_1
    //   89: astore_0
    //   90: goto -56 -> 34
    //   93: astore_0
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	Context
    //   1	88	1	localObject	Object
    //   9	4	2	str	String
    //   27	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	80	83	java/lang/Exception
    //   5	10	93	finally
    //   12	23	93	finally
    //   23	28	93	finally
    //   39	80	93	finally
    //   84	88	93	finally
  }
  
  /* Error */
  public static void a(Context paramContext, e parame)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 19	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 57	org/json/JSONObject:<init>	()V
    //   10: astore_2
    //   11: aload_2
    //   12: ldc 27
    //   14: aload_1
    //   15: invokevirtual 59	com/alipay/apmobilesecuritysdk/a/e:a	()Ljava/lang/String;
    //   18: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload_2
    //   23: ldc 33
    //   25: aload_1
    //   26: invokevirtual 64	com/alipay/apmobilesecuritysdk/a/e:b	()Ljava/lang/String;
    //   29: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   32: pop
    //   33: aload_2
    //   34: ldc 35
    //   36: aload_1
    //   37: invokevirtual 66	com/alipay/apmobilesecuritysdk/a/e:c	()Ljava/lang/String;
    //   40: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_2
    //   45: ldc 37
    //   47: aload_1
    //   48: invokevirtual 69	com/alipay/apmobilesecuritysdk/a/e:d	()Ljava/lang/String;
    //   51: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
    //   59: astore_1
    //   60: invokestatic 75	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   63: aload_1
    //   64: invokestatic 78	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   67: astore_2
    //   68: aload_2
    //   69: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   72: ifne +28 -> 100
    //   75: new 80	java/util/HashMap
    //   78: dup
    //   79: invokespecial 81	java/util/HashMap:<init>	()V
    //   82: astore_3
    //   83: aload_3
    //   84: ldc 83
    //   86: aload_2
    //   87: invokeinterface 88 3 0
    //   92: pop
    //   93: aload_0
    //   94: ldc 90
    //   96: aload_3
    //   97: invokestatic 95	com/alipay/security/mobile/module/c/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    //   100: aload_1
    //   101: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   104: istore 4
    //   106: iload 4
    //   108: ifne +36 -> 144
    //   111: invokestatic 75	com/alipay/security/mobile/module/a/a/c:a	()Ljava/lang/String;
    //   114: aload_1
    //   115: invokestatic 78	com/alipay/security/mobile/module/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_0
    //   119: new 19	org/json/JSONObject
    //   122: dup
    //   123: invokespecial 57	org/json/JSONObject:<init>	()V
    //   126: astore_1
    //   127: aload_1
    //   128: ldc 97
    //   130: aload_0
    //   131: invokevirtual 63	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   134: pop
    //   135: ldc 99
    //   137: aload_1
    //   138: invokevirtual 72	org/json/JSONObject:toString	()Ljava/lang/String;
    //   141: invokestatic 104	com/alipay/security/mobile/module/c/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: ldc 2
    //   146: monitorexit
    //   147: return
    //   148: astore_0
    //   149: aload_0
    //   150: invokestatic 45	com/alipay/security/mobile/module/a/c:a	(Ljava/lang/Throwable;)V
    //   153: goto -9 -> 144
    //   156: astore_0
    //   157: ldc 2
    //   159: monitorexit
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -19 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramContext	Context
    //   0	166	1	parame	e
    //   10	77	2	localObject	Object
    //   82	15	3	localHashMap	java.util.HashMap
    //   104	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	100	148	org/json/JSONException
    //   100	106	148	org/json/JSONException
    //   111	144	148	org/json/JSONException
    //   3	100	156	finally
    //   100	106	156	finally
    //   111	144	156	finally
    //   149	153	156	finally
    //   111	144	162	java/lang/Exception
  }
  
  /* Error */
  public static e b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 51	com/alipay/apmobilesecuritysdk/a/d:c	(Landroid/content/Context;)Ljava/lang/String;
    //   9: astore_0
    //   10: aload_0
    //   11: invokestatic 17	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   14: istore_2
    //   15: iload_2
    //   16: ifeq +10 -> 26
    //   19: aload_1
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: new 19	org/json/JSONObject
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 23	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   34: astore_0
    //   35: new 25	com/alipay/apmobilesecuritysdk/a/e
    //   38: dup
    //   39: aload_0
    //   40: ldc 27
    //   42: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: aload_0
    //   46: ldc 33
    //   48: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: aload_0
    //   52: ldc 35
    //   54: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: aload_0
    //   58: ldc 37
    //   60: invokevirtual 31	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokespecial 40	com/alipay/apmobilesecuritysdk/a/e:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   66: astore_0
    //   67: goto -46 -> 21
    //   70: astore_0
    //   71: aload_0
    //   72: invokestatic 45	com/alipay/security/mobile/module/a/c:a	(Ljava/lang/Throwable;)V
    //   75: aload_1
    //   76: astore_0
    //   77: goto -56 -> 21
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramContext	Context
    //   1	75	1	localObject	Object
    //   14	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   26	67	70	java/lang/Exception
    //   5	15	80	finally
    //   26	67	80	finally
    //   71	75	80	finally
  }
  
  private static String b()
  {
    String str = com.alipay.security.mobile.module.c.a.a("wxcasxx_v3");
    try
    {
      str = new JSONObject(str).getString("wxcasxx");
      str = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), str);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static String c(Context paramContext)
  {
    paramContext = com.alipay.security.mobile.module.c.c.a(paramContext, "vkeyid_profiles_v3", "deviceid", "");
    if (com.alipay.security.mobile.module.a.a.a(paramContext)) {
      return null;
    }
    return com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), paramContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */