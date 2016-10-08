package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class VoiceObject$1
  implements Parcelable.Creator<VoiceObject>
{
  public VoiceObject createFromParcel(Parcel paramParcel)
  {
    return new VoiceObject(paramParcel);
  }
  
  public VoiceObject[] newArray(int paramInt)
  {
    return new VoiceObject[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\VoiceObject$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */