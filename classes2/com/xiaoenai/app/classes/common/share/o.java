package com.xiaoenai.app.classes.common.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class o
  implements Parcelable.Creator<ShareInfo>
{
  public ShareInfo a(Parcel paramParcel)
  {
    ShareInfo localShareInfo = new ShareInfo();
    localShareInfo.a(paramParcel.readString());
    localShareInfo.b(paramParcel.readString());
    localShareInfo.c(paramParcel.readString());
    localShareInfo.d(paramParcel.readString());
    localShareInfo.e(paramParcel.readString());
    localShareInfo.f(paramParcel.readString());
    localShareInfo.g(paramParcel.readString());
    int i = paramParcel.readInt();
    String[] arrayOfString = null;
    if (i > 0) {
      arrayOfString = new String[i];
    }
    paramParcel.readStringArray(arrayOfString);
    localShareInfo.a(arrayOfString);
    localShareInfo.a(paramParcel.readInt());
    localShareInfo.b(paramParcel.readInt());
    localShareInfo.c(paramParcel.readInt());
    localShareInfo.d(paramParcel.readInt());
    localShareInfo.e(paramParcel.readInt());
    return localShareInfo;
  }
  
  public ShareInfo[] a(int paramInt)
  {
    return new ShareInfo[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */