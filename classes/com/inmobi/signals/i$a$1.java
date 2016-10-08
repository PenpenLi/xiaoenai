package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.signals.b.a;
import com.inmobi.signals.b.c.a;
import java.util.List;

class i$a$1
  implements c.a
{
  i$a$1(i.a parama, m paramm) {}
  
  public void a()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "Wifi scan timeout.");
    i.a.a(this.b, this.a);
  }
  
  public void a(List<a> paramList)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "Wifi scan successful.");
    this.a.a(paramList);
    i.a.a(this.b, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\i$a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */