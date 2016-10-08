package com.inmobi.signals;

import com.inmobi.commons.core.configs.a.a;
import com.inmobi.commons.core.configs.b;
import com.inmobi.commons.core.configs.b.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.f;
import com.inmobi.commons.core.utilities.uid.d;

public class o
  implements b.b
{
  private static final String a = o.class.getSimpleName();
  private static final Object b = new Object();
  private static volatile o c;
  private i d;
  private g e;
  private p f = new p();
  private boolean g = false;
  
  private o()
  {
    b.a().a(this.f, this);
    f.a().a(e().i());
    LocationInfo.a().a(e().h());
    com.inmobi.commons.core.c.a.a().a(this.f.a(), this.f.e());
  }
  
  public static o a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (b)
      {
        o localo2 = c;
        localObject1 = localo2;
        if (localo2 == null)
        {
          localObject1 = new o();
          c = (o)localObject1;
        }
        return (o)localObject1;
      }
    }
    return localo1;
  }
  
  public void a(com.inmobi.commons.core.configs.a parama)
  {
    this.f = ((p)parama);
    LocationInfo.a().a(e().h());
    f.a().a(e().i());
    com.inmobi.commons.core.c.a.a().a(this.f.a(), this.f.e());
  }
  
  public void b()
  {
    try
    {
      if (!this.g)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Starting signals component.");
        this.g = true;
        g();
        LocationInfo.a().b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void c()
  {
    try
    {
      if (this.g)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Stopping signals component.");
        this.g = false;
        h();
        LocationInfo.a().c();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  d d()
  {
    return new d(this.f.o().a());
  }
  
  public p.b e()
  {
    return this.f.f();
  }
  
  public p.a f()
  {
    return this.f.g();
  }
  
  void g()
  {
    for (;;)
    {
      try
      {
        if (!this.g)
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Ice can not be started as Signals component has not been started.");
          return;
        }
        if (!e().a()) {
          break label82;
        }
        n.a().b();
        if (this.d == null)
        {
          this.d = new i();
          this.d.a();
          continue;
        }
        this.d.a();
      }
      finally {}
      continue;
      label82:
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "User data collection is disabled.");
    }
  }
  
  void h()
  {
    n.a().c();
    if (this.d != null) {
      this.d.c();
    }
  }
  
  public void i()
  {
    if (!this.g)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Carb can not be started as Signals component has not been started.");
      return;
    }
    if (f().a())
    {
      if (this.e == null)
      {
        this.e = new g();
        this.e.a(f());
        return;
      }
      this.e.a(f());
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Carb is disabled.");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */