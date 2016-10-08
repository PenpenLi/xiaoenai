package com.xiaoenai.app.classes.store.sticker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<BaseSticker>
{
  public FaceSticker a(Parcel paramParcel)
  {
    return new FaceSticker(paramParcel, null);
  }
  
  public FaceSticker[] a(int paramInt)
  {
    return new FaceSticker[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\sticker\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */