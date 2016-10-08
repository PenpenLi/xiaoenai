package com.xiaoenai.app.model.mall;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Order$1
  implements Parcelable.Creator<Order>
{
  public Order createFromParcel(Parcel paramParcel)
  {
    return new Order(paramParcel);
  }
  
  public Order[] newArray(int paramInt)
  {
    return new Order[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\Order$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */