package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MeasureValueSet
  implements Parcelable, b
{
  public static final Parcelable.Creator<MeasureValueSet> CREATOR = new MeasureValueSet.1();
  private Map<String, MeasureValue> map = new LinkedHashMap();
  
  static MeasureValueSet a(Parcel paramParcel)
  {
    Object localObject = null;
    try
    {
      MeasureValueSet localMeasureValueSet = create();
      localObject = localMeasureValueSet;
      localMeasureValueSet.map = paramParcel.readHashMap(DimensionValueSet.class.getClassLoader());
      return localMeasureValueSet;
    }
    catch (Throwable paramParcel) {}
    return (MeasureValueSet)localObject;
  }
  
  private static Double a(String paramString)
  {
    try
    {
      paramString = Double.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static MeasureValueSet create()
  {
    return (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
  }
  
  @Deprecated
  public static MeasureValueSet create(int paramInt)
  {
    return (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
  }
  
  public static MeasureValueSet create(Map<String, Double> paramMap)
  {
    MeasureValueSet localMeasureValueSet = (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Double localDouble = (Double)paramMap.get(str);
        if (localDouble != null) {
          localMeasureValueSet.map.put(str, a.a().a(MeasureValue.class, new Object[] { localDouble }));
        }
      }
    }
    return localMeasureValueSet;
  }
  
  public static MeasureValueSet fromStringMap(Map<String, String> paramMap)
  {
    MeasureValueSet localMeasureValueSet = (MeasureValueSet)a.a().a(MeasureValueSet.class, new Object[0]);
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        Double localDouble = a((String)localEntry.getValue());
        if (localDouble != null) {
          localMeasureValueSet.map.put(localEntry.getKey(), a.a().a(MeasureValue.class, new Object[] { localDouble }));
        }
      }
    }
    return localMeasureValueSet;
  }
  
  public void clean()
  {
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext())
    {
      MeasureValue localMeasureValue = (MeasureValue)localIterator.next();
      a.a().a(localMeasureValue);
    }
    this.map.clear();
  }
  
  public boolean containValue(String paramString)
  {
    return this.map.containsKey(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void fill(Object... paramVarArgs)
  {
    if (this.map == null) {
      this.map = new LinkedHashMap();
    }
  }
  
  public Map<String, MeasureValue> getMap()
  {
    return this.map;
  }
  
  public MeasureValue getValue(String paramString)
  {
    return (MeasureValue)this.map.get(paramString);
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  public void merge(MeasureValueSet paramMeasureValueSet)
  {
    Iterator localIterator = this.map.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((MeasureValue)this.map.get(str)).merge(paramMeasureValueSet.getValue(str));
    }
  }
  
  public void setMap(Map<String, MeasureValue> paramMap)
  {
    this.map = paramMap;
  }
  
  public MeasureValueSet setValue(String paramString, double paramDouble)
  {
    this.map.put(paramString, a.a().a(MeasureValue.class, new Object[] { Double.valueOf(paramDouble) }));
    return this;
  }
  
  public void setValue(String paramString, MeasureValue paramMeasureValue)
  {
    this.map.put(paramString, paramMeasureValue);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.map);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MeasureValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */