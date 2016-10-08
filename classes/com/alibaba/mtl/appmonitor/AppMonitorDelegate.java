package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.m;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.sign.BaseRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppMonitorDelegate
{
  public static final String DEFAULT_VALUE = "defaultValue";
  public static boolean IS_DEBUG = false;
  public static final String MAX_VALUE = "maxValue";
  public static final String MIN_VALUE = "minValue";
  public static final String TAG = "AppMonitorDelegate";
  private static Application b;
  static volatile boolean i = false;
  
  public static void destroy()
  {
    try
    {
      i.a("AppMonitorDelegate", new Object[] { "start destory" });
      if (i)
      {
        c.e();
        c.destroy();
        b.destroy();
        if (b != null) {
          l.c(b.getApplicationContext());
        }
        i = false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.alibaba.mtl.appmonitor.b.b.a(localThrowable);
      }
    }
    finally {}
  }
  
  public static void enableLog(boolean paramBoolean)
  {
    i.a("AppMonitorDelegate", new Object[] { "[enableLog]" });
    i.d(paramBoolean);
  }
  
  /* Error */
  public static void init(Application paramApplication)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 32
    //   5: iconst_1
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 96
    //   13: aastore
    //   14: invokestatic 56	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: getstatic 41	com/alibaba/mtl/appmonitor/AppMonitorDelegate:i	Z
    //   20: ifne +35 -> 55
    //   23: aload_0
    //   24: putstatic 68	com/alibaba/mtl/appmonitor/AppMonitorDelegate:b	Landroid/app/Application;
    //   27: aload_0
    //   28: invokevirtual 74	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   31: invokestatic 100	com/alibaba/mtl/log/a:init	(Landroid/content/Context;)V
    //   34: invokestatic 102	com/alibaba/mtl/appmonitor/b:init	()V
    //   37: invokestatic 103	com/alibaba/mtl/appmonitor/c:init	()V
    //   40: aload_0
    //   41: invokestatic 107	com/alibaba/mtl/appmonitor/a:init	(Landroid/app/Application;)V
    //   44: aload_0
    //   45: invokevirtual 74	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   48: invokestatic 109	com/alibaba/mtl/log/e/l:b	(Landroid/content/Context;)V
    //   51: iconst_1
    //   52: putstatic 41	com/alibaba/mtl/appmonitor/AppMonitorDelegate:i	Z
    //   55: ldc 2
    //   57: monitorexit
    //   58: return
    //   59: astore_0
    //   60: invokestatic 110	com/alibaba/mtl/appmonitor/AppMonitorDelegate:destroy	()V
    //   63: goto -8 -> 55
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramApplication	Application
    // Exception table:
    //   from	to	target	type
    //   17	55	59	java/lang/Throwable
    //   3	17	66	finally
    //   17	55	66	finally
    //   60	63	66	finally
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet)
  {
    register(paramString1, paramString2, paramMeasureSet, null);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet)
  {
    register(paramString1, paramString2, paramMeasureSet, paramDimensionSet, false);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean)
  {
    try
    {
      if (i)
      {
        if ((!com.alibaba.mtl.appmonitor.f.b.isBlank(paramString1)) && (!com.alibaba.mtl.appmonitor.f.b.isBlank(paramString2))) {
          break label69;
        }
        i.a("AppMonitorDelegate", new Object[] { "register stat event. module: ", paramString1, " monitorPoint: ", paramString2 });
        if (IS_DEBUG) {
          throw new com.alibaba.mtl.appmonitor.b.a("register error. module and monitorPoint can't be null");
        }
      }
    }
    catch (Throwable paramString1)
    {
      com.alibaba.mtl.appmonitor.b.b.a(paramString1);
    }
    return;
    label69:
    paramString1 = new Metric(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean);
    MetricRepo.getRepo().add(paramString1);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean)
  {
    register(paramString1, paramString2, paramMeasureSet, null, paramBoolean);
  }
  
  public static void setChannel(String paramString)
  {
    com.alibaba.mtl.log.a.setChannel(paramString);
  }
  
  public static void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean) {}
    for (paramString1 = new SecurityRequestAuth(paramString1, paramString3);; paramString1 = new BaseRequestAuth(paramString1, paramString2))
    {
      com.alibaba.mtl.log.a.a(paramString1);
      m.a().init(b);
      return;
    }
  }
  
  public static void setSampling(int paramInt)
  {
    int j = 0;
    i.a("AppMonitorDelegate", new Object[] { "[setSampling]" });
    f[] arrayOff = f.a();
    int k = arrayOff.length;
    while (j < k)
    {
      f localf = arrayOff[j];
      localf.c(paramInt);
      m.a().a(localf, paramInt);
      j += 1;
    }
  }
  
  public static void setStatisticsInterval(int paramInt)
  {
    f[] arrayOff = f.a();
    int k = arrayOff.length;
    int j = 0;
    while (j < k)
    {
      f localf = arrayOff[j];
      localf.setStatisticsInterval(paramInt);
      setStatisticsInterval(localf, paramInt);
      j += 1;
    }
  }
  
  static void setStatisticsInterval(f paramf, int paramInt)
  {
    try
    {
      if ((i) && (paramf != null))
      {
        c.a(paramf.a(), paramInt);
        if (paramInt > 0)
        {
          paramf.b(true);
          return;
        }
        paramf.b(false);
        return;
      }
    }
    catch (Throwable paramf)
    {
      com.alibaba.mtl.appmonitor.b.b.a(paramf);
    }
  }
  
  public static void triggerUpload()
  {
    try
    {
      i.a("AppMonitorDelegate", new Object[] { "triggerUpload" });
      if ((i) && (com.alibaba.mtl.log.a.a.h())) {
        c.e();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.alibaba.mtl.appmonitor.b.b.a(localThrowable);
      }
    }
    finally {}
  }
  
  public static void turnOffRealTimeDebug()
  {
    i.a("AppMonitorDelegate", new Object[] { "[turnOffRealTimeDebug]" });
  }
  
  public static void turnOnRealTimeDebug(Map<String, String> paramMap)
  {
    com.alibaba.mtl.log.a.a.turnOnRealTimeDebug(paramMap);
  }
  
  public static void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    i.a("AppMonitorDelegate", new Object[] { "[updateMeasure]" });
    try
    {
      if ((i) && (!com.alibaba.mtl.appmonitor.f.b.isBlank(paramString1)))
      {
        if (com.alibaba.mtl.appmonitor.f.b.isBlank(paramString2)) {
          return;
        }
        paramString1 = MetricRepo.getRepo().getMetric(paramString1, paramString2);
        if ((paramString1 != null) && (paramString1.getMeasureSet() != null))
        {
          paramString1.getMeasureSet().upateMeasure(new Measure(paramString3, Double.valueOf(paramDouble3), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2)));
          return;
        }
      }
    }
    catch (Exception paramString1) {}
  }
  
  public static class Alarm
  {
    @Deprecated
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      return m.a(f.a, paramString1, paramString2);
    }
    
    public static void commitFail(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      commitFail(paramString1, paramString2, null, paramString3, paramString4);
    }
    
    public static void commitFail(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          i.a("AppMonitorDelegate", "module & monitorPoint must not null");
          return;
        }
        com.alibaba.mtl.log.b.a.z();
        HashMap localHashMap = new HashMap();
        localHashMap.put("_status", "0");
        if ((AppMonitorDelegate.i) && (com.alibaba.mtl.log.a.a.h()) && (f.a.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(paramString1, paramString2, Boolean.valueOf(false), localHashMap))))
        {
          i.a("AppMonitorDelegate", new Object[] { "commitFail module:", paramString1, " monitorPoint:", paramString2, " errorCode:", paramString4, "errorMsg:", paramString5 });
          com.alibaba.mtl.log.b.a.A();
          e.a().a(f.a.a(), paramString1, paramString2, paramString3, paramString4, paramString5);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramString1);
        return;
      }
      i.a("log discard !", "");
    }
    
    public static void commitSuccess(String paramString1, String paramString2)
    {
      commitSuccess(paramString1, paramString2, null);
    }
    
    public static void commitSuccess(String paramString1, String paramString2, String paramString3)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          i.a("AppMonitorDelegate", "module & monitorPoint must not null");
          return;
        }
        com.alibaba.mtl.log.b.a.z();
        if ((AppMonitorDelegate.i) && (com.alibaba.mtl.log.a.a.h()) && (f.a.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(paramString1, paramString2, Boolean.valueOf(true), null))))
        {
          i.a("AppMonitorDelegate", new Object[] { "commitSuccess module:", paramString1, " monitorPoint:", paramString2 });
          com.alibaba.mtl.log.b.a.A();
          e.a().a(f.a.a(), paramString1, paramString2, paramString3);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramString1);
        return;
      }
      i.a("log discard !", "");
    }
    
    public static void setSampling(int paramInt)
    {
      m.a().a(f.a, paramInt);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      f.a.setStatisticsInterval(paramInt);
      AppMonitorDelegate.setStatisticsInterval(f.a, paramInt);
    }
  }
  
  public static class Counter
  {
    @Deprecated
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      return m.a(f.b, paramString1, paramString2);
    }
    
    public static void commit(String paramString1, String paramString2, double paramDouble)
    {
      commit(paramString1, paramString2, null, paramDouble);
    }
    
    public static void commit(String paramString1, String paramString2, String paramString3, double paramDouble)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          i.a("AppMonitorDelegate", "module & monitorPoint must not null");
          return;
        }
        com.alibaba.mtl.log.b.a.x();
        if ((AppMonitorDelegate.i) && (com.alibaba.mtl.log.a.a.h()) && (f.b.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(f.b, paramString1, paramString2))))
        {
          i.a("AppMonitorDelegate", new Object[] { "commitCount module: ", paramString1, " monitorPoint: ", paramString2, " value: ", Double.valueOf(paramDouble) });
          com.alibaba.mtl.log.b.a.y();
          e.a().a(f.b.a(), paramString1, paramString2, paramString3, paramDouble);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramString1);
      }
    }
    
    public static void setSampling(int paramInt)
    {
      m.a().a(f.b, paramInt);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      f.b.setStatisticsInterval(paramInt);
      AppMonitorDelegate.setStatisticsInterval(f.b, paramInt);
    }
  }
  
  public static class OffLineCounter
  {
    @Deprecated
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      return m.a(f.c, paramString1, paramString2);
    }
    
    public static void commit(String paramString1, String paramString2, double paramDouble)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          i.a("AppMonitorDelegate", "module & monitorPoint must not null");
          return;
        }
        com.alibaba.mtl.log.b.a.v();
        if ((AppMonitorDelegate.i) && (com.alibaba.mtl.log.a.a.h()) && (f.c.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(f.c, paramString1, paramString2))))
        {
          i.a("AppMonitorDelegate", new Object[] { "commitOffLineCount module: ", paramString1, " monitorPoint: ", paramString2, " value: ", Double.valueOf(paramDouble) });
          com.alibaba.mtl.log.b.a.w();
          e.a().a(f.c.a(), paramString1, paramString2, null, paramDouble);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramString1);
      }
    }
    
    public static void setSampling(int paramInt)
    {
      m.a().a(f.c, paramInt);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      f.c.setStatisticsInterval(paramInt);
      AppMonitorDelegate.setStatisticsInterval(f.c, paramInt);
    }
  }
  
  public static class Stat
  {
    public static void begin(String paramString1, String paramString2, String paramString3)
    {
      try
      {
        if ((AppMonitorDelegate.i) && (com.alibaba.mtl.log.a.a.h()) && (f.d.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(f.d, paramString1, paramString2))))
        {
          i.a("AppMonitorDelegate", new Object[] { "statEvent begin. module: ", paramString1, " monitorPoint: ", paramString2, " measureName: ", paramString3 });
          e.a().a(Integer.valueOf(f.d.a()), paramString1, paramString2, paramString3);
        }
        return;
      }
      catch (Throwable paramString1)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramString1);
      }
    }
    
    @Deprecated
    public static boolean checkSampled(String paramString1, String paramString2)
    {
      return m.a(f.d, paramString1, paramString2);
    }
    
    public static void commit(String paramString1, String paramString2, double paramDouble)
    {
      commit(paramString1, paramString2, null, paramDouble);
    }
    
    public static void commit(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, double paramDouble)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          i.a("AppMonitorDelegate", "module & monitorPoint must not null");
          return;
        }
        com.alibaba.mtl.log.b.a.t();
        if ((AppMonitorDelegate.i) && (com.alibaba.mtl.log.a.a.h()) && (f.d.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(f.d, paramString1, paramString2))))
        {
          i.a("AppMonitorDelegate", new Object[] { "statEvent commit. module: ", paramString1, " monitorPoint: ", paramString2 });
          Object localObject = MetricRepo.getRepo().getMetric(paramString1, paramString2);
          com.alibaba.mtl.log.b.a.u();
          if (localObject != null)
          {
            localObject = ((Metric)localObject).getMeasureSet().getMeasures();
            if (((List)localObject).size() == 1)
            {
              localObject = ((Measure)((List)localObject).get(0)).getName();
              commit(paramString1, paramString2, paramDimensionValueSet, ((MeasureValueSet)com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0])).setValue((String)localObject, paramDouble));
              return;
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramString1);
      }
    }
    
    public static void commit(String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet)
    {
      for (;;)
      {
        try
        {
          if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
          {
            i.a("AppMonitorDelegate", "module & monitorPoint must not null");
            return;
          }
          com.alibaba.mtl.log.b.a.t();
          if ((!AppMonitorDelegate.i) || (!com.alibaba.mtl.log.a.a.h()) || (!f.d.isOpen())) {
            break;
          }
          if (!AppMonitorDelegate.IS_DEBUG)
          {
            f localf = f.d;
            if (paramDimensionValueSet != null)
            {
              localMap = paramDimensionValueSet.getMap();
              if (!m.a(localf, paramString1, paramString2, localMap)) {
                break;
              }
            }
          }
          else
          {
            i.a("statEvent commit success", new Object[] { "statEvent commit. module: ", paramString1, " monitorPoint: ", paramString2 });
            com.alibaba.mtl.log.b.a.u();
            e.a().a(f.d.a(), paramString1, paramString2, paramMeasureValueSet, paramDimensionValueSet);
            return;
          }
        }
        catch (Throwable paramString1)
        {
          com.alibaba.mtl.appmonitor.b.b.a(paramString1);
          return;
        }
        Map localMap = null;
      }
      i.a("statEvent commit failed,log discard", new Object[] { " ,. module: ", paramString1, " monitorPoint: ", paramString2 });
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
      try
      {
        if ((AppMonitorDelegate.i) && (com.alibaba.mtl.log.a.a.h()) && (f.d.isOpen()) && ((AppMonitorDelegate.IS_DEBUG) || (m.a(f.d, paramString1, paramString2))))
        {
          i.a("AppMonitorDelegate", new Object[] { "statEvent end. module: ", paramString1, " monitorPoint: ", paramString2, " measureName: ", paramString3 });
          e.a().a(paramString1, paramString2, paramString3);
        }
        return;
      }
      catch (Throwable paramString1)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramString1);
      }
    }
    
    public static void setSampling(int paramInt)
    {
      m.a().a(f.d, paramInt);
    }
    
    public static void setStatisticsInterval(int paramInt)
    {
      f.d.setStatisticsInterval(paramInt);
      AppMonitorDelegate.setStatisticsInterval(f.d, paramInt);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitorDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */