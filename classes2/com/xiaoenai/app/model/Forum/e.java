package com.xiaoenai.app.model.Forum;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
  implements Parcelable.Creator<Section>
{
  public Section a(Parcel paramParcel)
  {
    return new Section(paramParcel, null);
  }
  
  public Section[] a(int paramInt)
  {
    return new Section[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\Forum\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */