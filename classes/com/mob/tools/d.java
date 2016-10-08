package com.mob.tools;

import android.os.Handler.Callback;
import android.os.Message;

class d
  implements Handler.Callback
{
  d(a parama, Runnable paramRunnable) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.run();
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */