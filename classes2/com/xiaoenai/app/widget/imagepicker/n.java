package com.xiaoenai.app.widget.imagepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class n
  implements Parcelable.Creator<ImageDataManager>
{
  public ImageDataManager a(Parcel paramParcel)
  {
    return new ImageDataManager(paramParcel);
  }
  
  public ImageDataManager[] a(int paramInt)
  {
    return new ImageDataManager[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */