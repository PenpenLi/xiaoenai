package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MeasureSet
  implements Parcelable
{
  public static final Parcelable.Creator<MeasureSet> CREATOR = new MeasureSet.1();
  private List<Measure> d = new ArrayList(3);
  
  static MeasureSet a(Parcel paramParcel)
  {
    MeasureSet localMeasureSet = create();
    try
    {
      paramParcel = (Parcelable[])paramParcel.readParcelableArray(MeasureSet.class.getClassLoader());
      if (paramParcel != null)
      {
        ArrayList localArrayList = new ArrayList(paramParcel.length);
        int i = 0;
        while (i < paramParcel.length)
        {
          localArrayList.add((Measure)paramParcel[i]);
          i += 1;
        }
        localMeasureSet.d = localArrayList;
      }
      return localMeasureSet;
    }
    catch (Throwable paramParcel)
    {
      paramParcel.printStackTrace();
    }
    return localMeasureSet;
  }
  
  public static MeasureSet create()
  {
    return new MeasureSet();
  }
  
  public static MeasureSet create(Collection<String> paramCollection)
  {
    MeasureSet localMeasureSet = new MeasureSet();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localMeasureSet.addMeasure((String)paramCollection.next());
      }
    }
    return localMeasureSet;
  }
  
  public static MeasureSet create(String[] paramArrayOfString)
  {
    MeasureSet localMeasureSet = new MeasureSet();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localMeasureSet.addMeasure(paramArrayOfString[i]);
        i += 1;
      }
    }
    return localMeasureSet;
  }
  
  public MeasureSet addMeasure(Measure paramMeasure)
  {
    if (!this.d.contains(paramMeasure)) {
      this.d.add(paramMeasure);
    }
    return this;
  }
  
  public MeasureSet addMeasure(String paramString)
  {
    return addMeasure(new Measure(paramString));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Measure getMeasure(String paramString)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Measure localMeasure = (Measure)localIterator.next();
      if (localMeasure.getName().equals(paramString)) {
        return localMeasure;
      }
    }
    return null;
  }
  
  public List<Measure> getMeasures()
  {
    return this.d;
  }
  
  public void setConstantValue(MeasureValueSet paramMeasureValueSet)
  {
    if ((this.d != null) && (paramMeasureValueSet != null))
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        Measure localMeasure = (Measure)localIterator.next();
        if ((localMeasure.getConstantValue() != null) && (paramMeasureValueSet.getValue(localMeasure.getName()) == null)) {
          paramMeasureValueSet.setValue(localMeasure.getName(), localMeasure.getConstantValue().doubleValue());
        }
      }
    }
  }
  
  public void upateMeasure(Measure paramMeasure)
  {
    int j = this.d.size();
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(((Measure)this.d.get(i)).name, paramMeasure.name))
      {
        ((Measure)this.d.get(i)).setMax(paramMeasure.getMax());
        ((Measure)this.d.get(i)).setMin(paramMeasure.getMin());
        ((Measure)this.d.get(i)).setConstantValue(paramMeasure.getConstantValue());
      }
      i += 1;
    }
  }
  
  public void upateMeasures(List<Measure> paramList)
  {
    int k = this.d.size();
    int m = paramList.size();
    int i = 0;
    while (i < k)
    {
      int j = 0;
      while (j < m)
      {
        if (TextUtils.equals(((Measure)this.d.get(i)).name, ((Measure)paramList.get(j)).name))
        {
          ((Measure)this.d.get(i)).setMax(((Measure)paramList.get(j)).getMax());
          ((Measure)this.d.get(i)).setMin(((Measure)paramList.get(j)).getMin());
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public boolean valid(MeasureValueSet paramMeasureValueSet)
  {
    if (this.d != null)
    {
      int i;
      if (paramMeasureValueSet != null) {
        i = 0;
      }
      while (i < this.d.size())
      {
        Measure localMeasure = (Measure)this.d.get(i);
        if (localMeasure != null)
        {
          String str = localMeasure.getName();
          if (!paramMeasureValueSet.containValue(str)) {}
          while (!localMeasure.valid(paramMeasureValueSet.getValue(str))) {
            return false;
          }
        }
        i += 1;
      }
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.d != null) {}
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = this.d.toArray();
        Measure[] arrayOfMeasure = null;
        if (arrayOfObject != null)
        {
          arrayOfMeasure = new Measure[arrayOfObject.length];
          int i = 0;
          if (i < arrayOfObject.length)
          {
            arrayOfMeasure[i] = ((Measure)arrayOfObject[i]);
            i += 1;
          }
        }
        else
        {
          paramParcel.writeParcelableArray(arrayOfMeasure, paramInt);
          return;
        }
      }
      catch (Exception paramParcel)
      {
        paramParcel.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MeasureSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */