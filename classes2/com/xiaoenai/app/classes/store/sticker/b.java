package com.xiaoenai.app.classes.store.sticker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<BaseSticker>
{
  public FunnySticker a(Parcel paramParcel)
  {
    return new FunnySticker(paramParcel, null);
  }
  
  public FunnySticker[] a(int paramInt)
  {
    return new FunnySticker[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\sticker\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */