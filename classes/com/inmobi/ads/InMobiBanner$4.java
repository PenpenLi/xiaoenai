package com.inmobi.ads;

import android.os.Message;
import java.util.Map;

class InMobiBanner$4
  implements AdUnit.a
{
  InMobiBanner$4(InMobiBanner paramInMobiBanner) {}
  
  public void a()
  {
    if ((InMobiBanner.access$800(this.a) == null) || (!InMobiBanner.access$800(this.a).z())) {
      InMobiBanner.access$1100(this.a, new InMobiBanner.4.1(this));
    }
  }
  
  public void a(InMobiAdRequestStatus paramInMobiAdRequestStatus)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramInMobiAdRequestStatus;
    InMobiBanner.access$900(this.a).sendMessage(localMessage);
    InMobiBanner.access$1000(this.a);
  }
  
  public void a(Map<Object, Object> paramMap)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    localMessage.obj = paramMap;
    InMobiBanner.access$900(this.a).sendMessage(localMessage);
  }
  
  public void b()
  {
    InMobiBanner.access$900(this.a).sendEmptyMessage(3);
  }
  
  public void b(Map<Object, Object> paramMap)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    localMessage.obj = paramMap;
    InMobiBanner.access$900(this.a).sendMessage(localMessage);
  }
  
  public void c()
  {
    InMobiBanner.access$1000(this.a);
    InMobiBanner.access$900(this.a).sendEmptyMessage(4);
  }
  
  public void d()
  {
    InMobiBanner.access$900(this.a).sendEmptyMessage(6);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiBanner$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */