package com.meiqia.core;

import android.os.Handler.Callback;
import android.os.Message;
import com.meiqia.core.b.g;
import java.util.concurrent.atomic.AtomicBoolean;

class ao
  implements Handler.Callback
{
  ao(MeiQiaService paramMeiQiaService) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what)
    {
      g.b("socket reconnect");
      MeiQiaService.a(this.a).set(false);
      MeiQiaService.b(this.a);
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */