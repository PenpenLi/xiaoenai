package com.baidu.location;

import android.os.Handler;
import android.os.Message;

class r
  implements ax, n
{
  private static r cP = null;
  private l cO = null;
  private Handler cQ = null;
  
  public static r H()
  {
    if (cP == null) {
      cP = new r();
    }
    return cP;
  }
  
  private void J()
  {
    try
    {
      if (y.gb)
      {
        boolean bool = c.a7;
        if (!bool) {}
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void G()
  {
    if (this.cO != null) {
      this.cO.u();
    }
    this.cO = null;
  }
  
  public Handler I()
  {
    return this.cQ;
  }
  
  public void K() {}
  
  public class a
    extends Handler
  {
    public a() {}
    
    public void handleMessage(Message paramMessage)
    {
      if (!ab.gv) {
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        r.jdMethod_if(r.this);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */