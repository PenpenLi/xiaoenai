package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MusicObject$1
  implements Parcelable.Creator<MusicObject>
{
  public MusicObject createFromParcel(Parcel paramParcel)
  {
    return new MusicObject(paramParcel);
  }
  
  public MusicObject[] newArray(int paramInt)
  {
    return new MusicObject[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\MusicObject$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */