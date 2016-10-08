package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class AppMonitor
{
  public static final String TAG = "AppMonitor";
  private static Application jdField_a_of_type_AndroidAppApplication = null;
  private static ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static b jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$b = b.b;
  private static c jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c = null;
  protected static IMonitor a;
  private static Object jdField_a_of_type_JavaLangObject;
  private static String jdField_a_of_type_JavaLangString;
  private static List<a> jdField_a_of_type_JavaUtilList;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean;
  private static String jdField_c_of_type_JavaLangString;
  private static boolean jdField_c_of_type_Boolean;
  private static String d;
  private static Context mContext;
  
  static
  {
    jdField_a_of_type_AndroidOsHandlerThread = null;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    jdField_b_of_type_Boolean = false;
    try
    {
      System.loadLibrary("ut_c_api");
      Log.i("AppMonitor", "load ut_c_api.so success");
      jdField_a_of_type_AndroidContentServiceConnection = new AppMonitor.5();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.w("AppMonitor", "load ut_c_api.so failed");
      }
    }
  }
  
  private static int a(f paramf)
  {
    return paramf.a();
  }
  
  private static Runnable a()
  {
    return new AppMonitor.6();
  }
  
  private static Runnable a(String paramString)
  {
    return new AppMonitor.8(paramString);
  }
  
  private static Runnable a(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean)
  {
    return new AppMonitor.9(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean);
  }
  
  private static Runnable a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    return new AppMonitor.7(paramBoolean, paramString1, paramString2, paramString3);
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 29
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc -123
    //   13: aastore
    //   14: invokestatic 138	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: getstatic 70	com/alibaba/mtl/appmonitor/AppMonitor:jdField_b_of_type_Boolean	Z
    //   20: ifeq +123 -> 143
    //   23: iconst_0
    //   24: putstatic 70	com/alibaba/mtl/appmonitor/AppMonitor:jdField_b_of_type_Boolean	Z
    //   27: invokestatic 140	com/alibaba/mtl/appmonitor/AppMonitor:b	()V
    //   30: invokestatic 142	com/alibaba/mtl/appmonitor/AppMonitor:a	()Ljava/lang/Runnable;
    //   33: invokeinterface 147 1 0
    //   38: getstatic 149	com/alibaba/mtl/appmonitor/AppMonitor:jdField_c_of_type_Boolean	Z
    //   41: getstatic 151	com/alibaba/mtl/appmonitor/AppMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   44: getstatic 153	com/alibaba/mtl/appmonitor/AppMonitor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   47: getstatic 155	com/alibaba/mtl/appmonitor/AppMonitor:d	Ljava/lang/String;
    //   50: invokestatic 157	com/alibaba/mtl/appmonitor/AppMonitor:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Runnable;
    //   53: invokeinterface 147 1 0
    //   58: getstatic 159	com/alibaba/mtl/appmonitor/AppMonitor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   61: invokestatic 161	com/alibaba/mtl/appmonitor/AppMonitor:a	(Ljava/lang/String;)Ljava/lang/Runnable;
    //   64: invokeinterface 147 1 0
    //   69: getstatic 68	com/alibaba/mtl/appmonitor/AppMonitor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   72: astore_0
    //   73: aload_0
    //   74: monitorenter
    //   75: iconst_0
    //   76: istore_2
    //   77: iload_2
    //   78: getstatic 68	com/alibaba/mtl/appmonitor/AppMonitor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   81: invokeinterface 166 1 0
    //   86: if_icmpge +55 -> 141
    //   89: getstatic 68	com/alibaba/mtl/appmonitor/AppMonitor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   92: iload_2
    //   93: invokeinterface 170 2 0
    //   98: checkcast 18	com/alibaba/mtl/appmonitor/AppMonitor$a
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +31 -> 134
    //   106: aload_1
    //   107: getfield 173	com/alibaba/mtl/appmonitor/AppMonitor$a:o	Ljava/lang/String;
    //   110: aload_1
    //   111: getfield 176	com/alibaba/mtl/appmonitor/AppMonitor$a:p	Ljava/lang/String;
    //   114: aload_1
    //   115: getfield 179	com/alibaba/mtl/appmonitor/AppMonitor$a:jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet	Lcom/alibaba/mtl/appmonitor/model/MeasureSet;
    //   118: aload_1
    //   119: getfield 182	com/alibaba/mtl/appmonitor/AppMonitor$a:jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet	Lcom/alibaba/mtl/appmonitor/model/DimensionSet;
    //   122: aload_1
    //   123: getfield 185	com/alibaba/mtl/appmonitor/AppMonitor$a:g	Z
    //   126: invokestatic 187	com/alibaba/mtl/appmonitor/AppMonitor:a	(Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)Ljava/lang/Runnable;
    //   129: invokeinterface 147 1 0
    //   134: iload_2
    //   135: iconst_1
    //   136: iadd
    //   137: istore_2
    //   138: goto -61 -> 77
    //   141: aload_0
    //   142: monitorexit
    //   143: ldc 2
    //   145: monitorexit
    //   146: return
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: astore_0
    //   153: goto -10 -> 143
    //   156: astore_0
    //   157: ldc 2
    //   159: monitorexit
    //   160: aload_0
    //   161: athrow
    //   162: astore_1
    //   163: goto -29 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   72	77	0	localList	List
    //   152	1	0	localThrowable1	Throwable
    //   156	5	0	localObject1	Object
    //   101	22	1	locala	a
    //   147	4	1	localObject2	Object
    //   162	1	1	localThrowable2	Throwable
    //   76	62	2	i	int
    // Exception table:
    //   from	to	target	type
    //   77	102	147	finally
    //   106	134	147	finally
    //   141	143	147	finally
    //   148	150	147	finally
    //   17	75	152	java/lang/Throwable
    //   150	152	152	java/lang/Throwable
    //   3	17	156	finally
    //   17	75	156	finally
    //   150	152	156	finally
    //   106	134	162	java/lang/Throwable
  }
  
  private static void a(Exception paramException)
  {
    i.a("AppMonitor", "", paramException);
    if ((paramException instanceof DeadObjectException)) {
      a();
    }
  }
  
  private static void a(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean)
  {
    try
    {
      a locala = new a();
      locala.o = paramString1;
      locala.p = paramString2;
      locala.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet = paramMeasureSet;
      locala.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet = paramDimensionSet;
      locala.g = paramBoolean;
      jdField_a_of_type_JavaUtilList.add(locala);
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_AndroidAppApplication == null) {
      return false;
    }
    boolean bool = jdField_a_of_type_AndroidAppApplication.getApplicationContext().bindService(new Intent(jdField_a_of_type_AndroidAppApplication.getApplicationContext(), AppMonitorService.class), jdField_a_of_type_AndroidContentServiceConnection, 1);
    if (!bool) {
      b();
    }
    i.a("AppMonitor", new Object[] { "bindsuccess:", Boolean.valueOf(bool) });
    return bool;
  }
  
  private static void b()
  {
    jdField_a_of_type_ComAlibabaMtlAppmonitorIMonitor = new Monitor(jdField_a_of_type_AndroidAppApplication);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$b = b.b;
    i.a("AppMonitor", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
  }
  
  private static boolean b()
  {
    if (!jdField_a_of_type_Boolean) {
      i.a("AppMonitor", new Object[] { "Please call init() before call other method" });
    }
    return jdField_a_of_type_Boolean;
  }
  
  /* Error */
  @Deprecated
  public static void destroy()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 251	com/alibaba/mtl/appmonitor/AppMonitor:b	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 255	com/alibaba/mtl/appmonitor/AppMonitor$1
    //   18: dup
    //   19: invokespecial 256	com/alibaba/mtl/appmonitor/AppMonitor$1:<init>	()V
    //   22: astore_0
    //   23: getstatic 50	com/alibaba/mtl/appmonitor/AppMonitor:jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c	Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   26: aload_0
    //   27: invokevirtual 259	com/alibaba/mtl/appmonitor/AppMonitor$c:a	(Ljava/lang/Runnable;)V
    //   30: goto -19 -> 11
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	local1	AppMonitor.1
    //   33	5	0	localObject	Object
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	33	finally
    //   15	30	33	finally
  }
  
  public static void enableLog(boolean paramBoolean)
  {
    if (!b()) {
      return;
    }
    AppMonitor.13 local13 = new AppMonitor.13(paramBoolean);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(local13);
  }
  
  public static void init(Application paramApplication)
  {
    for (;;)
    {
      try
      {
        i.a("AppMonitor", new Object[] { "[init]" });
        try
        {
          if (!jdField_a_of_type_Boolean)
          {
            jdField_a_of_type_AndroidAppApplication = paramApplication;
            if (jdField_a_of_type_AndroidAppApplication != null) {
              mContext = jdField_a_of_type_AndroidAppApplication.getApplicationContext();
            }
            jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AppMonitor_Client");
            jdField_a_of_type_AndroidOsHandlerThread.start();
            jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c = new c(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
            if (jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$b != b.b) {
              continue;
            }
            b();
            jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(a());
            jdField_a_of_type_Boolean = true;
          }
        }
        catch (Throwable paramApplication)
        {
          continue;
        }
        return;
      }
      finally {}
      if (a()) {
        jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(true);
      }
    }
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet)
  {
    if (!b()) {
      return;
    }
    AppMonitor.14 local14 = new AppMonitor.14(paramString1, paramString2, paramMeasureSet);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(local14);
    a(paramString1, paramString2, paramMeasureSet, null, false);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet)
  {
    if (!b()) {
      return;
    }
    AppMonitor.16 local16 = new AppMonitor.16(paramString1, paramString2, paramMeasureSet, paramDimensionSet);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(local16);
    a(paramString1, paramString2, paramMeasureSet, paramDimensionSet, false);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean)
  {
    if (!b()) {
      return;
    }
    registerInternal(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean, false);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean)
  {
    if (!b()) {
      return;
    }
    AppMonitor.15 local15 = new AppMonitor.15(paramString1, paramString2, paramMeasureSet, paramBoolean);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(local15);
    a(paramString1, paramString2, paramMeasureSet, null, paramBoolean);
  }
  
  public static void register(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean)
  {
    int j = 0;
    Object localObject1;
    if (paramArrayOfString1 == null)
    {
      localObject1 = "null";
      if (paramArrayOfString2 != null) {
        break label143;
      }
    }
    int i;
    label143:
    for (Object localObject2 = "null";; localObject2 = new JSONArray(Arrays.asList(paramArrayOfString2)).toString())
    {
      i.a("AppMonitor", new Object[] { "[register]", "module:", paramString1, "measures:", localObject1, "dimensions:", localObject2, "isCommitDetail:", Boolean.valueOf(paramBoolean) });
      if (paramArrayOfString1 == null) {
        break label217;
      }
      localObject2 = MeasureSet.create();
      i = 0;
      while (i < paramArrayOfString1.length)
      {
        ((MeasureSet)localObject2).addMeasure(paramArrayOfString1[i]);
        i += 1;
      }
      localObject1 = new JSONArray(Arrays.asList(paramArrayOfString1)).toString();
      break;
    }
    paramArrayOfString1 = null;
    if (paramArrayOfString2 != null)
    {
      localObject1 = DimensionSet.create();
      i = j;
      for (;;)
      {
        paramArrayOfString1 = (String[])localObject1;
        if (i >= paramArrayOfString2.length) {
          break;
        }
        ((DimensionSet)localObject1).addDimension(paramArrayOfString2[i]);
        i += 1;
      }
    }
    register(paramString1, paramString2, (MeasureSet)localObject2, paramArrayOfString1, paramBoolean);
    return;
    label217:
    i.a("AppMonitor", new Object[] { "register failed:no mearsure" });
  }
  
  public static void registerInternal(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!b()) {
      return;
    }
    i.a("AppMonitor", new Object[] { "[registerInternal] : module:", paramString1, "monitorPoint:", paramString2, "measures:", paramMeasureSet, "dimensions:", paramDimensionSet, "isCommitDetail:", Boolean.valueOf(paramBoolean1), "isInternal:", Boolean.valueOf(paramBoolean2) });
    if (!paramBoolean2) {
      a(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean1);
    }
    paramString1 = a(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean1);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(paramString1);
  }
  
  public static void setChannel(String paramString)
  {
    if (!b()) {
      return;
    }
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(a(paramString));
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (!b()) {
      return;
    }
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(a(paramBoolean, paramString1, paramString2, paramString3));
    jdField_c_of_type_Boolean = paramBoolean;
    jdField_b_of_type_JavaLangString = paramString1;
    jdField_c_of_type_JavaLangString = paramString2;
    d = paramString3;
  }
  
  public static void setSampling(int paramInt)
  {
    if (!b()) {
      return;
    }
    AppMonitor.12 local12 = new AppMonitor.12(paramInt);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(local12);
  }
  
  public static void setStatisticsInterval(int paramInt)
  {
    if (!b()) {
      return;
    }
    AppMonitor.11 local11 = new AppMonitor.11(paramInt);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(local11);
  }
  
  public static void setStatisticsInterval(f paramf, int paramInt)
  {
    if (!b()) {
      return;
    }
    paramf = new AppMonitor.2(a(paramf), paramInt);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(paramf);
  }
  
  /* Error */
  @Deprecated
  public static void triggerUpload()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 247	com/alibaba/mtl/appmonitor/AppMonitor:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 392	com/alibaba/mtl/appmonitor/AppMonitor$10
    //   18: dup
    //   19: invokespecial 393	com/alibaba/mtl/appmonitor/AppMonitor$10:<init>	()V
    //   22: astore_0
    //   23: getstatic 50	com/alibaba/mtl/appmonitor/AppMonitor:jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c	Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   26: aload_0
    //   27: invokevirtual 259	com/alibaba/mtl/appmonitor/AppMonitor$c:a	(Ljava/lang/Runnable;)V
    //   30: goto -19 -> 11
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	local10	AppMonitor.10
    //   33	5	0	localObject	Object
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	33	finally
    //   15	30	33	finally
  }
  
  public static void turnOffRealTimeDebug()
  {
    if (!b()) {
      return;
    }
    AppMonitor.4 local4 = new AppMonitor.4();
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(local4);
  }
  
  public static void turnOnRealTimeDebug(Map<String, String> paramMap)
  {
    if (!b()) {
      return;
    }
    paramMap = new AppMonitor.3(paramMap);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.a(paramMap);
  }
  
  public static void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    i.a("AppMonitor", new Object[] { "[updateMeasure]" });
    if (!b()) {
      return;
    }
    paramString1 = new AppMonitor.17(paramString1, paramString2, paramString3, paramDouble1, paramDouble2, paramDouble3);
    jdField_a_of_type_ComAlibabaMtlAppmonitorAppMonitor$c.post(paramString1);
  }
  
  public static class Alarm
  {
    @Deprecated
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      if (AppMonitor.a == null) {
        return false;
      }
      try
      {
        boolean bool = AppMonitor.a.alarm_checkSampled(paramString1, paramString2);
        return bool;
      }
      catch (RemoteException paramString1)
      {
        AppMonitor.b(paramString1);
      }
      return false;
    }
    
    public static void commitFail(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Alarm.5(paramString1, paramString2, paramString3, paramString4);
      AppMonitor.a().a(paramString1);
    }
    
    public static void commitFail(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Alarm.6(paramString1, paramString2, paramString3, paramString4, paramString5);
      AppMonitor.a().a(paramString1);
    }
    
    public static void commitSuccess(String paramString1, String paramString2)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Alarm.3(paramString1, paramString2);
      AppMonitor.a().a(paramString1);
    }
    
    public static void commitSuccess(String paramString1, String paramString2, String paramString3)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Alarm.4(paramString1, paramString2, paramString3);
      AppMonitor.a().a(paramString1);
    }
    
    public static void setSampling(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.Alarm.2 local2 = new AppMonitor.Alarm.2(paramInt);
      AppMonitor.a().a(local2);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.Alarm.1 local1 = new AppMonitor.Alarm.1(paramInt);
      AppMonitor.a().a(local1);
    }
  }
  
  public static class Counter
  {
    @Deprecated
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      if (AppMonitor.a == null) {
        return false;
      }
      try
      {
        boolean bool = AppMonitor.a.counter_checkSampled(paramString1, paramString2);
        return bool;
      }
      catch (RemoteException paramString1)
      {
        AppMonitor.b(paramString1);
      }
      return false;
    }
    
    public static void commit(String paramString1, String paramString2, double paramDouble)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Counter.3(paramString1, paramString2, paramDouble);
      AppMonitor.a().a(paramString1);
    }
    
    public static void commit(String paramString1, String paramString2, String paramString3, double paramDouble)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Counter.4(paramString1, paramString2, paramString3, paramDouble);
      AppMonitor.a().a(paramString1);
    }
    
    public static void setSampling(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.Counter.2 local2 = new AppMonitor.Counter.2(paramInt);
      AppMonitor.a().a(local2);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.Counter.1 local1 = new AppMonitor.Counter.1(paramInt);
      AppMonitor.a().a(local1);
    }
  }
  
  public static class OffLineCounter
  {
    @Deprecated
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      if (AppMonitor.a == null) {
        return false;
      }
      try
      {
        boolean bool = AppMonitor.a.offlinecounter_checkSampled(paramString1, paramString2);
        return bool;
      }
      catch (RemoteException paramString1)
      {
        AppMonitor.b(paramString1);
      }
      return false;
    }
    
    public static void commit(String paramString1, String paramString2, double paramDouble)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.OffLineCounter.3(paramString1, paramString2, paramDouble);
      AppMonitor.a().a(paramString1);
    }
    
    public static void setSampling(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.OffLineCounter.2 local2 = new AppMonitor.OffLineCounter.2(paramInt);
      AppMonitor.a().a(local2);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.OffLineCounter.1 local1 = new AppMonitor.OffLineCounter.1(paramInt);
      AppMonitor.a().a(local1);
    }
  }
  
  public static class Stat
  {
    public static void begin(String paramString1, String paramString2, String paramString3)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Stat.3(paramString1, paramString2, paramString3);
      AppMonitor.a().a(paramString1);
    }
    
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      if (AppMonitor.a == null) {
        return false;
      }
      try
      {
        boolean bool = AppMonitor.a.stat_checkSampled(paramString1, paramString2);
        return bool;
      }
      catch (RemoteException paramString1)
      {
        AppMonitor.b(paramString1);
      }
      return false;
    }
    
    public static void commit(String paramString1, String paramString2, double paramDouble)
    {
      commit(paramString1, paramString2, null, paramDouble);
    }
    
    public static void commit(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, double paramDouble)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Stat.5(paramString1, paramString2, paramDimensionValueSet, paramDouble);
      AppMonitor.a().a(paramString1);
    }
    
    public static void commit(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Stat.6(paramString1, paramString2, paramDimensionValueSet, paramMeasureValueSet);
      AppMonitor.a().a(paramString1);
    }
    
    public static void commit(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
    {
      i.a("AppMonitor", new Object[] { "[commit from jni]" });
      DimensionValueSet localDimensionValueSet;
      int i;
      if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length == paramArrayOfString2.length))
      {
        localDimensionValueSet = DimensionValueSet.create();
        i = 0;
        while (i < paramArrayOfString2.length)
        {
          localDimensionValueSet.setValue(paramArrayOfString1[i], paramArrayOfString2[i]);
          i += 1;
        }
      }
      for (paramArrayOfString1 = localDimensionValueSet;; paramArrayOfString1 = null)
      {
        if ((paramArrayOfString3 != null) && (paramArrayOfString4 != null) && (paramArrayOfString3.length == paramArrayOfString4.length))
        {
          paramArrayOfString2 = MeasureValueSet.create();
          i = 0;
          for (;;)
          {
            if (i < paramArrayOfString4.length)
            {
              double d2 = 0.0D;
              double d1 = d2;
              if (!TextUtils.isEmpty(paramArrayOfString4[i])) {}
              try
              {
                d1 = Double.valueOf(paramArrayOfString4[i]).doubleValue();
                paramArrayOfString2.setValue(paramArrayOfString3[i], d1);
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  i.a("AppMonitor", new Object[] { "measure's value cannot convert to double. measurevalue:" + paramArrayOfString4[i] });
                  d1 = d2;
                }
              }
            }
          }
        }
        for (;;)
        {
          commit(paramString1, paramString2, paramArrayOfString1, paramArrayOfString2);
          return;
          i.a("AppMonitor", new Object[] { "measure is null ,or lenght not match" });
          paramArrayOfString2 = null;
        }
      }
    }
    
    public static Transaction createTransaction(String paramString1, String paramString2)
    {
      return createTransaction(paramString1, paramString2, null);
    }
    
    public static Transaction createTransaction(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet)
    {
      return new Transaction(Integer.valueOf(f.d.a()), paramString1, paramString2, paramDimensionValueSet);
    }
    
    public static void end(String paramString1, String paramString2, String paramString3)
    {
      if (!AppMonitor.c()) {
        return;
      }
      paramString1 = new AppMonitor.Stat.4(paramString1, paramString2, paramString3);
      AppMonitor.a().a(paramString1);
    }
    
    public static void setSampling(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.Stat.2 local2 = new AppMonitor.Stat.2(paramInt);
      AppMonitor.a().a(local2);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      if (!AppMonitor.c()) {
        return;
      }
      AppMonitor.Stat.1 local1 = new AppMonitor.Stat.1(paramInt);
      AppMonitor.a().a(local1);
    }
  }
  
  static class a
  {
    public DimensionSet b;
    public MeasureSet b;
    public boolean g;
    public String o;
    public String p;
  }
  
  static enum b
  {
    private b() {}
  }
  
  static class c
    extends Handler
  {
    private boolean h = false;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    public void a(Runnable paramRunnable)
    {
      if (paramRunnable == null) {
        return;
      }
      try
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = paramRunnable;
        sendMessage(localMessage);
        return;
      }
      catch (Throwable paramRunnable) {}
    }
    
    public void a(boolean paramBoolean)
    {
      this.h = true;
    }
    
    /* Error */
    public void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/alibaba/mtl/appmonitor/AppMonitor$c:h	Z
      //   4: ifeq +25 -> 29
      //   7: aload_0
      //   8: iconst_0
      //   9: putfield 15	com/alibaba/mtl/appmonitor/AppMonitor$c:h	Z
      //   12: invokestatic 46	com/alibaba/mtl/appmonitor/AppMonitor:a	()Ljava/lang/Object;
      //   15: astore_2
      //   16: aload_2
      //   17: monitorenter
      //   18: invokestatic 46	com/alibaba/mtl/appmonitor/AppMonitor:a	()Ljava/lang/Object;
      //   21: ldc2_w 47
      //   24: invokevirtual 54	java/lang/Object:wait	(J)V
      //   27: aload_2
      //   28: monitorexit
      //   29: aload_1
      //   30: getfield 34	android/os/Message:obj	Ljava/lang/Object;
      //   33: ifnull +29 -> 62
      //   36: aload_1
      //   37: getfield 34	android/os/Message:obj	Ljava/lang/Object;
      //   40: instanceof 56
      //   43: istore 4
      //   45: iload 4
      //   47: ifeq +15 -> 62
      //   50: aload_1
      //   51: getfield 34	android/os/Message:obj	Ljava/lang/Object;
      //   54: checkcast 56	java/lang/Runnable
      //   57: invokeinterface 60 1 0
      //   62: aload_0
      //   63: aload_1
      //   64: invokespecial 62	android/os/Handler:handleMessage	(Landroid/os/Message;)V
      //   67: return
      //   68: astore_3
      //   69: invokestatic 65	com/alibaba/mtl/appmonitor/AppMonitor:d	()V
      //   72: goto -45 -> 27
      //   75: astore_3
      //   76: aload_2
      //   77: monitorexit
      //   78: aload_3
      //   79: athrow
      //   80: astore_2
      //   81: goto -19 -> 62
      //   84: astore_2
      //   85: goto -23 -> 62
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	88	0	this	c
      //   0	88	1	paramMessage	Message
      //   15	62	2	localObject1	Object
      //   80	1	2	localThrowable1	Throwable
      //   84	1	2	localThrowable2	Throwable
      //   68	1	3	localInterruptedException	InterruptedException
      //   75	4	3	localObject2	Object
      //   43	3	4	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   18	27	68	java/lang/InterruptedException
      //   18	27	75	finally
      //   27	29	75	finally
      //   69	72	75	finally
      //   76	78	75	finally
      //   0	18	80	java/lang/Throwable
      //   29	45	80	java/lang/Throwable
      //   78	80	80	java/lang/Throwable
      //   50	62	84	java/lang/Throwable
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */