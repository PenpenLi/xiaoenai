package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MetricValueSet
  implements b
{
  private Map<Metric, d> l = Collections.synchronizedMap(new HashMap());
  
  public void clean()
  {
    Iterator localIterator = this.l.values().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      a.a().a(locald);
    }
    this.l.clear();
  }
  
  public void fill(Object... paramVarArgs)
  {
    if (this.l == null) {
      this.l = Collections.synchronizedMap(new HashMap());
    }
  }
  
  public d getEvent(Integer paramInteger, String paramString1, String paramString2, String paramString3, Class<? extends d> paramClass)
  {
    int i = 1;
    Metric localMetric;
    Integer localInteger;
    if (paramInteger.intValue() == f.d.a())
    {
      localMetric = MetricRepo.getRepo().getMetric(paramString1, paramString2);
      i = 0;
      localInteger = null;
      if (localMetric != null)
      {
        if (!this.l.containsKey(localMetric)) {
          break label121;
        }
        paramInteger = (d)this.l.get(localMetric);
      }
    }
    for (;;)
    {
      localInteger = paramInteger;
      if (i != 0)
      {
        a.a().a(localMetric);
        localInteger = paramInteger;
      }
      return localInteger;
      localMetric = (Metric)a.a().a(Metric.class, new Object[] { paramString1, paramString2, paramString3 });
      break;
      try
      {
        label121:
        paramInteger = (d)a.a().a(paramClass, new Object[] { paramInteger, paramString1, paramString2, paramString3 });
        this.l.put(localMetric, paramInteger);
        i = 0;
      }
      finally {}
    }
  }
  
  public List<d> getEvents()
  {
    return new ArrayList(this.l.values());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MetricValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */