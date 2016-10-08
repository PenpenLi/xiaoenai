package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.util.h;

public class AuthTask
{
  static final Object a = h.class;
  private static final int b = 73;
  private Activity c;
  
  public AuthTask(Activity paramActivity)
  {
    this.c = paramActivity;
  }
  
  private String a(Activity paramActivity, String paramString)
  {
    if (a(paramActivity))
    {
      String str = new h(paramActivity).a(paramString);
      if (TextUtils.equals(str, "failed")) {
        paramActivity = b(paramActivity, paramString);
      }
      do
      {
        return paramActivity;
        paramActivity = str;
      } while (!TextUtils.isEmpty(str));
      return l.a();
    }
    return b(paramActivity, paramString);
  }
  
  private String a(com.alipay.sdk.protocol.a arg1)
  {
    Object localObject1 = com.alipay.sdk.util.a.a(???.e());
    ??? = new Bundle();
    ???.putString("url", localObject1[0]);
    localObject1 = new Intent(this.c, H5AuthActivity.class);
    ((Intent)localObject1).putExtras(???);
    this.c.startActivity((Intent)localObject1);
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
  
  private static boolean a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.versionCode;
      if (i >= 73) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  /* Error */
  private String b(Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnull +348 -> 352
    //   7: aload_1
    //   8: invokevirtual 126	android/app/Activity:isFinishing	()Z
    //   11: ifne +341 -> 352
    //   14: new 128	com/alipay/sdk/widget/a
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 129	com/alipay/sdk/widget/a:<init>	(Landroid/app/Activity;)V
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 131	com/alipay/sdk/widget/a:b	()V
    //   27: invokestatic 136	com/alipay/sdk/sys/b:a	()Lcom/alipay/sdk/sys/b;
    //   30: aload_0
    //   31: getfield 24	com/alipay/sdk/app/AuthTask:c	Landroid/app/Activity;
    //   34: invokestatic 141	com/alipay/sdk/data/d:a	()Lcom/alipay/sdk/data/d;
    //   37: invokevirtual 144	com/alipay/sdk/sys/b:a	(Landroid/content/Context;Lcom/alipay/sdk/data/d;)V
    //   40: new 146	com/alipay/sdk/data/c
    //   43: dup
    //   44: invokespecial 147	com/alipay/sdk/data/c:<init>	()V
    //   47: aload_2
    //   48: invokevirtual 152	java/lang/String:toString	()Ljava/lang/String;
    //   51: new 154	org/json/JSONObject
    //   54: dup
    //   55: invokespecial 155	org/json/JSONObject:<init>	()V
    //   58: invokestatic 160	com/alipay/sdk/data/b:a	(Lcom/alipay/sdk/data/c;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/alipay/sdk/data/e;
    //   61: astore 6
    //   63: aload 6
    //   65: getfield 165	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   68: ldc -89
    //   70: putfield 171	com/alipay/sdk/data/a:b	Ljava/lang/String;
    //   73: aload 6
    //   75: getfield 165	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   78: ldc -83
    //   80: putfield 175	com/alipay/sdk/data/a:e	Ljava/lang/String;
    //   83: aload 6
    //   85: getfield 165	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   88: ldc -79
    //   90: putfield 180	com/alipay/sdk/data/a:d	Ljava/lang/String;
    //   93: aload 6
    //   95: getfield 165	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   98: ldc -74
    //   100: putfield 184	com/alipay/sdk/data/a:c	Ljava/lang/String;
    //   103: new 186	com/alipay/sdk/net/d
    //   106: dup
    //   107: new 146	com/alipay/sdk/data/c
    //   110: dup
    //   111: invokespecial 147	com/alipay/sdk/data/c:<init>	()V
    //   114: invokespecial 189	com/alipay/sdk/net/d:<init>	(Lcom/alipay/sdk/data/c;)V
    //   117: astore 7
    //   119: aload_3
    //   120: astore_2
    //   121: aload_3
    //   122: astore 5
    //   124: aload_3
    //   125: astore 4
    //   127: aload 7
    //   129: aload_1
    //   130: aload 6
    //   132: iconst_0
    //   133: invokevirtual 192	com/alipay/sdk/net/d:a	(Landroid/content/Context;Lcom/alipay/sdk/data/e;Z)Lcom/alipay/sdk/protocol/c;
    //   136: astore 6
    //   138: aload_3
    //   139: astore_1
    //   140: aload_3
    //   141: ifnull +17 -> 158
    //   144: aload_3
    //   145: astore_2
    //   146: aload_3
    //   147: astore 5
    //   149: aload_3
    //   150: astore 4
    //   152: aload_3
    //   153: invokevirtual 194	com/alipay/sdk/widget/a:c	()V
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: astore_2
    //   160: aload_1
    //   161: astore 5
    //   163: aload_1
    //   164: astore 4
    //   166: aload 6
    //   168: getfield 199	com/alipay/sdk/protocol/c:c	Lorg/json/JSONObject;
    //   171: ldc -55
    //   173: invokevirtual 205	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   176: ldc -49
    //   178: invokestatic 212	com/alipay/sdk/protocol/b:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/alipay/sdk/protocol/b;
    //   181: invokestatic 215	com/alipay/sdk/protocol/a:a	(Lcom/alipay/sdk/protocol/b;)[Lcom/alipay/sdk/protocol/a;
    //   184: astore_3
    //   185: aload_1
    //   186: astore_2
    //   187: aload_1
    //   188: astore 5
    //   190: aload_1
    //   191: astore 4
    //   193: aload_3
    //   194: arraylength
    //   195: istore 9
    //   197: iload 8
    //   199: iload 9
    //   201: if_icmpge +57 -> 258
    //   204: aload_3
    //   205: iload 8
    //   207: aaload
    //   208: astore 6
    //   210: aload_1
    //   211: astore_2
    //   212: aload_1
    //   213: astore 5
    //   215: aload_1
    //   216: astore 4
    //   218: aload 6
    //   220: getstatic 218	com/alipay/sdk/protocol/a:a	Lcom/alipay/sdk/protocol/a;
    //   223: if_acmpne +26 -> 249
    //   226: aload_1
    //   227: astore_2
    //   228: aload_1
    //   229: astore 5
    //   231: aload_1
    //   232: astore 4
    //   234: aload_0
    //   235: aload 6
    //   237: invokespecial 220	com/alipay/sdk/app/AuthTask:a	(Lcom/alipay/sdk/protocol/a;)Ljava/lang/String;
    //   240: astore_1
    //   241: aload_1
    //   242: areturn
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_3
    //   246: goto -219 -> 27
    //   249: iload 8
    //   251: iconst_1
    //   252: iadd
    //   253: istore 8
    //   255: goto -58 -> 197
    //   258: aconst_null
    //   259: astore_1
    //   260: aload_1
    //   261: astore_2
    //   262: aload_1
    //   263: ifnonnull +13 -> 276
    //   266: getstatic 225	com/alipay/sdk/app/m:b	Lcom/alipay/sdk/app/m;
    //   269: invokevirtual 228	com/alipay/sdk/app/m:a	()I
    //   272: invokestatic 231	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   275: astore_2
    //   276: aload_2
    //   277: invokevirtual 228	com/alipay/sdk/app/m:a	()I
    //   280: aload_2
    //   281: invokevirtual 233	com/alipay/sdk/app/m:b	()Ljava/lang/String;
    //   284: ldc -21
    //   286: invokestatic 238	com/alipay/sdk/app/l:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   289: areturn
    //   290: astore_1
    //   291: aload_2
    //   292: astore 4
    //   294: getstatic 240	com/alipay/sdk/app/m:d	Lcom/alipay/sdk/app/m;
    //   297: invokevirtual 228	com/alipay/sdk/app/m:a	()I
    //   300: invokestatic 231	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   303: astore_1
    //   304: aload_2
    //   305: ifnull +44 -> 349
    //   308: aload_2
    //   309: invokevirtual 194	com/alipay/sdk/widget/a:c	()V
    //   312: goto -52 -> 260
    //   315: astore_1
    //   316: aload 5
    //   318: ifnull +26 -> 344
    //   321: aload 5
    //   323: invokevirtual 194	com/alipay/sdk/widget/a:c	()V
    //   326: aconst_null
    //   327: astore_1
    //   328: goto -68 -> 260
    //   331: astore_1
    //   332: aload 4
    //   334: ifnull +8 -> 342
    //   337: aload 4
    //   339: invokevirtual 194	com/alipay/sdk/widget/a:c	()V
    //   342: aload_1
    //   343: athrow
    //   344: aconst_null
    //   345: astore_1
    //   346: goto -86 -> 260
    //   349: goto -89 -> 260
    //   352: aconst_null
    //   353: astore_3
    //   354: goto -327 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	AuthTask
    //   0	357	1	paramActivity	Activity
    //   0	357	2	paramString	String
    //   22	183	3	localObject1	Object
    //   243	1	3	localException	Exception
    //   245	109	3	localObject2	Object
    //   125	213	4	localObject3	Object
    //   122	200	5	localObject4	Object
    //   61	175	6	localObject5	Object
    //   117	11	7	locald	com.alipay.sdk.net.d
    //   1	253	8	i	int
    //   195	7	9	j	int
    // Exception table:
    //   from	to	target	type
    //   7	27	243	java/lang/Exception
    //   127	138	290	com/alipay/sdk/exception/NetErrorException
    //   152	156	290	com/alipay/sdk/exception/NetErrorException
    //   166	185	290	com/alipay/sdk/exception/NetErrorException
    //   193	197	290	com/alipay/sdk/exception/NetErrorException
    //   218	226	290	com/alipay/sdk/exception/NetErrorException
    //   234	241	290	com/alipay/sdk/exception/NetErrorException
    //   127	138	315	java/lang/Exception
    //   152	156	315	java/lang/Exception
    //   166	185	315	java/lang/Exception
    //   193	197	315	java/lang/Exception
    //   218	226	315	java/lang/Exception
    //   234	241	315	java/lang/Exception
    //   127	138	331	finally
    //   152	156	331	finally
    //   166	185	331	finally
    //   193	197	331	finally
    //   218	226	331	finally
    //   234	241	331	finally
    //   294	304	331	finally
  }
  
  /* Error */
  public String auth(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: astore_2
    //   4: aload_1
    //   5: ldc -13
    //   7: invokevirtual 246	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   10: ifne +56 -> 66
    //   13: new 248	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc -1
    //   30: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: new 257	com/alipay/sdk/sys/a
    //   38: dup
    //   39: aload_0
    //   40: getfield 24	com/alipay/sdk/app/AuthTask:c	Landroid/app/Activity;
    //   43: invokespecial 260	com/alipay/sdk/sys/a:<init>	(Landroid/content/Context;)V
    //   46: invokevirtual 261	com/alipay/sdk/sys/a:toString	()Ljava/lang/String;
    //   49: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_2
    //   54: ldc_w 263
    //   57: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_2
    //   62: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 24	com/alipay/sdk/app/AuthTask:c	Landroid/app/Activity;
    //   70: astore_1
    //   71: aload_1
    //   72: invokestatic 28	com/alipay/sdk/app/AuthTask:a	(Landroid/content/Context;)Z
    //   75: ifeq +42 -> 117
    //   78: new 15	com/alipay/sdk/util/h
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 30	com/alipay/sdk/util/h:<init>	(Landroid/app/Activity;)V
    //   86: aload_2
    //   87: invokevirtual 33	com/alipay/sdk/util/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_3
    //   91: aload_3
    //   92: ldc 35
    //   94: invokestatic 41	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   97: ifne +20 -> 117
    //   100: aload_3
    //   101: astore_1
    //   102: aload_3
    //   103: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +7 -> 113
    //   109: invokestatic 52	com/alipay/sdk/app/l:a	()Ljava/lang/String;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: areturn
    //   117: aload_0
    //   118: aload_1
    //   119: aload_2
    //   120: invokespecial 43	com/alipay/sdk/app/AuthTask:b	(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;
    //   123: astore_1
    //   124: goto -11 -> 113
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	AuthTask
    //   0	132	1	paramString	String
    //   3	117	2	localObject	Object
    //   90	13	3	str	String
    // Exception table:
    //   from	to	target	type
    //   4	66	127	finally
    //   66	100	127	finally
    //   102	113	127	finally
    //   117	124	127	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\app\AuthTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */