package com.alipay.mobilesecuritysdk.face;

public class SecurityClientMobile
{
  /* Error */
  public static String GetApdid(android.content.Context paramContext, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 17	com/alipay/apmobilesecuritysdk/a/i:a	()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: invokestatic 22	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   11: istore 4
    //   13: iload 4
    //   15: ifne +8 -> 23
    //   18: ldc 2
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: aload_0
    //   24: invokestatic 27	com/alipay/apmobilesecuritysdk/a/d:a	(Landroid/content/Context;)Lcom/alipay/apmobilesecuritysdk/a/e;
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +21 -> 50
    //   32: aload_2
    //   33: invokevirtual 30	com/alipay/apmobilesecuritysdk/a/e:a	()Ljava/lang/String;
    //   36: invokestatic 22	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   39: ifne +11 -> 50
    //   42: aload_2
    //   43: invokevirtual 30	com/alipay/apmobilesecuritysdk/a/e:a	()Ljava/lang/String;
    //   46: astore_2
    //   47: goto -29 -> 18
    //   50: aload_0
    //   51: invokestatic 35	com/alipay/apmobilesecuritysdk/a/a/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: invokestatic 22	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   61: ifeq -43 -> 18
    //   64: new 37	java/util/HashMap
    //   67: dup
    //   68: invokespecial 38	java/util/HashMap:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: ldc 40
    //   75: aload_1
    //   76: ldc 40
    //   78: ldc 42
    //   80: invokestatic 45	com/alipay/security/mobile/module/a/a:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: invokeinterface 51 3 0
    //   88: pop
    //   89: aload_2
    //   90: ldc 53
    //   92: aload_1
    //   93: ldc 53
    //   95: ldc 42
    //   97: invokestatic 45	com/alipay/security/mobile/module/a/a:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: invokeinterface 51 3 0
    //   105: pop
    //   106: aload_2
    //   107: ldc 55
    //   109: aload_1
    //   110: ldc 55
    //   112: ldc 42
    //   114: invokestatic 45	com/alipay/security/mobile/module/a/a:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   117: invokeinterface 51 3 0
    //   122: pop
    //   123: aload_0
    //   124: invokestatic 61	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:getInstance	(Landroid/content/Context;)Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    //   127: iconst_0
    //   128: aload_2
    //   129: aconst_null
    //   130: invokevirtual 65	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:initToken	(ILjava/util/Map;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;)V
    //   133: aload_0
    //   134: invokestatic 68	com/alipay/apmobilesecuritysdk/e/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   137: astore_2
    //   138: goto -120 -> 18
    //   141: astore_0
    //   142: ldc 2
    //   144: monitorexit
    //   145: aload_0
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramContext	android.content.Context
    //   0	147	1	paramMap	java.util.Map<String, String>
    //   6	132	2	localObject	Object
    //   54	4	3	str	String
    //   11	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	13	141	finally
    //   23	28	141	finally
    //   32	47	141	finally
    //   50	55	141	finally
    //   57	138	141	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\mobilesecuritysdk\face\SecurityClientMobile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */