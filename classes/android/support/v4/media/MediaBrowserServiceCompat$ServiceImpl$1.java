package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.util.Log;

class MediaBrowserServiceCompat$ServiceImpl$1
  implements Runnable
{
  MediaBrowserServiceCompat$ServiceImpl$1(MediaBrowserServiceCompat.ServiceImpl paramServiceImpl, MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks, String paramString, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    IBinder localIBinder = this.val$callbacks.asBinder();
    MediaBrowserServiceCompat.access$500(this.this$1.this$0).remove(localIBinder);
    MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(this.this$1.this$0, null);
    localConnectionRecord.pkg = this.val$pkg;
    localConnectionRecord.rootHints = this.val$rootHints;
    localConnectionRecord.callbacks = this.val$callbacks;
    localConnectionRecord.root = this.this$1.this$0.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
    if (localConnectionRecord.root == null) {
      Log.i("MediaBrowserServiceCompat", "No root for client " + this.val$pkg + " from service " + getClass().getName());
    }
    for (;;)
    {
      try
      {
        this.val$callbacks.onConnectFailed();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
        return;
      }
      try
      {
        MediaBrowserServiceCompat.access$500(this.this$1.this$0).put(localRemoteException1, localConnectionRecord);
        if (this.this$1.this$0.mSession != null)
        {
          this.val$callbacks.onConnect(localConnectionRecord.root.getRootId(), this.this$1.this$0.mSession, localConnectionRecord.root.getExtras());
          return;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
        MediaBrowserServiceCompat.access$500(this.this$1.this$0).remove(localRemoteException1);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompat$ServiceImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */