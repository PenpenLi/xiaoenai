package com.alipay.apmobilesecuritysdk.face;

import android.annotation.SuppressLint;
import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.b;
import com.taobao.dp.DeviceSecuritySDK;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"NewApi"})
public class APSecuritySdk
{
  private static APSecuritySdk a;
  private static Object b = new Object();
  private Context c;
  private String d;
  private volatile boolean e = false;
  private volatile boolean f = false;
  private Thread g;
  private LinkedList<RunningTask> h = new LinkedList();
  
  private APSecuritySdk(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static APSecuritySdk getInstance(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null) {
        a = new APSecuritySdk(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
  }
  
  public static String getUtdid(Context paramContext)
  {
    try
    {
      paramContext = (String)Class.forName("com.ta.utdid2.device.UTDevice").getMethod("getUtdid", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public TokenResult getTokenResult()
  {
    if (com.alipay.security.mobile.module.a.a.a(this.d)) {
      this.d = DeviceSecuritySDK.getInstance(this.c).getSecurityToken();
    }
    TokenResult localTokenResult = new TokenResult();
    try
    {
      localTokenResult.apdid = com.alipay.apmobilesecuritysdk.a.a.b(this.c);
      localTokenResult.apdidToken = com.alipay.apmobilesecuritysdk.a.a.a(this.c);
      localTokenResult.umidToken = this.d;
      localTokenResult.clientKey = b.a(this.c);
      return localTokenResult;
    }
    catch (Throwable localThrowable) {}
    return localTokenResult;
  }
  
  public void initToken(int paramInt, Map<String, String> paramMap, InitResultListener paramInitResultListener)
  {
    String str1 = com.alipay.security.mobile.module.a.a.a(paramMap, "utdid", "");
    String str2 = com.alipay.security.mobile.module.a.a.a(paramMap, "tid", "");
    paramMap = com.alipay.security.mobile.module.a.a.a(paramMap, "userId", "");
    this.h.addLast(new RunningTask(paramInt, str1, str2, paramMap, paramInitResultListener));
    if (this.g == null)
    {
      this.g = new Thread(new APSecuritySdk.1(this));
      this.g.setUncaughtExceptionHandler(new APSecuritySdk.2(this));
      this.g.start();
    }
  }
  
  public static abstract interface InitResultListener
  {
    public abstract void onResult(APSecuritySdk.TokenResult paramTokenResult);
  }
  
  private class RunningTask
  {
    private int b;
    private String c;
    private String d;
    private String e;
    private APSecuritySdk.InitResultListener f;
    
    public RunningTask(int paramInt, String paramString1, String paramString2, String paramString3, APSecuritySdk.InitResultListener paramInitResultListener)
    {
      this.b = paramInt;
      this.e = paramString3;
      if (com.alipay.security.mobile.module.a.a.a(paramString1)) {}
      for (this.c = APSecuritySdk.getUtdid(APSecuritySdk.c(APSecuritySdk.this));; this.c = paramString1)
      {
        this.d = paramString2;
        this.f = paramInitResultListener;
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   6: invokestatic 55	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:d	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Z
      //   9: ifeq +4 -> 13
      //   12: return
      //   13: aload_0
      //   14: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   17: iconst_1
      //   18: invokestatic 58	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   21: pop
      //   22: aload_0
      //   23: getfield 26	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:b	I
      //   26: tableswitch	default:+26->52, 1:+107->133, 2:+115->141, 3:+123->149
      //   52: ldc 60
      //   54: putstatic 64	com/alipay/apmobilesecuritysdk/b/a:a	Ljava/lang/String;
      //   57: aload_0
      //   58: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   61: iconst_0
      //   62: invokestatic 66	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:b	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   65: pop
      //   66: aload_0
      //   67: getfield 26	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:b	I
      //   70: istore_3
      //   71: iload_3
      //   72: iconst_3
      //   73: if_icmpne +319 -> 392
      //   76: aload_0
      //   77: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   80: invokestatic 36	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   83: invokestatic 72	com/taobao/dp/DeviceSecuritySDK:getInstance	(Landroid/content/Context;)Lcom/taobao/dp/DeviceSecuritySDK;
      //   86: ldc 74
      //   88: iload_2
      //   89: aconst_null
      //   90: new 76	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask$1
      //   93: dup
      //   94: aload_0
      //   95: invokespecial 79	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask$1:<init>	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask;)V
      //   98: invokevirtual 83	com/taobao/dp/DeviceSecuritySDK:initAsync	(Ljava/lang/String;ILcom/taobao/dp/http/IUrlRequestService;Lcom/taobao/dp/client/IInitResultListener;)V
      //   101: sipush 3000
      //   104: istore_2
      //   105: aload_0
      //   106: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   109: invokestatic 85	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:e	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Z
      //   112: ifne +45 -> 157
      //   115: iload_2
      //   116: ifle +41 -> 157
      //   119: ldc2_w 86
      //   122: invokestatic 93	java/lang/Thread:sleep	(J)V
      //   125: iload_2
      //   126: bipush 10
      //   128: isub
      //   129: istore_2
      //   130: goto -25 -> 105
      //   133: ldc 95
      //   135: putstatic 64	com/alipay/apmobilesecuritysdk/b/a:a	Ljava/lang/String;
      //   138: goto -81 -> 57
      //   141: ldc 60
      //   143: putstatic 64	com/alipay/apmobilesecuritysdk/b/a:a	Ljava/lang/String;
      //   146: goto -89 -> 57
      //   149: ldc 97
      //   151: putstatic 64	com/alipay/apmobilesecuritysdk/b/a:a	Ljava/lang/String;
      //   154: goto -97 -> 57
      //   157: aload_0
      //   158: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   161: invokestatic 36	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   164: invokestatic 72	com/taobao/dp/DeviceSecuritySDK:getInstance	(Landroid/content/Context;)Lcom/taobao/dp/DeviceSecuritySDK;
      //   167: invokevirtual 101	com/taobao/dp/DeviceSecuritySDK:getSecurityToken	()Ljava/lang/String;
      //   170: astore_1
      //   171: aload_1
      //   172: invokestatic 33	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
      //   175: ifne +12 -> 187
      //   178: aload_0
      //   179: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   182: aload_1
      //   183: invokestatic 104	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Ljava/lang/String;)Ljava/lang/String;
      //   186: pop
      //   187: new 106	java/util/HashMap
      //   190: dup
      //   191: invokespecial 107	java/util/HashMap:<init>	()V
      //   194: astore_1
      //   195: aload_1
      //   196: ldc 109
      //   198: ldc 111
      //   200: invokeinterface 117 3 0
      //   205: pop
      //   206: aload_1
      //   207: ldc 119
      //   209: aload_0
      //   210: getfield 44	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:d	Ljava/lang/String;
      //   213: invokeinterface 117 3 0
      //   218: pop
      //   219: aload_1
      //   220: ldc 121
      //   222: aload_0
      //   223: getfield 42	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:c	Ljava/lang/String;
      //   226: invokeinterface 117 3 0
      //   231: pop
      //   232: aload_1
      //   233: ldc 123
      //   235: aload_0
      //   236: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   239: invokestatic 126	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:f	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/String;
      //   242: invokeinterface 117 3 0
      //   247: pop
      //   248: aload_1
      //   249: ldc -128
      //   251: aload_0
      //   252: getfield 28	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:e	Ljava/lang/String;
      //   255: invokeinterface 117 3 0
      //   260: pop
      //   261: aload_0
      //   262: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   265: invokestatic 36	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   268: aload_1
      //   269: invokestatic 134	com/alipay/apmobilesecuritysdk/face/SecureSdk:getApdidToken	(Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;
      //   272: pop
      //   273: aload_0
      //   274: getfield 46	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:f	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;
      //   277: ifnull +78 -> 355
      //   280: new 136	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult
      //   283: dup
      //   284: aload_0
      //   285: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   288: invokespecial 139	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:<init>	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V
      //   291: astore_1
      //   292: aload_1
      //   293: aload_0
      //   294: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   297: invokestatic 36	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   300: invokestatic 143	com/alipay/apmobilesecuritysdk/a/a:b	(Landroid/content/Context;)Ljava/lang/String;
      //   303: putfield 146	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:apdid	Ljava/lang/String;
      //   306: aload_1
      //   307: aload_0
      //   308: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   311: invokestatic 36	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   314: invokestatic 148	com/alipay/apmobilesecuritysdk/a/a:a	(Landroid/content/Context;)Ljava/lang/String;
      //   317: putfield 151	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:apdidToken	Ljava/lang/String;
      //   320: aload_1
      //   321: aload_0
      //   322: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   325: invokestatic 126	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:f	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/String;
      //   328: putfield 154	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:umidToken	Ljava/lang/String;
      //   331: aload_1
      //   332: aload_0
      //   333: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   336: invokestatic 36	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   339: invokestatic 157	com/alipay/apmobilesecuritysdk/e/b:a	(Landroid/content/Context;)Ljava/lang/String;
      //   342: putfield 160	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:clientKey	Ljava/lang/String;
      //   345: aload_0
      //   346: getfield 46	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:f	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;
      //   349: aload_1
      //   350: invokeinterface 166 2 0
      //   355: aload_0
      //   356: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   359: iconst_0
      //   360: invokestatic 58	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   363: pop
      //   364: return
      //   365: astore_1
      //   366: aload_0
      //   367: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   370: iconst_0
      //   371: invokestatic 58	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   374: pop
      //   375: return
      //   376: astore_1
      //   377: aload_0
      //   378: getfield 21	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   381: iconst_0
      //   382: invokestatic 58	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   385: pop
      //   386: aload_1
      //   387: athrow
      //   388: astore_1
      //   389: goto -202 -> 187
      //   392: iload_3
      //   393: istore_2
      //   394: goto -318 -> 76
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	397	0	this	RunningTask
      //   170	180	1	localObject1	Object
      //   365	1	1	localThrowable	Throwable
      //   376	11	1	localObject2	Object
      //   388	1	1	localException	Exception
      //   1	393	2	i	int
      //   70	323	3	j	int
      // Exception table:
      //   from	to	target	type
      //   57	71	365	java/lang/Throwable
      //   76	101	365	java/lang/Throwable
      //   105	115	365	java/lang/Throwable
      //   119	125	365	java/lang/Throwable
      //   157	187	365	java/lang/Throwable
      //   187	355	365	java/lang/Throwable
      //   57	71	376	finally
      //   76	101	376	finally
      //   105	115	376	finally
      //   119	125	376	finally
      //   157	187	376	finally
      //   187	355	376	finally
      //   57	71	388	java/lang/Exception
      //   76	101	388	java/lang/Exception
      //   105	115	388	java/lang/Exception
      //   119	125	388	java/lang/Exception
      //   157	187	388	java/lang/Exception
    }
  }
  
  public class TokenResult
  {
    public String apdid;
    public String apdidToken;
    public String clientKey;
    public String umidToken;
    
    public TokenResult() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\APSecuritySdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */