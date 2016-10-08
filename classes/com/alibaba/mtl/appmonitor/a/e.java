package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.appmonitor.model.MetricValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.model.LogField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private static e jdField_a_of_type_ComAlibabaMtlAppmonitorAE;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private AtomicInteger b = new AtomicInteger(0);
  private AtomicInteger c = new AtomicInteger(0);
  private Map<String, c> g = new ConcurrentHashMap();
  private Map<UTDimensionValueSet, MetricValueSet> h = new ConcurrentHashMap();
  
  private d a(UTDimensionValueSet paramUTDimensionValueSet, String paramString1, String paramString2, String paramString3, Class<? extends d> paramClass)
  {
    if ((com.alibaba.mtl.appmonitor.f.b.d(paramString1)) && (com.alibaba.mtl.appmonitor.f.b.d(paramString2)))
    {
      Integer localInteger = paramUTDimensionValueSet.getEventId();
      if (localInteger != null) {
        synchronized (this.h)
        {
          MetricValueSet localMetricValueSet2 = (MetricValueSet)this.h.get(paramUTDimensionValueSet);
          MetricValueSet localMetricValueSet1 = localMetricValueSet2;
          if (localMetricValueSet2 == null)
          {
            localMetricValueSet1 = (MetricValueSet)com.alibaba.mtl.appmonitor.c.a.a().a(MetricValueSet.class, new Object[0]);
            this.h.put(paramUTDimensionValueSet, localMetricValueSet1);
          }
          return localMetricValueSet1.getEvent(localInteger, paramString1, paramString2, paramString3, paramClass);
        }
      }
    }
    return null;
  }
  
  public static e a()
  {
    try
    {
      if (jdField_a_of_type_ComAlibabaMtlAppmonitorAE == null) {
        jdField_a_of_type_ComAlibabaMtlAppmonitorAE = new e();
      }
      e locale = jdField_a_of_type_ComAlibabaMtlAppmonitorAE;
      return locale;
    }
    finally {}
  }
  
  private UTDimensionValueSet a(int paramInt)
  {
    UTDimensionValueSet localUTDimensionValueSet = (UTDimensionValueSet)com.alibaba.mtl.appmonitor.c.a.a().a(UTDimensionValueSet.class, new Object[0]);
    localUTDimensionValueSet.setValue(LogField.ACCESS.toString(), com.alibaba.mtl.log.a.b());
    localUTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), com.alibaba.mtl.log.a.c());
    localUTDimensionValueSet.setValue(LogField.USERID.toString(), com.alibaba.mtl.log.a.d());
    localUTDimensionValueSet.setValue(LogField.USERNICK.toString(), com.alibaba.mtl.log.a.e());
    localUTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(paramInt));
    return localUTDimensionValueSet;
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString1 = MetricRepo.getRepo().getMetric(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.getTransactionId();
    }
    return null;
  }
  
  private void a(f paramf, AtomicInteger paramAtomicInteger)
  {
    int i = paramAtomicInteger.incrementAndGet();
    i.a("EventRepo", new String[] { paramf.toString(), " EVENT size:", String.valueOf(i) });
    if (i >= paramf.b())
    {
      i.a("EventRepo", new Object[] { paramf.toString(), " event size exceed trigger count." });
      paramAtomicInteger.set(0);
      a(paramf.a());
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = MetricRepo.getRepo().getMetric(paramString1, paramString2);
    if (paramString1 != null) {
      paramString1.resetTransactionId();
    }
  }
  
  public Map<UTDimensionValueSet, List<d>> a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      synchronized (this.h)
      {
        ArrayList localArrayList = new ArrayList(this.h.keySet());
        int j = localArrayList.size();
        i = 0;
        if (i < j)
        {
          UTDimensionValueSet localUTDimensionValueSet = (UTDimensionValueSet)localArrayList.get(i);
          if ((localUTDimensionValueSet != null) && (localUTDimensionValueSet.getEventId().intValue() == paramInt))
          {
            localHashMap.put(localUTDimensionValueSet, ((MetricValueSet)this.h.get(localUTDimensionValueSet)).getEvents());
            this.h.remove(localUTDimensionValueSet);
          }
        }
        else
        {
          return localHashMap;
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    Map localMap = a(paramInt);
    r.a().b(new e.1(this, localMap));
  }
  
  public void a(int paramInt, String paramString1, String paramString2, MeasureValueSet paramMeasureValueSet, DimensionValueSet paramDimensionValueSet)
  {
    Object localObject = MetricRepo.getRepo().getMetric(paramString1, paramString2);
    if (localObject != null)
    {
      if (((Metric)localObject).getDimensionSet() != null) {
        ((Metric)localObject).getDimensionSet().setConstantValue(paramDimensionValueSet);
      }
      if (((Metric)localObject).getMeasureSet() != null) {
        ((Metric)localObject).getMeasureSet().setConstantValue(paramMeasureValueSet);
      }
      localObject = a(paramInt);
      ((g)a((UTDimensionValueSet)localObject, paramString1, paramString2, null, g.class)).a(paramDimensionValueSet, paramMeasureValueSet);
      if (com.alibaba.mtl.log.a.a.g())
      {
        paramString1 = (g)com.alibaba.mtl.appmonitor.c.a.a().a(g.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        paramString1.a(paramDimensionValueSet, paramMeasureValueSet);
        com.alibaba.mtl.appmonitor.f.c.a((UTDimensionValueSet)localObject, paramString1);
      }
      a(f.a(paramInt), this.c);
      return;
    }
    i.a("EventRepo", "metric is null");
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    UTDimensionValueSet localUTDimensionValueSet = a(paramInt);
    ((a)a(localUTDimensionValueSet, paramString1, paramString2, paramString3, a.class)).f();
    if (com.alibaba.mtl.log.a.a.g())
    {
      paramString1 = (a)com.alibaba.mtl.appmonitor.c.a.a().a(a.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
      paramString1.f();
      com.alibaba.mtl.appmonitor.f.c.a(localUTDimensionValueSet, paramString1);
    }
    a(f.a(paramInt), this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    UTDimensionValueSet localUTDimensionValueSet = a(paramInt);
    ((b)a(localUTDimensionValueSet, paramString1, paramString2, paramString3, b.class)).a(paramDouble);
    if (com.alibaba.mtl.log.a.a.g())
    {
      paramString1 = (b)com.alibaba.mtl.appmonitor.c.a.a().a(b.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
      paramString1.a(paramDouble);
      com.alibaba.mtl.appmonitor.f.c.a(localUTDimensionValueSet, paramString1);
    }
    a(f.a(paramInt), this.b);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    UTDimensionValueSet localUTDimensionValueSet = a(paramInt);
    a locala = (a)a(localUTDimensionValueSet, paramString1, paramString2, paramString3, a.class);
    locala.g();
    locala.a(paramString4, paramString5);
    if (com.alibaba.mtl.log.a.a.g())
    {
      paramString1 = (a)com.alibaba.mtl.appmonitor.c.a.a().a(a.class, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
      paramString1.g();
      paramString1.a(paramString4, paramString5);
      com.alibaba.mtl.appmonitor.f.c.a(localUTDimensionValueSet, paramString1);
    }
    a(f.a(paramInt), this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
  }
  
  public void a(Integer paramInteger, String paramString1, String paramString2, String paramString3)
  {
    String str = a(paramString1, paramString2);
    if (str != null) {
      a(str, paramInteger, paramString1, paramString2, paramString3);
    }
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, DimensionValueSet paramDimensionValueSet)
  {
    try
    {
      c localc2 = (c)this.g.get(paramString1);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = (c)com.alibaba.mtl.appmonitor.c.a.a().a(c.class, new Object[] { paramInteger, paramString2, paramString3 });
        this.g.put(paramString1, localc1);
      }
      localc1.a(paramDimensionValueSet);
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = MetricRepo.getRepo().getMetric(paramString2, paramString3);
    if ((localObject != null) && (((Metric)localObject).getMeasureSet() != null) && (((Metric)localObject).getMeasureSet().getMeasure(paramString4) != null)) {}
    try
    {
      c localc = (c)this.g.get(paramString1);
      localObject = localc;
      if (localc == null)
      {
        localObject = (c)com.alibaba.mtl.appmonitor.c.a.a().a(c.class, new Object[] { paramInteger, paramString2, paramString3 });
        this.g.put(paramString1, localObject);
      }
      ((c)localObject).a(paramString4);
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 != null) {
      a(paramString1, paramString3, true);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    c localc = (c)this.g.get(paramString1);
    if ((localc != null) && (localc.a(paramString2)))
    {
      this.g.remove(paramString1);
      if (paramBoolean) {
        b(localc.o, localc.p);
      }
      a(localc.e, localc.o, localc.p, localc.a(), localc.a());
      com.alibaba.mtl.appmonitor.c.a.a().a(localc);
    }
  }
  
  public void h()
  {
    ArrayList localArrayList = new ArrayList(this.g.keySet());
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)localArrayList.get(i);
      c localc = (c)this.g.get(str);
      if ((localc != null) && (localc.e())) {
        this.g.remove(str);
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */