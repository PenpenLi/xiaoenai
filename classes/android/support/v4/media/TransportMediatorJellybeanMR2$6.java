package android.support.v4.media;

import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;

class TransportMediatorJellybeanMR2$6
  implements RemoteControlClient.OnPlaybackPositionUpdateListener
{
  TransportMediatorJellybeanMR2$6(TransportMediatorJellybeanMR2 paramTransportMediatorJellybeanMR2) {}
  
  public void onPlaybackPositionUpdate(long paramLong)
  {
    this.this$0.mTransportCallback.playbackPositionUpdate(paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\TransportMediatorJellybeanMR2$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */