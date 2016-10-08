package com.tonicartos.superslim;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<LayoutManager.SavedState>
{
  public LayoutManager.SavedState a(Parcel paramParcel)
  {
    return new LayoutManager.SavedState(paramParcel);
  }
  
  public LayoutManager.SavedState[] a(int paramInt)
  {
    return new LayoutManager.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tonicartos\superslim\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */