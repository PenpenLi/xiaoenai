package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RatingCompat$1
  implements Parcelable.Creator<RatingCompat>
{
  public RatingCompat createFromParcel(Parcel paramParcel)
  {
    return new RatingCompat(paramParcel.readInt(), paramParcel.readFloat(), null);
  }
  
  public RatingCompat[] newArray(int paramInt)
  {
    return new RatingCompat[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\RatingCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */