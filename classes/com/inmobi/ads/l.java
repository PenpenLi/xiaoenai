package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;

final class l
  extends Handler
{
  private InMobiBanner a;
  
  public l(InMobiBanner paramInMobiBanner)
  {
    this.a = paramInMobiBanner;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.load(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */