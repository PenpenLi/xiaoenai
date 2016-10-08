package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MediaBrowserCompat$MediaItem$1
  implements Parcelable.Creator<MediaBrowserCompat.MediaItem>
{
  public MediaBrowserCompat.MediaItem createFromParcel(Parcel paramParcel)
  {
    return new MediaBrowserCompat.MediaItem(paramParcel, null);
  }
  
  public MediaBrowserCompat.MediaItem[] newArray(int paramInt)
  {
    return new MediaBrowserCompat.MediaItem[paramInt];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserCompat$MediaItem$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */