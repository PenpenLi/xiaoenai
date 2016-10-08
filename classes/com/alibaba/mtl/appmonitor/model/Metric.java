package com.alibaba.mtl.appmonitor.model;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Metric
  implements b
{
  private DimensionSet jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet;
  private MeasureSet jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet;
  private boolean g;
  private String o;
  private String p;
  private String r;
  private String s;
  private String z = null;
  
  @Deprecated
  public Metric() {}
  
  public Metric(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean)
  {
    this.o = paramString1;
    this.p = paramString2;
    this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet = paramDimensionSet;
    this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet = paramMeasureSet;
    this.s = null;
    this.g = paramBoolean;
  }
  
  private Measure a(String paramString, List<Measure> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Measure localMeasure = (Measure)paramList.next();
        if (TextUtils.equals(paramString, localMeasure.name)) {
          return localMeasure;
        }
      }
    }
    return null;
  }
  
  public void clean()
  {
    this.o = null;
    this.p = null;
    this.s = null;
    this.g = false;
    this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet = null;
    this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet = null;
    this.r = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Metric)paramObject;
        if (this.s == null)
        {
          if (((Metric)paramObject).s != null) {
            return false;
          }
        }
        else if (!this.s.equals(((Metric)paramObject).s)) {
          return false;
        }
        if (this.o == null)
        {
          if (((Metric)paramObject).o != null) {
            return false;
          }
        }
        else if (!this.o.equals(((Metric)paramObject).o)) {
          return false;
        }
        if (this.p != null) {
          break;
        }
      } while (((Metric)paramObject).p == null);
      return false;
    } while (this.p.equals(((Metric)paramObject).p));
    return false;
  }
  
  public void fill(Object... paramVarArgs)
  {
    this.o = ((String)paramVarArgs[0]);
    this.p = ((String)paramVarArgs[1]);
    if (paramVarArgs.length > 2) {
      this.s = ((String)paramVarArgs[2]);
    }
  }
  
  public DimensionSet getDimensionSet()
  {
    return this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet;
  }
  
  public MeasureSet getMeasureSet()
  {
    return this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet;
  }
  
  public String getModule()
  {
    return this.o;
  }
  
  public String getMonitorPoint()
  {
    return this.p;
  }
  
  public String getTransactionId()
  {
    try
    {
      if (this.r == null) {
        this.r = (UUID.randomUUID().toString() + "$" + this.o + "$" + this.p);
      }
      String str = this.r;
      return str;
    }
    finally {}
  }
  
  public int hashCode()
  {
    int k = 0;
    int i;
    int j;
    if (this.s == null)
    {
      i = 0;
      if (this.o != null) {
        break label53;
      }
      j = 0;
      label20:
      if (this.p != null) {
        break label64;
      }
    }
    for (;;)
    {
      return (j + (i + 31) * 31) * 31 + k;
      i = this.s.hashCode();
      break;
      label53:
      j = this.o.hashCode();
      break label20;
      label64:
      k = this.p.hashCode();
    }
  }
  
  /* Error */
  public boolean isCommitDetail()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 118
    //   4: aload_0
    //   5: getfield 24	com/alibaba/mtl/appmonitor/model/Metric:z	Ljava/lang/String;
    //   8: invokevirtual 122	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +9 -> 22
    //   16: iconst_1
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: ldc 124
    //   24: aload_0
    //   25: getfield 24	com/alibaba/mtl/appmonitor/model/Metric:z	Ljava/lang/String;
    //   28: invokevirtual 122	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   31: ifeq +8 -> 39
    //   34: iconst_0
    //   35: istore_2
    //   36: goto -18 -> 18
    //   39: aload_0
    //   40: getfield 39	com/alibaba/mtl/appmonitor/model/Metric:g	Z
    //   43: istore_2
    //   44: goto -26 -> 18
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	Metric
    //   47	4	1	localObject	Object
    //   11	33	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	47	finally
    //   22	34	47	finally
    //   39	44	47	finally
  }
  
  public void resetTransactionId()
  {
    this.r = null;
  }
  
  public void setCommitDetailFromConfig(String paramString)
  {
    try
    {
      this.z = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean valid(DimensionValueSet paramDimensionValueSet, MeasureValueSet paramMeasureValueSet)
  {
    boolean bool2 = true;
    if (this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet != null) {}
    for (boolean bool1 = this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelDimensionSet.valid(paramDimensionValueSet);; bool1 = true)
    {
      paramDimensionValueSet = MetricRepo.getRepo().getMetric("config_prefix" + this.o, "config_prefix" + this.p);
      if ((paramDimensionValueSet != null) && (paramDimensionValueSet.getMeasureSet() != null) && (paramMeasureValueSet != null) && (paramMeasureValueSet.getMap() != null) && (this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet != null))
      {
        List localList = paramDimensionValueSet.getMeasureSet().getMeasures();
        Iterator localIterator = paramMeasureValueSet.getMap().keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Measure localMeasure = a(str, localList);
          paramDimensionValueSet = localMeasure;
          if (localMeasure == null) {
            paramDimensionValueSet = a(str, this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet.getMeasures());
          }
          if ((paramDimensionValueSet == null) || (!paramDimensionValueSet.valid(paramMeasureValueSet.getValue(str)))) {
            return false;
          }
        }
        return bool1;
      }
      if (this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet != null) {
        if ((bool1) && (this.jdField_b_of_type_ComAlibabaMtlAppmonitorModelMeasureSet.valid(paramMeasureValueSet))) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\Metric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */