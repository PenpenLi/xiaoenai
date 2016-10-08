package com.xiaoenai.app.classes.settings.feedback;

import android.os.Handler;

public class n
  extends Thread
{
  private Handler a;
  private volatile boolean b = false;
  
  public n(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void run()
  {
    super.run();
    for (;;)
    {
      if (!this.b) {
        try
        {
          Thread.sleep(20000L);
          this.a.post(new o(this));
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */