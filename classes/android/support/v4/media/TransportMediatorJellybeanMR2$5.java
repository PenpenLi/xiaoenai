package android.support.v4.media;

import android.media.RemoteControlClient.OnGetPlaybackPositionListener;

class TransportMediatorJellybeanMR2$5
  implements RemoteControlClient.OnGetPlaybackPositionListener
{
  TransportMediatorJellybeanMR2$5(TransportMediatorJellybeanMR2 paramTransportMediatorJellybeanMR2) {}
  
  public long onGetPlaybackPosition()
  {
    return this.this$0.mTransportCallback.getPlaybackPosition();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\TransportMediatorJellybeanMR2$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */