package com.xiaoenai.app.model.mall;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class OrderInfo$1
  implements Parcelable.Creator<OrderInfo>
{
  public OrderInfo createFromParcel(Parcel paramParcel)
  {
    return new OrderInfo(paramParcel);
  }
  
  public OrderInfo[] newArray(int paramInt)
  {
    return new OrderInfo[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\OrderInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */