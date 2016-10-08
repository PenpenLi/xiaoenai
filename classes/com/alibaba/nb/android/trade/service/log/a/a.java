package com.alibaba.nb.android.trade.service.log.a;

import android.util.Log;
import com.alibaba.nb.android.trade.AliTradeContext;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a
{
  public static final a a = new a();
  private int b = 7;
  private final Map<String, Map<String, AtomicInteger[]>> c = new LinkedHashMap();
  private final ReadWriteLock d = new ReentrantReadWriteLock();
  private volatile long e;
  private com.alibaba.nb.android.trade.service.b.b f;
  private volatile String g = "";
  
  private static Appendable a(Appendable paramAppendable, CharSequence... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = paramVarArgs[i];
        paramAppendable.append('[');
        if (localCharSequence != null) {
          paramAppendable.append(localCharSequence);
        }
        paramAppendable.append(']');
        i += 1;
      }
      return paramAppendable;
    }
    catch (Exception paramVarArgs)
    {
      Log.w("AliSDK", paramVarArgs);
    }
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   5: lstore 7
    //   7: aload_0
    //   8: getfield 72	com/alibaba/nb/android/trade/service/log/a/a:f	Lcom/alibaba/nb/android/trade/service/b/b;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +276 -> 289
    //   16: aload_0
    //   17: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   20: invokeinterface 78 1 0
    //   25: invokeinterface 83 1 0
    //   30: aload_0
    //   31: getfield 35	com/alibaba/nb/android/trade/service/log/a/a:c	Ljava/util/Map;
    //   34: invokeinterface 89 1 0
    //   39: invokeinterface 95 1 0
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 101 1 0
    //   51: ifeq +278 -> 329
    //   54: aload_1
    //   55: invokeinterface 105 1 0
    //   60: checkcast 107	java/util/Map$Entry
    //   63: astore_3
    //   64: aload_3
    //   65: invokeinterface 110 1 0
    //   70: checkcast 112	java/lang/String
    //   73: astore_2
    //   74: aload_3
    //   75: invokeinterface 115 1 0
    //   80: checkcast 85	java/util/Map
    //   83: invokeinterface 89 1 0
    //   88: invokeinterface 95 1 0
    //   93: astore_3
    //   94: aload_3
    //   95: invokeinterface 101 1 0
    //   100: ifeq -55 -> 45
    //   103: aload_3
    //   104: invokeinterface 105 1 0
    //   109: checkcast 107	java/util/Map$Entry
    //   112: astore 5
    //   114: aload 5
    //   116: invokeinterface 115 1 0
    //   121: checkcast 117	[Ljava/util/concurrent/atomic/AtomicInteger;
    //   124: astore 4
    //   126: aload 4
    //   128: iconst_0
    //   129: aaload
    //   130: invokevirtual 123	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   133: ifgt +13 -> 146
    //   136: aload 4
    //   138: iconst_2
    //   139: aaload
    //   140: invokevirtual 123	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   143: ifle -49 -> 94
    //   146: aload 5
    //   148: invokeinterface 110 1 0
    //   153: checkcast 112	java/lang/String
    //   156: astore 5
    //   158: new 125	java/util/HashMap
    //   161: dup
    //   162: invokespecial 126	java/util/HashMap:<init>	()V
    //   165: astore 6
    //   167: aload 6
    //   169: ldc -128
    //   171: aload 4
    //   173: iconst_0
    //   174: aaload
    //   175: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokeinterface 136 3 0
    //   183: pop
    //   184: aload 6
    //   186: ldc -118
    //   188: aload 4
    //   190: iconst_1
    //   191: aaload
    //   192: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: invokeinterface 136 3 0
    //   200: pop
    //   201: aload 6
    //   203: ldc -116
    //   205: aload 4
    //   207: iconst_2
    //   208: aaload
    //   209: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokeinterface 136 3 0
    //   217: pop
    //   218: aload 6
    //   220: ldc -114
    //   222: aload 4
    //   224: iconst_3
    //   225: aaload
    //   226: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   229: invokeinterface 136 3 0
    //   234: pop
    //   235: aload_0
    //   236: getfield 72	com/alibaba/nb/android/trade/service/log/a/a:f	Lcom/alibaba/nb/android/trade/service/b/b;
    //   239: aload 5
    //   241: aload_2
    //   242: aload 6
    //   244: invokeinterface 147 4 0
    //   249: aload_0
    //   250: iconst_1
    //   251: iconst_3
    //   252: ldc -107
    //   254: ldc -105
    //   256: aload 5
    //   258: invokevirtual 154	com/alibaba/nb/android/trade/service/log/a/a:a	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   261: goto -167 -> 94
    //   264: astore_1
    //   265: aload_0
    //   266: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   269: invokeinterface 78 1 0
    //   274: invokeinterface 157 1 0
    //   279: aload_1
    //   280: athrow
    //   281: astore_1
    //   282: ldc 58
    //   284: aload_1
    //   285: invokestatic 64	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   288: pop
    //   289: aload_0
    //   290: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   293: invokeinterface 160 1 0
    //   298: invokeinterface 83 1 0
    //   303: aload_0
    //   304: getfield 35	com/alibaba/nb/android/trade/service/log/a/a:c	Ljava/util/Map;
    //   307: invokeinterface 163 1 0
    //   312: aload_0
    //   313: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   316: invokeinterface 160 1 0
    //   321: invokeinterface 157 1 0
    //   326: aload_0
    //   327: monitorexit
    //   328: return
    //   329: aload_0
    //   330: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   333: invokeinterface 78 1 0
    //   338: invokeinterface 157 1 0
    //   343: aload_0
    //   344: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   347: invokeinterface 160 1 0
    //   352: invokeinterface 83 1 0
    //   357: aload_0
    //   358: getfield 35	com/alibaba/nb/android/trade/service/log/a/a:c	Ljava/util/Map;
    //   361: invokeinterface 163 1 0
    //   366: aload_0
    //   367: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   370: invokeinterface 160 1 0
    //   375: invokeinterface 157 1 0
    //   380: aload_0
    //   381: lload 7
    //   383: putfield 165	com/alibaba/nb/android/trade/service/log/a/a:e	J
    //   386: goto -97 -> 289
    //   389: astore_1
    //   390: aload_0
    //   391: monitorexit
    //   392: aload_1
    //   393: athrow
    //   394: astore_1
    //   395: aload_0
    //   396: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   399: invokeinterface 160 1 0
    //   404: invokeinterface 157 1 0
    //   409: aload_1
    //   410: athrow
    //   411: astore_1
    //   412: aload_0
    //   413: getfield 40	com/alibaba/nb/android/trade/service/log/a/a:d	Ljava/util/concurrent/locks/ReadWriteLock;
    //   416: invokeinterface 160 1 0
    //   421: invokeinterface 157 1 0
    //   426: aload_1
    //   427: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	a
    //   11	44	1	localObject1	Object
    //   264	16	1	localObject2	Object
    //   281	4	1	localException	Exception
    //   389	4	1	localObject3	Object
    //   394	16	1	localObject4	Object
    //   411	16	1	localObject5	Object
    //   73	169	2	str	String
    //   63	41	3	localObject6	Object
    //   124	99	4	arrayOfAtomicInteger	AtomicInteger[]
    //   112	145	5	localObject7	Object
    //   165	78	6	localHashMap	java.util.HashMap
    //   5	377	7	l	long
    // Exception table:
    //   from	to	target	type
    //   30	45	264	finally
    //   45	94	264	finally
    //   94	146	264	finally
    //   146	261	264	finally
    //   16	30	281	java/lang/Exception
    //   265	281	281	java/lang/Exception
    //   329	357	281	java/lang/Exception
    //   366	386	281	java/lang/Exception
    //   395	411	281	java/lang/Exception
    //   2	12	389	finally
    //   16	30	389	finally
    //   265	281	389	finally
    //   282	289	389	finally
    //   289	303	389	finally
    //   312	326	389	finally
    //   329	357	389	finally
    //   366	386	389	finally
    //   395	411	389	finally
    //   412	428	389	finally
    //   357	366	394	finally
    //   303	312	411	finally
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.g);
    a(localStringBuilder, new CharSequence[] { paramString2 });
    if (paramString3 != null) {
      localStringBuilder.append(paramString3);
    }
    if (paramString4 != null) {
      localStringBuilder.append(" : ").append(paramString4);
    }
    paramString2 = localStringBuilder.toString();
    if (AliTradeContext.isDebugable()) {
      Log.println(paramInt, paramString1, paramString2);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      b.a().a(paramString1, paramString2);
      return;
    case 5: 
      b.a().b(paramString1, paramString2);
      return;
    }
    b.a().c(paramString1, paramString2);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt2 == 6) || ((this.b & 0x1 & paramInt1) > 0) || ((this.b & 0x2 & paramInt1) > 0)) {
      a("AliSDK", paramInt2, paramString1, paramString2, paramString3);
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramInt == 6) || ((this.b & 0x1 & 0x2) > 0) || ((this.b & 0x2 & 0x2) > 0)) {
      a(paramString1, paramInt, null, null, paramString2);
    }
  }
  
  protected final void finalize()
  {
    a();
    super.finalize();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\log\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */