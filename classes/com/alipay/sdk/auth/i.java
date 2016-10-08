package com.alipay.sdk.auth;

import android.app.Activity;
import com.alipay.sdk.data.e;
import com.alipay.sdk.net.d;

final class i
  implements Runnable
{
  i(d paramd, Activity paramActivity, e parame, APAuthInfo paramAPAuthInfo) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 18	com/alipay/sdk/auth/i:a	Lcom/alipay/sdk/net/d;
    //   8: aload_0
    //   9: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   12: aload_0
    //   13: getfield 22	com/alipay/sdk/auth/i:c	Lcom/alipay/sdk/data/e;
    //   16: iconst_0
    //   17: invokevirtual 38	com/alipay/sdk/net/d:a	(Landroid/content/Context;Lcom/alipay/sdk/data/e;Z)Lcom/alipay/sdk/protocol/c;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   26: ifnull +13 -> 39
    //   29: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   32: invokevirtual 47	com/alipay/sdk/widget/a:c	()V
    //   35: invokestatic 49	com/alipay/sdk/auth/h:b	()Lcom/alipay/sdk/widget/a;
    //   38: pop
    //   39: aload_1
    //   40: ifnonnull +55 -> 95
    //   43: new 51	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   50: aload_0
    //   51: getfield 24	com/alipay/sdk/auth/i:d	Lcom/alipay/sdk/auth/APAuthInfo;
    //   54: invokevirtual 58	com/alipay/sdk/auth/APAuthInfo:getRedirectUri	()Ljava/lang/String;
    //   57: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 64
    //   62: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 70	com/alipay/sdk/auth/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: pop
    //   72: aload_0
    //   73: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   76: invokestatic 72	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   79: invokestatic 75	com/alipay/sdk/auth/h:a	(Landroid/app/Activity;Ljava/lang/String;)V
    //   82: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   85: ifnull +9 -> 94
    //   88: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   91: invokevirtual 47	com/alipay/sdk/widget/a:c	()V
    //   94: return
    //   95: aload_1
    //   96: getfield 80	com/alipay/sdk/protocol/c:c	Lorg/json/JSONObject;
    //   99: ldc 82
    //   101: invokevirtual 88	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   104: ldc 90
    //   106: invokestatic 95	com/alipay/sdk/protocol/b:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/alipay/sdk/protocol/b;
    //   109: invokestatic 100	com/alipay/sdk/protocol/a:a	(Lcom/alipay/sdk/protocol/b;)[Lcom/alipay/sdk/protocol/a;
    //   112: astore_1
    //   113: aload_1
    //   114: arraylength
    //   115: istore 4
    //   117: iload_3
    //   118: iload 4
    //   120: if_icmpge +27 -> 147
    //   123: aload_1
    //   124: iload_3
    //   125: aaload
    //   126: astore_2
    //   127: aload_2
    //   128: getstatic 103	com/alipay/sdk/protocol/a:a	Lcom/alipay/sdk/protocol/a;
    //   131: if_acmpne +77 -> 208
    //   134: aload_2
    //   135: invokevirtual 106	com/alipay/sdk/protocol/a:e	()Ljava/lang/String;
    //   138: invokestatic 111	com/alipay/sdk/util/a:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   141: iconst_0
    //   142: aaload
    //   143: invokestatic 70	com/alipay/sdk/auth/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   146: pop
    //   147: invokestatic 72	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   150: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +62 -> 215
    //   156: new 51	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   163: aload_0
    //   164: getfield 24	com/alipay/sdk/auth/i:d	Lcom/alipay/sdk/auth/APAuthInfo;
    //   167: invokevirtual 58	com/alipay/sdk/auth/APAuthInfo:getRedirectUri	()Ljava/lang/String;
    //   170: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 64
    //   175: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 70	com/alipay/sdk/auth/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   184: pop
    //   185: aload_0
    //   186: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   189: invokestatic 72	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   192: invokestatic 75	com/alipay/sdk/auth/h:a	(Landroid/app/Activity;Ljava/lang/String;)V
    //   195: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   198: ifnull -104 -> 94
    //   201: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   204: invokevirtual 47	com/alipay/sdk/widget/a:c	()V
    //   207: return
    //   208: iload_3
    //   209: iconst_1
    //   210: iadd
    //   211: istore_3
    //   212: goto -95 -> 117
    //   215: new 119	android/content/Intent
    //   218: dup
    //   219: aload_0
    //   220: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   223: ldc 121
    //   225: invokespecial 124	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   228: astore_1
    //   229: aload_1
    //   230: ldc 126
    //   232: invokestatic 72	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   235: invokevirtual 130	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_1
    //   240: ldc -124
    //   242: aload_0
    //   243: getfield 24	com/alipay/sdk/auth/i:d	Lcom/alipay/sdk/auth/APAuthInfo;
    //   246: invokevirtual 58	com/alipay/sdk/auth/APAuthInfo:getRedirectUri	()Ljava/lang/String;
    //   249: invokevirtual 130	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   252: pop
    //   253: aload_0
    //   254: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   257: aload_1
    //   258: invokevirtual 138	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   261: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   264: ifnull -170 -> 94
    //   267: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   270: invokevirtual 47	com/alipay/sdk/widget/a:c	()V
    //   273: return
    //   274: astore_1
    //   275: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   278: ifnull -184 -> 94
    //   281: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   284: invokevirtual 47	com/alipay/sdk/widget/a:c	()V
    //   287: return
    //   288: astore_1
    //   289: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   292: ifnull +9 -> 301
    //   295: invokestatic 43	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   298: invokevirtual 47	com/alipay/sdk/widget/a:c	()V
    //   301: aload_1
    //   302: athrow
    //   303: astore_2
    //   304: goto -281 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	i
    //   3	255	1	localObject1	Object
    //   274	1	1	localException	Exception
    //   288	14	1	localObject2	Object
    //   20	115	2	localc	com.alipay.sdk.protocol.c
    //   303	1	2	localNetErrorException	com.alipay.sdk.exception.NetErrorException
    //   1	211	3	i	int
    //   115	6	4	j	int
    // Exception table:
    //   from	to	target	type
    //   4	21	274	java/lang/Exception
    //   23	39	274	java/lang/Exception
    //   43	82	274	java/lang/Exception
    //   95	117	274	java/lang/Exception
    //   127	147	274	java/lang/Exception
    //   147	195	274	java/lang/Exception
    //   215	261	274	java/lang/Exception
    //   4	21	288	finally
    //   23	39	288	finally
    //   43	82	288	finally
    //   95	117	288	finally
    //   127	147	288	finally
    //   147	195	288	finally
    //   215	261	288	finally
    //   4	21	303	com/alipay/sdk/exception/NetErrorException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\auth\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */