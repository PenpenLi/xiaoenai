package io.github.rockerhieu.emojicon.emoji;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<Emojicon>
{
  public Emojicon a(Parcel paramParcel)
  {
    return new Emojicon(paramParcel);
  }
  
  public Emojicon[] a(int paramInt)
  {
    return new Emojicon[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\io\github\rockerhieu\emojicon\emoji\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */