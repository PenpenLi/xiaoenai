package com.inmobi.ads;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class InMobiBanner$1
  implements Runnable
{
  InMobiBanner$1(InMobiBanner paramInMobiBanner, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.b.hasValidSize())
    {
      InMobiBanner.access$000(this.b);
      if (InMobiBanner.access$100(this.b)) {
        InMobiBanner.access$200(this.b).b(this.a);
      }
      return;
    }
    Logger.a(Logger.InternalLogLevel.ERROR, InMobiBanner.access$300(), "The height or width of the banner can not be determined");
    InMobiBanner.access$400(this.b).a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiBanner$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */