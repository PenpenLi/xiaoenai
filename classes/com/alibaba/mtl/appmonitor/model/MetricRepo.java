package com.alibaba.mtl.appmonitor.model;

import java.util.ArrayList;
import java.util.List;

public class MetricRepo
{
  private static MetricRepo a;
  public List<Metric> metrics;
  
  private MetricRepo(int paramInt)
  {
    this.metrics = new ArrayList(paramInt);
  }
  
  public static MetricRepo getRepo()
  {
    if (a == null) {
      a = new MetricRepo(3);
    }
    return a;
  }
  
  public static MetricRepo getRepo(int paramInt)
  {
    return new MetricRepo(paramInt);
  }
  
  public void add(Metric paramMetric)
  {
    if (!this.metrics.contains(paramMetric)) {
      this.metrics.add(paramMetric);
    }
  }
  
  public Metric getMetric(String paramString1, String paramString2)
  {
    Object localObject;
    if ((paramString1 == null) || (paramString2 == null) || (this.metrics == null))
    {
      localObject = null;
      return (Metric)localObject;
    }
    int j = this.metrics.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label97;
      }
      Metric localMetric = (Metric)this.metrics.get(i);
      if ((localMetric != null) && (localMetric.getModule().equals(paramString1)))
      {
        localObject = localMetric;
        if (localMetric.getMonitorPoint().equals(paramString2)) {
          break;
        }
      }
      i += 1;
    }
    label97:
    return null;
  }
  
  public boolean remove(Metric paramMetric)
  {
    if (this.metrics.contains(paramMetric)) {
      return this.metrics.remove(paramMetric);
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MetricRepo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */