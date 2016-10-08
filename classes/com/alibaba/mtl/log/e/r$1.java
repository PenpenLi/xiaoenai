package com.alibaba.mtl.log.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ThreadPoolExecutor;

class r$1
  extends Handler
{
  r$1(r paramr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    try
    {
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Runnable))) {
        r.b().submit((Runnable)paramMessage.obj);
      }
      return;
    }
    catch (Throwable paramMessage) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\r$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */