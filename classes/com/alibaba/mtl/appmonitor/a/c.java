package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.e.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  extends d
{
  private static final Long jdField_a_of_type_JavaLangLong = Long.valueOf(300000L);
  private Metric jdField_a_of_type_ComAlibabaMtlAppmonitorModelMetric;
  private DimensionValueSet jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet;
  private MeasureValueSet jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet;
  private Long jdField_b_of_type_JavaLangLong;
  private Map<String, MeasureValue> f;
  
  public DimensionValueSet a()
  {
    return this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet;
  }
  
  public MeasureValueSet a()
  {
    return this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet;
  }
  
  public void a(DimensionValueSet paramDimensionValueSet)
  {
    if (this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet == null)
    {
      this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet = paramDimensionValueSet;
      return;
    }
    this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet.addValues(paramDimensionValueSet);
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (this.f.isEmpty()) {
      this.jdField_b_of_type_JavaLangLong = Long.valueOf(l);
    }
    MeasureValue localMeasureValue = (MeasureValue)a.a().a(MeasureValue.class, new Object[] { Double.valueOf(l), Double.valueOf(l - this.jdField_b_of_type_JavaLangLong.longValue()) });
    this.f.put(paramString, localMeasureValue);
  }
  
  public boolean a(String paramString)
  {
    MeasureValue localMeasureValue = (MeasureValue)this.f.get(paramString);
    if (localMeasureValue != null)
    {
      long l = System.currentTimeMillis();
      i.a("DurationEvent", new Object[] { "statEvent consumeTime. module:", this.o, " monitorPoint:", this.p, " measureName:", paramString, " time:", Double.valueOf(l - localMeasureValue.getValue()) });
      localMeasureValue.setValue(l - localMeasureValue.getValue());
      localMeasureValue.setFinish(true);
      this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet.setValue(paramString, localMeasureValue);
      if (this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMetric.getMeasureSet().valid(this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet)) {
        return true;
      }
    }
    return false;
  }
  
  public void clean()
  {
    super.clean();
    this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMetric = null;
    this.jdField_b_of_type_JavaLangLong = null;
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext())
    {
      MeasureValue localMeasureValue = (MeasureValue)localIterator.next();
      a.a().a(localMeasureValue);
    }
    this.f.clear();
    if (this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet != null)
    {
      a.a().a(this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet);
      this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet = null;
    }
    if (this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet != null)
    {
      a.a().a(this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet);
      this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet = null;
    }
  }
  
  public boolean e()
  {
    long l = System.currentTimeMillis();
    List localList = this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMetric.getMeasureSet().getMeasures();
    if (localList != null)
    {
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (Measure)localList.get(i);
        if (localObject != null)
        {
          if (((Measure)localObject).getMax() != null) {}
          for (double d = ((Measure)localObject).getMax().doubleValue();; d = jdField_a_of_type_JavaLangLong.longValue())
          {
            localObject = (MeasureValue)this.f.get(((Measure)localObject).getName());
            if ((localObject == null) || (((MeasureValue)localObject).isFinish()) || (l - ((MeasureValue)localObject).getValue() <= d)) {
              break;
            }
            return true;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void fill(Object... paramVarArgs)
  {
    super.fill(paramVarArgs);
    if (this.f == null) {
      this.f = new HashMap();
    }
    this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMetric = MetricRepo.getRepo().getMetric(this.o, this.p);
    if (this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMetric.getDimensionSet() != null)
    {
      this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet = ((DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]));
      this.jdField_a_of_type_ComAlibabaMtlAppmonitorModelMetric.getDimensionSet().setConstantValue(this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionValueSet);
    }
    this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureValueSet = ((MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */