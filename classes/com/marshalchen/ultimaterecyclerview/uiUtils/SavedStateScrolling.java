package com.marshalchen.ultimaterecyclerview.uiUtils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;

public class SavedStateScrolling
  implements Parcelable
{
  public static final Parcelable.Creator<SavedStateScrolling> CREATOR = new c();
  public static final SavedStateScrolling a = new SavedStateScrolling.1();
  public int b;
  public int c = -1;
  public int d;
  public int e;
  public int f;
  public SparseIntArray g;
  public Parcelable h;
  
  public SavedStateScrolling()
  {
    this.h = null;
  }
  
  public SavedStateScrolling(Parcel paramParcel)
  {
    Object localObject = paramParcel.readParcelable(RecyclerView.class.getClassLoader());
    if (localObject != null) {}
    for (;;)
    {
      this.h = ((Parcelable)localObject);
      this.b = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = new SparseIntArray();
      int j = paramParcel.readInt();
      if (j <= 0) {
        break;
      }
      int i = 0;
      while (i < j)
      {
        int k = paramParcel.readInt();
        int m = paramParcel.readInt();
        this.g.put(k, m);
        i += 1;
      }
      localObject = a;
    }
  }
  
  public SavedStateScrolling(Parcelable paramParcelable)
  {
    if (paramParcelable != a) {}
    for (;;)
    {
      this.h = paramParcelable;
      return;
      paramParcelable = null;
    }
  }
  
  public Parcelable a()
  {
    return this.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    paramParcel.writeParcelable(this.h, paramInt);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    if (this.g == null) {}
    for (paramInt = 0;; paramInt = this.g.size())
    {
      paramParcel.writeInt(paramInt);
      if (paramInt <= 0) {
        break;
      }
      while (i < paramInt)
      {
        paramParcel.writeInt(this.g.keyAt(i));
        paramParcel.writeInt(this.g.valueAt(i));
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\uiUtils\SavedStateScrolling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */