package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class TextObject$1
  implements Parcelable.Creator<TextObject>
{
  public TextObject createFromParcel(Parcel paramParcel)
  {
    return new TextObject(paramParcel);
  }
  
  public TextObject[] newArray(int paramInt)
  {
    return new TextObject[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\TextObject$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */