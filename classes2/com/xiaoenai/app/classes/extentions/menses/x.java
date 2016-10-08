package com.xiaoenai.app.classes.extentions.menses;

import android.os.Handler;
import java.util.TimerTask;

class x
  extends TimerTask
{
  x(MensesMaleFragment paramMensesMaleFragment) {}
  
  public void run()
  {
    MensesMaleFragment.f(this.a).post(new y(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */