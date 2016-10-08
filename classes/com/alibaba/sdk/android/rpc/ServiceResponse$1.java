package com.alibaba.sdk.android.rpc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ServiceResponse$1
  implements Parcelable.Creator<ServiceResponse>
{
  public ServiceResponse createFromParcel(Parcel paramParcel)
  {
    return new ServiceResponse(paramParcel);
  }
  
  public ServiceResponse[] newArray(int paramInt)
  {
    return new ServiceResponse[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\rpc\ServiceResponse$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */