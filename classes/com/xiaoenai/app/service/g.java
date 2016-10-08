package com.xiaoenai.app.service;

import android.os.Handler;
import android.os.Message;

class g
  extends Handler
{
  g(ProtectService paramProtectService) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.a(this.a);
      ProtectService.a(this.a).c();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */