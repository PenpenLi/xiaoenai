package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;
import com.inmobi.rendering.RenderView;

final class an
  extends Handler
{
  private AdUnit a;
  
  public an(AdUnit paramAdUnit)
  {
    this.a = paramAdUnit;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.n().stopLoading();
    this.a.v();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */