package com.xiaoenai.app.classes.settings.feedback;

import android.os.Handler;
import android.os.Message;

class o
  implements Runnable
{
  o(n paramn) {}
  
  public void run()
  {
    Message localMessage = n.a(this.a).obtainMessage();
    localMessage.what = 1;
    n.a(this.a).sendMessage(localMessage);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */