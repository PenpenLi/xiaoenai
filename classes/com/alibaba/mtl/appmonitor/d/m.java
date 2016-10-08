package com.alibaba.mtl.appmonitor.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class m
{
  private static final String TAG = null;
  private static m a;
  private String F;
  private Map<com.alibaba.mtl.appmonitor.a.f, h> q = new HashMap();
  private int r;
  
  private m()
  {
    com.alibaba.mtl.appmonitor.a.f[] arrayOff = com.alibaba.mtl.appmonitor.a.f.a();
    int j = arrayOff.length;
    int i = 0;
    if (i < j)
    {
      com.alibaba.mtl.appmonitor.a.f localf = arrayOff[i];
      if (localf == com.alibaba.mtl.appmonitor.a.f.a) {
        this.q.put(localf, new f(localf, localf.e()));
      }
      for (;;)
      {
        i += 1;
        break;
        this.q.put(localf, new h(localf, localf.e()));
      }
    }
  }
  
  public static m a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new m();
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a(com.alibaba.mtl.appmonitor.a.f paramf, String paramString1, String paramString2)
  {
    return a().b(paramf, paramString1, paramString2, null);
  }
  
  public static boolean a(com.alibaba.mtl.appmonitor.a.f paramf, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return a().b(paramf, paramString1, paramString2, paramMap);
  }
  
  public static boolean a(String paramString1, String paramString2, Boolean paramBoolean, Map<String, String> paramMap)
  {
    return a().b(paramString1, paramString2, paramBoolean, paramMap);
  }
  
  public void a(com.alibaba.mtl.appmonitor.a.f paramf, int paramInt)
  {
    paramf = (h)this.q.get(paramf);
    if (paramf != null) {
      paramf.setSampling(paramInt);
    }
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: ldc 83
    //   2: iconst_2
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: ldc 85
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_1
    //   14: aastore
    //   15: invokestatic 90	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_1
    //   21: invokestatic 96	com/alibaba/mtl/appmonitor/f/b:isBlank	(Ljava/lang/String;)Z
    //   24: ifne +21 -> 45
    //   27: aload_0
    //   28: getfield 98	com/alibaba/mtl/appmonitor/d/m:F	Ljava/lang/String;
    //   31: ifnull +17 -> 48
    //   34: aload_0
    //   35: getfield 98	com/alibaba/mtl/appmonitor/d/m:F	Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +6 -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: invokestatic 110	com/alibaba/fastjson/JSON:parseObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;
    //   54: astore_2
    //   55: invokestatic 32	com/alibaba/mtl/appmonitor/a/f:a	()[Lcom/alibaba/mtl/appmonitor/a/f;
    //   58: astore_3
    //   59: aload_3
    //   60: arraylength
    //   61: istore 8
    //   63: iconst_0
    //   64: istore 7
    //   66: iload 7
    //   68: iload 8
    //   70: if_icmpge +87 -> 157
    //   73: aload_3
    //   74: iload 7
    //   76: aaload
    //   77: astore 4
    //   79: aload_2
    //   80: aload 4
    //   82: invokevirtual 114	com/alibaba/mtl/appmonitor/a/f:toString	()Ljava/lang/String;
    //   85: invokevirtual 119	com/alibaba/fastjson/JSONObject:getJSONObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;
    //   88: astore 5
    //   90: aload_0
    //   91: getfield 27	com/alibaba/mtl/appmonitor/d/m:q	Ljava/util/Map;
    //   94: aload 4
    //   96: invokeinterface 74 2 0
    //   101: checkcast 52	com/alibaba/mtl/appmonitor/d/h
    //   104: astore 6
    //   106: aload 5
    //   108: ifnull +35 -> 143
    //   111: aload 6
    //   113: ifnull +30 -> 143
    //   116: getstatic 18	com/alibaba/mtl/appmonitor/d/m:TAG	Ljava/lang/String;
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload 4
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: aload 5
    //   132: aastore
    //   133: invokestatic 90	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload 6
    //   138: aload 5
    //   140: invokevirtual 122	com/alibaba/mtl/appmonitor/d/h:b	(Lcom/alibaba/fastjson/JSONObject;)V
    //   143: iload 7
    //   145: iconst_1
    //   146: iadd
    //   147: istore 7
    //   149: goto -83 -> 66
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    //   157: aload_0
    //   158: aload_1
    //   159: putfield 98	com/alibaba/mtl/appmonitor/d/m:F	Ljava/lang/String;
    //   162: return
    //   163: astore_1
    //   164: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	m
    //   0	165	1	paramString	String
    //   54	26	2	localJSONObject1	com.alibaba.fastjson.JSONObject
    //   58	16	3	arrayOff	com.alibaba.mtl.appmonitor.a.f[]
    //   77	49	4	localf	com.alibaba.mtl.appmonitor.a.f
    //   88	51	5	localJSONObject2	com.alibaba.fastjson.JSONObject
    //   104	33	6	localh	h
    //   64	84	7	i	int
    //   61	10	8	j	int
    // Exception table:
    //   from	to	target	type
    //   20	45	152	finally
    //   45	47	152	finally
    //   48	50	152	finally
    //   153	155	152	finally
    //   50	63	163	java/lang/Throwable
    //   79	106	163	java/lang/Throwable
    //   116	143	163	java/lang/Throwable
    //   157	162	163	java/lang/Throwable
  }
  
  public boolean b(com.alibaba.mtl.appmonitor.a.f paramf, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    paramf = (h)this.q.get(paramf);
    if (paramf != null) {
      return paramf.a(this.r, paramString1, paramString2, paramMap);
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2, Boolean paramBoolean, Map<String, String> paramMap)
  {
    h localh = (h)this.q.get(com.alibaba.mtl.appmonitor.a.f.a);
    if ((localh != null) && ((localh instanceof f))) {
      return ((f)localh).a(this.r, paramString1, paramString2, paramBoolean, paramMap);
    }
    return false;
  }
  
  public void init(Context paramContext)
  {
    l.init(paramContext);
    k();
  }
  
  public void k()
  {
    this.r = new Random(System.currentTimeMillis()).nextInt(10000);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */