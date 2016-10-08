package com.xiaoenai.app.classes.home.view;

import java.util.Timer;

class a
  implements Runnable
{
  a(ContentView paramContentView) {}
  
  public void run()
  {
    if (ContentView.a(this.a) != null)
    {
      ContentView.a(this.a).cancel();
      ContentView.a(this.a, null);
    }
    ContentView.a(this.a, false);
    ContentView.a(this.a, 60);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */