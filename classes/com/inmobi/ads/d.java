package com.inmobi.ads;

import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.a;
import com.inmobi.commons.core.network.a.a;
import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

final class d
  implements a.a
{
  private static final String a = d.class.getSimpleName();
  private e b;
  private a c;
  
  public d(e parame, a parama)
  {
    this.b = parame;
    this.c = parama;
  }
  
  public void a()
  {
    new a(this.b, this).a();
  }
  
  public void a(c paramc)
  {
    paramc = new f(this.b, paramc);
    this.c.a(paramc);
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Ad fetch succeeded. Response:" + paramc.c());
  }
  
  public void b(c paramc)
  {
    paramc = new f(this.b, paramc);
    this.c.b(paramc);
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Ad fetch failed:" + paramc.d().b());
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
    
    public abstract void b(f paramf);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */