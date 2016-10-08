package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ImageObject$1
  implements Parcelable.Creator<ImageObject>
{
  public ImageObject createFromParcel(Parcel paramParcel)
  {
    return new ImageObject(paramParcel);
  }
  
  public ImageObject[] newArray(int paramInt)
  {
    return new ImageObject[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\ImageObject$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */