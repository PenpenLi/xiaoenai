package cn.sharesdk.framework;

import cn.sharesdk.framework.statistics.a;
import java.util.HashMap;

class p
  extends Thread
{
  p(n paramn, a parama) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap1 = this.a.g();
      HashMap localHashMap2 = new HashMap();
      if (n.a(this.b, this.a, localHashMap1, localHashMap2)) {
        this.b.b(localHashMap2);
      }
      this.a.a(localHashMap1);
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */