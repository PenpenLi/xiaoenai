package com.inmobi.ads;

import android.os.Message;
import java.util.Map;

class InMobiNative$1
  implements AdUnit.a
{
  InMobiNative$1(InMobiNative paramInMobiNative) {}
  
  public void a()
  {
    InMobiNative.access$100(this.a).sendEmptyMessage(1);
  }
  
  public void a(InMobiAdRequestStatus paramInMobiAdRequestStatus)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramInMobiAdRequestStatus;
    InMobiNative.access$100(this.a).sendMessage(localMessage);
  }
  
  public void a(Map<Object, Object> paramMap) {}
  
  public void b()
  {
    InMobiNative.access$100(this.a).sendEmptyMessage(3);
  }
  
  public void b(Map<Object, Object> paramMap) {}
  
  public void c()
  {
    InMobiNative.access$100(this.a).sendEmptyMessage(4);
  }
  
  public void d()
  {
    InMobiNative.access$100(this.a).sendEmptyMessage(5);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\InMobiNative$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */