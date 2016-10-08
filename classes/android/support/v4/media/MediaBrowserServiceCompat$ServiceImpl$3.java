package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.Log;

class MediaBrowserServiceCompat$ServiceImpl$3
  implements Runnable
{
  MediaBrowserServiceCompat$ServiceImpl$3(MediaBrowserServiceCompat.ServiceImpl paramServiceImpl, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = this.val$callbacks.asBinder();
    localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.access$500(this.this$1.this$0).get(localObject);
    if (localObject == null)
    {
      Log.w("MediaBrowserServiceCompat", "addSubscription for callback that isn't registered id=" + this.val$id);
      return;
    }
    MediaBrowserServiceCompat.access$700(this.this$1.this$0, this.val$id, (MediaBrowserServiceCompat.ConnectionRecord)localObject, this.val$options);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat$ServiceImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */