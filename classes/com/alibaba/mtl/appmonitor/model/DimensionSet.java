package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DimensionSet
  implements Parcelable
{
  public static final Parcelable.Creator<DimensionSet> CREATOR = new DimensionSet.1();
  private List<Dimension> c = new ArrayList(3);
  
  static DimensionSet a(Parcel paramParcel)
  {
    DimensionSet localDimensionSet = create();
    for (;;)
    {
      int i;
      try
      {
        paramParcel = paramParcel.readParcelableArray(DimensionSet.class.getClassLoader());
        if (paramParcel == null) {
          break label111;
        }
        if (localDimensionSet.c != null) {
          break label113;
        }
        localDimensionSet.c = new ArrayList();
      }
      catch (Throwable paramParcel)
      {
        i.a("DimensionSet", "[readFromParcel]", paramParcel);
      }
      if (i < paramParcel.length)
      {
        if ((paramParcel[i] != null) && ((paramParcel[i] instanceof Dimension))) {
          localDimensionSet.c.add((Dimension)paramParcel[i]);
        } else {
          i.a("DimensionSet", new Object[] { "parcelables[i]:", paramParcel[i] });
        }
      }
      else
      {
        label111:
        return localDimensionSet;
        label113:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public static DimensionSet create()
  {
    return new DimensionSet();
  }
  
  public static DimensionSet create(Collection<String> paramCollection)
  {
    DimensionSet localDimensionSet = new DimensionSet();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localDimensionSet.addDimension(new Dimension((String)paramCollection.next()));
      }
    }
    return localDimensionSet;
  }
  
  public static DimensionSet create(String[] paramArrayOfString)
  {
    DimensionSet localDimensionSet = new DimensionSet();
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localDimensionSet.addDimension(new Dimension(paramArrayOfString[i]));
        i += 1;
      }
    }
    return localDimensionSet;
  }
  
  public DimensionSet addDimension(Dimension paramDimension)
  {
    if (this.c.contains(paramDimension)) {
      return this;
    }
    this.c.add(paramDimension);
    return this;
  }
  
  public DimensionSet addDimension(String paramString)
  {
    return addDimension(new Dimension(paramString));
  }
  
  public DimensionSet addDimension(String paramString1, String paramString2)
  {
    return addDimension(new Dimension(paramString1, paramString2));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Dimension getDimension(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      Dimension localDimension = (Dimension)localIterator.next();
      if (localDimension.getName().equals(paramString)) {
        return localDimension;
      }
    }
    return null;
  }
  
  public List<Dimension> getDimensions()
  {
    return this.c;
  }
  
  public void setConstantValue(DimensionValueSet paramDimensionValueSet)
  {
    if ((this.c != null) && (paramDimensionValueSet != null))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Dimension localDimension = (Dimension)localIterator.next();
        if ((localDimension.getConstantValue() != null) && (paramDimensionValueSet.getValue(localDimension.getName()) == null)) {
          paramDimensionValueSet.setValue(localDimension.getName(), localDimension.getConstantValue());
        }
      }
    }
  }
  
  public boolean valid(DimensionValueSet paramDimensionValueSet)
  {
    if (this.c != null)
    {
      if (paramDimensionValueSet != null)
      {
        Iterator localIterator = this.c.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (paramDimensionValueSet.containValue(((Dimension)localIterator.next()).getName()));
        return false;
      }
      return false;
    }
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.c != null) {}
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = this.c.toArray();
        Dimension[] arrayOfDimension = null;
        if (arrayOfObject != null)
        {
          arrayOfDimension = new Dimension[arrayOfObject.length];
          int i = 0;
          if (i < arrayOfObject.length)
          {
            arrayOfDimension[i] = ((Dimension)arrayOfObject[i]);
            i += 1;
          }
        }
        else
        {
          paramParcel.writeParcelableArray(arrayOfDimension, paramInt);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\DimensionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */