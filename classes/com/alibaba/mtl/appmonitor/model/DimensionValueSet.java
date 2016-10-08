package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DimensionValueSet
  implements Parcelable, b
{
  public static final Parcelable.Creator<DimensionValueSet> CREATOR = new DimensionValueSet.1();
  protected Map<String, String> map;
  
  @Deprecated
  public DimensionValueSet()
  {
    if (this.map == null) {
      this.map = new LinkedHashMap();
    }
  }
  
  static DimensionValueSet a(Parcel paramParcel)
  {
    try
    {
      localDimensionValueSet = create();
      paramParcel.printStackTrace();
    }
    catch (Throwable paramParcel)
    {
      try
      {
        localDimensionValueSet.map = paramParcel.readHashMap(DimensionValueSet.class.getClassLoader());
        return localDimensionValueSet;
      }
      catch (Throwable paramParcel)
      {
        DimensionValueSet localDimensionValueSet;
        for (;;) {}
      }
      paramParcel = paramParcel;
      localDimensionValueSet = null;
    }
    return localDimensionValueSet;
  }
  
  public static DimensionValueSet create()
  {
    return (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
  }
  
  @Deprecated
  public static DimensionValueSet create(int paramInt)
  {
    return (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
  }
  
  public static DimensionValueSet fromStringMap(Map<String, String> paramMap)
  {
    DimensionValueSet localDimensionValueSet = (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]);
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      Map localMap = localDimensionValueSet.map;
      Object localObject = paramMap.getKey();
      if (paramMap.getValue() != null) {}
      for (paramMap = (String)paramMap.getValue();; paramMap = "null")
      {
        localMap.put(localObject, paramMap);
        break;
      }
    }
    return localDimensionValueSet;
  }
  
  public DimensionValueSet addValues(DimensionValueSet paramDimensionValueSet)
  {
    if (paramDimensionValueSet != null)
    {
      paramDimensionValueSet = paramDimensionValueSet.getMap();
      if (paramDimensionValueSet != null)
      {
        Iterator localIterator = paramDimensionValueSet.entrySet().iterator();
        if (localIterator.hasNext())
        {
          paramDimensionValueSet = (Map.Entry)localIterator.next();
          Map localMap = this.map;
          Object localObject = paramDimensionValueSet.getKey();
          if (paramDimensionValueSet.getValue() != null) {}
          for (paramDimensionValueSet = (String)paramDimensionValueSet.getValue();; paramDimensionValueSet = "null")
          {
            localMap.put(localObject, paramDimensionValueSet);
            break;
          }
        }
      }
    }
    return this;
  }
  
  public void clean()
  {
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
        paramObject = (DimensionValueSet)paramObject;
        if (this.map != null) {
          break;
        }
      } while (((DimensionValueSet)paramObject).map == null);
      return false;
    } while (this.map.equals(((DimensionValueSet)paramObject).map));
    return false;
  }
  
  public void fill(Object... paramVarArgs)
  {
    if (this.map == null) {
      this.map = new LinkedHashMap();
    }
  }
  
  public Map<String, String> getMap()
  {
    return this.map;
  }
  
  public String getValue(String paramString)
  {
    return (String)this.map.get(paramString);
  }
  
  public int hashCode()
  {
    if (this.map == null) {}
    for (int i = 0;; i = this.map.hashCode()) {
      return i + 31;
    }
  }
  
  public void setMap(Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      Map localMap = this.map;
      Object localObject = paramMap.getKey();
      if (paramMap.getValue() != null) {}
      for (paramMap = (String)paramMap.getValue();; paramMap = "null")
      {
        localMap.put(localObject, paramMap);
        break;
      }
    }
  }
  
  public DimensionValueSet setValue(String paramString1, String paramString2)
  {
    Map localMap = this.map;
    if (paramString2 != null) {}
    for (;;)
    {
      localMap.put(paramString1, paramString2);
      return this;
      paramString2 = "null";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.map);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\DimensionValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */