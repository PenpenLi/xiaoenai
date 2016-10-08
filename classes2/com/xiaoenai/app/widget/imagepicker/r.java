package com.xiaoenai.app.widget.imagepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class r
  implements Parcelable.Creator<ImageEntry>
{
  public ImageEntry a(Parcel paramParcel)
  {
    boolean bool = true;
    ImageEntry localImageEntry = new ImageEntry();
    localImageEntry.a(paramParcel.readInt());
    localImageEntry.a(paramParcel.readString());
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localImageEntry.a(bool);
      localImageEntry.b(paramParcel.readString());
      return localImageEntry;
      bool = false;
    }
  }
  
  public ImageEntry[] a(int paramInt)
  {
    return new ImageEntry[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */