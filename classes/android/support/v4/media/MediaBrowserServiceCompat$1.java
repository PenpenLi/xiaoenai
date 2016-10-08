package android.support.v4.media;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;

class MediaBrowserServiceCompat$1
  implements Runnable
{
  MediaBrowserServiceCompat$1(MediaBrowserServiceCompat paramMediaBrowserServiceCompat, MediaSessionCompat.Token paramToken) {}
  
  public void run()
  {
    Iterator localIterator = MediaBrowserServiceCompat.access$500(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      IBinder localIBinder = (IBinder)localIterator.next();
      MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.access$500(this.this$0).get(localIBinder);
      try
      {
        localConnectionRecord.callbacks.onConnect(localConnectionRecord.root.getRootId(), this.val$token, localConnectionRecord.root.getExtras());
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("MediaBrowserServiceCompat", "Connection for " + localConnectionRecord.pkg + " is no longer valid.");
        MediaBrowserServiceCompat.access$500(this.this$0).remove(localIBinder);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */