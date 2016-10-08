package com.xiaoenai.app.classes.home.view;

import java.util.Timer;

class h
  implements Runnable
{
  h(g paramg) {}
  
  public void run()
  {
    ContentView.a(this.a.a.a, false);
    ContentView.a(this.a.a.a, 60);
    if (ContentView.a(this.a.a.a) != null)
    {
      ContentView.a(this.a.a.a).cancel();
      ContentView.a(this.a.a.a, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */