package com.adhoc;

import java.util.ArrayList;

class af
  implements Runnable
{
  af(ae paramae) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Thread.sleep(3000L);
        ae.a(this.a);
        fl.a("list size after delete:" + ae.b.size());
        i = 0;
        if (i < ae.b.size())
        {
          Object localObject = ae.b.get(i);
          if (localObject == null)
          {
            fl.b("fragment null ! position: " + i);
          }
          else if ((ae.a(this.a, localObject)) && (ae.b(this.a, localObject)))
          {
            ae.a(this.a, new ae.a(this.a));
            ae.a.a(ae.b(this.a), localObject.hashCode());
            ae.a.a(ae.b(this.a), localObject.getClass().getSimpleName());
            ae.a.a(ae.b(this.a), System.currentTimeMillis() - 3000L);
            fl.a(localObject.getClass().getSimpleName() + " visiable : hituser & fathervisiable all  true");
            this.a.b(ae.c(this.a));
          }
        }
        else
        {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        fl.a(localInterruptedException);
        return;
      }
      catch (Throwable localThrowable)
      {
        fl.a(localThrowable);
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */