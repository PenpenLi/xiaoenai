package com.xiaoenai.app.classes.home.view;

import android.os.Handler;
import java.util.TimerTask;

class f
  extends TimerTask
{
  f(ContentView paramContentView) {}
  
  public void run()
  {
    ContentView.e(this.a).post(new g(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */