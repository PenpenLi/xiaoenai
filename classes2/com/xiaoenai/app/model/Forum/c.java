package com.xiaoenai.app.model.Forum;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<Post>
{
  public Post a(Parcel paramParcel)
  {
    return new Post(paramParcel);
  }
  
  public Post[] a(int paramInt)
  {
    return new Post[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\Forum\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */