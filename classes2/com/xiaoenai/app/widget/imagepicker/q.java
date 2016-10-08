package com.xiaoenai.app.widget.imagepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class q
  implements Parcelable.Creator
{
  public ImageDirEntry a(Parcel paramParcel)
  {
    ImageDirEntry localImageDirEntry = new ImageDirEntry();
    localImageDirEntry.a(paramParcel.readString());
    localImageDirEntry.b(paramParcel.readString());
    localImageDirEntry.a(paramParcel.readInt());
    return localImageDirEntry;
  }
  
  public ImageDirEntry[] a(int paramInt)
  {
    return new ImageDirEntry[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */