package com.inmobi.ads;

import android.os.Message;
import java.util.Map;

class InMobiInterstitial$1
  implements AdUnit.a
{
  InMobiInterstitial$1(InMobiInterstitial paramInMobiInterstitial) {}
  
  public void a()
  {
    InMobiInterstitial.access$100(this.a).sendEmptyMessage(1);
  }
  
  public void a(InMobiAdRequestStatus paramInMobiAdRequestStatus)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramInMobiAdRequestStatus;
    InMobiInterstitial.access$100(this.a).sendMessage(localMessage);
  }
  
  public void a(Map<Object, Object> paramMap)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    localMessage.obj = paramMap;
    InMobiInterstitial.access$100(this.a).sendMessage(localMessage);
  }
  
  public void b()
  {
    InMobiInterstitial.access$100(this.a).sendEmptyMessage(3);
  }
  
  public void b(Map<Object, Object> paramMap)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    localMessage.obj = paramMap;
    InMobiInterstitial.access$100(this.a).sendMessage(localMessage);
  }
  
  public void c()
  {
    i.a().b(InMobiInterstitial.access$200(this.a));
    InMobiInterstitial.access$100(this.a).sendEmptyMessage(4);
  }
  
  public void d()
  {
    InMobiInterstitial.access$100(this.a).sendEmptyMessage(6);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiInterstitial$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */