package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Dimension
  implements Parcelable
{
  public static final Parcelable.Creator<Dimension> CREATOR = new Dimension.1();
  protected String name;
  protected String y = "null";
  
  public Dimension() {}
  
  public Dimension(String paramString)
  {
    this(paramString, null);
  }
  
  public Dimension(String paramString1, String paramString2)
  {
    this.name = paramString1;
    if (paramString2 != null) {}
    for (;;)
    {
      this.y = paramString2;
      return;
      paramString2 = "null";
    }
  }
  
  static Dimension a(Parcel paramParcel)
  {
    try
    {
      String str = paramParcel.readString();
      paramParcel = new Dimension(paramParcel.readString(), str);
      return paramParcel;
    }
    catch (Throwable paramParcel) {}
    return null;
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
        paramObject = (Dimension)paramObject;
        if (this.name != null) {
          break;
        }
      } while (((Dimension)paramObject).name == null);
      return false;
    } while (this.name.equals(((Dimension)paramObject).name));
    return false;
  }
  
  public String getConstantValue()
  {
    return this.y;
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
  
  public void setConstantValue(String paramString)
  {
    this.y = paramString;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.y);
    paramParcel.writeString(this.name);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\Dimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */