package com.xiaoenai.app.service;

import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.home.mode.ModeWakeActivity;
import com.xiaoenai.app.utils.h.a;

class f
  implements Runnable
{
  f(MessageService.MessageReceiver paramMessageReceiver, String paramString) {}
  
  public void run()
  {
    if (this.a != null) {
      a.a().c(1);
    }
    Intent localIntent = new Intent(this.b.a.getApplicationContext(), ModeWakeActivity.class);
    localIntent.addFlags(268435456);
    Xiaoenai.j().startActivity(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */