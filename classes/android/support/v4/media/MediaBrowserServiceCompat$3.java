package android.support.v4.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.List;

class MediaBrowserServiceCompat$3
  extends MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>>
{
  MediaBrowserServiceCompat$3(MediaBrowserServiceCompat paramMediaBrowserServiceCompat, Object paramObject, MediaBrowserServiceCompat.ConnectionRecord paramConnectionRecord, String paramString, Bundle paramBundle)
  {
    super(paramObject);
  }
  
  void onResultSent(List<MediaBrowserCompat.MediaItem> paramList, int paramInt)
  {
    if (MediaBrowserServiceCompat.access$500(this.this$0).get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
      return;
    }
    Object localObject = paramList;
    if ((paramInt & 0x1) != 0) {
      localObject = MediaBrowserCompatUtils.applyOptions(paramList, this.val$options);
    }
    try
    {
      this.val$connection.callbacks.onLoadChildren(this.val$parentId, (List)localObject, this.val$options);
      return;
    }
    catch (RemoteException paramList)
    {
      Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */