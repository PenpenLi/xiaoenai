package com.xiaoenai.app.classes.chat.messagelist.message.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j
  implements Parcelable.Creator
{
  public PhotoMessage a(Parcel paramParcel)
  {
    boolean bool = true;
    PhotoMessage localPhotoMessage = new PhotoMessage();
    localPhotoMessage.b(paramParcel.readLong());
    localPhotoMessage.c(paramParcel.readString());
    localPhotoMessage.a(paramParcel.readInt(), paramParcel.readInt());
    localPhotoMessage.d(paramParcel.readString());
    localPhotoMessage.e(paramParcel.readString());
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localPhotoMessage.c(bool);
      localPhotoMessage.d(paramParcel.readLong());
      return localPhotoMessage;
      bool = false;
    }
  }
  
  public PhotoMessage[] a(int paramInt)
  {
    return new PhotoMessage[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */