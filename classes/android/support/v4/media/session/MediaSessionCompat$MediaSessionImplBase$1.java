package android.support.v4.media.session;

import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompat.Callback;

class MediaSessionCompat$MediaSessionImplBase$1
  extends VolumeProviderCompat.Callback
{
  MediaSessionCompat$MediaSessionImplBase$1(MediaSessionCompat.MediaSessionImplBase paramMediaSessionImplBase) {}
  
  public void onVolumeChanged(VolumeProviderCompat paramVolumeProviderCompat)
  {
    if (MediaSessionCompat.MediaSessionImplBase.access$300(this.this$0) != paramVolumeProviderCompat) {
      return;
    }
    paramVolumeProviderCompat = new ParcelableVolumeInfo(MediaSessionCompat.MediaSessionImplBase.access$400(this.this$0), MediaSessionCompat.MediaSessionImplBase.access$500(this.this$0), paramVolumeProviderCompat.getVolumeControl(), paramVolumeProviderCompat.getMaxVolume(), paramVolumeProviderCompat.getCurrentVolume());
    MediaSessionCompat.MediaSessionImplBase.access$600(this.this$0, paramVolumeProviderCompat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompat$MediaSessionImplBase$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */