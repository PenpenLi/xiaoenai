package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CmdObject$1
  implements Parcelable.Creator<CmdObject>
{
  public CmdObject createFromParcel(Parcel paramParcel)
  {
    return new CmdObject(paramParcel);
  }
  
  public CmdObject[] newArray(int paramInt)
  {
    return new CmdObject[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\CmdObject$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */