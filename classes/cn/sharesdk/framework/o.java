package cn.sharesdk.framework;

import java.util.HashMap;

class o
  extends Thread
{
  o(n paramn) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if ((!this.a.f()) && (this.a.a(localHashMap))) {
        this.a.b(localHashMap);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */