package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Measure
  implements Parcelable
{
  public static final Parcelable.Creator<Measure> CREATOR = new Measure.1();
  protected Double a = Double.valueOf(0.0D);
  protected Double b = Double.valueOf(0.0D);
  protected Double c = Double.valueOf(0.0D);
  protected String name;
  
  public Measure(String paramString)
  {
    this(paramString, Double.valueOf(0.0D));
  }
  
  public Measure(String paramString, Double paramDouble)
  {
    this(paramString, paramDouble, Double.valueOf(0.0D), null);
  }
  
  public Measure(String paramString, Double paramDouble1, Double paramDouble2, Double paramDouble3)
  {
    this.a = paramDouble2;
    this.b = paramDouble3;
    this.name = paramString;
    if (paramDouble1 != null) {
      d = paramDouble1.doubleValue();
    }
    this.c = Double.valueOf(d);
  }
  
  static Measure a(Parcel paramParcel)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        if (paramParcel.readInt() == 0)
        {
          i = 1;
          if (i != 0) {
            break label127;
          }
          localDouble1 = Double.valueOf(paramParcel.readDouble());
          if (paramParcel.readInt() == 0)
          {
            i = 1;
            if (i != 0) {
              break label122;
            }
            localDouble2 = Double.valueOf(paramParcel.readDouble());
            String str = paramParcel.readString();
            if (paramParcel.readInt() != 0) {
              continue;
            }
            i = j;
            if (i != 0) {
              break label117;
            }
            paramParcel = Double.valueOf(paramParcel.readDouble());
            paramParcel = new Measure(str, paramParcel, localDouble2, localDouble1);
            return paramParcel;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int i = 0;
        continue;
        i = 0;
        continue;
        paramParcel = null;
      }
      catch (Throwable paramParcel)
      {
        paramParcel.printStackTrace();
        return null;
      }
      label117:
      continue;
      label122:
      Double localDouble2 = null;
      continue;
      label127:
      Double localDouble1 = null;
    }
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
        paramObject = (Measure)paramObject;
        if (this.name != null) {
          break;
        }
      } while (((Measure)paramObject).name == null);
      return false;
    } while (this.name.equals(((Measure)paramObject).name));
    return false;
  }
  
  public Double getConstantValue()
  {
    return this.c;
  }
  
  public Double getMax()
  {
    return this.b;
  }
  
  public Double getMin()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    if (this.name == null) {}
    for (int i = 0;; i = this.name.hashCode()) {
      return i + 31;
    }
  }
  
  public void setConstantValue(Double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void setMax(Double paramDouble)
  {
    this.b = paramDouble;
  }
  
  public void setMin(Double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public void setRange(Double paramDouble1, Double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public boolean valid(MeasureValue paramMeasureValue)
  {
    paramMeasureValue = Double.valueOf(paramMeasureValue.getValue());
    return (paramMeasureValue != null) && ((this.a == null) || (paramMeasureValue.doubleValue() >= this.a.doubleValue())) && ((this.b == null) || (paramMeasureValue.doubleValue() <= this.b.doubleValue()));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    try
    {
      if (this.b == null)
      {
        paramInt = 0;
        paramParcel.writeInt(paramInt);
        if (this.b != null) {
          paramParcel.writeDouble(this.b.doubleValue());
        }
        if (this.a != null) {
          break label112;
        }
        paramInt = 0;
        label43:
        paramParcel.writeInt(paramInt);
        if (this.a != null) {
          paramParcel.writeDouble(this.a.doubleValue());
        }
        paramParcel.writeString(this.name);
        if (this.c != null) {
          break label117;
        }
      }
      label112:
      label117:
      for (paramInt = i;; paramInt = 1)
      {
        paramParcel.writeInt(paramInt);
        if (this.c != null) {
          paramParcel.writeDouble(this.c.doubleValue());
        }
        return;
        paramInt = 1;
        break;
        paramInt = 1;
        break label43;
      }
      return;
    }
    catch (Throwable paramParcel) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\Measure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */