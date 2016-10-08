package com.xiaoenai.app.model.mall;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Product$1
  implements Parcelable.Creator<Product>
{
  public Product createFromParcel(Parcel paramParcel)
  {
    return new Product(paramParcel);
  }
  
  public Product[] newArray(int paramInt)
  {
    return new Product[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\mall\Product$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */