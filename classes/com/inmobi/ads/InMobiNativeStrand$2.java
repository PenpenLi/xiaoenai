package com.inmobi.ads;

import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.Map;

class InMobiNativeStrand$2
  implements AdUnit.a
{
  InMobiNativeStrand$2(InMobiNativeStrand paramInMobiNativeStrand) {}
  
  public void a()
  {
    if (InMobiNativeStrand.access$100(this.a) == null) {
      Logger.a(Logger.InternalLogLevel.INTERNAL, InMobiNativeStrand.access$200(), "NativeStrandUnit already destroyed, ignoring ad load success");
    }
    do
    {
      return;
      InMobiNativeStrand.access$302(this.a, InMobiNativeStrand.access$100(this.a).x());
    } while (InMobiNativeStrand.access$300(this.a) == null);
    InMobiNativeStrand.access$300(this.a).a(InMobiNativeStrand.access$400(this.a));
    InMobiNativeStrand.access$000(this.a).sendEmptyMessage(1);
    Logger.a(Logger.InternalLogLevel.INTERNAL, InMobiNativeStrand.access$200(), "Ad load successful notifying app");
  }
  
  public void a(InMobiAdRequestStatus paramInMobiAdRequestStatus)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramInMobiAdRequestStatus;
    InMobiNativeStrand.access$000(this.a).sendMessage(localMessage);
  }
  
  public void a(Map<Object, Object> paramMap) {}
  
  public void b() {}
  
  public void b(Map<Object, Object> paramMap) {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiNativeStrand$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */