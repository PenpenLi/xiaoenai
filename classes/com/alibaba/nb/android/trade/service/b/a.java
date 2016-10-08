package com.alibaba.nb.android.trade.service.b;

import android.content.Context;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.ut.UTCrashCaughtListener;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders.UTCustomHitBuilder;
import com.ut.mini.UTTracker;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;
import java.util.HashMap;
import java.util.Map;

public class a
  implements b, IUTCrashCaughtListner
{
  public static final a a = new a();
  private static final String b = a.class.getSimpleName();
  private Context c;
  private String d;
  
  /* Error */
  private a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 34	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: invokestatic 40	com/alibaba/nb/android/trade/service/config/impl/AliTradeConfigServiceImpl:getInstance	()Lcom/alibaba/nb/android/trade/service/config/impl/AliTradeConfigServiceImpl;
    //   8: invokevirtual 43	com/alibaba/nb/android/trade/service/config/impl/AliTradeConfigServiceImpl:getAppKey	()Ljava/lang/String;
    //   11: putfield 45	com/alibaba/nb/android/trade/service/b/a:d	Ljava/lang/String;
    //   14: aload_0
    //   15: getstatic 50	com/alibaba/nb/android/trade/AliTradeContext:context	Landroid/content/Context;
    //   18: putfield 52	com/alibaba/nb/android/trade/service/b/a:c	Landroid/content/Context;
    //   21: getstatic 56	com/alibaba/nb/android/trade/AliTradeContext:isDebugMode	Z
    //   24: ifeq +13 -> 37
    //   27: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   30: invokevirtual 64	com/ut/mini/UTAnalytics:turnOnDebug	()V
    //   33: iconst_1
    //   34: invokestatic 70	com/alibaba/mtl/appmonitor/AppMonitor:enableLog	(Z)V
    //   37: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   40: aload_0
    //   41: getfield 52	com/alibaba/nb/android/trade/service/b/a:c	Landroid/content/Context;
    //   44: invokevirtual 74	com/ut/mini/UTAnalytics:setContext	(Landroid/content/Context;)V
    //   47: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   50: aload_0
    //   51: getfield 52	com/alibaba/nb/android/trade/service/b/a:c	Landroid/content/Context;
    //   54: invokevirtual 80	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   57: checkcast 82	android/app/Application
    //   60: invokevirtual 86	com/ut/mini/UTAnalytics:setAppApplicationInstance	(Landroid/app/Application;)V
    //   63: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   66: invokevirtual 89	com/ut/mini/UTAnalytics:turnOffCrashHandler	()V
    //   69: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   72: invokevirtual 92	com/ut/mini/UTAnalytics:turnOffAutoPageTrack	()V
    //   75: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   78: astore_1
    //   79: invokestatic 40	com/alibaba/nb/android/trade/service/config/impl/AliTradeConfigServiceImpl:getInstance	()Lcom/alibaba/nb/android/trade/service/config/impl/AliTradeConfigServiceImpl;
    //   82: pop
    //   83: aload_1
    //   84: getstatic 95	com/alibaba/nb/android/trade/service/config/impl/AliTradeConfigServiceImpl:channel	Ljava/lang/String;
    //   87: invokevirtual 99	com/ut/mini/UTAnalytics:setChannel	(Ljava/lang/String;)V
    //   90: invokestatic 102	com/alibaba/nb/android/trade/service/b/a:a	()Z
    //   93: ifne +67 -> 160
    //   96: getstatic 25	com/alibaba/nb/android/trade/service/b/a:b	Ljava/lang/String;
    //   99: ldc 104
    //   101: invokestatic 109	com/alibaba/nb/android/trade/utils/d/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: ldc 111
    //   106: invokestatic 117	com/alibaba/sdk/android/AlibabaSDK:getGlobalProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_2
    //   110: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   113: astore_3
    //   114: aload_0
    //   115: getfield 45	com/alibaba/nb/android/trade/service/b/a:d	Ljava/lang/String;
    //   118: astore 4
    //   120: aload_2
    //   121: astore_1
    //   122: aload_2
    //   123: ifnonnull +6 -> 129
    //   126: ldc 119
    //   128: astore_1
    //   129: aload_3
    //   130: new 121	com/ut/mini/core/sign/UTBaseRequestAuthentication
    //   133: dup
    //   134: aload 4
    //   136: aload_1
    //   137: invokespecial 123	com/ut/mini/core/sign/UTBaseRequestAuthentication:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: invokevirtual 127	com/ut/mini/UTAnalytics:setRequestAuthentication	(Lcom/ut/mini/core/sign/IUTRequestAuthentication;)V
    //   143: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   146: ldc -127
    //   148: invokevirtual 133	com/ut/mini/UTAnalytics:getTracker	(Ljava/lang/String;)Lcom/ut/mini/UTTracker;
    //   151: ldc -121
    //   153: getstatic 138	com/alibaba/nb/android/trade/AliTradeContext:sdkVersion	Ljava/lang/String;
    //   156: invokevirtual 143	com/ut/mini/UTTracker:setGlobalProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: return
    //   160: invokestatic 61	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   163: new 145	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication
    //   166: dup
    //   167: aload_0
    //   168: getfield 45	com/alibaba/nb/android/trade/service/b/a:d	Ljava/lang/String;
    //   171: ldc -109
    //   173: invokespecial 148	com/ut/mini/core/sign/UTSecuritySDKRequestAuthentication:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: invokevirtual 127	com/ut/mini/UTAnalytics:setRequestAuthentication	(Lcom/ut/mini/core/sign/IUTRequestAuthentication;)V
    //   179: goto -36 -> 143
    //   182: astore_1
    //   183: aload_1
    //   184: invokestatic 151	com/alibaba/nb/android/trade/utils/d/a:a	(Ljava/lang/Throwable;)V
    //   187: new 153	java/lang/RuntimeException
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	a
    //   78	59	1	localObject	Object
    //   182	10	1	localException	Exception
    //   109	14	2	str1	String
    //   113	17	3	localUTAnalytics	UTAnalytics
    //   118	17	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   4	37	182	java/lang/Exception
    //   37	120	182	java/lang/Exception
    //   129	143	182	java/lang/Exception
    //   143	159	182	java/lang/Exception
    //   160	179	182	java/lang/Exception
  }
  
  private static boolean a()
  {
    try
    {
      Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    b(paramString1, paramString2, paramMap);
  }
  
  public final void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    com.alibaba.nb.android.trade.utils.d.a.b(b, "调用ut打点，传入参数信息为：label=" + paramString1 + " time=60 page=" + paramString2 + " prop=" + paramMap);
    paramString1 = new UTHitBuilders.UTCustomHitBuilder(paramString1);
    paramString1.setDurationOnEvent(60L);
    paramString1.setEventPage(paramString2);
    paramString1.setProperties(paramMap);
    paramString1 = paramString1.build();
    com.alibaba.nb.android.trade.utils.d.a.b(b, "调用ut打点，经过UTHitBuilders构造后参数为：map=" + paramString1);
    UTAnalytics.getInstance().getTracker("aliTradesdk").send(paramString1);
  }
  
  public Map<String, String> onCrashCaught(Thread paramThread, Throwable paramThrowable)
  {
    HashMap localHashMap = new HashMap();
    if (KernelContext.serviceRegistry != null)
    {
      UTCrashCaughtListener[] arrayOfUTCrashCaughtListener = (UTCrashCaughtListener[])KernelContext.serviceRegistry.getServices(UTCrashCaughtListener.class, null);
      int j = arrayOfUTCrashCaughtListener.length;
      int i = 0;
      while (i < j)
      {
        Map localMap = arrayOfUTCrashCaughtListener[i].onCrashCaught(paramThread, paramThrowable);
        if (localMap != null) {
          localHashMap.putAll(localMap);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */