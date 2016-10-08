package com.xiaoenai.app.classes.home.view;

import android.os.Handler;
import android.widget.Button;
import com.xiaoenai.app.utils.as;

class g
  implements Runnable
{
  g(f paramf) {}
  
  public void run()
  {
    ContentView.f(this.a.a).setText(as.a(2131100564) + "(" + ContentView.g(this.a.a) + ")");
    ContentView.h(this.a.a);
    if (ContentView.g(this.a.a) == 0) {
      ContentView.e(this.a.a).post(new h(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */