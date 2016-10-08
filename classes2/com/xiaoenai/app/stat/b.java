package com.xiaoenai.app.stat;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<StatEntry>
{
  public StatEntry a(Parcel paramParcel)
  {
    return new StatEntry(paramParcel, null);
  }
  
  public StatEntry[] a(int paramInt)
  {
    return new StatEntry[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\stat\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */