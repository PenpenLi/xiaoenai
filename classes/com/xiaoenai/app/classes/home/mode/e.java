package com.xiaoenai.app.classes.home.mode;

import android.os.Handler;
import android.widget.TextView;

class e
  implements Runnable
{
  e(ModeSleepActivity paramModeSleepActivity) {}
  
  public void run()
  {
    ModeSleepActivity.b(this.a).setText(ModeSleepActivity.a(this.a));
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\mode\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */