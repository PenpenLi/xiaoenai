package com.marshalchen.ultimaterecyclerview.ui.floatingactionbutton;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator<FloatingActionsMenu.SavedState>
{
  public FloatingActionsMenu.SavedState a(Parcel paramParcel)
  {
    return new FloatingActionsMenu.SavedState(paramParcel, null);
  }
  
  public FloatingActionsMenu.SavedState[] a(int paramInt)
  {
    return new FloatingActionsMenu.SavedState[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\ui\floatingactionbutton\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */