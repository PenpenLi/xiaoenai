package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PlaybackStateCompat$1
  implements Parcelable.Creator<PlaybackStateCompat>
{
  public PlaybackStateCompat createFromParcel(Parcel paramParcel)
  {
    return new PlaybackStateCompat(paramParcel, null);
  }
  
  public PlaybackStateCompat[] newArray(int paramInt)
  {
    return new PlaybackStateCompat[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\session\PlaybackStateCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */