package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class VideoObject$1
  implements Parcelable.Creator<VideoObject>
{
  public VideoObject createFromParcel(Parcel paramParcel)
  {
    return new VideoObject(paramParcel);
  }
  
  public VideoObject[] newArray(int paramInt)
  {
    return new VideoObject[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\VideoObject$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */