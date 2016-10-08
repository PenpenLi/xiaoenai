package com.xiaoenai.app.model.album;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Photo$1
  implements Parcelable.Creator<Photo>
{
  public Photo createFromParcel(Parcel paramParcel)
  {
    return new Photo(paramParcel);
  }
  
  public Photo[] newArray(int paramInt)
  {
    return new Photo[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\album\Photo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */