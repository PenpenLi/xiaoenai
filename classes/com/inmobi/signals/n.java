package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.f;
import java.util.UUID;

public class n
{
  private static final String a = n.class.getSimpleName();
  private static n b;
  private static Object c = new Object();
  
  public static n a()
  {
    Object localObject1 = b;
    if (localObject1 == null) {
      synchronized (c)
      {
        n localn2 = b;
        localObject1 = localn2;
        if (localn2 == null)
        {
          b = new n();
          localObject1 = b;
        }
        return (n)localObject1;
      }
    }
    return localn1;
  }
  
  void b()
  {
    if (o.a().e().i())
    {
      f.a().a(UUID.randomUUID().toString());
      f.a().a(System.currentTimeMillis());
      f.a().b(0L);
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Session tracking started.");
    }
  }
  
  void c()
  {
    if (o.a().e().i())
    {
      f.a().b(System.currentTimeMillis());
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Session tracking stopped.");
    }
  }
  
  f d()
  {
    if (!o.a().e().i()) {
      return null;
    }
    return f.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */