package com.inmobi.ads;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

 enum r$b$2
{
  r$b$2(String paramString1)
  {
    super(paramString, paramInt, paramString1, null);
  }
  
  void a(r paramr)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Entering state:" + this);
    r.a(paramr, r.b.b);
    paramr.j();
  }
  
  void a(r paramr, boolean paramBoolean)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Activity in focus:" + paramBoolean);
    if ((paramBoolean) && (r.j(paramr))) {
      r.b.a.a(paramr);
    }
  }
  
  void b(r paramr, boolean paramBoolean)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Network available:" + paramBoolean);
    if ((paramBoolean) && (r.k(paramr))) {
      r.b.a.a(paramr);
    }
  }
  
  void c(r paramr)
  {
    r.b.c.a(paramr);
  }
  
  void d(r paramr)
  {
    d.a(paramr);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\r$b$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */