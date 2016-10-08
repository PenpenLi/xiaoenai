package android.support.v4.media;

import android.content.ServiceConnection;

class MediaBrowserCompat$MediaBrowserImplBase$1
  implements Runnable
{
  MediaBrowserCompat$MediaBrowserImplBase$1(MediaBrowserCompat.MediaBrowserImplBase paramMediaBrowserImplBase, ServiceConnection paramServiceConnection) {}
  
  public void run()
  {
    if (this.val$thisConnection == MediaBrowserCompat.MediaBrowserImplBase.access$700(this.this$0))
    {
      MediaBrowserCompat.MediaBrowserImplBase.access$800(this.this$0);
      MediaBrowserCompat.MediaBrowserImplBase.access$900(this.this$0).onConnectionFailed();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserCompat$MediaBrowserImplBase$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */