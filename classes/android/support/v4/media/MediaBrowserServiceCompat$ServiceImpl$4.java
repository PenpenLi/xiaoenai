package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.Log;

class MediaBrowserServiceCompat$ServiceImpl$4
  implements Runnable
{
  MediaBrowserServiceCompat$ServiceImpl$4(MediaBrowserServiceCompat.ServiceImpl paramServiceImpl, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject = this.val$callbacks.asBinder();
    localObject = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.access$500(this.this$1.this$0).get(localObject);
    if (localObject == null) {
      Log.w("MediaBrowserServiceCompat", "removeSubscription for callback that isn't registered id=" + this.val$id);
    }
    while (MediaBrowserServiceCompat.access$800(this.this$1.this$0, this.val$id, (MediaBrowserServiceCompat.ConnectionRecord)localObject, this.val$options)) {
      return;
    }
    Log.w("MediaBrowserServiceCompat", "removeSubscription called for " + this.val$id + " which is not subscribed");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat$ServiceImpl$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */