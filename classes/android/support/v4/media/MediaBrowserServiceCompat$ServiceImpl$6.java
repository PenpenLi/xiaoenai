package android.support.v4.media;

import android.os.IBinder;
import android.support.v4.util.ArrayMap;

class MediaBrowserServiceCompat$ServiceImpl$6
  implements Runnable
{
  MediaBrowserServiceCompat$ServiceImpl$6(MediaBrowserServiceCompat.ServiceImpl paramServiceImpl, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks) {}
  
  public void run()
  {
    IBinder localIBinder = this.val$callbacks.asBinder();
    MediaBrowserServiceCompat.access$500(this.this$1.this$0).remove(localIBinder);
    MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.this$1.this$0, null);
    localConnectionRecord.callbacks = this.val$callbacks;
    MediaBrowserServiceCompat.access$500(this.this$1.this$0).put(localIBinder, localConnectionRecord);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat$ServiceImpl$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */