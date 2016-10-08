package com.taobao.dp.client;

import android.content.Context;
import android.util.Base64;
import com.taobao.dp.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class b
  implements com.taobao.dp.b.h
{
  public static final String OS = "android";
  public static final String PROTOCAL_VERSION = "1.4.2";
  private static final int SECURITY_TOKEN_LENGTH = 32;
  public static final String SERVICE = "com.taobao.tdp";
  private static final String TOKEN_EX_VERSION = "0";
  public static final String UNIFIED_APP_KEY = "device_print_res_k1";
  public static final String UNIFIED_AUTH_CODE = "";
  private Context mContext;
  private a mEnvironment;
  private volatile String mExactId;
  private Object mInternalLock;
  private volatile String mSecToken;
  private List mServiceList;
  private Executor mSinglThreadExcutor;
  private volatile String mUuid;
  
  protected b(Context paramContext)
  {
    this.mContext = paramContext;
    this.mEnvironment = a.c;
    this.mSecToken = null;
    this.mUuid = null;
    this.mExactId = null;
    this.mSinglThreadExcutor = Executors.newSingleThreadExecutor();
    this.mServiceList = new ArrayList();
    this.mInternalLock = new Object();
  }
  
  private String deviceInfoFilter(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    try
    {
      paramString = paramString.replace("^", "\\^").replace(',', '^');
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  protected a getEnvironment(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.mEnvironment;
    case 1: 
      return a.a;
    case 2: 
      return a.b;
    }
    return a.c;
  }
  
  public String getSecurityToken()
  {
    for (;;)
    {
      synchronized (this.mInternalLock)
      {
        if ((this.mSecToken == null) || ("".equals(this.mSecToken)) || (this.mSecToken.length() < 32))
        {
          int j = 1;
          if ((this.mSecToken == null) || ("".equals(this.mSecToken))) {
            this.mSecToken = com.taobao.dp.c.h.a(this.mContext);
          }
          if (this.mSecToken != null)
          {
            i = j;
            if (!"".equals(this.mSecToken)) {}
          }
          else
          {
            this.mSecToken = "000000000000000000000000";
            i = j;
          }
          if (i != 0) {
            init(this.mEnvironment, null, null, false);
          }
          return this.mSecToken;
        }
      }
      int i = 0;
    }
  }
  
  public String getSecurityTokenEx()
  {
    String str = getSecurityToken();
    Object localObject2 = this.mExactId;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    new com.taobao.dp.b.a(this.mContext);
    com.taobao.dp.bean.a locala = new com.taobao.dp.bean.a();
    ((StringBuilder)localObject2).append(str).append(",").append((String)localObject1).append(",,,").append(deviceInfoFilter(com.taobao.dp.b.a.c())).append(",").append(deviceInfoFilter(com.taobao.dp.b.a.b())).append(",").append(com.taobao.dp.b.a.y()).append(",").append(locala.a).append(",").append(locala.b).append(",0");
    localObject1 = Base64.encodeToString(((StringBuilder)localObject2).toString().getBytes(), 2);
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      return (String)localObject1;
    }
    return str;
  }
  
  /* Error */
  protected int init(a parama, com.taobao.dp.http.IUrlRequestService paramIUrlRequestService, IInitResultListener paramIInitResultListener, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/taobao/dp/client/b:mEnvironment	Lcom/taobao/dp/client/a;
    //   4: aload_1
    //   5: if_acmpeq +8 -> 13
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 176	com/taobao/dp/client/b:setEnvironment	(Lcom/taobao/dp/client/a;)V
    //   13: aload_0
    //   14: getfield 76	com/taobao/dp/client/b:mInternalLock	Ljava/lang/Object;
    //   17: astore 5
    //   19: aload 5
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 59	com/taobao/dp/client/b:mUuid	Ljava/lang/String;
    //   26: astore 7
    //   28: aload_0
    //   29: getfield 57	com/taobao/dp/client/b:mSecToken	Ljava/lang/String;
    //   32: astore 6
    //   34: aload_0
    //   35: getfield 55	com/taobao/dp/client/b:mEnvironment	Lcom/taobao/dp/client/a;
    //   38: aload_1
    //   39: if_acmpeq +28 -> 67
    //   42: iconst_1
    //   43: istore 9
    //   45: aconst_null
    //   46: astore_1
    //   47: iconst_0
    //   48: istore 10
    //   50: aload 5
    //   52: monitorexit
    //   53: iload 9
    //   55: ifeq +238 -> 293
    //   58: iload 4
    //   60: ifeq +214 -> 274
    //   63: sipush 10007
    //   66: ireturn
    //   67: aload 7
    //   69: ifnull +35 -> 104
    //   72: aload 6
    //   74: ifnull +30 -> 104
    //   77: aload 7
    //   79: invokevirtual 87	java/lang/String:length	()I
    //   82: ifle +22 -> 104
    //   85: aload 6
    //   87: invokevirtual 87	java/lang/String:length	()I
    //   90: ifle +14 -> 104
    //   93: aconst_null
    //   94: astore_1
    //   95: iconst_1
    //   96: istore 10
    //   98: iconst_0
    //   99: istore 9
    //   101: goto -51 -> 50
    //   104: iload 4
    //   106: ifne +90 -> 196
    //   109: aload_2
    //   110: ifnonnull +86 -> 196
    //   113: aload_3
    //   114: ifnonnull +82 -> 196
    //   117: aload_0
    //   118: getfield 74	com/taobao/dp/client/b:mServiceList	Ljava/util/List;
    //   121: invokeinterface 182 1 0
    //   126: astore 7
    //   128: aload 7
    //   130: invokeinterface 188 1 0
    //   135: ifeq +61 -> 196
    //   138: aload 7
    //   140: invokeinterface 192 1 0
    //   145: checkcast 194	com/taobao/dp/b/c
    //   148: astore 8
    //   150: aload 8
    //   152: invokevirtual 197	com/taobao/dp/b/c:d	()Z
    //   155: ifne -27 -> 128
    //   158: aload 8
    //   160: invokevirtual 200	com/taobao/dp/b/c:c	()Lcom/taobao/dp/http/IUrlRequestService;
    //   163: ifnull -35 -> 128
    //   166: aload 8
    //   168: invokevirtual 200	com/taobao/dp/b/c:c	()Lcom/taobao/dp/http/IUrlRequestService;
    //   171: instanceof 202
    //   174: ifeq -46 -> 128
    //   177: aload 8
    //   179: invokevirtual 205	com/taobao/dp/b/c:a	()Lcom/taobao/dp/client/IInitResultListener;
    //   182: ifnonnull -54 -> 128
    //   185: aload 5
    //   187: monitorexit
    //   188: iconst_m1
    //   189: ireturn
    //   190: astore_1
    //   191: aload 5
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: new 194	com/taobao/dp/b/c
    //   199: dup
    //   200: aload_0
    //   201: getfield 48	com/taobao/dp/client/b:mContext	Landroid/content/Context;
    //   204: ldc 25
    //   206: ldc 28
    //   208: aload_0
    //   209: aload_1
    //   210: aload_2
    //   211: aload_3
    //   212: iload 4
    //   214: invokespecial 208	com/taobao/dp/b/c:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/taobao/dp/b/h;Lcom/taobao/dp/client/a;Lcom/taobao/dp/http/IUrlRequestService;Lcom/taobao/dp/client/IInitResultListener;Z)V
    //   217: astore_1
    //   218: aload_0
    //   219: getfield 74	com/taobao/dp/client/b:mServiceList	Ljava/util/List;
    //   222: invokeinterface 211 1 0
    //   227: ifne +41 -> 268
    //   230: iconst_1
    //   231: istore 9
    //   233: aload_0
    //   234: getfield 74	com/taobao/dp/client/b:mServiceList	Ljava/util/List;
    //   237: aload_1
    //   238: invokeinterface 214 2 0
    //   243: pop
    //   244: iload 9
    //   246: ifeq +13 -> 259
    //   249: aload_0
    //   250: getfield 69	com/taobao/dp/client/b:mSinglThreadExcutor	Ljava/util/concurrent/Executor;
    //   253: aload_1
    //   254: invokeinterface 220 2 0
    //   259: iconst_0
    //   260: istore 10
    //   262: iconst_0
    //   263: istore 9
    //   265: goto -215 -> 50
    //   268: iconst_0
    //   269: istore 9
    //   271: goto -38 -> 233
    //   274: aload_3
    //   275: ifnull +14 -> 289
    //   278: aload_3
    //   279: aload 6
    //   281: sipush 10007
    //   284: invokeinterface 226 3 0
    //   289: sipush 10007
    //   292: ireturn
    //   293: iload 10
    //   295: ifeq +31 -> 326
    //   298: iload 4
    //   300: ifeq +7 -> 307
    //   303: sipush 200
    //   306: ireturn
    //   307: aload_3
    //   308: ifnull +14 -> 322
    //   311: aload_3
    //   312: aload 6
    //   314: sipush 200
    //   317: invokeinterface 226 3 0
    //   322: sipush 200
    //   325: ireturn
    //   326: iload 4
    //   328: ifeq +21 -> 349
    //   331: aload_1
    //   332: monitorenter
    //   333: aload_1
    //   334: invokevirtual 229	java/lang/Object:wait	()V
    //   337: aload_1
    //   338: monitorexit
    //   339: aload_1
    //   340: invokevirtual 232	com/taobao/dp/b/c:e	()I
    //   343: ireturn
    //   344: astore_2
    //   345: aload_1
    //   346: monitorexit
    //   347: aload_2
    //   348: athrow
    //   349: sipush 200
    //   352: ireturn
    //   353: astore_2
    //   354: goto -17 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	b
    //   0	357	1	parama	a
    //   0	357	2	paramIUrlRequestService	com.taobao.dp.http.IUrlRequestService
    //   0	357	3	paramIInitResultListener	IInitResultListener
    //   0	357	4	paramBoolean	boolean
    //   17	175	5	localObject1	Object
    //   32	281	6	str	String
    //   26	113	7	localObject2	Object
    //   148	30	8	localc	c
    //   43	227	9	i	int
    //   48	246	10	j	int
    // Exception table:
    //   from	to	target	type
    //   22	42	190	finally
    //   50	53	190	finally
    //   77	93	190	finally
    //   117	128	190	finally
    //   128	188	190	finally
    //   196	230	190	finally
    //   233	244	190	finally
    //   249	259	190	finally
    //   333	337	344	finally
    //   337	339	344	finally
    //   333	337	353	java/lang/Exception
  }
  
  public void notifyDidChanged(c paramc, String paramString)
  {
    synchronized (this.mInternalLock)
    {
      if (paramc.b() == this.mEnvironment)
      {
        this.mSecToken = paramString;
        this.mUuid = paramc.f();
        this.mExactId = paramc.g();
      }
      return;
    }
  }
  
  public void onInitFinished(c paramc, int paramInt)
  {
    Object localObject1 = new ArrayList();
    for (;;)
    {
      Object localObject2;
      synchronized (this.mInternalLock)
      {
        if (!this.mServiceList.contains(paramc)) {
          break label246;
        }
        if (paramInt == 200)
        {
          paramc = this.mServiceList;
          this.mServiceList = new ArrayList();
          if (this.mServiceList.size() <= 0) {
            break label235;
          }
          localObject2 = (c)this.mServiceList.get(0);
          localObject1 = paramc;
          paramc = (c)localObject2;
          localObject2 = ((List)localObject1).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label220;
          }
          localObject1 = (c)((Iterator)localObject2).next();
          if (((c)localObject1).d())
          {
            ((c)localObject1).a(paramInt);
            try
            {
              localObject1.notify();
              continue;
            }
            finally
            {
              paramc = finally;
              throw paramc;
            }
          }
        }
        else
        {
          ((List)localObject1).add(paramc);
          this.mServiceList.remove(paramc);
          paramc = (c)localObject1;
        }
      }
      if (((c)localObject1).a() != null) {
        if (paramInt == 200)
        {
          ((c)localObject1).a().onInitFinished(this.mSecToken, paramInt);
        }
        else
        {
          ((c)localObject1).a().onInitFinished(null, paramInt);
          continue;
          label220:
          if (paramc != null) {
            this.mSinglThreadExcutor.execute(paramc);
          }
          return;
          label235:
          localObject2 = null;
          localObject1 = paramc;
          paramc = (c)localObject2;
          continue;
          label246:
          paramc = null;
        }
      }
    }
  }
  
  /* Error */
  protected void setEnvironment(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 55	com/taobao/dp/client/b:mEnvironment	Lcom/taobao/dp/client/a;
    //   7: if_acmpeq +137 -> 144
    //   10: aload_0
    //   11: getfield 76	com/taobao/dp/client/b:mInternalLock	Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: monitorenter
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 55	com/taobao/dp/client/b:mEnvironment	Lcom/taobao/dp/client/a;
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 59	com/taobao/dp/client/b:mUuid	Ljava/lang/String;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 57	com/taobao/dp/client/b:mSecToken	Ljava/lang/String;
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 61	com/taobao/dp/client/b:mExactId	Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 74	com/taobao/dp/client/b:mServiceList	Ljava/util/List;
    //   41: astore_1
    //   42: aload_0
    //   43: new 71	java/util/ArrayList
    //   46: dup
    //   47: invokespecial 72	java/util/ArrayList:<init>	()V
    //   50: putfield 74	com/taobao/dp/client/b:mServiceList	Ljava/util/List;
    //   53: aload_2
    //   54: monitorexit
    //   55: aload_1
    //   56: invokeinterface 182 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 188 1 0
    //   68: ifeq +76 -> 144
    //   71: aload_2
    //   72: invokeinterface 192 1 0
    //   77: checkcast 194	com/taobao/dp/b/c
    //   80: astore_1
    //   81: aload_1
    //   82: invokevirtual 197	com/taobao/dp/b/c:d	()Z
    //   85: ifeq +36 -> 121
    //   88: aload_1
    //   89: sipush 10007
    //   92: invokevirtual 254	com/taobao/dp/b/c:a	(I)V
    //   95: aload_1
    //   96: monitorenter
    //   97: aload_1
    //   98: invokevirtual 257	java/lang/Object:notify	()V
    //   101: aload_1
    //   102: monitorexit
    //   103: goto -41 -> 62
    //   106: astore_2
    //   107: aload_1
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aload_2
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: aload_1
    //   122: invokevirtual 205	com/taobao/dp/b/c:a	()Lcom/taobao/dp/client/IInitResultListener;
    //   125: ifnull -63 -> 62
    //   128: aload_1
    //   129: invokevirtual 205	com/taobao/dp/b/c:a	()Lcom/taobao/dp/client/IInitResultListener;
    //   132: aconst_null
    //   133: sipush 10007
    //   136: invokeinterface 226 3 0
    //   141: goto -79 -> 62
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	b
    //   0	147	1	parama	a
    //   106	12	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   97	103	106	finally
    //   2	17	111	finally
    //   55	62	111	finally
    //   62	97	111	finally
    //   107	111	111	finally
    //   117	121	111	finally
    //   121	141	111	finally
    //   17	55	116	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\client\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */