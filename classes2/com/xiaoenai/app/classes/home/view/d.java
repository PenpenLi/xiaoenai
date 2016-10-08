package com.xiaoenai.app.classes.home.view;

import android.os.Handler;
import android.widget.Button;
import com.xiaoenai.app.utils.as;

class d
  implements Runnable
{
  d(c paramc) {}
  
  public void run()
  {
    this.a.a.b.setText(as.a(2131100564) + "(" + ContentView.g(this.a.a.c) + ")");
    ContentView.h(this.a.a.c);
    if (ContentView.g(this.a.a.c) == 0) {
      ContentView.e(this.a.a.c).post(new e(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */