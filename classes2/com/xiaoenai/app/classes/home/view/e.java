package com.xiaoenai.app.classes.home.view;

import java.util.Timer;

class e
  implements Runnable
{
  e(d paramd) {}
  
  public void run()
  {
    ContentView.a(this.a.a.a.c, false);
    ContentView.a(this.a.a.a.c, 60);
    if (ContentView.a(this.a.a.a.c) != null)
    {
      ContentView.a(this.a.a.a.c).cancel();
      ContentView.a(this.a.a.a.c, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */