package com.xiaoenai.app.classes.street.widget;

import android.os.Handler;
import java.util.TimerTask;

class aa
  extends TimerTask
{
  aa(StreetPayBottomView paramStreetPayBottomView) {}
  
  public void run()
  {
    StreetPayBottomView.f(this.a).post(new ab(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */