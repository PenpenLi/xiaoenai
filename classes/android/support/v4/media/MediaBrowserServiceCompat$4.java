package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$4
  extends MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem>
{
  MediaBrowserServiceCompat$4(MediaBrowserServiceCompat paramMediaBrowserServiceCompat, Object paramObject, ResultReceiver paramResultReceiver)
  {
    super(paramObject);
  }
  
  void onResultSent(MediaBrowserCompat.MediaItem paramMediaItem, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("media_item", paramMediaItem);
    this.val$receiver.send(0, localBundle);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */