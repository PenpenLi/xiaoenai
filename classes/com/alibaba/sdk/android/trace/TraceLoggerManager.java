package com.alibaba.sdk.android.trace;

import android.util.Log;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.ReflectionUtils;
import com.alibaba.sdk.android.util.TraceHelper;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TraceLoggerManager
  implements TraceLoggerService
{
  public static final TraceLoggerManager INSTANCE = new TraceLoggerManager();
  private volatile long actionCountTraceTime;
  private final Map<String, Map<String, AtomicInteger[]>> actionCountTrack = new LinkedHashMap();
  private final ReadWriteLock actionCountTrackLock = new ReentrantReadWriteLock();
  private boolean logCatDebug;
  private volatile String msgHeaderBuffer = "";
  private int sdkLevel = 4;
  private UncaughtExceptionTraceHandler uncaughtExceptionTraceHandler = new UncaughtExceptionTraceHandler();
  private UserTrackerService userTrackerService;
  
  private CharSequence buildMessage(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.msgHeaderBuffer);
    buildStrHeader(localStringBuilder, new CharSequence[] { paramString1 });
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    if (paramString3 != null) {
      localStringBuilder.append(" : ").append(paramString3);
    }
    return localStringBuilder;
  }
  
  private Appendable buildStrHeader(Appendable paramAppendable, CharSequence... paramVarArgs)
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
  
  private void logCat(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    paramString3 = buildMessage(paramString2, paramString3, paramString4).toString();
    if (this.logCatDebug) {
      Log.println(paramInt, paramString1, paramString3);
    }
    paramString2 = ReflectionUtils.loadClassQuietly("com.alibaba.sdk.android.tlog.service.TlogServiceImpl");
    if (paramString2 != null) {}
    try
    {
      paramString2 = ReflectionUtils.getField(paramString2, "INSTANCE").get(null);
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    catch (IllegalAccessException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        paramString2 = null;
      }
      ReflectionUtils.invoke("com.alibaba.sdk.android.tlog.service.TlogServiceImpl", "logi", new String[] { "java.lang.String", "java.lang.String" }, paramString2, new Object[] { paramString1, paramString3 });
      return;
    }
    ReflectionUtils.invoke("com.alibaba.sdk.android.tlog.service.TlogServiceImpl", "logw", new String[] { "java.lang.String", "java.lang.String" }, paramString2, new Object[] { paramString1, paramString3 });
    return;
    ReflectionUtils.invoke("com.alibaba.sdk.android.tlog.service.TlogServiceImpl", "loge", new String[] { "java.lang.String", "java.lang.String" }, paramString2, new Object[] { paramString1, paramString3 });
  }
  
  /* Error */
  private void sendActionCountTrack(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   3: lstore 8
    //   5: iload_1
    //   6: ifne +17 -> 23
    //   9: lload 8
    //   11: aload_0
    //   12: getfield 154	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTraceTime	J
    //   15: lsub
    //   16: ldc2_w 155
    //   19: lcmp
    //   20: iflt +10 -> 30
    //   23: aload_0
    //   24: getfield 158	com/alibaba/sdk/android/trace/TraceLoggerManager:userTrackerService	Lcom/alibaba/sdk/android/ut/UserTrackerService;
    //   27: ifnonnull +4 -> 31
    //   30: return
    //   31: aload_0
    //   32: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   35: invokeinterface 164 1 0
    //   40: invokeinterface 169 1 0
    //   45: aload_0
    //   46: getfield 46	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrack	Ljava/util/Map;
    //   49: invokeinterface 175 1 0
    //   54: invokeinterface 181 1 0
    //   59: astore_2
    //   60: aload_2
    //   61: invokeinterface 187 1 0
    //   66: ifeq +248 -> 314
    //   69: aload_2
    //   70: invokeinterface 191 1 0
    //   75: checkcast 193	java/util/Map$Entry
    //   78: astore 4
    //   80: aload 4
    //   82: invokeinterface 196 1 0
    //   87: checkcast 134	java/lang/String
    //   90: astore_3
    //   91: aload 4
    //   93: invokeinterface 199 1 0
    //   98: checkcast 171	java/util/Map
    //   101: invokeinterface 175 1 0
    //   106: invokeinterface 181 1 0
    //   111: astore 4
    //   113: aload 4
    //   115: invokeinterface 187 1 0
    //   120: ifeq -60 -> 60
    //   123: aload 4
    //   125: invokeinterface 191 1 0
    //   130: checkcast 193	java/util/Map$Entry
    //   133: astore 6
    //   135: aload 6
    //   137: invokeinterface 199 1 0
    //   142: checkcast 201	[Ljava/util/concurrent/atomic/AtomicInteger;
    //   145: astore 5
    //   147: aload 5
    //   149: iconst_0
    //   150: aaload
    //   151: invokevirtual 206	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   154: ifgt +13 -> 167
    //   157: aload 5
    //   159: iconst_2
    //   160: aaload
    //   161: invokevirtual 206	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   164: ifle -51 -> 113
    //   167: aload 6
    //   169: invokeinterface 196 1 0
    //   174: checkcast 134	java/lang/String
    //   177: astore 6
    //   179: new 208	java/util/HashMap
    //   182: dup
    //   183: invokespecial 209	java/util/HashMap:<init>	()V
    //   186: astore 7
    //   188: aload 7
    //   190: ldc -45
    //   192: aload 5
    //   194: iconst_0
    //   195: aaload
    //   196: invokestatic 215	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   199: invokeinterface 219 3 0
    //   204: pop
    //   205: aload 7
    //   207: ldc -35
    //   209: aload 5
    //   211: iconst_1
    //   212: aaload
    //   213: invokestatic 215	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokeinterface 219 3 0
    //   221: pop
    //   222: aload 7
    //   224: ldc -33
    //   226: aload 5
    //   228: iconst_2
    //   229: aaload
    //   230: invokestatic 215	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokeinterface 219 3 0
    //   238: pop
    //   239: aload 7
    //   241: ldc -31
    //   243: aload 5
    //   245: iconst_3
    //   246: aaload
    //   247: invokestatic 215	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   250: invokeinterface 219 3 0
    //   255: pop
    //   256: aload_0
    //   257: getfield 158	com/alibaba/sdk/android/trace/TraceLoggerManager:userTrackerService	Lcom/alibaba/sdk/android/ut/UserTrackerService;
    //   260: aload 6
    //   262: ldc2_w 226
    //   265: aload_3
    //   266: aload 7
    //   268: invokeinterface 233 6 0
    //   273: aload_0
    //   274: iconst_1
    //   275: iconst_3
    //   276: ldc -21
    //   278: ldc -19
    //   280: aload 6
    //   282: invokevirtual 241	com/alibaba/sdk/android/trace/TraceLoggerManager:log	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto -172 -> 113
    //   288: astore_2
    //   289: aload_0
    //   290: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   293: invokeinterface 164 1 0
    //   298: invokeinterface 244 1 0
    //   303: aload_2
    //   304: athrow
    //   305: astore_2
    //   306: ldc 86
    //   308: aload_2
    //   309: invokestatic 92	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   312: pop
    //   313: return
    //   314: aload_0
    //   315: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   318: invokeinterface 164 1 0
    //   323: invokeinterface 244 1 0
    //   328: aload_0
    //   329: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   332: invokeinterface 247 1 0
    //   337: invokeinterface 169 1 0
    //   342: aload_0
    //   343: getfield 46	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrack	Ljava/util/Map;
    //   346: invokeinterface 250 1 0
    //   351: aload_0
    //   352: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   355: invokeinterface 247 1 0
    //   360: invokeinterface 244 1 0
    //   365: aload_0
    //   366: lload 8
    //   368: putfield 154	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTraceTime	J
    //   371: return
    //   372: astore_2
    //   373: aload_0
    //   374: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   377: invokeinterface 247 1 0
    //   382: invokeinterface 244 1 0
    //   387: aload_2
    //   388: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	TraceLoggerManager
    //   0	389	1	paramBoolean	boolean
    //   59	11	2	localIterator	java.util.Iterator
    //   288	16	2	localObject1	Object
    //   305	4	2	localException	Exception
    //   372	16	2	localObject2	Object
    //   90	176	3	str	String
    //   78	46	4	localObject3	Object
    //   145	99	5	arrayOfAtomicInteger	AtomicInteger[]
    //   133	148	6	localObject4	Object
    //   186	81	7	localHashMap	java.util.HashMap
    //   3	364	8	l	long
    // Exception table:
    //   from	to	target	type
    //   45	60	288	finally
    //   60	113	288	finally
    //   113	167	288	finally
    //   167	285	288	finally
    //   31	45	305	java/lang/Exception
    //   289	305	305	java/lang/Exception
    //   314	342	305	java/lang/Exception
    //   351	371	305	java/lang/Exception
    //   373	389	305	java/lang/Exception
    //   342	351	372	finally
  }
  
  private void updateMsgHeader(CharSequence... paramVarArgs)
  {
    this.msgHeaderBuffer = buildStrHeader(new StringBuilder(), paramVarArgs).toString();
  }
  
  public ActionTraceLogger action(int paramInt, String paramString)
  {
    return new ActionTraceLogger(paramInt, "core", paramString);
  }
  
  public ActionTraceLogger action(int paramInt, String paramString1, String paramString2)
  {
    return new ActionTraceLogger(paramInt, paramString1, paramString2);
  }
  
  public ActionTraceLogger action(String paramString)
  {
    return new ActionTraceLogger(7, "core", paramString);
  }
  
  public ActionTraceLogger action(String paramString1, String paramString2)
  {
    return new ActionTraceLogger(7, paramString1, paramString2);
  }
  
  /* Error */
  public void actionCountTrack(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   7: invokeinterface 164 1 0
    //   12: invokeinterface 169 1 0
    //   17: aload_0
    //   18: getfield 46	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrack	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 268 2 0
    //   27: checkcast 171	java/util/Map
    //   30: astore 6
    //   32: aload 6
    //   34: ifnull +16 -> 50
    //   37: aload 6
    //   39: aload_2
    //   40: invokeinterface 268 2 0
    //   45: checkcast 201	[Ljava/util/concurrent/atomic/AtomicInteger;
    //   48: astore 5
    //   50: aload_0
    //   51: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   54: invokeinterface 164 1 0
    //   59: invokeinterface 244 1 0
    //   64: aload 5
    //   66: ifnonnull +230 -> 296
    //   69: aload_0
    //   70: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   73: invokeinterface 247 1 0
    //   78: invokeinterface 169 1 0
    //   83: aload_0
    //   84: getfield 46	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrack	Ljava/util/Map;
    //   87: aload_1
    //   88: invokeinterface 268 2 0
    //   93: checkcast 171	java/util/Map
    //   96: astore 6
    //   98: aload 6
    //   100: ifnonnull +90 -> 190
    //   103: new 208	java/util/HashMap
    //   106: dup
    //   107: invokespecial 209	java/util/HashMap:<init>	()V
    //   110: astore 6
    //   112: aload_0
    //   113: getfield 46	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrack	Ljava/util/Map;
    //   116: aload_1
    //   117: aload 6
    //   119: invokeinterface 219 3 0
    //   124: pop
    //   125: aload 5
    //   127: astore_1
    //   128: aload_1
    //   129: astore 5
    //   131: aload_1
    //   132: ifnonnull +84 -> 216
    //   135: iconst_4
    //   136: anewarray 203	java/util/concurrent/atomic/AtomicInteger
    //   139: astore 5
    //   141: iconst_0
    //   142: istore 7
    //   144: iload 7
    //   146: aload 5
    //   148: arraylength
    //   149: if_icmpge +56 -> 205
    //   152: aload 5
    //   154: iload 7
    //   156: new 203	java/util/concurrent/atomic/AtomicInteger
    //   159: dup
    //   160: invokespecial 269	java/util/concurrent/atomic/AtomicInteger:<init>	()V
    //   163: aastore
    //   164: iload 7
    //   166: iconst_1
    //   167: iadd
    //   168: istore 7
    //   170: goto -26 -> 144
    //   173: astore_1
    //   174: aload_0
    //   175: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   178: invokeinterface 164 1 0
    //   183: invokeinterface 244 1 0
    //   188: aload_1
    //   189: athrow
    //   190: aload 6
    //   192: aload_2
    //   193: invokeinterface 268 2 0
    //   198: checkcast 201	[Ljava/util/concurrent/atomic/AtomicInteger;
    //   201: astore_1
    //   202: goto -74 -> 128
    //   205: aload 6
    //   207: aload_2
    //   208: aload 5
    //   210: invokeinterface 219 3 0
    //   215: pop
    //   216: aload_0
    //   217: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   220: invokeinterface 247 1 0
    //   225: invokeinterface 244 1 0
    //   230: iload_3
    //   231: ifeq +44 -> 275
    //   234: aload 5
    //   236: iconst_0
    //   237: aaload
    //   238: invokevirtual 272	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   241: pop
    //   242: aload 5
    //   244: iconst_1
    //   245: aaload
    //   246: iload 4
    //   248: invokevirtual 276	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   251: pop
    //   252: aload_0
    //   253: iconst_0
    //   254: invokespecial 278	com/alibaba/sdk/android/trace/TraceLoggerManager:sendActionCountTrack	(Z)V
    //   257: return
    //   258: astore_1
    //   259: aload_0
    //   260: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   263: invokeinterface 247 1 0
    //   268: invokeinterface 244 1 0
    //   273: aload_1
    //   274: athrow
    //   275: aload 5
    //   277: iconst_2
    //   278: aaload
    //   279: invokevirtual 272	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   282: pop
    //   283: aload 5
    //   285: iconst_3
    //   286: aaload
    //   287: iload 4
    //   289: invokevirtual 276	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   292: pop
    //   293: goto -41 -> 252
    //   296: goto -66 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	TraceLoggerManager
    //   0	299	1	paramString1	String
    //   0	299	2	paramString2	String
    //   0	299	3	paramBoolean	boolean
    //   0	299	4	paramInt	int
    //   1	283	5	localObject1	Object
    //   30	176	6	localObject2	Object
    //   142	27	7	i	int
    // Exception table:
    //   from	to	target	type
    //   17	32	173	finally
    //   37	50	173	finally
    //   83	98	258	finally
    //   103	125	258	finally
    //   135	141	258	finally
    //   144	164	258	finally
    //   190	202	258	finally
    //   205	216	258	finally
  }
  
  protected void finalize()
  {
    release();
    super.finalize();
  }
  
  public void init(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    for (;;)
    {
      try
      {
        updateMsgHeader(new CharSequence[] { TraceHelper.clientTTID, paramString });
        this.logCatDebug = paramBoolean1;
        if (paramBoolean1) {
          continue;
        }
        this.sdkLevel = 4;
        this.uncaughtExceptionTraceHandler.init(KernelContext.context);
      }
      catch (Exception paramString)
      {
        Log.w("AliSDK", paramString);
        continue;
      }
      finally {}
      return;
      this.sdkLevel |= 0x2;
      if (paramBoolean2) {
        this.sdkLevel |= 0x1;
      }
    }
  }
  
  public boolean isLogCatDebugEnabled()
  {
    return this.logCatDebug;
  }
  
  public void log(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt2 == 6) || ((this.sdkLevel & 0x1 & paramInt1) > 0) || ((this.sdkLevel & 0x2 & paramInt1) > 0)) {
      logCat("AliSDK", paramInt2, paramString1, paramString2, paramString3);
    }
  }
  
  public void log(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    if (((this.sdkLevel & 0x1 & paramInt1) > 0) || ((this.sdkLevel & 0x2 & paramInt1) > 0)) {
      logCat(paramString1, paramInt2, paramString2, paramString3, paramString4);
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: invokespecial 278	com/alibaba/sdk/android/trace/TraceLoggerManager:sendActionCountTrack	(Z)V
    //   7: aload_0
    //   8: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   11: invokeinterface 247 1 0
    //   16: invokeinterface 169 1 0
    //   21: aload_0
    //   22: getfield 46	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrack	Ljava/util/Map;
    //   25: invokeinterface 250 1 0
    //   30: aload_0
    //   31: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   34: invokeinterface 247 1 0
    //   39: invokeinterface 244 1 0
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 51	com/alibaba/sdk/android/trace/TraceLoggerManager:actionCountTrackLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   52: invokeinterface 247 1 0
    //   57: invokeinterface 244 1 0
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TraceLoggerManager
    //   47	16	1	localObject1	Object
    //   64	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	30	47	finally
    //   2	21	64	finally
    //   30	44	64	finally
    //   48	64	64	finally
  }
  
  public void setUserTrackerService(UserTrackerService paramUserTrackerService)
  {
    this.userTrackerService = paramUserTrackerService;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\trace\TraceLoggerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */