package com.bumptech.glide.d.d.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.d.b.a.c;

public class v
  implements a<ParcelFileDescriptor>
{
  private static final a a = new a();
  private a b;
  private int c;
  
  public v()
  {
    this(a, -1);
  }
  
  v(a parama, int paramInt)
  {
    this.b = parama;
    this.c = paramInt;
  }
  
  public Bitmap a(ParcelFileDescriptor paramParcelFileDescriptor, c paramc, int paramInt1, int paramInt2, com.bumptech.glide.d.a parama)
  {
    parama = this.b.a();
    parama.setDataSource(paramParcelFileDescriptor.getFileDescriptor());
    if (this.c >= 0) {}
    for (paramc = parama.getFrameAtTime(this.c);; paramc = parama.getFrameAtTime())
    {
      parama.release();
      paramParcelFileDescriptor.close();
      return paramc;
    }
  }
  
  public String a()
  {
    return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
  }
  
  static class a
  {
    public MediaMetadataRetriever a()
    {
      return new MediaMetadataRetriever();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */