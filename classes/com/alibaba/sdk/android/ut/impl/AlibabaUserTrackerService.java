package com.alibaba.sdk.android.ut.impl;

import android.app.Activity;
import android.content.Context;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.ut.UTCrashCaughtListener;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.ut.device.UTDevice;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders.UTCustomHitBuilder;
import com.ut.mini.UTTracker;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;

public class AlibabaUserTrackerService
  implements UserTrackerService, IUTCrashCaughtListner
{
  public static final UserTrackerService INSTANCE = new AlibabaUserTrackerService();
  private static final String TAG = AlibabaUserTrackerService.class.getSimpleName();
  private String appKey;
  private String appVersion;
  private Context context;
  
  private void initBaseRequestAuthentication()
  {
    String str2 = AlibabaSDK.getGlobalProperty("com.alibaba.app.appsecret");
    UTAnalytics localUTAnalytics = UTAnalytics.getInstance();
    String str3 = this.appKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "appSecret";
    }
    localUTAnalytics.setRequestAuthentication(new UTBaseRequestAuthentication(str3, str1));
  }
  
  private boolean isSecurityGuardAvaiable()
  {
    try
    {
      Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public String getDefaultUserTrackerId()
  {
    return UTDevice.getUtdid(this.context);
  }
  
  /* Error */
  public void init(AppContext paramAppContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokeinterface 87 1 0
    //   9: putfield 50	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:appKey	Ljava/lang/String;
    //   12: aload_0
    //   13: aload_1
    //   14: invokeinterface 91 1 0
    //   19: putfield 74	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:context	Landroid/content/Context;
    //   22: ldc 93
    //   24: ldc 95
    //   26: ldc 97
    //   28: invokestatic 101	com/alibaba/sdk/android/AlibabaSDK:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +9 -> 43
    //   37: invokestatic 48	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   40: invokevirtual 110	com/ut/mini/UTAnalytics:turnOnDebug	()V
    //   43: ldc 95
    //   45: ldc 112
    //   47: invokestatic 101	com/alibaba/sdk/android/AlibabaSDK:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 118	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   53: invokevirtual 121	java/lang/Boolean:booleanValue	()Z
    //   56: ifeq +14 -> 70
    //   59: getstatic 26	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:TAG	Ljava/lang/String;
    //   62: ldc 123
    //   64: invokestatic 128	com/alibaba/sdk/android/trace/AliSDKLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: invokestatic 48	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   73: aload_0
    //   74: getfield 74	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:context	Landroid/content/Context;
    //   77: invokevirtual 132	com/ut/mini/UTAnalytics:setContext	(Landroid/content/Context;)V
    //   80: invokestatic 48	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   83: aload_0
    //   84: getfield 74	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:context	Landroid/content/Context;
    //   87: checkcast 134	android/app/Application
    //   90: invokevirtual 138	com/ut/mini/UTAnalytics:setAppApplicationInstance	(Landroid/app/Application;)V
    //   93: invokestatic 48	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   96: getstatic 143	com/alibaba/sdk/android/util/TraceHelper:channel	Ljava/lang/String;
    //   99: invokevirtual 147	com/ut/mini/UTAnalytics:setChannel	(Ljava/lang/String;)V
    //   102: ldc 95
    //   104: ldc -107
    //   106: invokestatic 101	com/alibaba/sdk/android/AlibabaSDK:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: invokestatic 118	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   112: invokevirtual 121	java/lang/Boolean:booleanValue	()Z
    //   115: ifeq +46 -> 161
    //   118: getstatic 26	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:TAG	Ljava/lang/String;
    //   121: ldc -105
    //   123: invokestatic 128	com/alibaba/sdk/android/trace/AliSDKLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_0
    //   127: invokespecial 153	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:initBaseRequestAuthentication	()V
    //   130: invokestatic 48	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   133: ldc -101
    //   135: invokevirtual 159	com/ut/mini/UTAnalytics:getTracker	(Ljava/lang/String;)Lcom/ut/mini/UTTracker;
    //   138: ldc -95
    //   140: getstatic 166	com/alibaba/sdk/android/ConfigManager:SDK_INTERNAL_VERSION	Ljava/lang/String;
    //   143: invokevirtual 171	com/ut/mini/UTTracker:setGlobalProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: invokestatic 48	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   149: aload_0
    //   150: invokevirtual 175	com/ut/mini/UTAnalytics:setCrashCaughtListener	(Lcom/ut/mini/crashhandler/IUTCrashCaughtListner;)V
    //   153: goto -86 -> 67
    //   156: astore_1
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: aload_0
    //   162: invokespecial 177	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:isSecurityGuardAvaiable	()Z
    //   165: ifne +32 -> 197
    //   168: getstatic 26	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:TAG	Ljava/lang/String;
    //   171: ldc -77
    //   173: invokestatic 128	com/alibaba/sdk/android/trace/AliSDKLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_0
    //   177: invokespecial 153	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:initBaseRequestAuthentication	()V
    //   180: goto -50 -> 130
    //   183: astore_1
    //   184: aload_1
    //   185: invokestatic 183	com/alibaba/sdk/android/trace/AliSDKLogger:printStackTraceAndMore	(Ljava/lang/Throwable;)V
    //   188: new 185	java/lang/RuntimeException
    //   191: dup
    //   192: aload_1
    //   193: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   196: athrow
    //   197: new 189	com/alibaba/sdk/android/ut/impl/AdvancedUTSecuritySDKRequestAuthentication
    //   200: dup
    //   201: aload_0
    //   202: getfield 50	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:appKey	Ljava/lang/String;
    //   205: aload_0
    //   206: getfield 74	com/alibaba/sdk/android/ut/impl/AlibabaUserTrackerService:context	Landroid/content/Context;
    //   209: invokespecial 192	com/alibaba/sdk/android/ut/impl/AdvancedUTSecuritySDKRequestAuthentication:<init>	(Ljava/lang/String;Landroid/content/Context;)V
    //   212: astore_1
    //   213: invokestatic 48	com/ut/mini/UTAnalytics:getInstance	()Lcom/ut/mini/UTAnalytics;
    //   216: aload_1
    //   217: invokevirtual 61	com/ut/mini/UTAnalytics:setRequestAuthentication	(Lcom/ut/mini/core/sign/IUTRequestAuthentication;)V
    //   220: goto -90 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	AlibabaUserTrackerService
    //   0	223	1	paramAppContext	AppContext
    // Exception table:
    //   from	to	target	type
    //   2	43	156	finally
    //   43	67	156	finally
    //   70	130	156	finally
    //   130	146	156	finally
    //   146	153	156	finally
    //   161	180	156	finally
    //   184	197	156	finally
    //   197	220	156	finally
    //   2	43	183	java/lang/Exception
    //   43	67	183	java/lang/Exception
    //   70	130	183	java/lang/Exception
    //   130	146	183	java/lang/Exception
    //   161	180	183	java/lang/Exception
    //   197	220	183	java/lang/Exception
  }
  
  public Map<String, String> onCrashCaught(Thread paramThread, Throwable paramThrowable)
  {
    HashMap localHashMap = new HashMap();
    if (UTContext.appContext != null)
    {
      UTCrashCaughtListener[] arrayOfUTCrashCaughtListener = (UTCrashCaughtListener[])UTContext.appContext.getServices(UTCrashCaughtListener.class, null);
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
  
  public void sendCustomHit(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3, Map<String, String> paramMap)
  {
    paramString1 = new UTOriginalCustomHitBuilder(paramString3, paramInt, paramString1, paramString2, String.valueOf(paramLong), paramMap);
    UTAnalytics.getInstance().getTracker("onesdk").send(paramString1.build());
  }
  
  public void sendCustomHit(String paramString1, long paramLong, String paramString2, Map<String, String> paramMap)
  {
    paramString1 = new UTHitBuilders.UTCustomHitBuilder(paramString1);
    paramString1.setDurationOnEvent(paramLong);
    paramString1.setEventPage(paramString2);
    paramString1.setProperties(paramMap);
    paramString1 = paramString1.build();
    UTAnalytics.getInstance().getTracker("onesdk").send(paramString1);
  }
  
  public void sendCustomHit(String paramString, Activity paramActivity)
  {
    if (paramActivity != null) {}
    for (paramActivity = paramActivity.getTitle().toString();; paramActivity = paramString)
    {
      sendCustomHit(paramString, 60L, paramActivity, null);
      return;
    }
  }
  
  public void sendCustomHit(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    sendCustomHit(paramString1, 60L, paramString2, paramMap);
  }
  
  public void updateUserTrackerProperties(Map<String, Object> paramMap)
  {
    if (paramMap == null) {}
    do
    {
      return;
      if (paramMap.containsKey("user_nick"))
      {
        String str2 = (String)paramMap.get("user_nick");
        UTAnalytics.getInstance().userRegister(str2);
        if (paramMap.containsKey("user_id"))
        {
          String str3 = (String)paramMap.get("user_id");
          UTAnalytics localUTAnalytics = UTAnalytics.getInstance();
          String str1 = str3;
          if (str3 == null) {
            str1 = str2;
          }
          localUTAnalytics.updateUserAccount(str2, str1);
        }
      }
      paramMap = (String)paramMap.get("app_version");
    } while ((paramMap == null) || (paramMap.equals(this.appVersion)));
    this.appVersion = paramMap;
    UTAnalytics.getInstance().setAppVersion(paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ut\impl\AlibabaUserTrackerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */