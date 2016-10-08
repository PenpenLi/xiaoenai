package com.xiaoenai.app.classes.extentions.menses;

import android.os.Handler;
import java.util.TimerTask;

class l
  extends TimerTask
{
  l(MensesActivity paramMensesActivity) {}
  
  public void run()
  {
    MensesActivity.f(this.a).post(new m(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */