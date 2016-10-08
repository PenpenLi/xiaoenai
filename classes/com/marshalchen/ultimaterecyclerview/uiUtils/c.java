package com.marshalchen.ultimaterecyclerview.uiUtils;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<SavedStateScrolling>
{
  public SavedStateScrolling a(Parcel paramParcel)
  {
    return new SavedStateScrolling(paramParcel);
  }
  
  public SavedStateScrolling[] a(int paramInt)
  {
    return new SavedStateScrolling[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\uiUtils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */