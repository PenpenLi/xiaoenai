package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.data.e;
import com.alipay.sdk.protocol.c;
import com.alipay.sdk.util.h;
import org.json.JSONObject;

public class PayTask
{
  static final Object a = h.class;
  private Activity b;
  private com.alipay.sdk.widget.a c = null;
  
  public PayTask(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  private String a(com.alipay.sdk.protocol.a arg1)
  {
    ??? = com.alipay.sdk.util.a.a(???.e());
    Object localObject1 = new Intent(this.b, H5PayActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("url", ???[0]);
    if (???.length == 2) {
      localBundle.putString("cookie", ???[1]);
    }
    ((Intent)localObject1).putExtras(localBundle);
    this.b.startActivity((Intent)localObject1);
    synchronized (a)
    {
      try
      {
        a.wait();
        localObject1 = l.a;
        ??? = (com.alipay.sdk.protocol.a)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          ??? = l.a();
        }
        return (String)???;
      }
      catch (InterruptedException localInterruptedException)
      {
        String str = l.a();
        return str;
      }
    }
  }
  
  private String a(String paramString)
  {
    return new h(this.b).a(paramString);
  }
  
  private String b(String paramString)
  {
    try
    {
      if ((this.b != null) && (!this.b.isFinishing()))
      {
        this.c = new com.alipay.sdk.widget.a(this.b);
        this.c.b();
        com.alipay.sdk.sys.b.a().a(this.b, com.alipay.sdk.data.d.a());
      }
      return c(paramString);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.c = null;
      }
    }
  }
  
  /* Error */
  private String c(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: new 118	com/alipay/sdk/data/c
    //   6: dup
    //   7: invokespecial 119	com/alipay/sdk/data/c:<init>	()V
    //   10: aload_1
    //   11: new 121	org/json/JSONObject
    //   14: dup
    //   15: invokespecial 122	org/json/JSONObject:<init>	()V
    //   18: invokestatic 127	com/alipay/sdk/data/b:a	(Lcom/alipay/sdk/data/c;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/alipay/sdk/data/e;
    //   21: astore_1
    //   22: new 129	com/alipay/sdk/net/d
    //   25: dup
    //   26: new 118	com/alipay/sdk/data/c
    //   29: dup
    //   30: invokespecial 119	com/alipay/sdk/data/c:<init>	()V
    //   33: invokespecial 132	com/alipay/sdk/net/d:<init>	(Lcom/alipay/sdk/data/c;)V
    //   36: astore_2
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 25	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   42: aload_1
    //   43: iconst_0
    //   44: invokevirtual 135	com/alipay/sdk/net/d:a	(Landroid/content/Context;Lcom/alipay/sdk/data/e;Z)Lcom/alipay/sdk/protocol/c;
    //   47: getfield 140	com/alipay/sdk/protocol/c:c	Lorg/json/JSONObject;
    //   50: ldc -114
    //   52: invokevirtual 146	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   55: ldc -108
    //   57: invokestatic 153	com/alipay/sdk/protocol/b:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/alipay/sdk/protocol/b;
    //   60: invokestatic 156	com/alipay/sdk/protocol/a:a	(Lcom/alipay/sdk/protocol/b;)[Lcom/alipay/sdk/protocol/a;
    //   63: astore_1
    //   64: aload_1
    //   65: arraylength
    //   66: istore 7
    //   68: iconst_0
    //   69: istore 5
    //   71: iload 5
    //   73: iload 7
    //   75: if_icmpge +246 -> 321
    //   78: aload_1
    //   79: iload 5
    //   81: aaload
    //   82: astore_2
    //   83: aload_2
    //   84: getstatic 160	com/alipay/sdk/protocol/a:f	Lcom/alipay/sdk/protocol/a;
    //   87: if_acmpne +332 -> 419
    //   90: aload_2
    //   91: invokevirtual 34	com/alipay/sdk/protocol/a:e	()Ljava/lang/String;
    //   94: invokestatic 39	com/alipay/sdk/util/a:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   97: astore_2
    //   98: aload_2
    //   99: arraylength
    //   100: iconst_3
    //   101: if_icmpne +318 -> 419
    //   104: ldc -94
    //   106: aload_2
    //   107: iconst_0
    //   108: aaload
    //   109: invokestatic 166	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   112: ifeq +307 -> 419
    //   115: invokestatic 104	com/alipay/sdk/sys/b:a	()Lcom/alipay/sdk/sys/b;
    //   118: getfield 169	com/alipay/sdk/sys/b:a	Landroid/content/Context;
    //   121: astore_3
    //   122: invokestatic 174	com/alipay/sdk/tid/b:a	()Lcom/alipay/sdk/tid/b;
    //   125: astore 4
    //   127: aload_2
    //   128: iconst_1
    //   129: aaload
    //   130: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +286 -> 419
    //   136: aload_2
    //   137: iconst_2
    //   138: aaload
    //   139: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifeq +6 -> 148
    //   145: goto +274 -> 419
    //   148: aload 4
    //   150: aload_2
    //   151: iconst_1
    //   152: aaload
    //   153: putfield 175	com/alipay/sdk/tid/b:a	Ljava/lang/String;
    //   156: aload 4
    //   158: aload_2
    //   159: iconst_2
    //   160: aaload
    //   161: putfield 177	com/alipay/sdk/tid/b:b	Ljava/lang/String;
    //   164: new 179	com/alipay/sdk/tid/a
    //   167: dup
    //   168: aload_3
    //   169: invokespecial 182	com/alipay/sdk/tid/a:<init>	(Landroid/content/Context;)V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_3
    //   175: invokestatic 187	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   178: invokevirtual 188	com/alipay/sdk/util/b:a	()Ljava/lang/String;
    //   181: aload_3
    //   182: invokestatic 187	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   185: invokevirtual 190	com/alipay/sdk/util/b:b	()Ljava/lang/String;
    //   188: aload 4
    //   190: getfield 175	com/alipay/sdk/tid/b:a	Ljava/lang/String;
    //   193: aload 4
    //   195: getfield 177	com/alipay/sdk/tid/b:b	Ljava/lang/String;
    //   198: invokevirtual 193	com/alipay/sdk/tid/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_2
    //   202: invokevirtual 196	com/alipay/sdk/tid/a:close	()V
    //   205: goto +214 -> 419
    //   208: astore_1
    //   209: getstatic 202	com/alipay/sdk/app/m:d	Lcom/alipay/sdk/app/m;
    //   212: invokevirtual 205	com/alipay/sdk/app/m:a	()I
    //   215: invokestatic 208	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   218: astore_2
    //   219: aload_2
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   225: ifnull +12 -> 237
    //   228: aload_0
    //   229: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   232: invokevirtual 210	com/alipay/sdk/widget/a:c	()V
    //   235: aload_2
    //   236: astore_1
    //   237: aload_1
    //   238: astore_2
    //   239: aload_1
    //   240: ifnonnull +13 -> 253
    //   243: getstatic 212	com/alipay/sdk/app/m:b	Lcom/alipay/sdk/app/m;
    //   246: invokevirtual 205	com/alipay/sdk/app/m:a	()I
    //   249: invokestatic 208	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   252: astore_2
    //   253: aload_2
    //   254: invokevirtual 205	com/alipay/sdk/app/m:a	()I
    //   257: aload_2
    //   258: invokevirtual 213	com/alipay/sdk/app/m:b	()Ljava/lang/String;
    //   261: ldc -41
    //   263: invokestatic 218	com/alipay/sdk/app/l:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   266: astore_1
    //   267: aload_1
    //   268: areturn
    //   269: astore_3
    //   270: aload_2
    //   271: invokevirtual 196	com/alipay/sdk/tid/a:close	()V
    //   274: goto +145 -> 419
    //   277: astore_1
    //   278: aload_0
    //   279: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   282: ifnull +132 -> 414
    //   285: aload_0
    //   286: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   289: invokevirtual 210	com/alipay/sdk/widget/a:c	()V
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -57 -> 237
    //   297: astore_1
    //   298: aload_2
    //   299: invokevirtual 196	com/alipay/sdk/tid/a:close	()V
    //   302: aload_1
    //   303: athrow
    //   304: astore_1
    //   305: aload_0
    //   306: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   309: ifnull +10 -> 319
    //   312: aload_0
    //   313: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   316: invokevirtual 210	com/alipay/sdk/widget/a:c	()V
    //   319: aload_1
    //   320: athrow
    //   321: aload_0
    //   322: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   325: ifnull +10 -> 335
    //   328: aload_0
    //   329: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   332: invokevirtual 210	com/alipay/sdk/widget/a:c	()V
    //   335: aload_1
    //   336: arraylength
    //   337: istore 7
    //   339: iload 6
    //   341: istore 5
    //   343: iload 5
    //   345: iload 7
    //   347: if_icmpge +48 -> 395
    //   350: aload_1
    //   351: iload 5
    //   353: aaload
    //   354: astore_2
    //   355: aload_2
    //   356: getstatic 220	com/alipay/sdk/protocol/a:a	Lcom/alipay/sdk/protocol/a;
    //   359: if_acmpne +27 -> 386
    //   362: aload_0
    //   363: aload_2
    //   364: invokespecial 222	com/alipay/sdk/app/PayTask:a	(Lcom/alipay/sdk/protocol/a;)Ljava/lang/String;
    //   367: astore_2
    //   368: aload_2
    //   369: astore_1
    //   370: aload_0
    //   371: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   374: ifnull -107 -> 267
    //   377: aload_0
    //   378: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   381: invokevirtual 210	com/alipay/sdk/widget/a:c	()V
    //   384: aload_2
    //   385: areturn
    //   386: iload 5
    //   388: iconst_1
    //   389: iadd
    //   390: istore 5
    //   392: goto -49 -> 343
    //   395: aload_0
    //   396: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   399: ifnull +15 -> 414
    //   402: aload_0
    //   403: getfield 23	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   406: invokevirtual 210	com/alipay/sdk/widget/a:c	()V
    //   409: aconst_null
    //   410: astore_1
    //   411: goto -174 -> 237
    //   414: aconst_null
    //   415: astore_1
    //   416: goto -179 -> 237
    //   419: iload 5
    //   421: iconst_1
    //   422: iadd
    //   423: istore 5
    //   425: goto -354 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	PayTask
    //   0	428	1	paramString	String
    //   36	349	2	localObject	Object
    //   121	61	3	localContext	android.content.Context
    //   269	1	3	localException	Exception
    //   125	69	4	localb	com.alipay.sdk.tid.b
    //   69	355	5	i	int
    //   1	339	6	j	int
    //   66	282	7	k	int
    // Exception table:
    //   from	to	target	type
    //   37	68	208	com/alipay/sdk/exception/NetErrorException
    //   83	145	208	com/alipay/sdk/exception/NetErrorException
    //   148	173	208	com/alipay/sdk/exception/NetErrorException
    //   201	205	208	com/alipay/sdk/exception/NetErrorException
    //   270	274	208	com/alipay/sdk/exception/NetErrorException
    //   298	304	208	com/alipay/sdk/exception/NetErrorException
    //   321	335	208	com/alipay/sdk/exception/NetErrorException
    //   335	339	208	com/alipay/sdk/exception/NetErrorException
    //   355	368	208	com/alipay/sdk/exception/NetErrorException
    //   173	201	269	java/lang/Exception
    //   37	68	277	java/lang/Exception
    //   83	145	277	java/lang/Exception
    //   148	173	277	java/lang/Exception
    //   201	205	277	java/lang/Exception
    //   270	274	277	java/lang/Exception
    //   298	304	277	java/lang/Exception
    //   321	335	277	java/lang/Exception
    //   335	339	277	java/lang/Exception
    //   355	368	277	java/lang/Exception
    //   173	201	297	finally
    //   37	68	304	finally
    //   83	145	304	finally
    //   148	173	304	finally
    //   201	205	304	finally
    //   209	219	304	finally
    //   270	274	304	finally
    //   298	304	304	finally
    //   321	335	304	finally
    //   335	339	304	finally
    //   355	368	304	finally
  }
  
  public boolean checkAccountIfExist()
  {
    e locale = com.alipay.sdk.data.b.a();
    try
    {
      boolean bool = new com.alipay.sdk.net.d().a(this.b, locale, true).c.optBoolean("hasAccount", false);
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public String getVersion()
  {
    return "15.0.0";
  }
  
  /* Error */
  public String pay(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: astore_2
    //   4: aload_1
    //   5: ldc -17
    //   7: invokevirtual 244	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10: ifne +56 -> 66
    //   13: new 246	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc -3
    //   30: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: new 255	com/alipay/sdk/sys/a
    //   38: dup
    //   39: aload_0
    //   40: getfield 25	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   43: invokespecial 256	com/alipay/sdk/sys/a:<init>	(Landroid/content/Context;)V
    //   46: invokevirtual 259	com/alipay/sdk/sys/a:toString	()Ljava/lang/String;
    //   49: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_2
    //   54: ldc_w 261
    //   57: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_2
    //   62: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_2
    //   66: aload_2
    //   67: ldc_w 264
    //   70: invokevirtual 244	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifeq +13 -> 86
    //   76: aload_0
    //   77: aload_2
    //   78: invokespecial 266	com/alipay/sdk/app/PayTask:b	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: areturn
    //   86: aload_0
    //   87: getfield 25	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   90: invokestatic 271	com/alipay/sdk/util/k:b	(Landroid/content/Context;)Z
    //   93: ifeq +54 -> 147
    //   96: new 14	com/alipay/sdk/util/h
    //   99: dup
    //   100: aload_0
    //   101: getfield 25	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   104: invokespecial 86	com/alipay/sdk/util/h:<init>	(Landroid/app/Activity;)V
    //   107: aload_2
    //   108: invokevirtual 88	com/alipay/sdk/util/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore_3
    //   112: aload_3
    //   113: ldc_w 273
    //   116: invokestatic 166	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   119: ifeq +12 -> 131
    //   122: aload_0
    //   123: aload_2
    //   124: invokespecial 266	com/alipay/sdk/app/PayTask:b	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore_1
    //   128: goto -46 -> 82
    //   131: aload_3
    //   132: astore_1
    //   133: aload_3
    //   134: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifeq -55 -> 82
    //   140: invokestatic 83	com/alipay/sdk/app/l:a	()Ljava/lang/String;
    //   143: astore_1
    //   144: goto -62 -> 82
    //   147: aload_0
    //   148: aload_2
    //   149: invokespecial 266	com/alipay/sdk/app/PayTask:b	(Ljava/lang/String;)Ljava/lang/String;
    //   152: astore_1
    //   153: goto -71 -> 82
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	PayTask
    //   0	161	1	paramString	String
    //   3	146	2	localObject	Object
    //   111	23	3	str	String
    // Exception table:
    //   from	to	target	type
    //   4	66	156	finally
    //   66	82	156	finally
    //   86	128	156	finally
    //   133	144	156	finally
    //   147	153	156	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\PayTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */