package com.xiaoenai.app.classes.home.view;

import android.os.Handler;
import android.widget.TextView;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import java.util.TimerTask;

class s
  extends TimerTask
{
  s(ContentView paramContentView, k paramk, TextView paramTextView) {}
  
  public void run()
  {
    ContentView.e(this.c).post(new t(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */