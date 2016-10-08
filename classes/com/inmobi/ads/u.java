package com.inmobi.ads;

import android.os.Handler;
import android.support.annotation.NonNull;

class u
  implements af
{
  private final Handler a = new Handler();
  private final InMobiStrandPositioning.InMobiClientPositioning b;
  
  public u(@NonNull InMobiStrandPositioning.InMobiClientPositioning paramInMobiClientPositioning)
  {
    this.b = paramInMobiClientPositioning;
  }
  
  public void a(long paramLong, @NonNull af.a parama)
  {
    this.a.post(new u.1(this, parama));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */